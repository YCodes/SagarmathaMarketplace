package com.sagarmatha.aop;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sagarmatha.domain.Address;
import com.sagarmatha.domain.Admin;
import com.sagarmatha.domain.Customer;
import com.sagarmatha.domain.Order;
import com.sagarmatha.domain.OrderLine;
import com.sagarmatha.domain.Vendor;
import com.sagarmatha.model.SubmitForm;
import com.sagarmatha.service.OrderService;
import com.sagarmatha.util.EmailService;

@Aspect
@SessionAttributes(value = "order")
public class AspectClass {

	@Autowired
	EmailService emailService;

	@Autowired
	OrderService orderService;

	/* Email after admin signup */

	@After("execution( * com.sagarmatha.controller.AdminController.addAdmin(..)) && args(admin, result)")
	public void traceMethodForAdmin(Admin admin, BindingResult result) {

		if (result.hasErrors()) {
			emailService.sendEmailNotification(admin.getEmail(), "Error", "Sorry this email already exist");
		} else {
			System.out.println("AOP CALLED###########" + admin.getEmail());
			String body = "Welcome " + admin.getFirstName() + " " + admin.getLastName() + " to Sagarmatha Marketplace"
					+ "\n" + " Your username is: " + " " + admin.getEmail();
			emailService.sendEmailNotification(admin.getEmail(), "Welcome from Sagarmatha", body);
		}

	}

	/* Email after customer signup */

	@After("execution( * com.sagarmatha.controller.CustomerController.saveCustomer(..)) && args(customer, result)")
	public void traceMethodForCustomer(Customer customer, BindingResult result) {

		if (result.hasErrors()) {
			emailService.sendEmailNotification(customer.getEmail(), "Error", "Sorry this email already exist");
		} else {
			System.out.println("AOP CALLED###########" + customer.getEmail());
			String body = "Welcome " + customer.getFirstName() + " " + customer.getLastName()
					+ " to Sagarmatha Marketplace" + "\n" + " Your username is: " + " " + customer.getEmail();
			emailService.sendEmailNotification(customer.getEmail(), "Welcome from Sagarmatha", body);
		}

	}

	/* Email after vendor signup */

	@After("execution( * com.sagarmatha.controller.VendorController.addVendorSignup(..)) && args(vendor, result,model)")
	public void traceMethodForVendor(Vendor vendor, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			emailService.sendEmailNotification(vendor.getEmail(), "Error", "Sorry this email already exist");
		} else {
			System.out.println("AOP CALLED###########" + vendor.getEmail());
			String body = "Welcome " + vendor.getFirst_name() + " " + vendor.getLast_name()
					+ " to Sagarmatha Marketplace" + "\n" + " Your username is: " + " " + vendor.getEmail();
			emailService.sendEmailNotification(vendor.getEmail(), "Welcome from Sagarmatha", body);
		}

	}

	/*@Around("execution( * com.sagarmatha.controller.OrderController.orderSuccessMethod(..)) && args(principal)")
	public void traceMethodForInvoice(Principal principal) {
		String body ="Congratulations!! \n Your order has been placed. \n It will be shipped soon";
		System.out.println("Order success method aop"+principal.getName());
		emailService.sendEmailNotification(principal.getName(), "Order placed", body);
		
		
	}*/
	
}
