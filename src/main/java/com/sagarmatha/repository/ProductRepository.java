package com.sagarmatha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByVendorId(Long Id);

}
