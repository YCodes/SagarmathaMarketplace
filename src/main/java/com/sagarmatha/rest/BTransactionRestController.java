package com.sagarmatha.rest;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sagarmatha.service.BTransactionService;

@RestController
public class BTransactionRestController {
	
	@Autowired
	BTransactionService btransactionservice;
	
	 
	 @PostMapping(value="/bank/mock/transaction/api")
		public ResponseEntity<String> doTransaction(@RequestBody String requestString){
		 System.out.println("Encoded Coming From CLient- " + requestString);
		 byte[] decodedBytes = Base64.getDecoder().decode(requestString);
		 String decodedString = new String(decodedBytes);
			System.out.println("******************************");
			 System.out.println("Decoded For Showing - " + decodedString);
			 String receviceresponse = btransactionservice.doTransaction(decodedString);
			return new ResponseEntity<String>(receviceresponse,HttpStatus.OK);
		}
	

}
