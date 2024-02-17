package com.echnelapp.orderservice.converter;

import com.echnelapp.orderservice.dto.OrderResponse;
import com.echnelapp.orderservice.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {

    public OrderResponse convertEntityToDto(Order order) {
        return new OrderResponse(
                order.getOrderId(),
                order.getStatus(),
                order.getAccountId(),
                order.getTotalAmount(),
                order.getTotalTax(),
                order.getTransactionDate()
        );
    }

    public List<OrderResponse> convertEntityToDto(List<Order> orders) {
        return orders.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
}