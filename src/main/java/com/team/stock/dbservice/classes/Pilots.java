package com.team.stock.dbservice.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pilots {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String last_name;
	
	
	public Pilots(Integer id, String name, String last_name) {
		super();
		this.id = id;
		this.name = name;
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "Pilots [id=" + id + ", name=" + name + ", last_name=" + last_name + "]";
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

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Pilots() {
		// TODO Auto-generated constructor stub
	}

}
