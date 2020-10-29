package com.switchfully.hans.order.domain.instances;

import com.switchfully.hans.order.api.dto.CreateItemGroupDto;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private String groupID;
    private final String selectedItemId;
    private final double amountOrdered;
    private LocalDate shippingDate;

    public ItemGroup(String selectedItemId, double amountOrdered) {
        this.groupID = UUID.randomUUID().toString();
        this.selectedItemId = selectedItemId;
        this.amountOrdered = amountOrdered;
    }

    /*public void setShippingDate(@RequestBody ItemRepository itemRepository) {
       Item itemToCheck = ItemRepository.getById(selectedItemId);
        if(itemToCheck.getAmountInStock() >= amountOrdered){
            this.shippingDate = LocalDate.now().plusDays(1);
        } else {
            this.shippingDate = LocalDate.now().plusDays(7);
        }
    }*/

    public String getSelectedItemId() {
        return selectedItemId;
    }

    public double getAmountOrdered() {
        return amountOrdered;
    }
}
