package pe.lgomezs.appservicetransaction.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardPaymentCashRequest {
  private Billing billing;
  private Beneficiary beneficiary;
  private Creditcard creditcard;
  private String tokenStoreCode;
  private String tokenUserName;
  private String tokenHostname;
  private String internalOperationCode;


  public CreditCardPaymentCashRequest() {
  }

  @Getter
  @Setter
  public static class Billing {
    private List<RequestConfirmationDoubleBilling.Invoicing> invoicing;
    private List<RequestConfirmationDoubleBilling.PaymentDetail> payments;
    private Boolean changeOnlyPEN;

    public Billing(){}

    public Billing(List<RequestConfirmationDoubleBilling.Invoicing> invoicing,
                   List<RequestConfirmationDoubleBilling.PaymentDetail> payments, Boolean changeOnlyPEN) {
      this.invoicing = invoicing;
      this.payments = payments;
      this.changeOnlyPEN = changeOnlyPEN;
    }
  }

  @Getter
  @Setter
  public static class Beneficiary {
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private Document document;

    public Beneficiary(){}
  }

  @Getter
  @Setter
  public static class Document {
    private String id;
    private String type;

    public Document(){

    }

  }

  @Getter
  @Setter
  public static class Creditcard {
    private String type;
    private String id;

    public Creditcard(){}
  }
}
