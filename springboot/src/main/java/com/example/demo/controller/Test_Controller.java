package com.example.demo.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EmailService;

@RestController
public class Test_Controller {

	@Autowired
	EmailService email;
	
	@GetMapping("/mail")
	public void sendMail() throws MessagingException {
		email.sendMail();
	}
}
