package pe.lgomezs.appservicetransaction.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import pe.lgomezs.appservicetransaction.util.Util;

import javax.persistence.Embeddable;

@Slf4j
@ToString
@Getter
@Setter
@Embeddable
public class Customer {
  private String firstName;
  private String secondName;
  private String firstSurname;
  private String secondSurname;
  private String identityDocumentType;
  private String identityDocumentNumber;

  public Customer() {
  }

  public Customer(String firstName, String secondName, String firstSurname, String secondSurname, String identityDocumentType, String identityDocumentNumber) throws Exception {
    this.firstName = firstName;
    this.secondName = secondName;
    this.firstSurname = firstSurname;
    this.secondSurname = secondSurname;
    this.identityDocumentType = identityDocumentType;
    if (Util.validateDocumentNumber(identityDocumentNumber)) {
      this.identityDocumentNumber = identityDocumentNumber;
    }
  }
}
