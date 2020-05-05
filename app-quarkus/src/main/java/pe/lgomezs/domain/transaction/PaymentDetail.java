package pe.lgomezs.domain.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@ToString(exclude = {"creditCardTransaction"})
@NoArgsConstructor()
@Getter
@Setter
@Entity
public class PaymentDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long paymentDetailId;
  private BigDecimal amount;
  private BigDecimal amountReceive;
  private String currency;
  @Enumerated(EnumType.STRING)
  private PaymentMethodType paymentMethodType;

  @Embedded
  @AttributeOverrides(value = {
    @AttributeOverride(name = "solesTotalAmount", column = @Column(name = "pendingPaySolesTotalAmount")),
    @AttributeOverride(name = "dollarsTotalAmount", column = @Column(name = "pendingPayDollarsTotalAmount"))
  })
  private CreditCardPendingPay creditCardPendingPay;

  @JsonIgnore
  @JoinColumn(name = "creditCardTransactionId")
  @ManyToOne
  private CreditCardTransaction creditCardTransaction;

  protected String status;
  private String billingType;

  public PaymentDetail(String currency, BigDecimal amount,PaymentMethodType paymentMethodType,String status,String billingType,CreditCardPendingPay creditCardPendingPay) {
    this.amount = amount;
    this.currency = currency;
    this.paymentMethodType = paymentMethodType;
    this.status=status;
    this.billingType=billingType;
    this.creditCardPendingPay=creditCardPendingPay;
  }
}
