package com.switchfully.hans.order.api.controllers;

import com.switchfully.hans.order.api.dto.CreateCustomerDto;
import com.switchfully.hans.order.api.dto.GetCustomerDto;
import com.switchfully.hans.order.domain.exceptions.NotAnAdminException;
import com.switchfully.hans.order.domain.instances.Customer;
import com.switchfully.hans.order.domain.repositories.AdminRepository;
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
    private final AdminRepository adminRepository;

    @Autowired
    public CustomerController(CustomerService customerService, AdminRepository adminRepository) {
        this.customerService = customerService;
        this.adminRepository = adminRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetCustomerDto> getAllCustomers(@RequestParam(required = false) String adminId) throws NotAnAdminException {
        adminRepository.checkAdminId(adminId);
        logger.info("List of customers requested");
        return customerService.getCustomerList();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CreateCustomerDto createCustomerDto){
        Customer customerToCreate = customerService.createNewCustomerInRepository(createCustomerDto);
        logger.info("Customer created with name {} {}.",
                customerToCreate.getFirstName(), customerToCreate.getLastName());
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public GetCustomerDto getById(@PathVariable String id, @RequestParam(required = false) String adminId) throws NotAnAdminException {
        adminRepository.checkAdminId(adminId);
        Customer customer = customerService.getById(id);
        logger.info("Customer requested with id {}", customer.getId());
        return customerService.getGetCustomerById(customer);
    }

}
