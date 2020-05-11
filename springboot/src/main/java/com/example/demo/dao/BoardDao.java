package com.example.demo.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BoardDao {

	public int totalBoardCount();
	public List<LinkedHashMap<String,Object>> SelectBoard(int page_idx);
	
	public void InsertBoard(Map<String,Object> map);
}
