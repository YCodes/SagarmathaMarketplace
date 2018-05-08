package com.sagarmatha.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.sagarmatha.domain.User;
import com.sagarmatha.service.CustomerService;
import com.sagarmatha.service.UserService;


public class EmailExistValidator  implements ConstraintValidator<EmailExist, String>{

	@Autowired
	CustomerService customerService;
	
	@Autowired
	UserService userService;
	@Override
	public void initialize(EmailExist arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext arg1) {
		User user = null;
		try {
			user = userService.findByEmail(username);
			System.out.println("#######Validator Called");
		} catch (Exception e) {
			return true;
		}
		return user == null;
	}

}
