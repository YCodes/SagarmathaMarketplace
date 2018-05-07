package com.sagarmatha.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	JavaMailSender sendEmail;
	
	@Override
	public void sendEmailNotification(String to, String messageSubject, String messageBody) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(messageSubject);
		simpleMailMessage.setText(messageBody);
		sendEmail.send(simpleMailMessage);
		
	}

}
