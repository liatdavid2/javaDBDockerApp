package com.team.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.stock.dbservice.classes.Accordion;
import com.team.stock.dbservice.classes.ConversionTable;
import com.team.stock.dbservice.classes.Pilots;

public interface PilotsRepository extends JpaRepository<Pilots, Integer>{

    @Query("SELECT r.last_name FROM Pilots r where r.name = :name") 
    List<String> find_last_name_ByName(@Param("name") String name);
}
