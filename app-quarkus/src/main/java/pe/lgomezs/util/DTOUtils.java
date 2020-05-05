package pe.lgomezs.util;

import pe.lgomezs.domain.transaction.CreditCardTransaction;
import pe.lgomezs.dto.RequestConfirmationDoubleBilling;
import pe.lgomezs.dto.ResponseCalculationDoubleBilling;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DTOUtils {

    public ResponseCalculationDoubleBilling getResponseCreditCard(CreditCardTransaction creditCardTransaction) throws Exception {
        if (creditCardTransaction == null) return null;
        ResponseCalculationDoubleBilling responseCalculationDoubleBilling = new ResponseCalculationDoubleBilling();
        responseCalculationDoubleBilling.setBeneficiary(creditCardTransaction.getBeneficiary());
        responseCalculationDoubleBilling.setEmail(creditCardTransaction.getEmail());
        responseCalculationDoubleBilling.setCreditCardNumber(creditCardTransaction.getCreditCardNumber());
        responseCalculationDoubleBilling.setCreditCardType(creditCardTransaction.getCreditCardType());
        responseCalculationDoubleBilling.setInternalOperationCode(creditCardTransaction.getInternalOperationCode());
        responseCalculationDoubleBilling.setProcessTraceId(creditCardTransaction.getProcessTraceId());
        responseCalculationDoubleBilling.setStatus(creditCardTransaction.getStatus());

        List<ResponseCalculationDoubleBilling.PaymentDetail> payments = new ArrayList<>();
        creditCardTransaction.getPaymentDetails().forEach(paymentDetail -> {
            payments.add(new ResponseCalculationDoubleBilling.PaymentDetail(paymentDetail.getPaymentMethodType().getDescription(),
                    new RequestConfirmationDoubleBilling.Amount(paymentDetail.getAmount(), CurrencyType.getLabel(paymentDetail.getCurrency()).getDescription())));
        });

        responseCalculationDoubleBilling.setPayments(payments);
        return responseCalculationDoubleBilling;
    }
}
