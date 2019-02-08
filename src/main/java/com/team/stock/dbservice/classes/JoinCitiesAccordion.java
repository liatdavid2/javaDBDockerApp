package com.team.stock.dbservice.classes;

public class JoinCitiesAccordion {
	private Integer ID;
	private String Name;
	
	public JoinCitiesAccordion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JoinCitiesAccordion(Integer iD, String name) {
		super();
		ID = iD;
		Name = name;
	}
	@Override
	public String toString() {
		return "JoinCitiesAccordion [ID=" + ID + ", Name=" + Name + "]";
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
}
