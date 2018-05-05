package com.sagarmatha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagarmatha.domain.Admin;
import com.sagarmatha.service.AdminService;
import com.sagarmatha.service.ProductService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/admin/addAdmin")
	public String getAdmin() {
		return "addAdmin";
	}
	
	@RequestMapping("/admin/addCategory")
	public String getCategory() {
		return "addCategory";
	}
	
	@RequestMapping(value="/admin/addAdmin", method=RequestMethod.POST)
	public String addAdmin(@ModelAttribute("admin") @Valid Admin admin, BindingResult result) {
		
		System.out.println("Controller Called for admin######");
		if(result.hasErrors()) {
			return "addAdmin";
		}
		
		adminService.addAdmin(admin);
		return "redirect:/login";
	}
	
	@RequestMapping("/admin/admindashboard")
	public String getAdminDashboard() {
		return "admindashboard";
	}
	
	
}
