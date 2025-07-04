package com.example.demo.DTO;


import lombok.Data;

import java.time.LocalDate;

@Data
public class PaymentRequest {
    private LocalDate paymentDate;
    private double amount;
    private String paymentMode;
    private Long quoteId;
    private Long userId;
}
