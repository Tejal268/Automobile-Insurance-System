package com.example.demo.service;

import com.example.demo.dto.ProposalRequest;
import com.example.demo.dto.ProposalResponse;

import java.util.List;

public interface ProposalService {
    ProposalResponse submitProposal(ProposalRequest request);
    List<ProposalResponse> getProposalsByUserId(Long userId);
}
