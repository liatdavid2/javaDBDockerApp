package com.team.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.stock.dbservice.classes.Accordion;

public interface AccordionRepository extends JpaRepository<Accordion, Integer>{

	List<Accordion> findAll();

}
