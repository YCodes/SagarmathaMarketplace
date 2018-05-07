package com.sagarmatha.service;

import org.springframework.stereotype.Service;

import com.sagarmatha.domain.Order;

@Service
public interface OrderService {
	
	public void saveOrder(Order order) ;

	public void reduceStockAndSave(Order order);
}
