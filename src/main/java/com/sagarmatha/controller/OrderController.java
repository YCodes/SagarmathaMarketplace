package com.sagarmatha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sagarmatha.domain.Address;
import com.sagarmatha.domain.Order;
import com.sagarmatha.domain.User;
import com.sagarmatha.model.SubmitForm;
import com.sagarmatha.service.OrderService;
import com.sagarmatha.service.UserService;

@Controller
@SessionAttributes(value = "order")
public class OrderController {

	@ModelAttribute("order")
	public Order gerOrder() {
		return new Order();
	}

	@Autowired
	public OrderService orderService;
	
	@Autowired
	public UserService userService;
	

	@RequestMapping("/shoppingcart")
	public String createOrderPage(Model model, @ModelAttribute("order") Order order) {
		model.addAttribute("ShoppingCart", order);

		if (order.getOrderLine().isEmpty())
			return "productList";
		else
			return "cartPage";
	}

	
	@GetMapping("checkout/submit")
	public String getcheckoutCustomerOrder(Model model,@ModelAttribute("paymentForm") SubmitForm paymentForm) {
		model.addAttribute("total", 1500);
		return "submitorder";
	}


	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
	public String showCart(Model model, @ModelAttribute("order") Order order) {

		model.addAttribute("order", order);
		int totalQuantities = order.getOrderLine().stream().mapToInt(or -> or.getQuantity()).sum();
		double totalPrice = order.getOrderLine().stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();
		model.addAttribute("orderedQuantities", totalQuantities);
		model.addAttribute("totalPrice", totalPrice);
		if (order.getOrderLine().size() == 0)
			return "redirect:/homepage";
		else
			return "cartPage";
	}

	@PostMapping("checkout/submit")
	public String checkoutCustomerOrder(Model model, @ModelAttribute("paymentForm") SubmitForm paymentForm,
			@RequestParam("month") String month, @RequestParam("year") String year) {
		Order order = new Order();
		/*Address shippingAddress = new Address();
		shippingAddress.setCity(paymentForm.getCity());
		shippingAddress.setCountry(paymentForm.getCountry());
		shippingAddress.setState(paymentForm.getState());
		shippingAddress.setStreet(paymentForm.getStreet());
		shippingAddress.setZipCode(paymentForm.getZipCode());
		order.setShippingAddress(shippingAddress);*/
					
		paymentForm.setCardNumber(paymentForm.getCardNumber().replaceAll("\\s", ""));
		paymentForm.setCardExpirationDate(month + "/" + year);

		if (order.getOrderLine().size() == 0)
			return "redirect:/homepage";
		else
			return "cartPage";

	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String confirmOrder(Model model, @ModelAttribute("order") Order order) {

		/*if (responseCode.equals("5")) {
			model.addAttribute("error", "Please Enter the Correct Card Detail");
			return "paymentDetail";
		}
		if (responseCode.equals("6")) {
			model.addAttribute("error", "Transaction Amount Not Sufficient");
			return "submitorder";*/
		//}
		//orderService.reduceStockAndSave(order);
	//	return "ordersuccess";


		model.addAttribute("order", order);
		int totalQuantities = order.getOrderLine().stream().mapToInt(or -> or.getQuantity()).sum();
		double totalPrice = order.getOrderLine().stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();
		model.addAttribute("orderedQuantities", totalQuantities);
		model.addAttribute("totalPrice", totalPrice);
		
		return "confirmedOrder";
	}
	
	
	@RequestMapping(value = "/place-order", method = RequestMethod.GET)
	public String placeOrder(Model model, @ModelAttribute("order") Order order, SessionStatus sessionStatus, Authentication principal) {
		
		double totalPrice = order.getOrderLine().stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();
	
		
		String email = principal.getName();
		User user = userService.findByEmail(email);
		
		
//		Customer customer= (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Customer customer = (Customer)user;
		
		order.setTotalPrice(totalPrice);
//		order.setCustomer(customer);
		
		orderService.saveOrder(order);
		
		sessionStatus.setComplete();
		
		
		return "redirect:/homepage";
	}
}
