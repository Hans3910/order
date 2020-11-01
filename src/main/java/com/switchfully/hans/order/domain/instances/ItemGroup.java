package com.switchfully.hans.order.domain.instances;

import java.time.LocalDate;


public class ItemGroup {
    private String ItemId;
    private double amount;
    private LocalDate shippingDate;

    public ItemGroup(String itemId, double amount) {
        this.ItemId = itemId;
        this.amount = amount;
    }

    public String getItemId() {
        return ItemId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }
}
