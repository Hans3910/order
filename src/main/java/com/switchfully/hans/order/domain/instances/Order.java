package com.switchfully.hans.order.domain.instances;


import java.util.List;
import java.util.UUID;

public class Order {
    private final String orderId;
    private final String customerId;
    private final List<ItemGroup> itemGroups;
    private final double totalPrice;


    public Order(String customerId, List<ItemGroup> itemGroups, double totalPrice) {
        this.orderId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.itemGroups = itemGroups;
        this.totalPrice = totalPrice;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

}