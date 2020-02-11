package com.example.demo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardEntity;

import services.BoardDao;
import services.BoardService;



@CrossOrigin(origins = {"http://localhost:8080", "https://localhost:8080" }) 
@EnableAutoConfiguration
@RestController
public class RestApiController {
	
	@Autowired
	BoardService BoardRepository;
	
	@GetMapping(value="/api/test")
	public @ResponseBody String test() {
		System.out.println("레스트api테스트!!");
		return "테스트";
	}
	
	
	@GetMapping(value="/api/board")
	public @ResponseBody JSONObject SelectBoard(@RequestParam("board_no") Long board_no) {
		
		JSONObject json = new JSONObject();
		System.out.println("파라미터:"+board_no);
		BoardEntity d = new BoardEntity((long)2,"타이틀","테스트용","user");
		
		//BoardRepository.save(d);
		//List<BoardEntity> list = BoardRepository.findAll();
		List<HashMap<String,Object>> list =  BoardRepository.SelectBoard();
		//BoardEntity b = BoardRepository.findOne(board_no);
		
		System.out.println(list);
		
		
		return json;
		
	}
	
}
