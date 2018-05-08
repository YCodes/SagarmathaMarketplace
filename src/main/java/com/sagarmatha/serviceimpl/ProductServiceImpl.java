package com.sagarmatha.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagarmatha.domain.Product;
import com.sagarmatha.repository.ProductRepository;
import com.sagarmatha.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> viewAllProduct() {
		
		return productRepository.findAll();
		
	}
	
	@Override
	public List<Product> viewActiveProducts(Long Id) {
		
		return productRepository.findActiveProducts(Id);
		
	}

	@Override
	public void addProduct(Product product) {
		
		productRepository.save(product);

	}

	@Override
	public List<Product> viewProductByVendorId(Long Id) {
		
		return productRepository.findByVendorId(Id);
	}

	@Override
	public void deleteProduct(Long id) {

		Product product = productRepository.findOne(id);
		product.setActive(true);
		productRepository.save(product);
		
	}

	@Override
	public void updateProduct(Long Id, Product product) {
		
		Product product_db = productRepository.findOne(Id);
		
		product_db.setProduct_name(product.getProduct_name());
		product_db.setCategory(product.getCategory());
		product_db.setProduct_description(product.getProduct_description());
		product_db.setProduct_quantity(product.getProduct_quantity());
		
		productRepository.save(product_db);
		
		
	}

	@Override
	public Product findProductById(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public List<Product> findByCategoryId(Long productCategory) {
		 List<Product>productList = new ArrayList<>();
	        productList.addAll(productRepository.findByCategory_CategoryId(productCategory));
	        return productList;
	}

	@Override
	public List<Product> searchByProductName(String str) {
		
		return productRepository.findByProductName(str);
	}

}
