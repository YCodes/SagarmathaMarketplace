package com.sagarmatha.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sagarmatha.domain.Role;
import com.sagarmatha.domain.User;
import com.sagarmatha.domain.Vendor;
import com.sagarmatha.repository.VendorRepository;
import com.sagarmatha.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	VendorRepository vendorRepository;
	
	// Saves vendor in vendor table plus creates a record for vendor is User table.
	@Override
	public void saveVendor(Vendor vendor) {
		
		// Save in User table
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User user = vendor.getUser();
		user.setUserName(vendor.getEmail());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_VENDOR);
		user.setEnabled(true);
		vendorRepository.save(vendor);
		
		
	}

	
	@Override
	public Vendor findVendorById(Long Id) {
		
		return vendorRepository.findVendorById(Id);
	}

	@Override
	public void updateVendor(Long Id, Vendor vendor) {
		
		Vendor vendor_db = vendorRepository.findOne(Id);
		
		vendor_db.setFirst_name(vendor.getFirst_name());
		vendor_db.setLast_name(vendor.getLast_name());
		vendor_db.setPhone_number(vendor.getPhone_number());
		vendor_db.setAddress(vendor.getAddress());
		//vendor_db.setEmail(vendor.getEmail());
		vendor_db.setUser(vendor.getUser());
		
		vendorRepository.save(vendor_db);
		
		// start here
		
	}


	@Override
	public Vendor findVendorByEmail(String email) {
		
		return vendorRepository.findVendorByEmail(email);
	}

}
