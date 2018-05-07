package com.sagarmatha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sagarmatha.report.ProductReport;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String report(ModelMap modelMap) {
		
		ProductReport pr = new ProductReport();
		modelMap.put("listProducts", pr.findAll());
		
		return "report";
	}

}
