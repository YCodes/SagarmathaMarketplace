package com.sagarmatha.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sagarmatha.domain.Order;
import com.sagarmatha.domain.OrderLine;
import com.sagarmatha.domain.Product;
import com.sagarmatha.service.ProductService;

@Controller
@SessionAttributes({"order"})
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	// Vendor Add Products from Vendor Dashboard

	/*@RequestMapping(value="/vendor/addproduct", method = RequestMethod.POST)
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
		
	}*/

	// Product details page
	@RequestMapping("/productdetails/{productId}")
	public String getProductDetailsPage(Model model, @PathVariable("productId") Long ProductId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("here");
		OrderLine orderLine = new OrderLine();
		orderLine.setQuantity(1);
		orderLine.setProduct(productService.findProductById(ProductId));
		model.addAttribute("orderLine", orderLine);
		return "productDetail";
	}	 	

	@RequestMapping(value="/addToCart/{productId}", method = RequestMethod.GET)
	@ModelAttribute("order")
	public ModelAndView addProductToCart( Model model, @PathVariable("productId") long id, SessionStatus sessionStatus, HttpServletRequest request) {
		System.out.println("inside add to cart ");
		HttpSession cart = request.getSession();
		
//		Product product = productService.findProductById(id);
//		Order order = new Order();
//		List<OrderLine> orderLineList = new ArrayList();
//		OrderLine orderLine = new OrderLine();
//		orderLine.setProduct(product);
//		
//		orderLineList.add(orderLine);
//		
//		order.setOrderLine(orderLineList);
//		model.addAttribute("cart", (Order)cart);
		
//		System.out.println(model==null);
		Order order = (Order)cart.getAttribute("order");
		System.out.println(order.getOrderLine().get(0).getProduct().getProduct_name());
		
		List<OrderLine> orderLines = ((Order) cart).getOrderLine();
		Boolean orderLineExists = false;
		for (OrderLine orderLine : orderLines) {
			if (orderLine.getProduct().getProductId() == id) {
				orderLineExists = true;
			}
		}
		if (!orderLineExists) {
			OrderLine orderLine = new OrderLine();
			orderLine.setProduct(productService.findProductById(id));
			orderLines.add(orderLine);
			((Order) cart).setOrderLine(orderLines);	
		}
		ModelAndView mnv = new ModelAndView("cartPage");
		return mnv;
	}

}
