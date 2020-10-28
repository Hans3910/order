package com.switchfully.hans.order.api.dto;

import com.switchfully.hans.order.domain.instances.Item;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

public class CreateItemGroupDto {
    private String orderedItemID;
    private double orderedItemAmount;


    public String getOrderedItemID() {
        return orderedItemID;
    }

    public CreateItemGroupDto setOrderedItemID(String orderedItemID) {
        this.orderedItemID = orderedItemID;
        return this;
    }

    public double getOrderedItemAmount() {
        return orderedItemAmount;
    }

    public CreateItemGroupDto setOrderedItemAmount(double orderedItemAmount) {
        this.orderedItemAmount = orderedItemAmount;
        return this;
    }
}
