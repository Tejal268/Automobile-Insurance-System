package com.example.demo.service;

import com.example.demo.Entity.Proposal;
import com.example.demo.Entity.Quote;
import com.example.demo.Exceptions.QuoteNotFoundException;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.repository.ProposalRepository;
import com.example.demo.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl {

    private final QuoteRepository quoteRepository;
    private final ProposalRepository proposalRepository;

    public Quote generateQuote(Long proposalId, Quote quote) {
        Proposal proposal = proposalRepository.findById(proposalId)
                .orElseThrow(() -> new ResourceNotFoundException("Proposal not found with ID: " + proposalId));

        quote.setProposal(proposal);
        return quoteRepository.save(quote);
    }

    public Quote getQuoteByProposalId(Long proposalId) {
        Proposal proposal = proposalRepository.findById(proposalId)
                .orElseThrow(() -> new ResourceNotFoundException("Proposal not found with ID: " + proposalId));

        return quoteRepository.findByProposal(proposal)
                .orElseThrow(() -> new QuoteNotFoundException("Quote not found for proposal ID: " + proposalId));
    }

    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }
}
