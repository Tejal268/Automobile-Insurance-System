package com.example.demo.controller;

import com.example.demo.DTO.ProposalRequest;
import com.example.demo.DTO.ProposalResponse;
import com.example.demo.service.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proposals")
@RequiredArgsConstructor
public class ProposalController {

    private final ProposalService proposalService;

    // ✅ Submit new proposal
    @PostMapping("/submit")
    public ResponseEntity<ProposalResponse> submitProposal(@RequestBody ProposalRequest request) {
        ProposalResponse response = proposalService.submitProposal(request);
        return ResponseEntity.ok(response);
    }

    // ✅ Get all proposals for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProposalResponse>> getUserProposals(@PathVariable Long userId) {
        List<ProposalResponse> proposals = proposalService.getProposalsByUserId(userId);
        return ResponseEntity.ok(proposals);
    }
}
