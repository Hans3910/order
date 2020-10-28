package com.switchfully.hans.order.domain.instances;

import com.switchfully.hans.order.api.dto.CreateItemGroupDto;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

public class ItemGroup {
    private final String selectedItemId;
    private final double amountOrdered;
    private LocalDate shippingDate;

    public ItemGroup(String selectedItemId, double amountOrdered, ItemRepository itemRepository) {
        this.selectedItemId = selectedItemId;
        this.amountOrdered = amountOrdered;
        setShippingDate(itemRepository);
    }

    public void setShippingDate(ItemRepository itemRepository) {
        Item itemToCheck = itemRepository.getById(selectedItemId);
        if(itemToCheck.getAmountInStock() >= amountOrdered){
            this.shippingDate = LocalDate.now().plusDays(1);
        } else {
            this.shippingDate = LocalDate.now().plusDays(7);
        }
    }
}
