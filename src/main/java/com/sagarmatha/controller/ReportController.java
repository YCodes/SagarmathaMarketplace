package com.sagarmatha.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagarmatha.domain.Product;
import com.sagarmatha.service.ProductService;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String report(ModelMap modelMap) {
		
		List<Map<String, ?>> listProducts = new ArrayList<Map<String,?>>();
		
		for(Product p : productService.viewAllProduct()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("Id", p.getProductId());
			m.put("Name", p.getProduct_name());
			m.put("Category", p.getCategory().getCategoryName());
			m.put("Quantity", p.getProduct_quantity());
			m.put("Price", p.getPrice());
			m.put("VendorId", p.getVendorId());
			listProducts.add(m);
		}
		modelMap.put("listProducts", listProducts );
		
		return "report";
	}

}
