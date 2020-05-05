package pe.lgomezs.appservicetransaction.util;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;


@Slf4j
public enum CurrencyType {

    PEN("001", "PEN", "Compra de dólares", "Extorno de compra de dólares", "S/"),
    USD("010", "USD", "Venta de dólares", "Extorno de venta de dólares", "US$");


    private final String code;
    private final String symbol;
    private final String description;
    private final String descriptionRollback;
    private final String label;

    CurrencyType(String code, String symbol, String description, String descriptionRollback, String label) {
        this.code = code;
        this.symbol = symbol;
        this.description = description;
        this.descriptionRollback = descriptionRollback;
        this.label = label;
    }

    public static CurrencyType getSymbol(String code) throws Exception {
        return Arrays.stream(CurrencyType.values())
                .filter(currencyType -> currencyType.code.equals(code))
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Este codigo de moneda es desconocido: {}", code);
                    return new Exception("Error getLabel CurrencyType  ");
                });
    }

    public static CurrencyType getCode(String symbol)  {
        try {
            return Arrays.stream(CurrencyType.values())
                    .filter(currencyCode -> currencyCode.symbol.equals(symbol))
                    .findFirst()
                    .orElseThrow(() -> {
                        log.error("Este codigo de moneda es desconocido: {}", symbol);
                        return new Exception("Error getLabel CurrencyType  ");
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static CurrencyType getLabel(String code)  {
        try {
            return Arrays.stream(CurrencyType.values())
                    .filter(currencyCode -> currencyCode.code.equals(code))
                    .findFirst()
                    .orElseThrow(() -> {
                        log.error("Este codigo de moneda es desconocido: {}", code);
                        return new Exception("Error getLabel CurrencyType  ");
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getSymbol() {
        return symbol;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionRollback() {
        return descriptionRollback;
    }

    public String getLabel() {
        return label;
    }
}
