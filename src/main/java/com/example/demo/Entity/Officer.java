package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "officers")
@Data
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD

=======
@Builder
>>>>>>> 29c1f66 (Initial project upload)
public class Officer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String designation; // e.g., Inspector, Underwriter
}
