package com.switchfully.hans.order.api.dto;

import com.switchfully.hans.order.domain.instances.ItemGroup;

import java.util.Collection;

public class GetOrderDto {
    private String orderID;
    private Collection<ItemGroup> itemGroups;
    private int totalOrderPrice;

    public String getOrderID() {
        return orderID;
    }

    public GetOrderDto setOrderID(String orderID) {
        this.orderID = orderID;
        return this;
    }

    public Collection<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public GetOrderDto setItemGroups(Collection<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public GetOrderDto setTotalOrderPrice(int totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
        return this;
    }
}
