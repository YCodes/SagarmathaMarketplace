package com.sagarmatha.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagarmatha.domain.Category;
import com.sagarmatha.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/admin/addProductCategory")
	public String getProductCategory() {
		return "addCategory";
	}
	
	@RequestMapping(value="/admin/addProductCategory", method=RequestMethod.POST)
	public String addProductCategory(@ModelAttribute("category") @Valid Category category, BindingResult result) {
		
		if(result.hasErrors()) {
			return "categoryList";
		}
		
	
		categoryService.addCategory(category);
		System.out.println("#######CAtegory Controller Called!!!!!!!!!!!!!S");
		return "redirect:/admin/addProductCategory";
	}
	
}
