package com.echnelapp.orderservice.dto;

public record OrderRequest(
        String accountId,
        Double totalAmount,
        Double totalTax
) {}
