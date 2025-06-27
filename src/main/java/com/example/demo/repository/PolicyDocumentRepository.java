package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.PolicyDocument;

public interface PolicyDocumentRepository extends JpaRepository<PolicyDocument, Long>{

}
