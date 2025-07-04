package com.example.demo.controller;

import com.example.demo.Entity.Proposal;
import com.example.demo.Entity.ProposalStatus;
import com.example.demo.Entity.User;
import com.example.demo.repository.ProposalRepository;
import com.example.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/officer")
@RequiredArgsConstructor
public class OfficerController {

    private final ProposalRepository proposalRepository;
    private final UserServiceImpl userService;

    /**
     * Officer registration API
     */
    @PostMapping("/register")
    public String registerOfficer(@RequestBody User officerAsUser) {
        // Don't set role forcibly; let it come from frontend or set it here for safety
        officerAsUser.setRole("OFFICER");
        return userService.register(officerAsUser);
    }


    /**
     * Get all proposals with status PENDING
     */
    @GetMapping("/proposals")
    public ResponseEntity<List<Proposal>> getPendingProposals() {
        return ResponseEntity.ok(
                proposalRepository.findByStatus(ProposalStatus.PENDING)
        );
    }

    /**
     * Update proposal status
     */
    @PostMapping("/proposals/{id}/update-status")
    public ResponseEntity<String> updateProposalStatus(@PathVariable Long id,
                                                       @RequestParam ProposalStatus status) {

        Proposal proposal = proposalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proposal not found"));

        proposal.setStatus(status);
        proposalRepository.save(proposal);
        return ResponseEntity.ok("Proposal status updated to " + status);
    }
}
