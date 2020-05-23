package com.example.demo.Board;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface BoardMapper {
	public int totalBoardCount();
	public List<LinkedHashMap<String,Object>> SelectBoard(int page_idx);
	
	public void InsertBoard(Map<String,Object> map);
}
