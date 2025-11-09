package com.submodule.customer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {


    //RestTemplate is a synchronous client-side object provided by Spring that is used for consuming RESTful web services.
    //but its not the best way to connet two services , cause u can see in CustomerService that the service gotta know all the microservices
    //which is not good if there is a lot of services
    // thats why u gotta use a Discovery Service (like eureka), that knows all addresses of microservices.
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
