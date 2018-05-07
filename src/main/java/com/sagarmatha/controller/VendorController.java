package com.sagarmatha.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sagarmatha.domain.Category;
import com.sagarmatha.domain.Product;
import com.sagarmatha.domain.Vendor;
import com.sagarmatha.service.CategoryService;
import com.sagarmatha.service.ProductService;
import com.sagarmatha.service.VendorService;

@Controller
public class VendorController {

	@Autowired
	VendorService vendorService;

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ServletContext context;

	@RequestMapping("/vendorsignup")
	public String vendorSignup() {
		return "vendorRegistration";
	}

	@RequestMapping(value = "/vendorsignup", method = RequestMethod.POST)
	public String addVendorSignup(@ModelAttribute("vendor") @Valid Vendor vendor, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "redirect:vendorsignup";

		}

		vendorService.saveVendor(vendor);

		return "redirect:/login";

	}

	@RequestMapping("/vendor/dashboard/{vendorId}")

	public String vendorDashboard(@PathVariable("vendorId") Long vendorId, ModelMap model) {

		Vendor vendor_db = vendorService.findVendorById(vendorId);
		model.addAttribute("vendor", vendor_db);

		// List<Product> products =
		// productService.viewProductByVendorId(vendor_db.getId());

		List<Product> products = productService.viewAllProduct();
		model.addAttribute("products", products);

		return "vendorDashboard";
	}

	@RequestMapping(value = "/vendor/update", method = RequestMethod.POST)
	public String vendorUpdate(@ModelAttribute("vendorUpdate") @Valid Vendor vendor, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			return "redirect:/vendor/dashboard";
		}
		Long id = vendor.getId();
		vendorService.updateVendor(id, vendor);

		return "redirect:/vendor/dashboard/" + id;
	}

	@RequestMapping("/vendor/listproduct")
	public String vendorListProduct(Principal principal, ModelMap model) {
		
		Long vendorId = vendorService.findVendorByEmail(principal.getName()).getId();
		Vendor vendor_db = vendorService.findVendorById(vendorId);

		model.addAttribute("vendorId", vendor_db.getId());

		List<Product> products = productService.viewAllProduct();
		model.addAttribute("products", products);

		List<Category> categories = categoryService.viewAllCategory();
		model.addAttribute("categories", categories);

		return "listproduct";
	}

	@RequestMapping(value = "/vendor/product/update", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("vendorUpdate") @Valid Product product) {
		Long id = product.getProductId();
		productService.updateProduct(id, product);
		return "redirect:/vendor/listproduct";
	}

	@RequestMapping("/vendor/product/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "redirect:/vendor/listproduct";
	}

	@RequestMapping("/vendor/addproduct")
	public String vendorAddProduct(Principal principal, ModelMap model) {

		Long vendorId = vendorService.findVendorByEmail(principal.getName()).getId();
		Vendor vendor_db = vendorService.findVendorById(vendorId);

		model.addAttribute("vendorId", vendor_db.getId());

		List<Category> categories = categoryService.viewAllCategory();
		model.addAttribute("categories", categories);

		return "addproduct";
	}

	// Vendor Add Products from Vendor Dashboard

	@RequestMapping(value = "/vendor/addproduct", method = RequestMethod.POST)
	public String vendorAddProduct(@ModelAttribute("product") @Valid Product product, BindingResult result,
			ModelMap model) throws IOException {

		// if (result.hasErrors(s)) {
		// System.out.println("validation errors");
		// return "addproduct";
		// } else {
		// System.out.println("Fetching file");
		// MultipartFile multipartFile = productimg.getProduct_image();
		// String uploadPath = context.getRealPath("") + File.separator + "products" +
		// File.separator;
		// // Now do something with file...
		// FileCopyUtils.copy(productimg.getProduct_image().getBytes(),
		// new File(uploadPath + product.getProduct_image().getOriginalFilename()));
		// String fileName = multipartFile.getOriginalFilename();
		//
		// }

		// System.out.println("base 1");

		// product.setProduct_category(categoryService.findOne(product_category));

		// System.out.println("base 2" +
		// product.getProduct_category().getCategoryName());

		productService.addProduct(product);
		return "redirect:/vendor/listproduct";

	}

}
