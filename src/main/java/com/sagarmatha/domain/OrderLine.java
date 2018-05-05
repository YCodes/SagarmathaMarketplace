package com.sagarmatha.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


public class OrderLine implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue
	private Long orderLineId;
	
	@OneToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	
	private int quantity;

	public OrderLine() {
		super();
	}

	public OrderLine(Long orderLineId, Product product, int quantity) {
		super();
		this.orderLineId = orderLineId;
		this.product = product;
		this.quantity = quantity;
	}

	public Long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderLine [orderLineId=" + orderLineId + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
	
	
	
}
