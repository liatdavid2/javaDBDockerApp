package com.team.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.stock.dbservice.classes.Accordion;

public interface AccordionRepository extends JpaRepository<Accordion, Integer>{

	List<Accordion> findAll();

   // @Query("SELECT r.* FROM RuleVo r where r.name = :name") 
    //List<?> findIdByName(@Param("name") String name);
}
