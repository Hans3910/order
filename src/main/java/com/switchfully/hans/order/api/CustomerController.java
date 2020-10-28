package com.switchfully.hans.order.api;

import com.switchfully.hans.order.api.dto.CreateCustomerDto;
import com.switchfully.hans.order.api.dto.GetCustomerDto;
import com.switchfully.hans.order.domain.instances.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.switchfully.hans.order.service.CustomerService;

import java.util.Collection;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetCustomerDto> getAllCustomers(){
        logger.info("List of customers requested");
        return customerService.getCustomerList();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CreateCustomerDto createCustomerDto){
        Customer customerToCreate = customerService.createNewCustomerInRepository(createCustomerDto, this);
        logger.info("Customer created with name {} {}.",
                customerToCreate.getFirstName(), customerToCreate.getLastName());
    }
}
