package com.sagarmatha.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagarmatha.domain.User;
import com.sagarmatha.repository.UserRepository;
import com.sagarmatha.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Override
	public User findByEmail(String userName) {
		
		return userRepository.findUserByuserName(userName);
	}

}
