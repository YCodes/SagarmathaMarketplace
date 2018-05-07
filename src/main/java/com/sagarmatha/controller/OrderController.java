package com.sagarmatha.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sagarmatha.domain.Address;
import com.sagarmatha.domain.Order;
import com.sagarmatha.model.SubmitForm;
import com.sagarmatha.service.OrderService;

@Controller
@SessionAttributes(value = "order")
@RequestMapping("order")
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
	
	@GetMapping("checkout/submit")
	public String getcheckoutCustomerOrder(Model model,@ModelAttribute("paymentForm") SubmitForm paymentForm) {
		model.addAttribute("total", 1500);
		return "submitorder";

	}

	@PostMapping("checkout/submit")
	public String checkoutCustomerOrder(Model model, @ModelAttribute("paymentForm") SubmitForm paymentForm,
			@RequestParam("month") String month, @RequestParam("year") String year) {
		/*Order order = new Order();
		Address shippingAddress = new Address();
		shippingAddress.setCity(paymentForm.getCity());
		shippingAddress.setCountry(paymentForm.getCountry());
		shippingAddress.setState(paymentForm.getState());
		shippingAddress.setStreet(paymentForm.getStreet());
		shippingAddress.setZipCode(paymentForm.getZipCode());
		order.setShippingAddress(shippingAddress);*/
					
		paymentForm.setCardNumber(paymentForm.getCardNumber().replaceAll("\\s", ""));
		paymentForm.setCardExpirationDate(month + "/" + year);

		List<String> destionationscard = new ArrayList<>();
		destionationscard.add("1233333333");
		destionationscard.add("12112121221");
		destionationscard.add("1212121221");
		String responseCode = orderService.doTransaction("111", paymentForm.getCardNumber(),
				paymentForm.getCardExpirationDate(), paymentForm.getCardHolderName(), paymentForm.getCvv(),
				paymentForm.getCardZipcode(), (double) 100, "789456123", destionationscard);

		if (responseCode.equals("5")) {
			model.addAttribute("error", "Please Enter the Correct Card Detail");
			return "paymentDetail";
		}
		if (responseCode.equals("6")) {
			model.addAttribute("error", "Transaction Amount Not Sufficient");
			return "submitorder";
		}
		//orderService.reduceStockAndSave(order);
		return "ordersuccess";

	}
}
