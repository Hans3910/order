package com.switchfully.hans.order.service;

import com.switchfully.hans.order.api.CustomerController;
import com.switchfully.hans.order.api.dto.CreateCustomerDto;
import com.switchfully.hans.order.api.dto.GetCustomerDto;
import com.switchfully.hans.order.domain.instances.Address;
import com.switchfully.hans.order.domain.instances.Customer;
import com.switchfully.hans.order.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Collection<Customer> getAll() {
        return customerRepository.getAllCustomers();
    }

    public void addCustomer(Customer customer){
        customerRepository.getCustomers().put(customer.getId(), customer);
    }

    public List<GetCustomerDto> getCustomerList() {
        return getAll().stream()
                .map(customer -> new GetCustomerDto()
                        .setId(customer.getId())
                        .setLastName(customer.getLastName())
                        .setFirstName(customer.getFirstName())
                        .setEmail(customer.getEmail())
                        .setStreetName(customer.getAddress().getStreetName())
                        .setStreetNumber(customer.getAddress().getStreetNumber())
                        .setPostalCode(customer.getAddress().getPostalCode())
                        .setCity(customer.getAddress().getCity()))
                .collect(Collectors.toList());
    }

    public Customer createNewCustomerInRepository(CreateCustomerDto createCustomerDto, CustomerController customerController) {
        Address addressToCreate = new Address(createCustomerDto.getStreetName(), createCustomerDto.getStreetNumber(), createCustomerDto.getPostalCode(), createCustomerDto.getCity());
        Customer customerToCreate = new Customer(createCustomerDto.getFirstName(), createCustomerDto.getLastName(), createCustomerDto.getEmail(),addressToCreate, createCustomerDto.getPhoneNumber());
        addCustomer(customerToCreate);
        return customerToCreate;
    }
}
