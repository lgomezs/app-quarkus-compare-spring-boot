package pe.lgomezs.domain.transaction;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class TransactionBase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "creditCardTransactionId")
  protected Long transactionId;

  protected UUID processTraceId;
  protected String internalOperationCode;
  protected ZonedDateTime operationDate;
  @Column(name = "originalCreditCardTransactionId")
  protected Long originalTransactionId;
  protected String transactionType;
  protected String creditCardNumber;
  protected String status;
  protected BigDecimal totalAmount;
  protected BigDecimal amountAdjustment;
  @Column(columnDefinition = "BIT", length = 1)
  protected boolean applyITF;
  @Column(columnDefinition = "BIT", length = 1)
  protected boolean changeFlag;
  protected String email;
  @Column(columnDefinition = "BIT", length = 1)
  protected boolean statusPrint;
  @Column(columnDefinition = "BIT", length = 1)
  protected boolean statusEmail;
  protected String creditCardType;

  public boolean getStatusEmail(){
    return this.statusEmail;
  }

  @Embedded
  @AttributeOverrides(value = {
    @AttributeOverride(name = "firstName", column = @Column(name = "beneficiaryFirstName")),
    @AttributeOverride(name = "secondName", column = @Column(name = "beneficiarySecondName")),
    @AttributeOverride(name = "firstSurname", column = @Column(name = "beneficiaryFirstSurname")),
    @AttributeOverride(name = "secondSurname", column = @Column(name = "beneficiarySecondSurname")),
    @AttributeOverride(name = "identityDocumentType", column = @Column(name = "beneficiaryIdentityDocumentType")),
    @AttributeOverride(name = "identityDocumentNumber", column = @Column(name = "beneficiaryIdentityDocumentNumber"))
  })
  protected Customer beneficiary;

}
