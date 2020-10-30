package com.switchfully.hans.order.domain.repositories;


import com.switchfully.hans.order.domain.exceptions.CreationFailedException;
import com.switchfully.hans.order.domain.exceptions.OrderAlreadyExistsException;
import com.switchfully.hans.order.domain.exceptions.OrderNotFoundException;
import com.switchfully.hans.order.domain.instances.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class OrderRepository {

    private final Map<String, Order> orders;

    @Autowired
    public OrderRepository() {
        this.orders = new HashMap<>();
    }

    public Order save(Order order) {
        if (orders.containsValue(order))
            throw new OrderAlreadyExistsException(
                    "Order with id"
                            + order.getOrderId()
                            + " already exists.");
        orders.put(order.getOrderId(), order);

        return order;
    }

    public Order getOrder(String orderId) {
        Order item = orders.get(orderId);
        if (Objects.isNull(item)) {
            throw new OrderNotFoundException("There is no order available with the id " + orderId);
        }
        return item;
    }

    public Map<String, Order> getOrderMap() {
        return orders;
    }



    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }
}
