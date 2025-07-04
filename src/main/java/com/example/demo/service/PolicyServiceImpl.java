package com.example.demo.service;

import com.example.demo.Entity.Payment;
import com.example.demo.Entity.Policy;
import com.example.demo.repository.PaymentRepository;
import com.example.demo.repository.PolicyDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PolicyServiceImpl {

    private final PolicyDocumentRepository policyDocumentRepository;
    private final PaymentRepository paymentRepository;

    /**
     * Generate a new Policy for the given payment.
     */
    public Policy generatePolicyDocument(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        Policy policy = new Policy();
        policy.setIssuedDate(LocalDate.now());
        policy.setPayment(payment);

        // Just save the policy without documentUrl
        return policyDocumentRepository.save(policy);
    }

    /**
     * Retrieve all saved policies.
     */
    public List<Policy> getAllPolicies() {
        return policyDocumentRepository.findAll();
    }
}
