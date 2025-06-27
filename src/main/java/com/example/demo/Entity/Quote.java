package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "quotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double premiumAmount;
    private String coverageDetails;
    private LocalDate validTill;

    @OneToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;
}
