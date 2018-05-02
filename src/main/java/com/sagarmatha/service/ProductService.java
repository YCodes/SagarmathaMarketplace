package com.sagarmatha.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sagarmatha.domain.Product;

@Service
public interface ProductService {
	
	public List<Product> viewAllProduct();
	
	public void addProduct(Product product);
	
	public List<Product> viewProductByVendorId(Long Id);
	
	public void deleteProduct(Long id);
	
	public void updateProduct(Long Id, Product product);
	

}
