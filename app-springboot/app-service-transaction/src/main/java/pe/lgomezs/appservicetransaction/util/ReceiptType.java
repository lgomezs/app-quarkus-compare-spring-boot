package pe.lgomezs.appservicetransaction.util;

public enum ReceiptType {
  EMAIL("Correo"),
  PRINT("Física");

  private String descriptionType;

  ReceiptType(String descriptionType) {
    this.descriptionType = descriptionType;
  }

  public String getDescriptionType() {
    return descriptionType;
  }
}
