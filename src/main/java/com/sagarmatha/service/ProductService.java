package com.sagarmatha.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sagarmatha.domain.Product;

@Service
public interface ProductService {
	
	   
	
	public List<Product> viewAllProduct();
	
	public List<Product> viewActiveProducts(Long Id, boolean isActive);
	
	public void addProduct(Product product);
	
	public List<Product> viewProductByVendorId(Long Id);
	
	public void deleteProduct(Long id);
	
	public void updateProduct(Long Id, Product product);
	
	public Product findProductById(Long id);

	public List<Product> findByCategoryId(Long long1);

	public List<Product> searchByProductName(String str);

	public Product add(Product product);

	public void delete(Product savedProduct);

	public List<Product> findActiveProductsHome(boolean b);

}
