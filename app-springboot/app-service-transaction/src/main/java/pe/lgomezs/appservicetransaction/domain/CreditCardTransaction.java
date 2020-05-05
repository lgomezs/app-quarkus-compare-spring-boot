package pe.lgomezs.appservicetransaction.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Getter
@Setter
@ToString
@Entity
@Table(name = "CreditCardTransaction")
public class CreditCardTransaction extends TransactionBase {

    @OneToMany(mappedBy = "creditCardTransaction", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE}, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<PaymentDetail> paymentDetails;

    public PaymentDetail getLastPayment() {
        return new ArrayList<>(paymentDetails).get(paymentDetails.size() - 1);
    }

    public CreditCardTransaction() {
    }

    public CreditCardTransaction(UUID processTraceId, String internalOperationCode,
                                 ZonedDateTime operationDate, Long originalTransactionId, String transactionType,
                                 String creditCardNumber, Customer beneficiary, String status, BigDecimal totalAmount,
                                 BigDecimal amountAdjustment, boolean applyITF,
                                 boolean changeFlag, String creditCardType,
                                 List<PaymentDetail> paymentDetails
    ) {
        this.processTraceId = processTraceId;
        this.internalOperationCode = internalOperationCode;
        this.originalTransactionId = originalTransactionId;
        this.transactionType = transactionType;
        this.creditCardNumber = creditCardNumber;
        this.beneficiary = beneficiary;
        this.status = status;
        this.totalAmount = totalAmount;
        this.amountAdjustment = amountAdjustment;
        this.applyITF = applyITF;
        this.changeFlag = changeFlag;
        this.creditCardType = creditCardType;
        this.paymentDetails = paymentDetails;
        this.paymentDetails.forEach(paymentDetail -> paymentDetail.setCreditCardTransaction(this));
        this.operationDate = operationDate;
    }

    public List<PaymentDetail> getPaymentDetails() {
        return paymentDetails.stream().distinct().collect(Collectors.toList());
    }
}
