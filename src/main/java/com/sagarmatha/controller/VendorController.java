package com.sagarmatha.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagarmatha.domain.Product;
import com.sagarmatha.domain.Vendor;
import com.sagarmatha.service.ProductService;
import com.sagarmatha.service.VendorService;

@Controller
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/vendor/signup")
	public String vendorSignup() {
		return "vendorRegistration";
	}
	
	@RequestMapping(value="/vendor/signup", method = RequestMethod.POST)
	public String addVendorSignup(@ModelAttribute("vendor") @Valid Vendor vendor, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			return "redirect:vendor/signup";
		}
		
		vendorService.saveVendor(vendor);
		
		model.addAttribute("vendorId",vendor.getId());
		
		
		return "redirect:/vendor/dashboard";
		
	}
	
	@RequestMapping("/vendor/dashboard")
	public String vendorDashboard(ModelMap model) {
		
		Vendor vendor = new Vendor();
		vendor.setId((long) 27);
		Vendor vendor_db = vendorService.findVendorById(vendor.getId());
		
		model.addAttribute("vendor",vendor_db);
		
//		List<Product> products = productService.viewProductByVendorId(vendor_db.getId());
//		
		List<Product> products = productService.viewAllProduct();
		model.addAttribute("products",products);
		
		return "vendorDashboard";
	}
	
	@RequestMapping(value = "/vendor/update/{Id}", method = RequestMethod.POST)
	public String vendorUpdate(@PathVariable("id") Long id, @ModelAttribute("vendorUpdate") @Valid Vendor vendor, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			return "redirect:vendor/signup";
		}
		
		vendorService.updateVendor(id, vendor);
		
		model.addAttribute("vendorId",vendor.getId());
		
		return "redirect:/vendor/dashboard";
	}
	
	@RequestMapping("/vendor/product/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/vendor/dashboard";
	}
	
	@RequestMapping(value = "/vendor/product/update/{id}", method = RequestMethod.POST)
	public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("vendorUpdate") @Valid Product product) {
		productService.updateProduct((Long) id, product);
		return "redirect:/vendor/dashboard";
	}

}
