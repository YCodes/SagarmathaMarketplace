package com.sagarmatha.repository;

import org.jboss.logging.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sagarmatha.domain.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

	@Query("SELECT v from Vendor v where v.Id = ?1")
	Vendor findVendorById(Long Id);

	

}
