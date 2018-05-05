package com.sagarmatha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByVendorId(Long Id);
	
	@Query("Select p from Product p where p.vendorId = ?1 and p.isActive = false")
	public List<Product> findActiveProducts(Long Id);

}
