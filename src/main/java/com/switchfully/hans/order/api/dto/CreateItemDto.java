package com.switchfully.hans.order.api.dto;

public class CreateItemDto {
    private String name;
    private String description;
    private double price;
    private double amountInStock;

    public CreateItemDto(String name, String description, double price, double amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public String getName() {
        return name;
    }

    public CreateItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public CreateItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getAmountInStock() {
        return amountInStock;
    }

    public CreateItemDto setAmountInStock(double amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }
}
