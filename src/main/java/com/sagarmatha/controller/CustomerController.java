package com.sagarmatha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagarmatha.domain.Customer;
import com.sagarmatha.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping("/customer/customerSignup")
	public String getCustomerSignUpPage() {
		return "customerSignup";
	}
	
	@RequestMapping(value="/customer/customerSignup", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("IN ERROR***************8");
			return "customerSignup";
		} 
		customerService.addCustomer(customer);
		return "redirect:/login";
	}
}
