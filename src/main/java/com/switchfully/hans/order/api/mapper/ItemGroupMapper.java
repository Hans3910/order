package com.switchfully.hans.order.api.mapper;

import com.switchfully.hans.order.api.dto.ItemGroupDTO;
import com.switchfully.hans.order.domain.instances.ItemGroup;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ItemGroupMapper {
    public ItemGroup createItemGroup(ItemGroupDTO itemGroupDTO, LocalDate shippingDate) {
        ItemGroup result = new ItemGroup(
                itemGroupDTO.getOrderId(),
                itemGroupDTO.getItemId(),
                itemGroupDTO.getAmount(),
                itemGroupDTO.getOrderPrice(),
                shippingDate
        );
        return result;
    }

    public ItemGroupDTO detailDTO(ItemGroup itemGroup) {
        ItemGroupDTO result = new ItemGroupDTO();
        result.setOrderId(itemGroup.getOrderId());
        result.setItemId(itemGroup.getItemId());
        result.setAmount(itemGroup.getAmount());
        result.setOrderPrice(itemGroup.getPrice());
        result.setShippingDate(itemGroup.getShippingDate());
        result.setItemGroupId(itemGroup.getItemGroupId());
        return result;
    }
}
