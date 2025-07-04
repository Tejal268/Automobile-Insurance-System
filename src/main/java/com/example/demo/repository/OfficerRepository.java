package com.example.demo.repository;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> 29c1f66 (Initial project upload)
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Officer;

public interface OfficerRepository extends JpaRepository<Officer, Long>{

<<<<<<< HEAD
	Optional<Officer> findByEmail(String email);
    boolean existsByEmail(String email);
=======
>>>>>>> 29c1f66 (Initial project upload)
}
