package com.example.demo.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfficerResponse {
    private Long id;
    private String name;
    private String email;
    private String designation;
}
