package com.koreait.search.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
	private SqlSession sqlSession;
	@Autowired
	public SearchController(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@GetMapping(value="/")
	public String index() {

		return "index";
	}
}
