package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Officer;

public interface OfficerRepository extends JpaRepository<Officer, Long>{

}
