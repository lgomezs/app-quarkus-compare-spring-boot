package pe.lgomezs.controller;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import pe.lgomezs.dto.CreditCardPaymentCashRequest;

import pe.lgomezs.dto.ResponseCalculationDoubleBilling;
import pe.lgomezs.service.CreditCardService;

import org.jboss.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import java.util.UUID;


@Path("/credit-card")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreditCardController {

    private static final Logger LOG = Logger.getLogger(CreditCardController.class);
    @Inject
    private CreditCardService creditCardService;

    @Path("{processTraceId}/payment")
    @POST
    public ResponseCalculationDoubleBilling saveCreditCard(@PathParam String processTraceId, CreditCardPaymentCashRequest creditCardPaymentCashRequest) throws Exception {
        LOG.info("############ Inicio saveCreditCard");
        ResponseCalculationDoubleBilling responseCalculationDoubleBilling = creditCardService.findByProcessTraceId(UUID.fromString(processTraceId));
        if (responseCalculationDoubleBilling == null) {
            creditCardService.saveCreditCard(UUID.fromString(processTraceId), creditCardPaymentCashRequest);
            return findTransaction(processTraceId);
        }
        return responseCalculationDoubleBilling;
    }

    @Path("{processTraceId}/get")
    @GET
    public ResponseCalculationDoubleBilling findTransaction(@PathParam String processTraceId) {
        return creditCardService.findByProcessTraceId(UUID.fromString(processTraceId));
    }
}
