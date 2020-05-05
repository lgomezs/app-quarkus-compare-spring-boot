package pe.lgomezs.appservicetransaction.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
public enum DocumentType {
  DNI(1, "DNI"),
  CARNET_EXTRANJERIA(3, "CE"),
  PASAPORTE(5, "PAS");

  private int codType;
  private String descriptionType;

  DocumentType(int codType, String descriptionType) {
    this.codType = codType;
    this.descriptionType = descriptionType;
  }

  public static DocumentType getCode(String description) throws Exception {
    return Arrays.stream(DocumentType.values())
      .filter(descriptionType -> descriptionType.descriptionType.equals(description))
      .findFirst()
      .orElseThrow(() -> {
        log.error("Este Codigo de documento no existe {}", description);
        return  new Exception("Error getCode DocumentType()  ");
      });
  }

  public static DocumentType getName(int code) throws Exception {
    return Arrays.stream(DocumentType.values())
      .filter(descriptionType -> descriptionType.codType == code)
      .findFirst()
      .orElseThrow(() -> {
        log.error("Este Codigo de documento no existe {}", code);
        return  new Exception("Error getCode getName()  ");
      });
  }


  public int getCodType() {
    return codType;
  }

  public String getDescriptionType() {
    return descriptionType;
  }

}
