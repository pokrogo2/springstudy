package com.koreait.myproject01.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GBoardController {
	private SqlSession sqlSession;
	
	
	public GBoardController(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}


	@GetMapping(value= "gBoard.do")
	public String login() {
		return "galleryBoard/listPage";
	}
	
	
	
	
	
	
}
