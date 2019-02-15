package com.team.stock.dbservice.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConversionTable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String hebrew_name;
	private String db_name;
	
	
	@Override
	public String toString() {
		return "ConversionTable [id=" + id + ", hebrew_name=" + hebrew_name + ", db_name=" + db_name + "]";
	}


	public ConversionTable(Integer id, String hebrew_name, String db_name) {
		super();
		this.id = id;
		this.hebrew_name = hebrew_name;
		this.db_name = db_name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getHebrew_name() {
		return hebrew_name;
	}


	public void setHebrew_name(String hebrew_name) {
		this.hebrew_name = hebrew_name;
	}


	public String getDb_name() {
		return db_name;
	}


	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}


	public ConversionTable() {
		// TODO Auto-generated constructor stub
	}

}
