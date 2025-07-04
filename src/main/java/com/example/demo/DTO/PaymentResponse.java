package com.example.demo.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {
    private Long id;
    private double amount;
    private String paymentMode;
    private String userEmail;
}

