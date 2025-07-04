package com.example.demo.controller;

import com.example.demo.Entity.Policy;
import com.example.demo.service.PolicyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
@RequiredArgsConstructor
public class PolicyDocumentController {

    private final PolicyServiceImpl policyDocumentService;

    @PostMapping("/generate/{paymentId}")
    public ResponseEntity<Policy> generatePolicyDoc(@PathVariable Long paymentId) {
        Policy document = policyDocumentService.generatePolicyDocument(paymentId);
        return ResponseEntity.ok(document);
    }

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        List<Policy> policies = policyDocumentService.getAllPolicies();
        return ResponseEntity.ok(policies);
    }
}
