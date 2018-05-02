package com.sagarmatha.service;

import com.sagarmatha.domain.Customer;
import com.sagarmatha.domain.User;

public interface CustomerService {

	public void addCustomer(Customer customer);
	public User findUserByUsername(String username);
}
