package pe.lgomezs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@Setter
public class RequestConfirmationDoubleBilling {
  private List<Invoicing> invoicing;
  private List<PaymentDetail> payments;
  private Boolean changeOnlyPEN;

  public RequestConfirmationDoubleBilling(){}


  @Getter
  @Setter
  public static class Invoicing {
    private Amount amount;
    private String billingType;

    public Invoicing(){}

    public Invoicing(Amount amount, String billingType) {
      this.amount = amount;
      this.billingType = billingType;
    }
  }

  @Getter
  @Setter
  public static class PaymentDetail {
    private String paymentType;
    private Amount amount;

    public PaymentDetail(){}

    public PaymentDetail(String paymentType, Amount amount) {
      this.paymentType = paymentType;
      this.amount = amount;
    }
  }

  @Getter
  @Setter
  public static class Amount {
    private BigDecimal amount;
    private String currencyCode;

    public Amount(){}

    public Amount(BigDecimal amount, String currencyCode) {
      this.amount = amount;
      this.currencyCode = currencyCode;
    }
  }
}
