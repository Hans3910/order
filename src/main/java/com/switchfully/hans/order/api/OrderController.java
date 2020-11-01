package com.switchfully.hans.order.api;


import com.switchfully.hans.order.api.dto.CreateOrderDto;
import com.switchfully.hans.order.api.dto.GetOrderDto;
import com.switchfully.hans.order.domain.instances.ItemGroup;
import com.switchfully.hans.order.domain.instances.Order;
import com.switchfully.hans.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final Logger myLogger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody CreateOrderDto createOrderDto) {
        myLogger.info("Creation of new order requested");
        Order newOrder = new Order(createOrderDto.getCustomerId(), createOrderDto.getItemGroups(), 0.0, LocalDate.now());
        orderService.addOrder(newOrder);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetOrderDto> getAll() {
        myLogger.info("List of all orders was requested");
        return orderService.getAll().stream()
                .map(order -> new GetOrderDto()
                        .setOrderId(order.getOrderId())
                        .setCustomerId(order.getCustomerId())
                        .setItemGroups(order.getItemGroups())
                        .setTotalPrice(order.getTotalPrice())
                        .setShippingDate(order.getShippingDate()))
                .collect(Collectors.toList());
    }
}
