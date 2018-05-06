package com.sagarmatha.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sagarmatha.domain.Order;
import com.sagarmatha.domain.OrderLine;
import com.sagarmatha.domain.Product;
import com.sagarmatha.service.ProductService;

@Controller
@SessionAttributes(value = { "order" })
public class ProductController {

	@Autowired
	ProductService productService;

	// Product details page
	@RequestMapping("/product/productdetails/{productId}")
	public String getProductDetailsPage(Model model, @PathVariable Long ProductId) {
		OrderLine orderLine = new OrderLine();
		orderLine.setQuantity(1);
		orderLine.setProduct(productService.findProductById(ProductId));
		model.addAttribute("orderline", orderLine);
		return "productDetail";
	}	

	@RequestMapping(value="/product/addToCart/{productId}", method=RequestMethod.POST)
	public String addProductToCart(Model model, @ModelAttribute("order") Order order,
			@RequestParam("quantity") int quantity, @PathVariable Long productId) {
		List<OrderLine> orderLines = order.getOrderLine();
		Boolean orderLineExists = false;
		for (OrderLine orderLine : orderLines) {
			if (orderLine.getProduct().getProductId() == productId) {
				orderLine.setQuantity(quantity);
				orderLineExists = true;
			}
		}
		if (!orderLineExists) {
			OrderLine orderLine = new OrderLine();
			orderLine.setProduct(productService.findProductById(productId));
			orderLine.setQuantity(quantity);
			orderLines.add(orderLine);
			order.setOrderLine(orderLines);
		}
		return "redirect:/productList";
	}

}
