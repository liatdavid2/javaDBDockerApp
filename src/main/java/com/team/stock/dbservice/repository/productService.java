package com.team.stock.dbservice.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.team.stock.dbservice.classes.ProductJdbc;
@Service	
public class productService {
	@Autowired
	com.team.stock.dbservice.dao.productDaoImpl productDaoImpl;
	public Collection<ProductJdbc> findAll() {
		return productDaoImpl.findAll();
	}
}
