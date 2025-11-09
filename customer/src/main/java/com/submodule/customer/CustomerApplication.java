package com.submodule.customer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // this annotation is used on a microservice client to enable it to interact with the Eureka Discovery Server
public class CustomerApplication {
    public static void main(String[] args){
        SpringApplication.run(CustomerApplication.class, args);
    }

}
