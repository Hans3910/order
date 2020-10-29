package com.switchfully.hans.order.domain.instances;

import com.switchfully.hans.order.service.ItemService;

import java.util.List;
import java.util.UUID;

public class Order {
    private String orderId;
    private List<ItemGroup> itemGroups;
    private double totalOrderPrice;

    public Order(List<ItemGroup> itemGroups) {
        this.orderId = UUID.randomUUID().toString();
        this.itemGroups = itemGroups;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public void setItemGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }


}
