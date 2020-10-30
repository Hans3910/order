package com.switchfully.hans.order.service;

import com.switchfully.hans.order.api.dto.GetOrderDto;
import com.switchfully.hans.order.api.dto.OrderDto;
import com.switchfully.hans.order.api.mapper.OrderMapper;
import com.switchfully.hans.order.domain.exceptions.CreationFailedException;
import com.switchfully.hans.order.domain.exceptions.OrderNotFoundException;
import com.switchfully.hans.order.domain.instances.ItemGroup;
import com.switchfully.hans.order.domain.instances.Order;
import com.switchfully.hans.order.domain.repositories.CustomerRepository;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import com.switchfully.hans.order.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> getAllOrderDTOs() {
        return orderRepository.getOrders().stream()
                .map(orderMapper::detailDTO)
                .collect(Collectors.toList());
    }

    public List<OrderDto> getAllMyOrderDTOs(String customerId) {
        return orderRepository.getOrders().stream()
                .map(orderMapper::detailDTO)
                .filter(order -> order.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    public OrderDto getOrderDetailsById(String id) {
        return orderMapper.detailDTO(orderRepository.getOrder(id));

    }

    public OrderDto registerOrder(OrderDto orderDTO) {
        Order order = orderRepository.save(orderMapper.createOrder(orderDTO));
        return orderMapper.detailDTO(order);
    }

    public OrderDto placeOrder(String id) {
        if (!orderRepository.getOrderMap().containsKey(id)) throw new OrderNotFoundException("Order with Isbn " + id );
        Order order = orderRepository.getOrder(id);
        return orderMapper.detailDTO(order);
    }
}
