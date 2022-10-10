package main.endpoint;

import org.example.calc.GetRequest;
import org.example.calc.GetResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import main.service.CalculationService;

@Endpoint
public class CalculationEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.org/calc";

    private final CalculationService calculationService;

    public CalculationEndpoint(CalculationService calculationService){
        this.calculationService = calculationService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getRequest")
    @ResponsePayload
    public GetResponse getSquare(@RequestPayload GetRequest request){
        return calculationService.getSquare(request);
    }
}
