package pe.lgomezs.service;

import pe.lgomezs.dto.CreditCardPaymentCashRequest;
import pe.lgomezs.dto.ResponseCalculationDoubleBilling;

import java.util.UUID;

public interface CreditCardService {

    void saveCreditCard(UUID processTraceId, CreditCardPaymentCashRequest creditCardPaymentCashRequest);

    ResponseCalculationDoubleBilling findByProcessTraceId(UUID uuid);


}
