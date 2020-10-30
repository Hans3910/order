package com.switchfully.hans.order.api.mapper;

import com.switchfully.hans.order.api.dto.OrderDto;
import com.switchfully.hans.order.domain.instances.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order createOrder(OrderDto orderDTO) {
        Order result = new Order(
                orderDTO.getCustomerId()
        );
        return result;
    }

    public OrderDto detailDTO(Order order) {
        OrderDto result = new OrderDto();
        result.setOrderId(order.getOrderId());
        result.setCustomerId(order.getCustomerId());
        result.setItemGroups(order.getItemGroups());
        result.setTotalPrice(order.getTotalPrice());
        return result;
    }


}