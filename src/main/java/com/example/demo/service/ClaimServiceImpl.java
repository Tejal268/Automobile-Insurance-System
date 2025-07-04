package com.example.demo.service;

import com.example.demo.Entity.*;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.repository.ClaimRepository;
import com.example.demo.repository.PolicyDocumentRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaimServiceImpl {

    private final ClaimRepository claimRepository;
    private final UserRepository userRepository;
    private final PolicyDocumentRepository policyRepository;

    public Claim fileClaim(Long userId, Long policyId, String reason) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Policy policy = policyRepository.findById(policyId)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));

        Claim claim = new Claim();
        claim.setClaimDate(LocalDate.now());
        claim.setReason(reason);
        claim.setStatus(ClaimStatus.PENDING);
        claim.setUser(user);
        claim.setPolicy(policy);

        return claimRepository.save(claim);
    }

    public List<Claim> getClaimsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return claimRepository.findByUser(user);
    }

    public Claim updateClaimStatus(Long claimId, ClaimStatus status) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));

        claim.setStatus(status);
        return claimRepository.save(claim);
    }
}
