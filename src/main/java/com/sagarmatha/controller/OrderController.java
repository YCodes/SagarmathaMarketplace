package com.sagarmatha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sagarmatha.domain.Order;
import com.sagarmatha.service.OrderService;

@Controller
@SessionAttributes(value = "order")
public class OrderController {

	@Autowired
	public OrderService orderService;

	@RequestMapping("/shoppingcart")
	public String createOrderPage(Model model, @ModelAttribute("order") Order order) {
		model.addAttribute("ShoppingCart", order);

		if (order.getOrderLine().isEmpty())
			return "productList";
		else
			return "cartPage";
	}
	
	/*@RequestMapping(value="/order", method=RequestMethod.POST)
	public String createOrder(Order order) {
		orderService.saveOrder(order);
		return "redirect:/";
	}*/
}
