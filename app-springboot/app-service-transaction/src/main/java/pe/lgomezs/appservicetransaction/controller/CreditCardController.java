package pe.lgomezs.appservicetransaction.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.lgomezs.appservicetransaction.dto.CreditCardPaymentCashRequest;
import pe.lgomezs.appservicetransaction.dto.ResponseCalculationDoubleBilling;
import pe.lgomezs.appservicetransaction.service.CreditCardService;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/credit-card")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping(value = "/{processTraceId}/payment")
    public ResponseEntity<?> creditCardPayment(@PathVariable String processTraceId,
                                               @RequestBody CreditCardPaymentCashRequest creditCardPaymentCashRequest) {
        ResponseCalculationDoubleBilling responseCalculationDoubleBilling = creditCardService.findByProcessTraceId(UUID.fromString(processTraceId));
        if (responseCalculationDoubleBilling == null) {
            creditCardService.saveCreditCard(UUID.fromString(processTraceId), creditCardPaymentCashRequest);
            responseCalculationDoubleBilling = creditCardService.findByProcessTraceId(UUID.fromString(processTraceId));
        }
        return ResponseEntity.ok().body(responseCalculationDoubleBilling);
    }

    @GetMapping("/{processTraceId}/payment")
    public ResponseEntity<ResponseCalculationDoubleBilling> creditCardPendingPaymentResponse(@PathVariable("processTraceId") final String processTraceId) {
        return ResponseEntity.ok().body(creditCardService.findByProcessTraceId(UUID.fromString(processTraceId)));
    }
}
