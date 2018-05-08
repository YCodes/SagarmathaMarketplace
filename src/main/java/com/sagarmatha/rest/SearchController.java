/*package com.sagarmatha.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagarmatha.domain.Product;
import com.sagarmatha.service.ProductService;

@RestController
public class SearchController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/sagarmathamarketplace/search")
    public  List<Product> searchProduct( String str){
        if(str!=(null) && str.trim().length()>0){
        	
           return productService.searchByProductName(str);
        }
        
        return productService.viewAllProduct();
    }
}
*/