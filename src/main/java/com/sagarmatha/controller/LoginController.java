package com.sagarmatha.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sagarmatha.domain.Role;
import com.sagarmatha.domain.User;
import com.sagarmatha.domain.Vendor;
import com.sagarmatha.service.UserService;
import com.sagarmatha.service.VendorService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	VendorService vendorService;

	@RequestMapping(value = { "/login", "/" })
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed")
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping("/home")
	public String getHome(Principal principal) {
		if (principal == null) {
			return "redirect:login";
		}
		User user = userService.findByEmail(principal.getName());
		Vendor vendor = vendorService.findVendorByEmail(principal.getName());
		if (user != null) {
			if (user.getRole().equals(Role.Customer)) {
				return "redirect:customerSignup";
			} else if (user.getRole().equals(Role.Vendor)) {
				
				return "redirect:vendor/dashboard?vendorId="+vendor.getId();
			}
			else if(user.getRole().equals(Role.Admin)) {
				return "redirect:admin/admindashboard";
			}
		}

		return "customerPage";
	}

}
