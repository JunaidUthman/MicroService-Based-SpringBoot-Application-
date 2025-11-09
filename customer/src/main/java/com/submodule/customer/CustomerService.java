package com.submodule.customer;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService{

    private CustomerRepository customerRepository;
    private RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);


        // see CostumerConfig to understand restTemplate
        FraudResponse fraudResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud/{customerId}",
                FraudResponse.class, customer.getId());

        if(fraudResponse.isFraud()){
            throw new IllegalStateException("customer is Fraud!!");
        }
        else{
            System.out.println("the customer is not a fraud");
        }

    }
}
