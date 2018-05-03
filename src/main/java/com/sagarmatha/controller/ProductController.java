package com.sagarmatha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagarmatha.domain.Product;
import com.sagarmatha.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	// Vendor Add Products from Vendor Dashboard
	@RequestMapping(value="/vendor/addproduct", method = RequestMethod.POST)
	public String vendorAddProduct(@ModelAttribute("product") @Valid Product product, BindingResult result) {
		productService.addProduct(product);
		return "redirect:/vendor/dashboard";
		
	}

	@RequestMapping("/customer/product/productdetails")
	public String getProductDetailsPage() {
		return "productDetail";
	}
	
	@RequestMapping("/customer/cartPage")
	public String getCartPage() {
		return "cartPage";
	}




}
