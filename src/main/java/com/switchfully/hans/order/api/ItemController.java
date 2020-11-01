package com.switchfully.hans.order.api;

import com.switchfully.hans.order.api.dto.CreateItemDto;
import com.switchfully.hans.order.api.dto.GetItemDto;

import com.switchfully.hans.order.domain.exceptions.NotAuthorizedException;
import com.switchfully.hans.order.domain.instances.Item;
import com.switchfully.hans.order.domain.repositories.AdminRepository;
import com.switchfully.hans.order.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;
    private final AdminRepository adminRepository;

    @Autowired
    public ItemController(ItemService itemService, AdminRepository adminRepository)  {
        this.itemService = itemService;
        this.adminRepository = adminRepository;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetItemDto> getAllItems(){
        logger.info("List of all items was requested.");
        return itemService.getItemList();
    }

    @PostMapping
    public Item addNewItem(@RequestBody CreateItemDto newItemDto, @RequestParam(required = false) String adminId) throws NotAuthorizedException {
        adminRepository.checkAdminId(adminId);
        Item newItem = new Item(newItemDto.getName(), newItemDto.getDescription(), newItemDto.getPrice(), newItemDto.getAmountInStock());
        itemService.addNewItem(newItem);
        return newItem;
    }
}
