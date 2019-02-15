package com.team.stock.dbservice.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planes {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String pilot_name;
	
	
	public Planes(Integer id, String name, String pilot_name) {
		super();
		this.id = id;
		this.name = name;
		this.pilot_name = pilot_name;
	}


	@Override
	public String toString() {
		return "Planes [id=" + id + ", name=" + name + ", pilot_name=" + pilot_name + "]";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPilot_name() {
		return pilot_name;
	}


	public void setPilot_name(String pilot_name) {
		this.pilot_name = pilot_name;
	}


	public Planes() {
		// TODO Auto-generated constructor stub
	}

}
