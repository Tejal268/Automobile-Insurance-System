package com.example.demo.DTO;


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

