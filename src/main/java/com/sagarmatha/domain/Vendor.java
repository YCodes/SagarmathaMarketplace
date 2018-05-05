package com.sagarmatha.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

@Entity
public class Vendor {
	
	public Vendor() {
		user = new User();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String first_name;
	private String last_name;
	private String phone_number;
	private String email;
	private boolean vendorFee;

	public boolean isVendorFee() {
		return vendorFee;
	}
	public void setVendorFee(boolean vendorFee) {
		this.vendorFee = vendorFee;
	}
	@Override
	public String toString() {
		return "Vendor [Id=" + Id + ", first_name=" + first_name + ", last_name=" + last_name + ", phone_number="
				+ phone_number + ", email=" + email + ", password_confirmation=" + password_confirmation + ", address="
				+ address + ", user=" + user + "]";
	}

	@Transient
	private String password_confirmation;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Valid
	private Address address;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Valid
	private User user;
	
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		this.Id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
