package com.sagarmatha.controller;

import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/vendorsignup")
	public String vendorSignup() {
		return "vendorRegistration";
	}
	
	@RequestMapping(value="/vendorsignup", method = RequestMethod.POST)
	public String addVendorSignup(@ModelAttribute("vendor") @Valid Vendor vendor, BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			return "redirect:vendorsignup";	
	
		}

		vendorService.saveVendor(vendor);

		model.addAttribute("vendorId", vendor.getId());

		return "redirect:/vendor/dashboard";

	}

	@RequestMapping("/vendor/dashboard")
	public String vendorDashboard(@RequestParam("vendorId") Long vendorId, ModelMap model) {
		
		Vendor vendor_db = vendorService.findVendorById(vendorId);
		System.out.println("vendor controller called"+vendorId);
		model.addAttribute("vendor",vendor_db);
		System.out.println(vendor_db);
		
//		List<Product> products = productService.viewProductByVendorId(vendor_db.getId());
//		
		List<Product> products = productService.viewAllProduct();
		model.addAttribute("products",products);
		
		return "vendorDashboard";
	}

	@RequestMapping(value = "/vendor/update", method = RequestMethod.POST)
	public String vendorUpdate(@ModelAttribute("vendorUpdate") @Valid Vendor vendor,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "redirect:/vendor/dashboard";
		}
		Long id = vendor.getId();
		vendorService.updateVendor(id, vendor);

		model.addAttribute("vendorId", vendor.getId());

		return "redirect:/vendor/dashboard";
	}
	
	@RequestMapping("/vendor/listproduct")
	public String vendorListProduct(Principal principal, ModelMap model) {
		String vendorUser = principal.getName();
		List<Product> products = productService.viewActiveProducts();
		model.addAttribute("products", products);
		return "listproduct";
	}
	
	@RequestMapping(value = "/vendor/product/update/{id}", method = RequestMethod.POST)
	public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("vendorUpdate") @Valid Product product) {
		productService.updateProduct((Long) id, product);
		return "redirect:/vendor/listproduct";
	}

	@RequestMapping("/vendor/product/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/vendor/listproduct";
	}
	
	@RequestMapping("/vendor/addproduct")
	public String vendorAddProduct(ModelMap model) {
		
		Vendor vendor = new Vendor();
		vendor.setId((long) 3);
		Vendor vendor_db = vendorService.findVendorById(vendor.getId());

		model.addAttribute("vendorId", vendor_db.getId());
		
		List<Product> products = productService.viewAllProduct();
		
		model.addAttribute("products", products);
		
		return "addproduct";
	}

}
