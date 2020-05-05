package pe.lgomezs.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
public enum TransactionType {

    CREDIT_CARD("Pago de tarjeta de crédito");

    private String descriptionType;

    TransactionType(String descriptionType) {
        this.descriptionType = descriptionType;
    }

    public String getDescriptionType() {
        return descriptionType;
    }

    public static TransactionType getDescription(String name) throws Exception {
        return Arrays.stream(TransactionType.values())
                .filter(descriptionType -> descriptionType.name().equals(name))
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Este nombre de transaccion no existe {}", name);
                    return new Exception("Error getDescription TransactionType");
                });
    }

}
