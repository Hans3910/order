package api;

import api.dto.CreateCustomerDto;
import api.dto.GetCustomerDto;
import domain.instances.Address;
import domain.instances.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;

import java.awt.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetCustomerDto> getAllCustomers(){
        return getCustomerList();
    }


    private java.util.List<GetCustomerDto> getCustomerList() {
        return customerService.getAll().stream()
                .map(customer -> new GetCustomerDto()
                        .setId(customer.getId())
                        .setLastName(customer.getLastName())
                        .setFirstName(customer.getFirstName())
                        .setEmail(customer.getEmail())
                        .setStreetName(customer.getAddress().getStreetName())
                        .setStreetNumber(customer.getAddress().getNumber())
                        .setPostalCode(customer.getAddress().getPostalCode())
                        .setCity(customer.getAddress().getCity()))
                .collect(Collectors.toList());
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CreateCustomerDto createCustomerDto){
        Address addressToCreate = new Address(createCustomerDto.getStreetName(), createCustomerDto.getStreetNumber(), createCustomerDto.getPostalCode(), createCustomerDto.getCity());
        Customer customerToCreate = new Customer(createCustomerDto.getFirstName(), createCustomerDto.getLastName(), createCustomerDto.getEmail(),addressToCreate, createCustomerDto.getPhoneNumber());

    }


}
