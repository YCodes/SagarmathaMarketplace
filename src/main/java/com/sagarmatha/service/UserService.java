package com.sagarmatha.service;

import com.sagarmatha.domain.User;

public interface UserService {
	User findByEmail(String email);
}
