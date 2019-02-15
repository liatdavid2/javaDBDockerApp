package com.team.stock.dbservice.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.team.stock.dbservice.classes.JoinCitiesAccordion;
import com.team.stock.dbservice.classes.ProductJdbc;
@Repository
public class productDaoImpl implements productDao{

	@Autowired
	JdbcTemplate JdbcTemplate;
	
	@Override
	public Collection<ProductJdbc> findAll() {
		//List<JoinCitiesAccordion>usernameList=new ArrayList<>();
		return JdbcTemplate.query(" SELECT * from world.product_jdbc "
				,new BeanPropertyRowMapper<>(ProductJdbc.class) );
		
	}

}
