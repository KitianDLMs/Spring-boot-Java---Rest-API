package com.echnelapp.orderservice.service;

import com.echnelapp.orderservice.dto.OrderRequest;
import com.echnelapp.orderservice.model.Order;
import com.echnelapp.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderRequest orderRequest) {
        Order order = Order.builder()
                .accountId(orderRequest.accountId())
                .status("PENDING")
                .totalAmount(orderRequest.totalAmount())
                .totalTax(orderRequest.totalTax())
                .transactionDate(LocalDate.now())
                .build();

        return orderRepository.save(order);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(String orderId) {
        return orderRepository.findByOrderId(orderId).orElse(null);
    }


    public Optional<Order> updateOrder(String orderId, OrderRequest orderRequest) {
        return orderRepository.findByOrderId(orderId).map(existingOrder -> {
            existingOrder.setAccountId(orderRequest.accountId());
            existingOrder.setTotalAmount(orderRequest.totalAmount());
            existingOrder.setTotalTax(orderRequest.totalTax());
            return orderRepository.save(existingOrder);
        });
    }

    public void deleteOrder(String orderId) {
        orderRepository.findByOrderId(orderId).ifPresent(orderRepository::delete);
    }
}
