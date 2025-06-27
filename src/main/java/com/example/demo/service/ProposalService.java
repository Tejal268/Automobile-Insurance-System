package com.example.demo.service;

import com.example.demo.DTO.ProposalRequest;
import com.example.demo.DTO.ProposalResponse;

import java.util.List;

public interface ProposalService {
    ProposalResponse submitProposal(ProposalRequest request);
    List<ProposalResponse> getProposalsByUserId(Long userId);
}
