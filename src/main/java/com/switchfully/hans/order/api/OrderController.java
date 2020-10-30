package com.switchfully.hans.order.api;

import com.switchfully.hans.order.api.dto.CreateItemGroupDto;
import com.switchfully.hans.order.api.dto.GetOrderDto;
import com.switchfully.hans.order.api.mapper.ItemGroupMapper;
import com.switchfully.hans.order.domain.exceptions.NotAuthorizedException;
import com.switchfully.hans.order.domain.instances.Admin;
import com.switchfully.hans.order.domain.instances.Customer;
import com.switchfully.hans.order.domain.instances.ItemGroup;
import com.switchfully.hans.order.domain.instances.Order;
import com.switchfully.hans.order.domain.repositories.AdminRepository;
import com.switchfully.hans.order.domain.repositories.CustomerRepository;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import com.switchfully.hans.order.domain.repositories.OrderRepository;
import com.switchfully.hans.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(Order.class);
    private OrderService orderService;
    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<Order> getAllOrders(){
        logger.info("List of all Orders was requested.");
        return orderService.getOrderList();

    }

    @PostMapping
    public Order createOrder(@RequestParam String customerId, @RequestBody List<CreateItemGroupDto> orderItemsDto){
        List<ItemGroup> orderItems = ItemGroupMapper.convertToList(orderItemsDto);
        return orderService.createOrder(customerId, orderItems);
    }


}
