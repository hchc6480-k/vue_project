package com.example.demo.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDao;

@Service
public class BoardService {

	@Autowired
	BoardDao BoardDao;
	
	public int totalBoardCount() {
		return BoardDao.totalBoardCount();
	}
	public List<LinkedHashMap<String, Object>> SelectBoard(int page_idx){
		return BoardDao.SelectBoard(page_idx);
	};
	
	public void InsertBoard(Map<String, Object> map) {
		BoardDao.InsertBoard(map);
	}

}
