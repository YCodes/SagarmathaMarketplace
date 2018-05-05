package com.sagarmatha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("aa")
	public String getPage() {
		return "abc";
	}
}
