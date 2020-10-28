package com.switchfully.hans.order.api.dto;

public class GetItemDto {
    private String id;
    private String name;
    private String description;
    private double price;
    private double amountInStock;

    public String getId() {
        return id;
    }

    public GetItemDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GetItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public GetItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public GetItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getAmountInStock() {
        return amountInStock;
    }

    public GetItemDto setAmountInStock(double amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }
}
