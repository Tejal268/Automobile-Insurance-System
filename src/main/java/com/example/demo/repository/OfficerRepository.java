package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Officer;

public interface OfficerRepository extends JpaRepository<Officer, Long>{

	Optional<Officer> findByEmail(String email);
    boolean existsByEmail(String email);
}
