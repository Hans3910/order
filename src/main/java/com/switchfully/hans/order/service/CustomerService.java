package com.switchfully.hans.order.service;

import com.switchfully.hans.order.api.dto.CreateCustomerDto;
import com.switchfully.hans.order.api.dto.GetCustomerDto;
import com.switchfully.hans.order.domain.exceptions.EntityNotFoundException;
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
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Collection<Customer> getAll() {
        return CustomerRepository.getAllCustomers();
    }

    public void addCustomer(Customer customer){
        CustomerRepository.getCustomers().put(customer.getId(), customer);
    }

    public Customer getById(String id) {
        Customer customer = customerRepository.getById(id);
        if (customer == null) throw new EntityNotFoundException(Customer.class, "CustomerId", id);
        return customer;
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

    public Customer createNewCustomerInRepository(CreateCustomerDto createCustomerDto) {
        Address addressToCreate = new Address(createCustomerDto.getStreetName(), createCustomerDto.getStreetNumber(), createCustomerDto.getPostalCode(), createCustomerDto.getCity());
        Customer customerToCreate = new Customer(createCustomerDto.getFirstName(), createCustomerDto.getLastName(), createCustomerDto.getEmail(),addressToCreate, createCustomerDto.getPhoneNumber());
        addCustomer(customerToCreate);
        return customerToCreate;
    }

    public GetCustomerDto getGetCustomerById(Customer customer) {
        return new GetCustomerDto()
                .setId(customer.getId())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setEmail(customer.getEmail())
                .setStreetName(customer.getAddress().getStreetName())
                .setStreetNumber(customer.getAddress().getStreetNumber())
                .setPostalCode(customer.getAddress().getPostalCode())
                .setCity(customer.getAddress().getCity());
    }
}
