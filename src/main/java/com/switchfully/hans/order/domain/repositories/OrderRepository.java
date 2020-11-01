package com.switchfully.hans.order.domain.repositories;


import com.switchfully.hans.order.domain.exceptions.CreationFailedException;
import com.switchfully.hans.order.domain.exceptions.OrderAlreadyExistsException;
import com.switchfully.hans.order.domain.exceptions.OrderNotFoundException;
import com.switchfully.hans.order.domain.instances.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;


@Repository
public class OrderRepository {
    private final Map<String, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public Collection<Order> getAll() {
        return new ArrayList<>(orders.values());
    }
}




