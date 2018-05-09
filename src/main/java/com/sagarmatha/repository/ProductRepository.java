package com.sagarmatha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByVendorId(Long Id);
	
	@Query("Select p from Product p where vendorId = ?1 and isActive = ?2")
	public List<Product> findActiveProducts(Long Id, boolean value);

	 public List<Product> findByCategory_CategoryId(Long productCategory);

	 @Query("select p from Product p where p.product_name like ?1%")
	public List<Product> findByProductName(String str);

	

}
