package main.service;

import org.example.calc.GetRequest;
import org.example.calc.GetResponse;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public GetResponse getSquare(GetRequest request){
        GetResponse getResponse = new GetResponse();
        if(request != null){
            getResponse.setSquare(Math.pow(request.getNumber(), 2));
        }else {
            getResponse.setSquare(0);
        }
        return getResponse;
    }
}
