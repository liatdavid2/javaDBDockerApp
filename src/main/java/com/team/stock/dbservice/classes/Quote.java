package com.team.stock.dbservice.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quote")
public class Quote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String username;
	private String Quote;
	
	
	public Quote( String username, String quote) {
		super();
		this.id = id;
		this.username = username;
		Quote = quote;
	}
	public String getQuote() {
		return Quote;
	}
	public void setQuote(String quote) {
		Quote = quote;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
