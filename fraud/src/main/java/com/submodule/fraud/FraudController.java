package com.submodule.fraud;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud")


public class FraudController {

    FraudCheckService  fraudService;
    public FraudController(FraudCheckService  fraudService){
        this.fraudService = fraudService;
    }

    @GetMapping(path="{customerId}")
    public FraudResponse isFraud(@PathVariable Integer customerId) {
        Boolean isfraud = fraudService.isFraud(customerId);

        return new FraudResponse(isfraud);
    }
}
