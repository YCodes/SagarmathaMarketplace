package com.sagarmatha.serviceimpl;

import java.awt.PageAttributes.MediaType;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sagarmatha.domain.Order;
import com.sagarmatha.domain.OrderLine;
import com.sagarmatha.model.TransactionRequest;
import com.sagarmatha.repository.OrderRepository;
import com.sagarmatha.service.OrderService;
import com.sagarmatha.util.JsonConverter;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void saveOrder(Order order) {
		 orderRepository.save(order);
		
	}
	
	final String uri = "http://localhost:8080/sagarmathamarketplace/bank/mock/transaction/api";

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public String doTransaction(String srcCardNo, String expirationDate, String nameOnCard, String CVV,
			String zipCode, Double amount, String dstCardNo,List<String> destinatioinscard) {
		
		TransactionRequest transactionRequest = new TransactionRequest(srcCardNo, expirationDate, nameOnCard, CVV, zipCode, amount, dstCardNo,destinatioinscard);
         System.out.println(transactionRequest);
	   String sendData = null;
		try {
			sendData = JsonConverter.<TransactionRequest>objectToJson(transactionRequest);
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
		}
		
		String encodedString = Base64.getEncoder().encodeToString(sendData.getBytes());
		String resultReceive;
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(encodedString, headers);
		
		resultReceive=restTemplate.postForObject(uri, entity,String.class);
	
		return resultReceive;
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