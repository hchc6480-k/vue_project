package com.example.demo.controller;




import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BoardService;





@CrossOrigin(origins = {"http://localhost:8080", "https://localhost:8080" }) 
@EnableAutoConfiguration
@RestController
public class Board_RestApiController {
	
	@Autowired
	BoardService BoardRepository;
	
	@GetMapping(value="/api/test")
	public @ResponseBody String test() {
		System.out.println("레스트api테스트!!?");
		return "테스트";
	}
	
	
	@GetMapping(value="/api/board")
	public @ResponseBody Map<String,Object> SelectBoard() {
		//JSONObject json = new JSONObject();
		Map<String,Object> result = new HashMap<String,Object>();
		
		List<LinkedHashMap<String,Object>> list =  BoardRepository.SelectBoard();
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
				BoardRepository.InsertBoard(map);
				result.put("code", "success");
			}else if(type.equals("U")) {
				
			}else if(type.equals("D")) {
				
			}
		}
		
		return result;
	}
	
}
