package com.sagarmatha.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagarmatha.domain.Admin;
import com.sagarmatha.domain.Role;
import com.sagarmatha.domain.User;
import com.sagarmatha.repository.AdminRepository;
import com.sagarmatha.service.AdminService;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public void addAdmin(Admin admin) {
		
		BCryptPasswordEncoder passworEncoder = new BCryptPasswordEncoder();
		User user = admin.getUser();
		user.setUserName(admin.getEmail());
		user.setRole(Role.Admin);
		user.setPassword(passworEncoder.encode(user.getPassword()));
		System.out.println("##########Service called"+admin.getEmail()+"Userid"+user.getUserId());
		System.out.println(admin.getAddress());
		System.out.println(user);
		adminRepository.save(admin);
	}
	
	@Override
	public List<Admin> findAllAdmin() {
		return adminRepository.findAll();
	}
}
