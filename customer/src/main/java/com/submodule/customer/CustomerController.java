package com.submodule.customer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService) { // a recordis a specific type of classes that generate constructor,accessors for fields and functions like equals and tistring automaticly.btw:a record is immutable, so all its fields are final

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("new customer registration{}" , customerRegistrationRequest);

        customerService.registerCustomer(customerRegistrationRequest);
    }
}
