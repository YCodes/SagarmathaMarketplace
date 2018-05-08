package com.sagarmatha.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sagarmatha.domain.Order;
import com.sagarmatha.domain.OrderLine;
import com.sagarmatha.domain.Product;
import com.sagarmatha.service.ProductService;

@Controller
@SessionAttributes(value = { "order" })
public class ProductController {

	@Autowired
	ProductService productService;

	@ModelAttribute("order")
	public Order getOrder() {
		return new Order();
	}

	// Vendor Add Products from Vendor Dashboard

	/*
	 * @RequestMapping(value = "/vendor/addproduct", method = RequestMethod.POST)
	 * public String vendorAddProduct(@ModelAttribute("product") @Valid Product
	 * product, BindingResult result,
	 * 
	 * @RequestParam CommonsMultipartFile[] product_image) {
	 * 
	 * if (product_image != null && product_image.length > 0) { for
	 * (CommonsMultipartFile aFile : product_image) {
	 * 
	 * System.out.println("Saving file: " + aFile.getOriginalFilename());
	 * 
	 * Product uploadFile = new Product(); //
	 * product.setProduct_image(aFile.getBytes()); } }
	 * 
	 * productService.addProduct(product); return "redirect:/vendor/listproduct";
	 * 
	 * }
	 */

	// Product details page
	@RequestMapping("/product/productdetails/{productId}")
	public String getProductDetailsPage(Model model, @PathVariable("productId") Long ProductId) {
		Product product = productService.findProductById(ProductId);
		model.addAttribute("orderLine", product);
	
		return "productDetail";
	}

	@RequestMapping(value = "/product/addToCart/{productId}", method = RequestMethod.POST)
	public String addProductToCart(Model model, @ModelAttribute("order") Order order,
			@RequestParam("quantity") int quantity, @PathVariable Long productId) {

		System.out.println(quantity);
		List<OrderLine> orderLines = order.getOrderLine();
		Boolean orderLineExists = false;
		for (OrderLine orderLine : orderLines) {
			if (orderLine.getProduct().getProductId() == productId) {
				orderLine.setQuantity(quantity);
				orderLineExists = true;
			}
		}
		if (!orderLineExists) {
			OrderLine orderLine = new OrderLine();
			orderLine.setProduct(productService.findProductById(productId));
			orderLine.setQuantity(quantity);
			orderLines.add(orderLine);
			order.setOrderLine(orderLines);
		}
		return "redirect:/homepage";
	}

}
