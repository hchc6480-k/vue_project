package com.example.demo;

import java.io.PrintWriter;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class WebInterCeptor extends HandlerInterceptorAdapter{

	
	public static String access_token = "a";  
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String get_access_token = request.getHeader("access_token") !=null ? request.getHeader("access_token") : "";
		System.out.println("get_access_token:"+get_access_token);
		/*
		if(!access_token.equals(get_access_token)) {
			request.setAttribute("confirm", "no");
			return false;
		}else {
			request.setAttribute("confirm", "ok");
		}*/
		return super.preHandle(request, response, handler);
	}
			
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		super.afterCompletion(request, response, handler, ex);
	}

}
