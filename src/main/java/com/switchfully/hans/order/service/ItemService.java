package com.switchfully.hans.order.service;


import com.switchfully.hans.order.api.dto.CreateOrderDto;
import com.switchfully.hans.order.api.dto.GetItemDto;

import com.switchfully.hans.order.domain.instances.Item;
import com.switchfully.hans.order.domain.instances.ItemGroup;
import com.switchfully.hans.order.domain.repositories.AdminRepository;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    public final ItemRepository itemRepository;
    private AdminRepository adminRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Collection<Item> getAll() {
        return itemRepository.getAll();
    }

    public List<GetItemDto> getItemList() {
        return getAll().stream()
                .map(item -> new GetItemDto()
                        .setId(item.getId())
                        .setName(item.getName())
                        .setDescription(item.getDescription())
                        .setPrice(item.getPrice())
                        .setAmountInStock(item.getAmountInStock()))
                .collect(Collectors.toList());
    }
    public void addNewItem(Item newItemToAdd){
        itemRepository.addNewItem(newItemToAdd);
    }


    public double calculateTotalPrice(CreateOrderDto createOrderDto) {
        double totalPrice = 0;
        for (ItemGroup itemGroup : createOrderDto.getItemGroups() ) {
            itemRepository.checkItemId(itemGroup.getItemId());
            totalPrice += itemGroup.getAmount() * itemRepository.getItemById(itemGroup.getItemId()).getPrice();
        }
        return totalPrice;
    }

    public void setShippingDate(CreateOrderDto createOrderDto) {
        for (ItemGroup itemGroup : createOrderDto.getItemGroups() ) {
            if(itemRepository.getItemById(itemGroup.getItemId()).getAmountInStock() > itemGroup.getAmount()){
                itemGroup.setShippingDate(LocalDate.now().plusDays(1));
            } else {
                itemGroup.setShippingDate(LocalDate.now().plusDays(7));
            }
        }
    }
}
