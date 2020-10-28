package com.switchfully.hans.order.api;

import com.switchfully.hans.order.api.dto.CreateItemGroupDto;
import com.switchfully.hans.order.api.dto.GetOrderDto;
import com.switchfully.hans.order.domain.exceptions.NotAuthorizedException;
import com.switchfully.hans.order.domain.instances.Admin;
import com.switchfully.hans.order.domain.instances.Customer;
import com.switchfully.hans.order.domain.instances.ItemGroup;
import com.switchfully.hans.order.domain.instances.Order;
import com.switchfully.hans.order.domain.repositories.AdminRepository;
import com.switchfully.hans.order.domain.repositories.CustomerRepository;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import com.switchfully.hans.order.domain.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(Order.class);
    // HIER VERDERGAAN!! NIET AF
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetOrderDto> getAllOrders(){
        logger.info("List of all Orders was requested.");
        return OrderRepository.getOrders().values().stream()
                .map(order -> new GetOrderDto()
                        .setOrderID(order.getOrderId())
                        .setItemGroups(order.getItemGroups()))
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(CreateItemGroupDto [] order, @RequestBody ItemRepository itemRepository, @RequestParam(required = false) String customerId) throws NotAuthorizedException {
        if (customerId == null || customerId.isBlank() || !CustomerRepository.getCustomers().containsKey(customerId)) {
            throw new NotAuthorizedException(Customer.class, "CustomerId", customerId);
        }

        List<ItemGroup> itemGroupsInOrder = new ArrayList<>();
        Order newOrder = new Order(itemGroupsInOrder);
        for (CreateItemGroupDto createItemGroupDto : order ) {
            ItemGroup itemGroupToAdd = new ItemGroup(createItemGroupDto.getOrderedItemID(), createItemGroupDto.getOrderedItemAmount(), itemRepository);
            newOrder.getItemGroups().add(itemGroupToAdd);
        }
        OrderRepository.getOrders().put(newOrder.getOrderId(), newOrder);
    }


}
