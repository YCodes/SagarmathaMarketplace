package com.sagarmatha.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sagarmatha.domain.Address;
import com.sagarmatha.domain.Order;
import com.sagarmatha.domain.OrderLine;
import com.sagarmatha.domain.User;
import com.sagarmatha.model.SubmitForm;

import com.sagarmatha.service.OrderLineService;

import com.sagarmatha.repository.AddressRepository;

import com.sagarmatha.service.OrderService;
import com.sagarmatha.service.UserService;
import com.sagarmatha.util.EmailService;

@Controller
@SessionAttributes(value = "order")
public class OrderController {

	@ModelAttribute("order")
	public Order gerOrder() {
		return new Order();
	}

	@Autowired
	OrderService orderService;

	@Autowired
	UserService userService;

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	EmailService emailService;

	@RequestMapping("/shoppingcart")
	public String createOrderPage(Model model, @ModelAttribute("order") Order order) {
		model.addAttribute("ShoppingCart", order);

		if (order.getOrderLine().isEmpty())
			return "productList";
		else
			return "cartPage";
	}

	@GetMapping("checkout/submit")
	public String getcheckoutCustomerOrder(Model model, @ModelAttribute("paymentForm") SubmitForm paymentForm,
			@ModelAttribute("order") Order order) {
		model.addAttribute("order", order);
		int totalQuantities = order.getOrderLine().stream().mapToInt(or -> or.getQuantity()).sum();
		double totalPrice = order.getOrderLine().stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();
		double tax = 0.07*totalPrice;
		double sum = totalPrice+tax;
		model.addAttribute("sum",sum);
		model.addAttribute("tax",tax);
		model.addAttribute("orderedQuantities", totalQuantities);
		model.addAttribute("totalPrice", totalPrice);
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
			@RequestParam("month") String month, @RequestParam("year") String year, Principal principal,

			@ModelAttribute Order order,SessionStatus sessionStatus) {
//		BCryptPasswordEncoder Encoder = new BCryptPasswordEncoder();
		paymentForm.setCardNumber(paymentForm.getCardNumber().replaceAll("\\s",""));
        paymentForm.setCardExpirationDate(month + "/" + year);
//        paymentForm.setCvv(Encoder.encode(paymentForm.getCvv()));
        model.addAttribute("order", order);
		double totalPrice = order.getOrderLine().stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();
		double tax = 0.07*totalPrice;
		double sum = totalPrice+tax;
		model.addAttribute("sum",sum);
		model.addAttribute("tax",tax);

		model.addAttribute("totalPrice", totalPrice);
		Address shippingAddress = new Address();
		shippingAddress.setCity(paymentForm.getCity());
		shippingAddress.setCountry(paymentForm.getCountry());
		shippingAddress.setState(paymentForm.getState());
		shippingAddress.setStreet(paymentForm.getStreet());
		shippingAddress.setZipCode(paymentForm.getZipCode());
	
		List<OrderLine> ol = order.getOrderLine();
		for(OrderLine o : ol) {
			o.getProduct().getPrice();
		}
		
		model.addAttribute("User", principal.getName());
		 List<String> destionationscard = new ArrayList<>();
	       destionationscard.add("4444444444444444");
	      
	        String responseCode = orderService.doTransaction(paymentForm.getCardNumber(),
	            paymentForm.getCardExpirationDate(), paymentForm.getCardHolderName(), paymentForm.getCvv(),
	            paymentForm.getCardZipcode(), sum, "3333333333333333",destionationscard);
	        
	        if(responseCode.equals("5")){
	        	model.addAttribute("error", "Please Enter the Correct Card Detail");
	        	return "submitorder";
	        }
	        if(responseCode.equals("6")) {
	        	model.addAttribute("error", "Transaction Amount Not Sufficient");
	        	return "submitorder";
	        }
	        
	        
	        addressRepository.save(shippingAddress);
	        order.setShippingAddress(addressRepository.findOne(shippingAddress.getAddressId()));
	        order.setTotalPrice(totalPrice);
	    	orderService.saveOrder(order);
	    	sessionStatus.setComplete();
	    	orderSuccessMethod(principal);			
	        
			return "ordersuccess";
	    	
	    }
	
	public void orderSuccessMethod(Principal principal) {
		System.out.println("order success method called1 "+principal.getName());
		String body ="Congratulations!! \n Your order has been placed. \n It will be shipped soon";
		System.out.println("order success method called2 "+principal.getName());
		emailService.sendEmailNotification(principal.getName(), "Order placed", body);
	}
    
  @RequestMapping(value = "/change", method = RequestMethod.GET)
	public String changeOrderDetails(Model model, @ModelAttribute("order") Order order,
			@RequestParam("quantity") int quantity, @RequestParam("orderLineIndex") int orderLineIndex) {

		int index = orderLineIndex - 1;

		order.getOrderLine().get(index).setQuantity(quantity);

		model.addAttribute("order", order);
		return "confirmedOrder";
	}

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String confirmOrder(Model model, @ModelAttribute("order") Order order) {

		int totalQuantities = order.getOrderLine().stream().mapToInt(or -> or.getQuantity()).sum();
		double totalPrice = order.getOrderLine().stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();
		model.addAttribute("orderedQuantities", totalQuantities);
		model.addAttribute("totalPrice", totalPrice);

		return "confirmedOrder";
	}

}
