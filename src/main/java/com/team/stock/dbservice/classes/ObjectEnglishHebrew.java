package com.team.stock.dbservice.classes;

public class ObjectEnglishHebrew {
 private Integer id;
 private String H_name ;
 private String E_name ;
 
 
public ObjectEnglishHebrew() {
	super();
	// TODO Auto-generated constructor stub
}
public ObjectEnglishHebrew(Integer id, String h_name, String e_name) {
	super();
	this.id = id;
	H_name = h_name;
	E_name = e_name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getH_name() {
	return H_name;
}
public void setH_name(String h_name) {
	H_name = h_name;
}
public String getE_name() {
	return E_name;
}
public void setE_name(String e_name) {
	E_name = e_name;
}
 
 
}
