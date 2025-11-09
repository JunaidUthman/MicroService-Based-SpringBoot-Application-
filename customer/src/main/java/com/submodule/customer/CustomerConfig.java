package com.submodule.customer;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced
    //once u use this, u can automaticly use the name od the service instead of its hardcoded adress(FRAUD not localhost:8081)
    //When the request is made, the internal load balancer intercepts the logical name (FRAUD-SERVICE) and queries the Eureka Server to find all available, healthy instances of that service (e.g., 192.168.1.5:8081, 192.168.1.6:8082).
    // the internal load balancer uses an algorithm(often Round Robin) to select one of the available instances.

    // to learn more about loadbalancers , see the image in the docs/images/external and internal loadbalancer
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
