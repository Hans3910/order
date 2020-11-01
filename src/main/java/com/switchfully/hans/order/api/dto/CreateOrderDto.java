package com.switchfully.hans.order.api.dto;


import com.switchfully.hans.order.domain.instances.ItemGroup;
import java.util.List;

public class CreateOrderDto {
    private String customerId;
    private List<ItemGroup> itemGroups;

    public String getCustomerId() {
        return customerId;
    }

    public CreateOrderDto setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public CreateOrderDto setItemGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }
}
