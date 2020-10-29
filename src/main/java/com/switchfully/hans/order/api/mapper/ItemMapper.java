package com.switchfully.hans.order.api.mapper;

import com.switchfully.hans.order.api.dto.CreateItemDto;
import com.switchfully.hans.order.domain.instances.Item;

public class ItemMapper {
    public static Item convertNewItemDtoToItem(CreateItemDto newItemDto){
        return new Item(newItemDto.getName(), newItemDto.getDescription(), newItemDto.getPrice(), newItemDto.getAmountInStock());
    }
}
