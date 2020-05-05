package pe.lgomezs.domain.transaction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@ToString
@Setter
@Getter
@Embeddable
public class CreditCardPendingPay {
  private BigDecimal solesTotalAmount;
  private BigDecimal dollarsTotalAmount;

  public CreditCardPendingPay() {
  }

  public CreditCardPendingPay(BigDecimal solesTotalAmount, BigDecimal dollarsTotalAmount) {
    this.solesTotalAmount = solesTotalAmount;
    this.dollarsTotalAmount = dollarsTotalAmount;
  }
}
