package com.sagarmatha.domain;

public class DemoProduct {
	
	private int Id;
	private String name;
	private String category;
	private int quantity;
	
	public DemoProduct(int id, String name, String category, int quantity) {
		Id = id;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
