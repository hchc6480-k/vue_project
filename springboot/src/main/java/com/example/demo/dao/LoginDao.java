package com.example.demo.dao;

import java.util.Map;

public interface LoginDao {
	
	public void RegistUsr(Map<String,Object> map);
	public Map<String,Object> SelectUsr(Map<String,Object> map);


}
