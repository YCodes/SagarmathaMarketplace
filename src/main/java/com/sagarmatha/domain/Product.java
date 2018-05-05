package com.sagarmatha.domain;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long productId;
	
	private String product_name;
	private String product_category;
	private String product_description;
	private int product_quantity;
	private int product_price;
	
	public int getPrice() {
		return product_price;
	}
	public void setPrice(int price) {
		this.product_price = price;
	}
	@Lob @Basic(fetch = FetchType.LAZY)
	private byte[] product_image;
	private int vendorId;
	
	private boolean isActive;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_category() {
		return product_category;
	}
	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public byte[] getProduct_image() {
		return product_image;
	}
	public void setProduct_image(byte[] product_image) {
		this.product_image = product_image;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", product_name=" + product_name + ", product_category="
				+ product_category + ", product_description=" + product_description + ", product_quantity="
				+ product_quantity + ", product_price=" + product_price + ", product_image="
				+ Arrays.toString(product_image) + ", vendorId=" + vendorId + ", isActive=" + isActive + "]";
	}
	

}
