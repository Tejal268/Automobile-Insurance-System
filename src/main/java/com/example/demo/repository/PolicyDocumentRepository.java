package com.example.demo.repository;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Payment;
import com.example.demo.Entity.Policy;


public interface PolicyDocumentRepository extends JpaRepository<Policy, Long>{

	Optional<Policy> findByPayment(Payment payment);
=======
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.PolicyDocument;

public interface PolicyDocumentRepository extends JpaRepository<PolicyDocument, Long>{
>>>>>>> 29c1f66 (Initial project upload)

}
