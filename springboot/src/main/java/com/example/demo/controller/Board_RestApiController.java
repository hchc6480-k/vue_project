package com.example.demo.controller;




import java.util.HashMap;




import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BoardDao;


@CrossOrigin(origins = {"http://127.0.0.1:8080", "https://127.0.0.1:8080","http://localhost:8080" }) 
@EnableAutoConfiguration
@RestController
public class Board_RestApiController {	
	
	@Autowired
	BoardDao BoardDao;
	
	@GetMapping(value="/api/tests")
	public @ResponseBody String test(HttpServletRequest req) {
		//Tests t = new Tests();		
		System.out.println("토근값:"+req.getHeader("token"));
		boolean a = StringUtils.isBlank("a");		
		return "테스트";
	}
	
	
	@GetMapping(value="/api/board")
	public @ResponseBody Map<String,Object> SelectBoard(@RequestParam(value="page",required = false) String page) {
		//JSONObject json = new JSONObject();	
		Map<String,Object> result = new HashMap<String,Object>();
		int page_idx = 0;
		result.put("now_page",page);
		if(page.equals("1")) page = "0";
		if(page != null && !page.equals("0")) {			
			page_idx = (Integer.parseInt(page)*2) -2;
		}
		List<LinkedHashMap<String,Object>> list =  BoardDao.SelectBoard(page_idx);
		
		result.put("total_count", BoardDao.totalBoardCount());		
		result.put("list", list);
		return result;
	}
	
	@PostMapping(value="/api/board/cdboard")
	@ResponseBody
	public Map<String,Object> CDBoard(
		@RequestParam(value="type",required=false) String type,
		@RequestParam(value="board_title") String board_nm,
		@RequestParam(value="board_content") String board_detail,
		@RequestParam(value="user_id") String user_id){
				
		Map<String,Object> result = new HashMap<String, Object>();
		if(type !=null && board_nm !=null && board_detail !=null && user_id !=null) {
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("board_nm", board_nm);
			map.put("board_detail", board_detail);
			map.put("user_id", user_id);
			
			if(type.equals("C")) {
				BoardDao.InsertBoard(map);
				result.put("state", "200");
				result.put("message", "success");
			}else if(type.equals("U")) {
				
			}else if(type.equals("D")) {
				
			}
		}else {
			result.put("state", "500");
			result.put("message", "필수 값이 누락 되었습니다.");
		}
		
		return result;
	}
	
}
