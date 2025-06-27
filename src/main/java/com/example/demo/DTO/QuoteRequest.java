package com.example.demo.DTO;


import lombok.Data;

@Data
public class QuoteRequest {
    private Long proposalId;
    private double premiumAmount;
    private String coverageDetails;
}
