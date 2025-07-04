package com.example.demo.Entity;

<<<<<<< HEAD
=======

>>>>>>> 29c1f66 (Initial project upload)
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
>>>>>>> 29c1f66 (Initial project upload)
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

<<<<<<< HEAD
    @Column(name = "premium_amount", nullable = false)
    private double amount;

    private LocalDate expiryDate;

    @OneToOne
    @JoinColumn(name = "proposal_id", nullable = false)
    @JsonIgnore  // ✅ Add this line
=======
    private double premiumAmount;
    private String coverageDetails;
    private LocalDate validTill;

    @OneToOne
    @JoinColumn(name = "proposal_id")
>>>>>>> 29c1f66 (Initial project upload)
    private Proposal proposal;
}
