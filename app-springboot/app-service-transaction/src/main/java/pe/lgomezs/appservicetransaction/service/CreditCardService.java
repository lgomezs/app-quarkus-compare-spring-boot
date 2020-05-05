package pe.lgomezs.appservicetransaction.service;



import pe.lgomezs.appservicetransaction.dto.CreditCardPaymentCashRequest;
import pe.lgomezs.appservicetransaction.dto.ResponseCalculationDoubleBilling;

import java.util.UUID;

public interface CreditCardService {

    void saveCreditCard(UUID processTraceId, CreditCardPaymentCashRequest creditCardPaymentCashRequest);

    ResponseCalculationDoubleBilling findByProcessTraceId(UUID uuid);


}
