package com.switchfully.hans.order.domain.repositories;


import com.switchfully.hans.order.domain.instances.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    private static final Map<String, Order> orders = new HashMap<>();

    public static Map<String, Order> getOrders() {
        return orders;
    }
}
