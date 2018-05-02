package com.sagarmatha.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import com.sagarmatha.domain.Customer;
import com.sagarmatha.util.EmailService;


@Aspect
public class AspectClass {

	@Autowired
	EmailService emailService;


    @After("execution( * com.sagarmatha.controller.CustomerController.saveCustomer(..)) && args(customer, result)")
    public void traceMethod(Customer customer, BindingResult result){

    	if(result.hasErrors()) {
    		 emailService.sendEmailNotification(customer.getEmail(), "Error","Sorry this email already exist");
    	}
    	else {
    		System.out.println("AOP CALLED###########" +customer.getEmail());
        	String body = "Welcome to Sagarmatha Marketplace"+"\n"+" Your username is: "+" "+ customer.getEmail();
            emailService.sendEmailNotification(customer.getEmail(), "Welcome",body);
    	} 	
       
    } 
    
    
}
