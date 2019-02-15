package com.team.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.stock.dbservice.classes.Quote;

public interface QuoetsRepository extends JpaRepository<Quote, Integer>{

	List<Quote> findByusername(String username);

}
