package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

<<<<<<< HEAD
import java.time.LocalDate;


=======
>>>>>>> 29c1f66 (Initial project upload)
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
=======
@Builder
>>>>>>> 29c1f66 (Initial project upload)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String role; // USER, OFFICER, ADMIN
<<<<<<< HEAD

    private String address;

    @Column(unique = true, nullable = false)
    private String aadhaarNumber;

    @Column(unique = true, nullable = false)
    private String panNumber;

    private LocalDate dateOfBirth;

    private int age;

    
=======
>>>>>>> 29c1f66 (Initial project upload)
}
