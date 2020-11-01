package com.switchfully.hans.order.api.dto;


import com.switchfully.hans.order.domain.instances.ItemGroup;
import java.util.List;

public class GetOrderDto {
    private String orderId;
    private String customerId;
    private List<ItemGroup> itemGroups;
    private double totalPrice;

    public String getOrderId() {
        return orderId;
    }

    public GetOrderDto setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public GetOrderDto setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public GetOrderDto setItemGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public GetOrderDto setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

}
