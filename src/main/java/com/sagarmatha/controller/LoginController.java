package com.sagarmatha.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sagarmatha.domain.Category;
import com.sagarmatha.domain.Order;
import com.sagarmatha.domain.Product;
import com.sagarmatha.domain.Role;
import com.sagarmatha.domain.User;
import com.sagarmatha.domain.Vendor;
import com.sagarmatha.service.CategoryService;
import com.sagarmatha.service.ProductService;
import com.sagarmatha.service.UserService;
import com.sagarmatha.service.VendorService;

@Controller
@SessionAttributes("order")
public class LoginController {

	@ModelAttribute
	public Order getOrder() {
		return new Order();
	}

	@Autowired
	UserService userService;

	@Autowired
	VendorService vendorService;

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;
	
	

	@RequestMapping(value = { "/login" })
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed")
	public String loginerror(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping("/logouts")
	public String logoutSuccessful() {
		System.out.println("Logout success called.......");
		return "redirect:/";
	}

	@RequestMapping("/403")
	public String errorPage() {
		return "403error";
	}

	@RequestMapping(value = { "/home", "/" })
	public String getHome(@RequestParam("categoryId") Optional<Long> categoryId, Model model, Principal principal,
			@ModelAttribute("order") Order order) {
		if (principal == null) {
			if (categoryId.isPresent()) {
				model.addAttribute("products", productService.findByCategoryId(categoryId.get()));
			} else {
				model.addAttribute("products", productService.findActiveProductsHome(false));
			}
			List<Category> categories = categoryService.viewAllCategory();

			model.addAttribute("categories", categories);
			return "index";
		}
		User user = userService.findByEmail(principal.getName());
		if (user != null) {
			if (user.getRole().equals(Role.ROLE_CUSTOMER)) {
				if (order.getOrderLine().size() == 0) {
					if (categoryId.isPresent()) {
						model.addAttribute("products", productService.findByCategoryId(categoryId.get()));
					} else {
						model.addAttribute("products", productService.findActiveProductsHome(false));
					}
					List<Category> categories = categoryService.viewAllCategory();

					model.addAttribute("categories", categories);
					return "index";
				} else {
					return "redirect:/shoppingcart";
				}
			} else if (user.getRole().equals(Role.ROLE_VENDOR)) {
				Vendor vendor = vendorService.findVendorByEmail(principal.getName());
				return "redirect:vendor/dashboard/" + vendor.getId();
			} else if (user.getRole().equals(Role.ROLE_ADMIN)) {
				return "redirect:admin/addAdmin";

			}
		}

		return "customerPage";
	}

	@RequestMapping(value = { "/homepage" })
	public String showHomepage(@RequestParam("categoryId") Optional<Long> categoryId, Model model) {
		if (categoryId.isPresent()) {
			model.addAttribute("products", productService.findByCategoryId(categoryId.get()));
		} else {
			model.addAttribute("products", productService.findActiveProductsHome(false));
		}
		List<Category> categories = categoryService.viewAllCategory();

		model.addAttribute("categories", categories);
		return "index";
	}

}
