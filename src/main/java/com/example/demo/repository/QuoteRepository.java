package com.example.demo.repository;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Proposal;
=======
import org.springframework.data.jpa.repository.JpaRepository;

>>>>>>> 29c1f66 (Initial project upload)
import com.example.demo.Entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long>{

<<<<<<< HEAD
	  Optional<Quote> findByProposal(Proposal proposal);
=======
>>>>>>> 29c1f66 (Initial project upload)
}
