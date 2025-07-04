package com.example.demo.Entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
>>>>>>> 29c1f66 (Initial project upload)
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "proposals")
@Data
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
=======
@Builder
>>>>>>> 29c1f66 (Initial project upload)
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;
<<<<<<< HEAD
    private String vehicleType;
    private LocalDate registrationDate;
    
    @Enumerated(EnumType.STRING)
    private ProposalStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore // Hides from Swagger input
    private User user;

    @Transient
    private Long userId; // Used for response only
}
=======

    private String vehicleType;

    private LocalDate registrationDate;

    private String status; // e.g., PENDING, APPROVED, REJECTED

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

>>>>>>> 29c1f66 (Initial project upload)
