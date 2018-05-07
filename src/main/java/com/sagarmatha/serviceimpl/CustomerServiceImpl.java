package com.sagarmatha.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagarmatha.domain.Customer;
import com.sagarmatha.domain.Role;
import com.sagarmatha.domain.User;
import com.sagarmatha.repository.CustomerRepository;
import com.sagarmatha.repository.UserRepository;
import com.sagarmatha.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void addCustomer(Customer customer) {

		BCryptPasswordEncoder passworEncoder = new BCryptPasswordEncoder();
		User user = customer.getUser();
		user.setUserName(customer.getEmail());
		user.setRole(Role.ROLE_CUSTOMER);
		user.setPassword(passworEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		customerRepository.save(customer);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findUserByuserName(username);
	}

}
