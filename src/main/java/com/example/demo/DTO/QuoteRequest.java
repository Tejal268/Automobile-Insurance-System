package com.example.demo.dto;


import lombok.Data;

@Data
public class QuoteRequest {
    private Long proposalId;
    private double premiumAmount;
    private String coverageDetails;
}
