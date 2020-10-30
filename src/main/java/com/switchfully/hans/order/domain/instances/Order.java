package com.switchfully.hans.order.domain.instances;

import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private List<ItemGroup> itemGroups;
    private String customerId;
    private double totalOrderPrice;

    public Order(List<ItemGroup> itemGroups, String customerId, double totalOrderPrice) {
        this.orderId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.itemGroups = itemGroups;
        this.totalOrderPrice = totalOrderPrice;
    }

    public String getOrderId() {
        return orderId;
    }


}
