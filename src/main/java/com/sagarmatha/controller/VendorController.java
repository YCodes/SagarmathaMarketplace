package com.sagarmatha.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
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

	private static final String UPLOAD_DIRECTORY = "/products";

	@RequestMapping("/vendorsignup")
	public String vendorSignup() {
		return "vendorRegistration";
	}

	@RequestMapping(value = "/vendorsignup", method = RequestMethod.POST)
	public String addVendorSignup(@ModelAttribute("vendor") @Valid Vendor vendor, BindingResult result,
			ModelMap model) {

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
		// Vendor vendor = vendorService.findVendorByEmail(principal.getName());
		// System.out.println(vendor);
		// List<Product> products = productService.viewActiveProducts(vendor.getId());
		// System.out.println(products);

		// List<Product> products = productService.viewActiveProducts(vendorId);
		List<Product> products = productService.viewAllProduct();
		model.addAttribute("products", products);

		List<Category> categories = categoryService.viewAllCategory();
		model.addAttribute("categories", categories);

		Long vendorId = vendorService.findVendorByEmail(principal.getName()).getId();
		Vendor vendor_db = vendorService.findVendorById(vendorId);

		model.addAttribute("vendorId", vendor_db.getId());

		return "listproduct";
	}

	@RequestMapping(value = "/vendor/product/update", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute("updateproduct") @Valid Product product, BindingResult result) {
		Long id = product.getProductId();
		System.out.println(id);
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

	/*
	 * @RequestMapping(value="/vendor/addproduct", method = RequestMethod.POST)
	 * public String vendorAddProduct(@ModelAttribute("product") @Valid Product
	 * product, BindingResult result,@RequestParam("product_image") MultipartFile[]
	 * files, ModelMap model) throws IOException { // Save file on system String
	 * imageName = product.getProduct_name()+".jpg"; for (MultipartFile file :
	 * files) { if (!file.getOriginalFilename().isEmpty()) { BufferedOutputStream
	 * outputStream = new BufferedOutputStream( new FileOutputStream( new
	 * File("D:/sagarmathamarketplace/src/main/webapp/resources/MultipleFileUpload",
	 * imageName)));
	 * 
	 * outputStream.write(file.getBytes()); outputStream.flush();
	 * outputStream.close(); } else { model.addAttribute("msg",
	 * "Please select at least one file.."); return "fileUploadForm"; } }
	 * 
	 * productService.addProduct(product); return "redirect:/vendor/listproduct";
	 * 
	 * }
	 */

	@RequestMapping(value = "/vendor/addproduct", method = RequestMethod.POST)
	public String vendorAddProduct(@ModelAttribute("product") @Valid Product product, BindingResult result,
			@RequestParam("photo") MultipartFile[] files, ModelMap model) throws IOException {
		// Save file on system
		/*
		 * String imageName = product.getProduct_name()+".jpg"; for (MultipartFile file
		 * : files) { if (!file.getOriginalFilename().isEmpty()) { BufferedOutputStream
		 * outputStream = new BufferedOutputStream( new FileOutputStream( new File(
		 * "D:\\SagarmathaMarketplace\\src\\main\\webapp\\resources\\MultipleFileUpload",
		 * imageName)));
		 * 
		 * outputStream.write(file.getBytes()); outputStream.flush();
		 * outputStream.close(); } else { model.addAttribute("msg",
		 * "Please select at least one file.."); return "fileUploadForm"; } }
		 */

		MultipartFile photo = product.getPhoto();
		System.out.println("*AddPHOTO");

		String rootDirectory = context.getRealPath("/");
		System.out.println();
		String userUID = UUID.randomUUID().toString();
		System.out.println(userUID);
		if (photo != null && !photo.isEmpty()) {
			try {
				System.out.println("Checking add photo");
				String photoURL = rootDirectory + "resources\\images\\" + userUID + ".png";
				System.out.println("Checking URL");
				System.out.println(photoURL);
				photo.transferTo(new File(photoURL));
				// photo.transferTo(new File(rootDirectory + "\\resources\\MultipleFileUpload\\"
				// + userUID + ".png"));
				product.setPhotoURL(userUID);

			} catch (Exception e) {
				throw new RuntimeException("Employee photo saving failed", e);
				// throw new UnableToUploadPhotoException("Employee photo saving failed");
			}
		}
		System.out.println("*********************************");
		System.out.println(product);
		productService.addProduct(product);
		return "redirect:/vendor/listproduct";

	}
}
