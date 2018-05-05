package com.sagarmatha.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sagarmatha.domain.Product;
import com.sagarmatha.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	// Vendor Add Products from Vendor Dashboard
	@RequestMapping(value="/vendor/addproduct", method = RequestMethod.POST)
	public String vendorAddProduct(@ModelAttribute("product") @Valid Product product, BindingResult result,@RequestParam CommonsMultipartFile[] product_image) {
		
		if (product_image != null && product_image.length > 0) {
            for (CommonsMultipartFile aFile : product_image){
                  
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                 
                Product uploadFile = new Product();
                product.setProduct_image(aFile.getBytes());               
            }
        }
		
		productService.addProduct(product);
		return "redirect:/vendor/listproduct";
		
	}

	@RequestMapping("/customer/product/productdetails")
	public String getProductDetailsPage() {
		return "productDetail";
	}
	
	@RequestMapping("/customer/cartPage")
	public String getCartPage() {
		return "cartPage";
	}
	

}
