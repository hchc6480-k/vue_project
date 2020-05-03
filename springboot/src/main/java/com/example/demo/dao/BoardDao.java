package com.example.demo.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BoardDao {

	public List<LinkedHashMap<String,Object>> SelectBoard();
	
	public void InsertBoard(Map<String,Object> map);
}
