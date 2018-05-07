package com.sagarmatha.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagarmatha.domain.Order;


import com.sagarmatha.domain.OrderLine;
import com.sagarmatha.model.TransactionRequest;
import com.sagarmatha.repository.OrderRepository;
import com.sagarmatha.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void saveOrder(Order order) {
		 orderRepository.save(order);
		
	}

	@Override
	public void reduceStockAndSave(Order order) {

		for(OrderLine ol : order.getOrderLine()) {
			int stock = ol.getProduct().getProduct_quantity();
			int quantity = ol.getQuantity();
			ol.getProduct().setProduct_quantity(stock-quantity);
		}
		orderRepository.save(order);
	}

}
