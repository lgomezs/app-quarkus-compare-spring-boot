package pe.lgomezs.appservicetransaction.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    private static final String DOCUMENT_PATTERN = "^[A-Za-z0-9]{8,9}$";


    public static boolean validateDocumentNumber(String identityDocumentNumber) throws Exception {
        Pattern dniPattern = Pattern.compile(DOCUMENT_PATTERN);
        Matcher matcher = dniPattern.matcher(identityDocumentNumber);
        if (matcher.matches()) {
            return true;
        } else {
            throw new Exception("Número de documento inválido: {} " + identityDocumentNumber);
        }
    }

}
