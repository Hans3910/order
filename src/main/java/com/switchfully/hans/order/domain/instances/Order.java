package com.switchfully.hans.order.domain.instances;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String orderId;
    private final String customerId;
    private final List<ItemGroup> itemGroups;
    private final double totalPrice;
    private final LocalDate shippingDate;

    public Order(String customerId, List<ItemGroup> itemGroups, double totalPrice, LocalDate shippingDate) {
        this.shippingDate = shippingDate;
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

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}