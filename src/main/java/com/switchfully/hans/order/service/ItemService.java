package com.switchfully.hans.order.service;

import com.switchfully.hans.order.api.ItemController;
import com.switchfully.hans.order.api.dto.CreateItemDto;
import com.switchfully.hans.order.api.dto.GetItemDto;
import com.switchfully.hans.order.domain.exceptions.NotAuthorizedException;
import com.switchfully.hans.order.domain.instances.Admin;
import com.switchfully.hans.order.domain.instances.Item;
import com.switchfully.hans.order.domain.repositories.AdminRepository;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(Item newItem) {
        itemRepository.addBook(newItem);
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

    public void checkAdminId(String adminId) throws NotAuthorizedException {
        if (adminId == null || adminId.isBlank() || !AdminRepository.getAdministrators().containsKey(adminId)) {
            throw new NotAuthorizedException(Admin.class, "AdminId", adminId);
        }
    }

    public void createNewItem(CreateItemDto createItemDto) {
        Item newItem = new Item(createItemDto.getName(), createItemDto.getDescription(), createItemDto.getPrice(), createItemDto.getAmountInStock());
        addItem(newItem);
    }
}
