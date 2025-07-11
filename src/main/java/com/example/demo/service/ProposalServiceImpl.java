package com.example.demo.service;

import com.example.demo.Entity.Proposal;
import com.example.demo.Entity.ProposalStatus;
import com.example.demo.Entity.User;
import com.example.demo.repository.ProposalRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProposalServiceImpl {

    private final ProposalRepository proposalRepository;
    private final UserRepository userRepository;

    /**
     * Create and submit a new proposal.
     */
    public Proposal submitProposal(Long userId, Proposal proposal) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        proposal.setUser(user);
        proposal.setStatus(ProposalStatus.SUBMITTED); // ✅ Use Enum

        Proposal saved = proposalRepository.save(proposal);
        saved.setUser(null); // Avoid exposing full user data
        saved.setUserId(userId);
        return saved;
    }

    /**
     * Get proposals for a specific user.
     */
    public List<Proposal> getProposalsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Proposal> proposals = proposalRepository.findByUser(user);
        proposals.forEach(p -> {
            p.setUser(null);
            p.setUserId(userId);
        });
        return proposals;
    }

    /**
     * Get all proposals.
     */
    public List<Proposal> getAllProposals() {
        List<Proposal> proposals = proposalRepository.findAll();
        proposals.forEach(p -> {
            p.setUserId(p.getUser().getId());
            p.setUser(null);
        });
        return proposals;
    }

    /**
     * Delete a proposal.
     */
    public void deleteProposal(Long proposalId) {
        proposalRepository.deleteById(proposalId);
    }

    /**
     * Update a proposal's status.
     */
    public void updateProposalStatus(Long proposalId, ProposalStatus newStatus) {
        Proposal proposal = proposalRepository.findById(proposalId)
                .orElseThrow(() -> new RuntimeException("Proposal not found"));

        proposal.setStatus(newStatus);
        proposalRepository.save(proposal);
    }

    /**
     * Approve a proposal.
     */
    public void approveProposal(Long proposalId) {
        updateProposalStatus(proposalId, ProposalStatus.APPROVED);
    }

    /**
     * Reject a proposal.
     */
    public void rejectProposal(Long proposalId) {
        updateProposalStatus(proposalId, ProposalStatus.REJECTED);
    }

    /**
     * Request additional information.
     */
    public void requestAdditionalInfo(Long proposalId) {
        updateProposalStatus(proposalId, ProposalStatus.PENDING_DOCUMENTS);
    }
}
