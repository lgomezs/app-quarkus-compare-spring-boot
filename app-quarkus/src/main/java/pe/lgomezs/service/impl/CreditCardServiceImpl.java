package pe.lgomezs.service.impl;

import lombok.extern.slf4j.Slf4j;
import pe.lgomezs.domain.transaction.*;
import pe.lgomezs.dto.CreditCardPaymentCashRequest;
import pe.lgomezs.dto.ResponseCalculationDoubleBilling;
import pe.lgomezs.exception.TransactionException;
import pe.lgomezs.repository.CreditCardRepository;
import pe.lgomezs.service.CreditCardService;
import pe.lgomezs.util.*;
import pe.lgomezs.util.CurrencyType;
import pe.lgomezs.util.TransactionType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Slf4j
@ApplicationScoped
public class CreditCardServiceImpl implements CreditCardService {

    @Inject
    private CreditCardRepository creditCardRepository;
    @Inject
    private DTOUtils dtoUtils;


    @Override
    public void saveCreditCard(UUID processTraceId, CreditCardPaymentCashRequest creditCardPaymentCashRequest) {
        log.info("Start saveCreditCard() {} ", processTraceId);
        creditCardPaymentCashRequest.setInternalOperationCode("5002");
        final CreditCardTransaction creditCardTransaction;
        try {
            creditCardTransaction = transaction(processTraceId, creditCardPaymentCashRequest, generateZoneDateTime());
        } catch (Exception e) {
            log.error("Error al procesar transaccion {} ", e.getMessage());
            throw new TransactionException("Error al procesar transaccion");
        }
        this.creditCardRepository.save(creditCardTransaction);
    }

    @Override
    public ResponseCalculationDoubleBilling findByProcessTraceId(UUID uuid) {
        log.info("Start findByProcessTraceId() {} ", uuid);
        try {
            return dtoUtils.getResponseCreditCard(creditCardRepository.findByProcessTraceId(uuid));
        } catch (Exception e) {
            log.error("Error al buscar transaccion {} ", e.getMessage());
            throw new TransactionException("Error al buscar transaccion");
        }
    }

    protected CreditCardTransaction transaction(final UUID processTraceId,
                                                final CreditCardPaymentCashRequest creditCardPaymentCashRequest,
                                                final ZonedDateTime operationDate) throws Exception {

        List<PaymentDetail> listPaymentDetail = creditCardPaymentCashRequest.getBilling().getInvoicing().stream()
                .filter(paymentDetail -> !paymentDetail.getAmount().getAmount().equals(BigDecimal.ZERO))
                .map(paymentDetail ->
                        new PaymentDetail(CurrencyType.getCode(paymentDetail.getAmount().getCurrencyCode()).getCode(), paymentDetail.getAmount().getAmount(), PaymentMethodType.CASH,
                                TransactionStatus.ACCEPTED.name(), paymentDetail.getBillingType(), new CreditCardPendingPay(BigDecimal.ZERO.setScale(2), BigDecimal.ZERO.setScale(2))))
                .collect(Collectors.toList());

        return new CreditCardTransaction(
                processTraceId,
                creditCardPaymentCashRequest.getInternalOperationCode(),
                operationDate,
                null,
                TransactionType.CREDIT_CARD.name(),
                creditCardPaymentCashRequest.getCreditcard().getId(),
                new Customer(
                        creditCardPaymentCashRequest.getBeneficiary().getFirstName(),
                        creditCardPaymentCashRequest.getBeneficiary().getSecondName(),
                        creditCardPaymentCashRequest.getBeneficiary().getFirstSurname(),
                        creditCardPaymentCashRequest.getBeneficiary().getSecondSurname(),
                        String.valueOf(DocumentType.getCode(creditCardPaymentCashRequest.getBeneficiary().getDocument().getType()).getCodType()),
                        creditCardPaymentCashRequest.getBeneficiary().getDocument().getId()),
                TransactionStatus.ACCEPTED.name(),
                creditCardPaymentCashRequest.getBilling().getInvoicing().size() > 1 ? BigDecimal.ZERO.setScale(2) : creditCardPaymentCashRequest.getBilling().getInvoicing().get(0).getAmount().getAmount(),
                creditCardPaymentCashRequest.getBilling().getInvoicing().get(0).getAmount().getAmount(),
                false,
                true,
                creditCardPaymentCashRequest.getCreditcard().getType(),
                listPaymentDetail);
    }

    public static ZonedDateTime generateZoneDateTime() {
        Instant timeStamp = Instant.now();
        return timeStamp.atZone(ZoneId.of("America/Lima"));
    }
}
