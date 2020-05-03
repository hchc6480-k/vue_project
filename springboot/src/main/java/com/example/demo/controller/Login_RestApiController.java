package com.example.demo.controller;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LoginDao;
import com.example.demo.service.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@CrossOrigin(origins = {"http://localhost:8080", "https://localhost:8080" }) 
@EnableAutoConfiguration
@RestController
public class Login_RestApiController {
	
	@Autowired
	LoginService LoginRepository;

	@GetMapping(value="/usr/registMbr")
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
			
			try {
				LoginRepository.RegistUsr(data);
			} catch (Exception e) {
				result.put("state", "500");
				result.put("message", "fail");
			}
									
		}else {
			result.put("state", "500");
			result.put("message", "fail");
		}
		
		return result;		
	}
	
	/* 로그인 정보 체크 */
	@PostMapping(value="/usr/LoginChk")
	public Map<String,Object>LoginChk(
			@RequestParam(value="user_id") String user_id,
			@RequestParam(value="pwd") String pwd){
		
		Map<String,Object> result = new HashMap<String, Object>();
							
		if(user_id != null && pwd != null) {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("user_id", user_id);
			map.put("pwd", pwd);
			
			Map<String,Object> data = LoginRepository.SelectUsr(map);
			
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
			
		}
		
		System.out.println(result);
		
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
						
			Map<String,Object> data = LoginRepository.SelectUsr(map);
			
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
			result.put("message", "fail");
		}
		
		System.out.println(result);
		
		return result;
	}
	
	
}