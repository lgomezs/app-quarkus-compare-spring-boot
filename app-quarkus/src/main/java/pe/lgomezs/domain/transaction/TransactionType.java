package pe.lgomezs.domain.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TransactionType {
    SOLES("001");

    private final String code;

    TransactionType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Deprecated
    public static TransactionType fromCode(String code) throws Exception {
        return Arrays.stream(TransactionType.values())
                .filter(currencyType -> currencyType.code.equals(code))
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Este codigo de moneda es desconocido: {}", code);
                    return new Exception("Error fromCode TransactionType");
                });
    }

}
