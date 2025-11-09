package com.submodule.fraud;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {

    private FraudCheckHistoryReposetory fraudCheckHistoryReposetory;

    public FraudCheckService(FraudCheckHistoryReposetory fraudCheckHistoryReposetory){
        this.fraudCheckHistoryReposetory = fraudCheckHistoryReposetory;
    }

    public boolean isFraud(Integer costumertId){

        fraudCheckHistoryReposetory.save(
                FraudCheckHistory.builder()
                        .CostumerId(costumertId)
                        .isFraud(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        System.out.println("hello");
        return false;//just for test
    }
}
