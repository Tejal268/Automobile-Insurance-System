package com.example.demo.DTO;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProposalResponse {
    private Long id;
    private String vehicleNumber;
    private String vehicleType;
    private String status;
    private String userEmail;
}
