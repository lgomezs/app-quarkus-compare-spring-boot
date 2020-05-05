package pe.lgomezs.appservicetransaction.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PaymentMethodType {
    CASH("Efectivo");

    private final String description;
    private final String name;

    PaymentMethodType(String description) {
        this.description = description;
        this.name = name();
    }

    public static PaymentMethodType getDescription(String name) throws Exception {
        return Arrays.stream(PaymentMethodType.values())
                .filter(currencyType -> currencyType.name.equals(name))
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Este tipo de pago es desconocido: {}", name);
                    return new Exception("Error getDescription PaymentMethodType");
                });
    }

    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
