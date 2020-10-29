package com.switchfully.hans.order.api.dto;

public class CreateItemGroupDto {
    private String orderId;
    private String orderedItemID;
    private double orderedItemAmount;

    public CreateItemGroupDto(String orderId, String orderedItemID, double orderedItemAmount) {
        this.orderId = orderId;
        this.orderedItemID = orderedItemID;
        this.orderedItemAmount = orderedItemAmount;
    }

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

    public String getOrderId() {
        return orderId;
    }

    public CreateItemGroupDto setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }
}
