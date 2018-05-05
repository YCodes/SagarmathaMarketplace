package com.sagarmatha.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sagarmatha.domain.Order;
import com.sagarmatha.repository.OrderRepository;
import com.sagarmatha.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void saveOrder(Order order) {
		 orderRepository.save(order);
		
	}

}
