package com.sagarmatha.domain;

import java.util.Arrays;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long productId;
	
	private String product_name;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Valid
	private Category product_category;
	private String product_description;
	private int product_quantity;
	private int product_price;
	@Transient
	private MultipartFile product_image;
	private int vendorId;
	
	
	public int getPrice() {
		return product_price;
	}
	public void setPrice(int price) {
		this.product_price = price;
	}
	
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
	public Category getProduct_category() {
		return product_category;
	}
	public void setProduct_category(Category product_category) {
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
	public MultipartFile getProduct_image() {
		return product_image;
	}
	public void setProduct_image(MultipartFile product_image) {
		this.product_image = product_image;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", product_name=" + product_name + ", product_category="
				+ product_category + ", product_description=" + product_description + ", product_quantity="
				+ product_quantity + ", product_price=" + product_price + ", product_image="
				+ product_image + ", vendorId=" + vendorId + ", isActive=" + isActive + "]";
	}
	

}
