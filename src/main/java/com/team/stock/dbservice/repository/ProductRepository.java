package com.team.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.stock.dbservice.classes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAll();

}
