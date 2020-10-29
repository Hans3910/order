package com.switchfully.hans.order.domain.repositories;


import com.switchfully.hans.order.domain.instances.*;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private Map<String, Order> orders = new HashMap<>();

    public OrderRepository() {
        fillRepository();
    }

    public List<Order> getAll() {
        return new ArrayList<>(orders.values());
    }

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void createOrder(Order newOrder){
        orders.put(newOrder.getOrderId(), newOrder);
    }

    private void fillRepository() {
        Address address = new Address("kerkstaat", "12", 3500, "Hasselt");
        Customer customer = new Customer("Hans", "Hendrickx", "hans@hans.com", address, "049653369");
        Item item = new Item("steol", "mooi stoel", 25.0, 30.0);
        Item item2 = new Item("tafel", "mooi tafel", 25.0, 30.0);
        ItemGroup itemGroup = new ItemGroup(item.getId(), 10);
        ItemGroup itemGroup1 = new ItemGroup(item2.getId(), 36);
        List<ItemGroup> items = new ArrayList<>();
        items.add(itemGroup);
        items.add(itemGroup1);
        Order order1 = new Order(items, customer.getId(), 100.0 );
        orders.put(order1.getOrderId(), order1);
    }



}
