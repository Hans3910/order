package com.switchfully.hans.order.domain.instances;

import java.util.UUID;

public class Item {
    private String id;
    private String name;
    private String description;
    private double price;
    private double amountInStock;

    public Item(String name, String description, double price, double amountInStock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getAmountInStock() {
        return amountInStock;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmountInStock(double amountInStock) {
        this.amountInStock = amountInStock;
    }
}
