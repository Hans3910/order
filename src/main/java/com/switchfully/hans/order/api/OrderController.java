package com.switchfully.hans.order.api;


import com.switchfully.hans.order.api.dto.GetOrderDto;
import com.switchfully.hans.order.api.dto.OrderDto;
import com.switchfully.hans.order.domain.exceptions.CreationFailedException;
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
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> adminViewsAllOrders() {
        return orderService.getAllOrderDTOs();
    }

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> customerViewsAllHisOrders(@PathVariable String customerId) {
        return orderService.getAllMyOrderDTOs(customerId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createNewEmptyOrderWithStatusCreated(@RequestBody OrderDto orderDTO) {
        return orderService.registerOrder(orderDTO);
    }

    @PutMapping(path = "/customer/place-order/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto updateOrderStatusFromCreatedToOrdered(@PathVariable String id) {
        return orderService.placeOrder(id);
    }
}
