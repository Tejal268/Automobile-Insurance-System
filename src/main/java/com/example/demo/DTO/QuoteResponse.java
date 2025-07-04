package com.example.demo.DTO;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class QuoteResponse {
    private Long id;
    private double premiumAmount;
    private String coverageDetails;
    private LocalDate validTill;
    private Long proposalId;
}

