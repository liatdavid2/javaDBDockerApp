package com.team.stock.dbservice.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Accordion")
public class Accordion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String Headline;
	private String Body;
	
	

	@Override
	public String toString() {
		return "Accordion [id=" + id + ", Headline=" + Headline + ", Body=" + Body + "]";
	}



	public Accordion(Integer id, String headline, String body) {
		super();
		this.id = id;
		Headline = headline;
		Body = body;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getHeadline() {
		return Headline;
	}



	public void setHeadline(String headline) {
		Headline = headline;
	}



	public String getBody() {
		return Body;
	}



	public void setBody(String body) {
		Body = body;
	}



	public Accordion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
