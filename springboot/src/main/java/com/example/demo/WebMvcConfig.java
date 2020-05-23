package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	WebInterCeptor InterCeptor;
			
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("preHandle");
		registry.addInterceptor(InterCeptor).addPathPatterns("/**").excludePathPatterns("/login");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	/*
	@Bean
	public WebInterCeptor WebInterCeptor() {
		return new WebInterCeptor();
	}
	*/

}
