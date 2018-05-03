package com.sagarmatha.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sagarmatha.domain.Admin;

@Service
public interface AdminService {
	
	public void addAdmin(Admin admin);
	
	public List<Admin> findAllAdmin();

}
