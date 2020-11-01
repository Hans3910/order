package com.switchfully.hans.order.service;



import com.switchfully.hans.order.api.OrderController;
import com.switchfully.hans.order.api.dto.CreateOrderDto;
import com.switchfully.hans.order.domain.exceptions.CreationFailedException;
import com.switchfully.hans.order.domain.instances.Order;
import com.switchfully.hans.order.domain.repositories.CustomerRepository;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import com.switchfully.hans.order.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class OrderService {
    private final OrderRepository orderRepository;
    public final ItemRepository itemRepository;
    public final CustomerRepository customerRepository;
    public ItemService itemService;

    @Autowired
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository, CustomerRepository customerRepository, ItemService itemService) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
        this.itemService = itemService;
    }

    public void addOrder(Order order) {
        validateItemGroups(order);
        orderRepository.addOrder(order);
    }

    private void validateItemGroups(Order order) {
        if (order.getItemGroups().size() == 0)
            throw new CreationFailedException(OrderService.class, "order is empty", "");
    }

    public Collection<Order> getAll() {
        return orderRepository.getAll();
    }

    public Order createNewOrder(CreateOrderDto createOrderDto, String customerId) {
        itemService.setShippingDate(createOrderDto);
        Order newOrder = new Order(customerId, createOrderDto.getItemGroups() , itemService.calculateTotalPrice(createOrderDto));
        addOrder(newOrder);
        return newOrder;
    }
}



