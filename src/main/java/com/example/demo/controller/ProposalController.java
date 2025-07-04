package com.example.demo.controller;

<<<<<<< HEAD
import com.example.demo.Entity.Proposal;
import com.example.demo.service.ProposalServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
=======
import com.example.demo.DTO.ProposalRequest;
import com.example.demo.DTO.ProposalResponse;
import com.example.demo.service.ProposalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
>>>>>>> 29c1f66 (Initial project upload)
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proposals")
@RequiredArgsConstructor
public class ProposalController {

<<<<<<< HEAD
    private final ProposalServiceImpl proposalService;

    @PostMapping("/submit/{userId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Proposal> submitProposal(
            @PathVariable Long userId,
            @RequestBody Proposal proposal
    ) {
        Proposal savedProposal = proposalService.submitProposal(userId, proposal);
        return ResponseEntity.ok(savedProposal);
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyRole('USER', 'OFFICER')")
    public ResponseEntity<List<Proposal>> getUserProposals(@PathVariable Long userId) {
        return ResponseEntity.ok(proposalService.getProposalsByUserId(userId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Proposal>> getAllProposals() {
        return ResponseEntity.ok(proposalService.getAllProposals());
    }
    
    @DeleteMapping("/{proposalId}")
    public ResponseEntity<String> deleteProposal(@PathVariable Long proposalId) {
        proposalService.deleteProposal(proposalId);
        return ResponseEntity.ok("Proposal deleted successfully");
    }
    
 // Approve a proposal
    @PostMapping("/approve/{proposalId}")
    @PreAuthorize("hasRole('OFFICER')")
    public ResponseEntity<String> approveProposal(@PathVariable Long proposalId) {
        proposalService.approveProposal(proposalId);
        return ResponseEntity.ok("Proposal approved");
    }

    // Reject a proposal
    @PostMapping("/reject/{proposalId}")
    @PreAuthorize("hasRole('OFFICER')")
    public ResponseEntity<String> rejectProposal(@PathVariable Long proposalId) {
        proposalService.rejectProposal(proposalId);
        return ResponseEntity.ok("Proposal rejected");
    }

    // Request additional information
    @PostMapping("/request-info/{proposalId}")
    @PreAuthorize("hasRole('OFFICER')")
    public ResponseEntity<String> requestAdditionalInfo(@PathVariable Long proposalId) {
        proposalService.requestAdditionalInfo(proposalId);
        return ResponseEntity.ok("Requested additional info");
    }


}

=======
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
>>>>>>> 29c1f66 (Initial project upload)
