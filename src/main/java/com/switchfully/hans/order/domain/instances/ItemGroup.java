package com.switchfully.hans.order.domain.instances;

import com.switchfully.hans.order.api.dto.CreateItemGroupDto;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private final String selectedItemId;
    private final double amountOrdered;
    private LocalDate shippingDate;

    public ItemGroup(String selectedItemId, double amountOrdered) {
        this.selectedItemId = selectedItemId;
        this.amountOrdered = amountOrdered;
        this.shippingDate = LocalDate.now().plusWeeks(1);
    }

    public String getSelectedItemId() {
        return selectedItemId;
    }

    public double getAmountOrdered() {
        return amountOrdered;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }
}
