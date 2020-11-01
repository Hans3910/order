package com.switchfully.hans.order.api.controllers;


import com.switchfully.hans.order.api.dto.CreateOrderDto;
import com.switchfully.hans.order.api.dto.GetOrderDto;

import com.switchfully.hans.order.domain.exceptions.NotACustomerException;
import com.switchfully.hans.order.domain.instances.Order;
import com.switchfully.hans.order.domain.repositories.CustomerRepository;
import com.switchfully.hans.order.service.ItemService;
import com.switchfully.hans.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final Logger myLogger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;
    private final ItemService itemService;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderController(OrderService orderService, ItemService itemService, CustomerRepository customerRepository) {
        this.orderService = orderService;
        this.itemService = itemService;
        this.customerRepository = customerRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody CreateOrderDto createOrderDto, @RequestParam String customerId) throws NotACustomerException {
        customerRepository.checkCustomerId(customerId);
        myLogger.info("Creating new order");
        return orderService.createNewOrder(createOrderDto, customerId);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetOrderDto> getAll() {
        myLogger.info("List of all orders was requested");
        return orderService.getAllOrders();
    }
}
