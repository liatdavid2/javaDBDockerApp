package com.team.stock.dbservice.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.team.stock.dbservice.classes.JoinCitiesAccordion;

@Repository
public class JDBCRepository {

	@Autowired
	JdbcTemplate JdbcTemplate;

	public List<String> getAllBodyName(String column,String table,String condition){
		List<String>usernameList=new ArrayList<>();
		usernameList.addAll(JdbcTemplate.queryForList(" SELECT "+ column+" FROM world."+table+" where "+
				condition,String.class));
		return usernameList;
	}
	public List<JoinCitiesAccordion> getJoinCitiesAccordion(){
		List<JoinCitiesAccordion>usernameList=new ArrayList<>();
		usernameList= JdbcTemplate.query(" SELECT world.city.ID as id,name FROM world.city  join world.accordion on world.city.id=world.accordion.id  "
				,new BeanPropertyRowMapper(JoinCitiesAccordion.class) );
		return usernameList;
	}
	public List<?> getobjJoinCitiesAccordion(){
		List<JoinCitiesAccordion>usernameList=new ArrayList<>();
		usernameList= JdbcTemplate.query(" SELECT * FROM world.city  join world.accordion on world.city.id=world.accordion.id  "
				,new BeanPropertyRowMapper(JoinCitiesAccordion.class) );
		return usernameList;
	}
}
