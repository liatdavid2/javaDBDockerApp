package com.team.stock.dbservice.classes;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ProductID;
	private String ProductName;
	private LocalDateTime Ordered; 
	private Boolean InStock;
	
	
	
	public Product(Integer productID, String productName, LocalDateTime ordered, Boolean inStock) {
		super();
		ProductID = productID;
		ProductName = productName;
		Ordered = ordered;
		InStock = inStock;
	}






	@Override
	public String toString() {
		return "Product [ProductID=" + ProductID + ", ProductName=" + ProductName + ", Ordered=" + Ordered
				+ ", InStock=" + InStock + "]";
	}






	public LocalDateTime getOrdered() {
		return Ordered;
	}






	public void setOrdered(LocalDateTime ordered) {
		Ordered = ordered;
	}






	public Boolean getInStock() {
		return InStock;
	}






	public void setInStock(Boolean inStock) {
		InStock = inStock;
	}






	






	public Integer getProductID() {
		return ProductID;
	}



	public void setProductID(Integer productID) {
		ProductID = productID;
	}



	public String getProductName() {
		return ProductName;
	}



	public void setProductName(String productName) {
		ProductName = productName;
	}








	public Boolean getIn() {
		return InStock;
	}



	public void setIn(Boolean in) {
		InStock = in;
	}



	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
