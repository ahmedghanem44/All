package com.product.beans;
//product_ID, product_name, product_description, price, quantity
public class Product {
	
	private int id;
	private String name;
	private String description;
	private double price;
	private int quantity ;
	
	public Product () {
		
	}
	public Product(int id, String name, String description, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Product ID: "+this.id+"\t"+"Name: "+this.name+"\tDescription: "+this.description+
				"\tPrice: "+this.price+"\tQuantity: "+this.quantity ;
	}
	
	
	
	
	
}
