package com.sagarmatha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagarmatha.domain.Admin;
import com.sagarmatha.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
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
			System.out.println("IN ERROR***************8");
			return "addAdmin";
		}
		
		adminService.addAdmin(admin);
		System.out.println("CALLED ADMIN CONTROLLER........" + admin.getEmail());
		return "redirect:/";
	}
	
	@RequestMapping(value="/dmin/addAdmin", method=RequestMethod.GET)
	public String getAllAdmin(Model model) {
		return "addAdmin";	
	}
}
