package com.example.demo.controller;


import com.example.demo.Entity.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ProposalRepository proposalRepository;
    private final PaymentRepository paymentRepository;
    private final QuoteRepository quoteRepository;
    private final PolicyDocumentRepository policyDocumentRepository;
    private final UserRepository userRepository;
    
    @GetMapping("/proposals")
    public ResponseEntity<List<Proposal>> getAllProposals() {
        return ResponseEntity.ok(proposalRepository.findAll());
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentRepository.findAll());
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getAllQuotes() {
        return ResponseEntity.ok(quoteRepository.findAll());
    }

    @GetMapping("/documents")
    public ResponseEntity<List<Policy>> getAllPolicyDocs() {
        return ResponseEntity.ok(policyDocumentRepository.findAll());
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }
}
