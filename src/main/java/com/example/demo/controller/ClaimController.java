package com.example.demo.controller;

import com.example.demo.Entity.Claim;
import com.example.demo.Entity.ClaimStatus;
import com.example.demo.service.ClaimServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@RequiredArgsConstructor
public class ClaimController {

    private final ClaimServiceImpl claimService;

    @PostMapping("/file")
    public ResponseEntity<Claim> fileClaim(@RequestParam Long userId,
                                           @RequestParam Long policyId,
                                           @RequestParam String reason) {
        return ResponseEntity.ok(claimService.fileClaim(userId, policyId, reason));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Claim>> getClaimsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(claimService.getClaimsByUser(userId));
    }

    @PutMapping("/update-status/{claimId}")
    public ResponseEntity<Claim> updateStatus(@PathVariable Long claimId,
                                              @RequestParam ClaimStatus status) {
        return ResponseEntity.ok(claimService.updateClaimStatus(claimId, status));
    }
}
