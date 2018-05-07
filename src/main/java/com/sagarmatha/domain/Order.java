package com.sagarmatha.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long orderId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ORDERED_AT")
	private Date orderedAt = new Date();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	private List<OrderLine> orderLine = new ArrayList<OrderLine>();
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	@OneToOne
	private Address shippingAddress;
	
	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Column(name = "TOTAL_PRICE")
	private double totalPrice;
	
	
	public Order() {
		super();
	}

	public Order(Long orderId, Date orderedAt, List<OrderLine> orderLine, Customer customer, double totalPrice) {
		super();
		this.orderId = orderId;
		this.orderedAt = orderedAt;
		this.orderLine = orderLine;
		this.customer = customer;
		this.totalPrice = totalPrice;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderedAt() {
		return orderedAt;
	}

	public void setOrderedAt(Date orderedAt) {
		this.orderedAt = orderedAt;
	}

	public List<OrderLine> getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderedAt=" + orderedAt + ", orderLine=" + orderLine + ", customer="
				+ customer + ", totalPrice=" + totalPrice + "]";
	}

	
	
	
	
	
	
	
	
}
