package com.sagarmatha.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.sagarmatha.domain.Order;
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
	
	final String uri = "http://localhost:8080/sagarmathamarketplace/bank/mock/transaction/api";

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public String doTransaction(String txnId, String srcCardNo, String expirationDate, String nameOnCard, String CVV,
			String zipCode, Double amount, String dstCardNo,List<String> destinatioinscard) {
		
		TransactionRequest transactionRequest = new TransactionRequest(txnId, srcCardNo, expirationDate, nameOnCard, CVV, zipCode, amount, dstCardNo,destinatioinscard);
         
	/*	String sendData;
		try {
			sendData = JsonConverter.<TransactionRequest>objectToJson(transactionRequest);
		} catch (JsonProcessingException e) {
		
			e.printStackTrace();
		}*/
		
		String resultReceive;
		
		resultReceive=restTemplate.postForObject(uri, transactionRequest,String.class);
	
		System.out.println(resultReceive);
		return resultReceive;
	}

}
