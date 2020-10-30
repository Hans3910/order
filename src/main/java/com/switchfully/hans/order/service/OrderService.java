package com.switchfully.hans.order.service;

import com.switchfully.hans.order.api.dto.GetOrderDto;
import com.switchfully.hans.order.domain.instances.ItemGroup;
import com.switchfully.hans.order.domain.instances.Order;
import com.switchfully.hans.order.domain.repositories.CustomerRepository;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import com.switchfully.hans.order.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ItemRepository itemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Order createOrder(String customerId, List<ItemGroup> orderItems){
        List<ItemGroup> orders = assignShippingDates(orderItems);
        double totalCost = calculateTotalCost(orders);

        Order newOrder = new Order(orders, customerId, totalCost);
        orderRepository.createOrder(newOrder);

        return newOrder;
    }

    private List<ItemGroup> assignShippingDates(List<ItemGroup> orderItems){

        for(ItemGroup itemGroup : orderItems){
            if(checkIfItemInStock(itemGroup)){
                itemGroup.setShippingDate(LocalDate.now().plusDays(1));
            }
        }
        return orderItems;
    }


    private double calculateTotalCost(List<ItemGroup> orderItems){
        return orderItems.stream()
                .map(itemGroup -> itemRepository.getPrice(itemGroup.getSelectedItemId()) * itemGroup.getAmountOrdered())
                .reduce(0.0, Double::sum);
    }

    private boolean checkIfItemInStock(ItemGroup itemGroup) {
        return itemRepository.getItemAmountInStock(itemGroup.getSelectedItemId()) >= itemGroup.getAmountOrdered();
    }


    public Collection<Order> getOrderList() {
        return orderRepository.getAll();
    }
}
