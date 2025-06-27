package com.example.demo.service;


import com.example.demo.DTO.ProposalRequest;
import com.example.demo.DTO.ProposalResponse;
import com.example.demo.Entity.Proposal;
import com.example.demo.Entity.User;
import com.example.demo.repository.ProposalRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;
    private final UserRepository userRepository;

    public ProposalServiceImpl(ProposalRepository proposalRepository, UserRepository userRepository) {
        this.proposalRepository = proposalRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ProposalResponse submitProposal(ProposalRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Proposal proposal = Proposal.builder()
                .vehicleNumber(request.getVehicleNumber())
                .vehicleType(request.getVehicleType())
                .registrationDate(request.getRegistrationDate())
                .status("PENDING")
                .user(user)
                .build();

        Proposal saved = proposalRepository.save(proposal);

        return ProposalResponse.builder()
                .id(saved.getId())
                .vehicleNumber(saved.getVehicleNumber())
                .vehicleType(saved.getVehicleType())
                .status(saved.getStatus())
                .userEmail(user.getEmail())
                .build();
    }

    @Override
    public List<ProposalResponse> getProposalsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return proposalRepository.findByUser(user).stream()
                .map(p -> ProposalResponse.builder()
                        .id(p.getId())
                        .vehicleNumber(p.getVehicleNumber())
                        .vehicleType(p.getVehicleType())
                        .status(p.getStatus())
                        .userEmail(user.getEmail())
                        .build())
                .collect(Collectors.toList());
    }
}
