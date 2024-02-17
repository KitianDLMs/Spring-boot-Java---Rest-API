package com.echnelapp.orderservice.dto;

import java.time.LocalDate;

public record OrderResponse(
        String orderId,
        String status,
        String accountId,
        Double totalAmount,
        Double totalTax,
        LocalDate transactionDate
) {}
