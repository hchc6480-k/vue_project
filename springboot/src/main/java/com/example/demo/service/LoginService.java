package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginDao;

@Service
public class LoginService {

	@Autowired
	LoginDao LoginDao;
	
	public void RegistUsr(Map<String,Object> map){
		LoginDao.RegistUsr(map);
	};
	
	public Map<String,Object> SelectUsr(Map<String,Object> map){
		return LoginDao.SelectUsr(map);
	};

}
