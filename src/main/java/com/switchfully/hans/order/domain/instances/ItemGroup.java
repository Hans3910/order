package com.switchfully.hans.order.domain.instances;

import com.switchfully.hans.order.domain.exceptions.CreationFailedException;

import java.time.LocalDate;


public class ItemGroup {
    private final String ItemId;
    private final int amount;
    private LocalDate shippingDate;

    public ItemGroup(String itemID, int amount) {
        this.ItemId = itemID;
        this.amount = checkOrderAmount(amount);
    }

    private int checkOrderAmount(int amount) {
        if(amount <=0) throw new CreationFailedException(ItemGroup.class, "amount not valid", String.valueOf(amount));
        return amount;
    }

    public String getItemId() {
        return ItemId;
    }

    public int getAmount() {
        return amount;
    }
}
