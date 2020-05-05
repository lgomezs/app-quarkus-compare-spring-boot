package pe.lgomezs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pe.lgomezs.domain.transaction.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@ToString
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCalculationDoubleBilling {
    UUID processTraceId;
    String internalOperationCode;
    String originalTransactionId;
    String transactionType;
    String creditCardNumber;
    String status;
    String email;
    String creditCardType;
    Customer beneficiary;
    AmountDetail totalAdjustment;
    List<PaymentDetail> payments;
    Boolean changeOnlyPEN;
    String exchangeType;

    public ResponseCalculationDoubleBilling() {
    }

    public ResponseCalculationDoubleBilling(UUID processTraceId, String internalOperationCode, String originalTransactionId, String transactionType,
                                            String creditCardNumber, String status, String email, String creditCardType, Customer beneficiary,
                                            AmountDetail totalAdjustment, List<PaymentDetail> payments, Boolean changeOnlyPEN, String exchangeType) {
        this.processTraceId = processTraceId;
        this.internalOperationCode = internalOperationCode;
        this.originalTransactionId = originalTransactionId;
        this.transactionType = transactionType;
        this.creditCardNumber = creditCardNumber;
        this.status = status;
        this.email = email;
        this.creditCardType = creditCardType;
        this.beneficiary = beneficiary;
        this.totalAdjustment = totalAdjustment;
        this.payments = payments;
        this.changeOnlyPEN = changeOnlyPEN;
        this.exchangeType = exchangeType;
    }

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class PaymentDetail {
        private String paymentType;
        private RequestConfirmationDoubleBilling.Amount amount;

        public PaymentDetail(String paymentType, RequestConfirmationDoubleBilling.Amount amount) {
            this.paymentType = paymentType;
            this.amount = amount;
        }
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AmountDetail {
        private BigDecimal amount;
        private BigDecimal amountPreliminary;
        private String currencyCode;
    }
}
