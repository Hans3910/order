package com.switchfully.hans.order.api.dto;

import com.switchfully.hans.order.domain.instances.ItemGroup;
import com.switchfully.hans.order.service.ItemService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;

public class GetOrderDto {
    private String orderID;
    private List<CreateItemGroupDto> itemGroups;
    private double totalOrderPrice;


    public GetOrderDto(String orderID, List<CreateItemGroupDto> itemGroups) {
        this.orderID = orderID;
        this.itemGroups = itemGroups;
    }

    public String getOrderID() {
        return orderID;
    }

    public GetOrderDto setOrderID(String orderID) {
        this.orderID = orderID;
        return this;
    }

    public Collection<CreateItemGroupDto> getItemGroups() {
        return itemGroups;
    }

    public GetOrderDto setItemGroups(List<CreateItemGroupDto> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public GetOrderDto setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
        return this;
    }

}
