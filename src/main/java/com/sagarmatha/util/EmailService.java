package com.sagarmatha.util;

public interface EmailService {

	public void sendEmailNotification(String to,String messageSubject, String messageBody);
}
