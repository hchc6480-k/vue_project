package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Board.BoardMapper;

@RestController
public class TetsApi {
	
	/*
	@Autowired
	BoardMapper bm;
	
	@GetMapping(value="/api/tests")
	public @ResponseBody String test(HttpServletRequest req) {
		System.out.println(bm.SelectBoard(1));
		return "테스트";
	}
	*/
}
