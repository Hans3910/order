package com.switchfully.hans.order.service;

import com.switchfully.hans.order.api.dto.CreateItemGroupDto;
import com.switchfully.hans.order.api.dto.GetOrderDto;
import com.switchfully.hans.order.domain.instances.ItemGroup;
import com.switchfully.hans.order.domain.instances.Order;
import com.switchfully.hans.order.domain.repositories.ItemRepository;
import com.switchfully.hans.order.domain.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public List<GetOrderDto> getOrderList() {
        List<Order> orders = getAll();

        List<GetOrderDto> list = new ArrayList<>();
        for (Order order : orders) {
            GetOrderDto getOrderDto = new GetOrderDto(order.getOrderId(), new ArrayList<>());
            for (int j = 0; j < order.getItemGroups().size(); j++) {
                CreateItemGroupDto createItemGroupDto = new CreateItemGroupDto(order.getOrderId(), order.getItemGroups().get(j).getSelectedItemId(), order.getItemGroups().get(j).getAmountOrdered());
                getOrderDto.getItemGroups().add(createItemGroupDto);
                getOrderDto.setTotalOrderPrice(calculate());
            }

            list.add(getOrderDto);
        }
        return list;
    }

    public double calculate(){
        List<List<ItemGroup>> itemGroups = orderRepository.getOrders().values()
                .stream()
                .map(Order::getItemGroups)
                .collect(Collectors.toList());

        List<ItemGroup> list = new ArrayList<>();
        for (List<ItemGroup> itemGroup : itemGroups) {
            list.addAll(itemGroup);
        }

        return list.stream()
                .mapToDouble(itemGroup -> itemGroup.getAmountOrdered() * ItemService.getItemById(itemGroup.getSelectedItemId()).getPrice())
                .sum();
    }




}
