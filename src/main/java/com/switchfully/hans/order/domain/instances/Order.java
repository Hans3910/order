package com.switchfully.hans.order.domain.instances;

import java.util.Collection;
import java.util.UUID;

public class Order {
    private String orderId;
    private Collection<ItemGroup> itemGroups;
    private int totalOrderPrice;

    public Order(Collection<ItemGroup> itemGroups) {
        this.orderId = UUID.randomUUID().toString();
        this.itemGroups = itemGroups;
    }

    public String getOrderId() {
        return orderId;
    }

    public Collection<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public void setItemGroups(Collection<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(int totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }
}
