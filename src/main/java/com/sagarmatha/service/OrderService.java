package com.sagarmatha.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sagarmatha.domain.Order;

@Service
public interface OrderService {
	
	public void saveOrder(Order order) ;
	
	String doTransaction(String srcCardNo, String expirationDate, String nameOnCard, String CVV, String zipCode, Double amount, String dstCardNo,List<String> destinationscard);

	public void reduceStockAndSave(Order order);
}