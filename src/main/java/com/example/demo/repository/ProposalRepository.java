package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Proposal;
<<<<<<< HEAD
import com.example.demo.Entity.ProposalStatus;
=======
>>>>>>> 29c1f66 (Initial project upload)
import com.example.demo.Entity.User;

import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    List<Proposal> findByUser(User user);
<<<<<<< HEAD
    List<Proposal> findByStatus(ProposalStatus status);

=======
>>>>>>> 29c1f66 (Initial project upload)
}

