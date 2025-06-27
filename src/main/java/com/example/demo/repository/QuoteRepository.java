package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long>{

}
