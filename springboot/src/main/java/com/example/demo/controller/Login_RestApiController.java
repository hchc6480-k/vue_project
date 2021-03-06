package com.example.demo.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LoginDao;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@CrossOrigin(origins = {"http://127.0.0.1:8080", "https://127.0.0.1:8080","http://localhost:8080" }) 
@EnableAutoConfiguration
@RestController
public class Login_RestApiController {
	
	@Autowired
	LoginDao LoginDao;

	@PostMapping(value="/usr/registMbr")
	public Map<String,Object>registMbr(
			@RequestParam(value="user_id") String user_id,
			@RequestParam(value="pwd") String pwd,
			@RequestParam(value="mbr_nm") String mbr_nm) {
		
		Map<String,Object> result = new HashMap<String, Object>();
		
		if(user_id != null && pwd !=null && mbr_nm != null) {
			Map<String,Object> claims = new HashMap<String, Object>();				
			String secretKey = "A";
			//String jwt_token = Jwts.builder().setHeader(header).setClaims(claims).signWith(SignatureAlgorithm.HS256, secretKey.getBytes()).compact();
			String jwt_token = Jwts.builder()
					.setHeaderParam("typ", "JWT")
					.setHeaderParam("issueDate", System.currentTimeMillis())
					.setClaims(claims)
					.setSubject(user_id)
					.signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
					.compact();
			
			Map<String,Object> data = new HashMap<String, Object>();
			data.put("user_id", user_id);
			data.put("pwd", pwd);
			data.put("mbr_nm", mbr_nm);
			data.put("mbr_token", jwt_token);
			System.out.println(data);
			try {
				LoginDao.RegistUsr(data);
				result.put("state", "200");
				result.put("message", "success");
			} catch (Exception e) {				
				System.out.println(e.getMessage());
				result.put("state", "500");
				result.put("message", "fail");
			}
									
		}else {
			result.put("state", "500");
			result.put("message", "필수값이 누락 되었습니다.");
		}
		
		return result;		
	}
	
	/* 로그인 정보 체크 */
	@PostMapping(value="/usr/LoginChk")
	public Map<String,Object>LoginChk(
			@RequestParam(value="user_id") String user_id,
			@RequestParam(value="pwd") String pwd , HttpServletRequest req){
		System.out.println("토큰:"+req.getHeader("access_token"));
		Map<String,Object> result = new HashMap<String, Object>();
							
		if(user_id != null && pwd != null) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("user_id", user_id);
			map.put("pwd", pwd);
			
			Map<String,Object> data = LoginDao.SelectUsr(map);
			
			if(data != null){
				result.put("user_id",data.get("user_id"));
				result.put("mbr_nm",data.get("mbr_nm"));
				result.put("token", data.get("mbr_token"));
				result.put("state", "200");
				result.put("message", "success");				
			}else {
				result.put("state", "500");
				result.put("message", "fail");
			}
			
		}else {
			result.put("state", "500");
			result.put("message", "필수 값이 누락 되었습니다.");
		}
					
		return result;
	}
	
	/* 회원 정보 가져오기 */
	@PostMapping(value="/usr/userInfo")
	public Map<String,Object>userInfo(
			@RequestParam(value="token") String access_token			
			){
		
		Map<String,Object> result = new HashMap<String, Object>();
							
		if(access_token != null) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("access_token", access_token);
						
			Map<String,Object> data = LoginDao.SelectUsr(map);
			
			if(data != null){
				result.put("mbr_nm",data.get("mbr_nm"));
				result.put("user_id",data.get("user_id"));
				result.put("token", data.get("mbr_token"));
				result.put("state", "200");
				result.put("message", "success");
			}else {
				result.put("state", "500");
				result.put("message", "fail");
			}
			
		}else {
			result.put("state", "500");
			result.put("message", "필수 값이 누락 되었습니다.");
		}
		
		System.out.println(result);
		
		return result;
	}
	
	
}
