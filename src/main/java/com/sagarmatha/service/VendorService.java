package com.sagarmatha.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sagarmatha.domain.Vendor;

@Service
public interface VendorService {
	
	void saveVendor(Vendor vendor);
	
	Vendor findVendorById(Long Id); 
	
	void updateVendor(Long Id, Vendor vendor);

}
