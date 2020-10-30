package com.switchfully.hans.order.domain.instances;

import java.util.UUID;

public class Item {
    private final String id;
    private String name;
    private final String description;
    private final double price;
    private final double amountInStock;

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

    public void setName(String name) {
        this.name = name;
    }

}
