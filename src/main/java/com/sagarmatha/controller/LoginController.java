package com.sagarmatha.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sagarmatha.domain.Category;
import com.sagarmatha.domain.Product;
import com.sagarmatha.domain.Role;
import com.sagarmatha.domain.User;
import com.sagarmatha.domain.Vendor;
import com.sagarmatha.service.CategoryService;
import com.sagarmatha.service.ProductService;
import com.sagarmatha.service.UserService;
import com.sagarmatha.service.VendorService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = { "/login", "/" })
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed")
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}
	

	@RequestMapping("/403")
	public String errorPage() {
		return "403error";
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
				return "redirect:homepage";
			} else if (user.getRole().equals(Role.Vendor)) {
				
				return "redirect:vendor/dashboard/"+vendor.getId();
			}
			else if(user.getRole().equals(Role.Admin)) {
				return "redirect:admin/admindashboard";
			}
		}

		return "customerPage";
	}
	
	@RequestMapping(value = "/homepage")
	public String showHomepage(Model model) {
		List<Category>categories = categoryService.viewAllCategory();
		List<Product> product = productService.viewAllProduct();
		model.addAttribute("categories",categories);
		model.addAttribute("products", product);
		return "index";
	}

}
