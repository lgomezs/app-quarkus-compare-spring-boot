package pe.lgomezs.domain.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@JsonFormat(shape= JsonFormat.Shape.OBJECT)
public enum IdentityDocumentType {
  DNI("1");

  private final String code;

  IdentityDocumentType(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }


  @Deprecated
  public static IdentityDocumentType fromCode(String code) throws Exception {
    return Arrays.stream(IdentityDocumentType.values())
      .filter(identityDocumentType -> identityDocumentType.code.equals(code))
      .findFirst()
      .orElseThrow(() -> {
        log.error("Este codigo de documento de identidad es desconocido: {}", code);
        return new Exception("Error fromCode IdentityDocumentType");
      });
  }
}
