package com.switchfully.hans.order.api.mapper;

import com.switchfully.hans.order.api.dto.CreateItemGroupDto;
import com.switchfully.hans.order.domain.instances.ItemGroup;

import java.util.List;
import java.util.stream.Collectors;

public class ItemGroupMapper {
    public static List<ItemGroup> convertToList(List<CreateItemGroupDto> itemGroupDtosToConvert){
        return itemGroupDtosToConvert.stream()
                .map(itemGroupDto -> new ItemGroup(itemGroupDto.getOrderedItemID(), itemGroupDto.getOrderedItemAmount()))
                .collect(Collectors.toList());
    }

}
