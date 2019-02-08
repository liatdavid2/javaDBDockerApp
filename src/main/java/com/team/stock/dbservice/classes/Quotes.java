package com.team.stock.dbservice.classes;

import java.util.List;

public class Quotes {
	private String userName;
	private List<String>Quotes;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getQuotes() {
		return Quotes;
	}
	public void setQuotes(List<String> quotes) {
		Quotes = quotes;
	}
	public Quotes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
