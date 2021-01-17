package com.example.demo;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Configuration
public class EmailService{
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public void sendMail() throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setTo("blueberry_91@naver.com");
		helper.setSubject("정신차려!!");
		helper.setText("졸리냐?!!!");
		javaMailSender.send(message);
		
		
	}
}
