package com.team.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.stock.dbservice.classes.Accordion;
import com.team.stock.dbservice.classes.ConversionTable;

public interface ConversionTableRepository extends JpaRepository<ConversionTable, Integer>{

	List<ConversionTable> findAll();

    @Query("SELECT r.db_name FROM ConversionTable r where r.hebrew_name = :hebrew_name") 
    String findDBName(@Param("hebrew_name") String hebrew_name);
}
