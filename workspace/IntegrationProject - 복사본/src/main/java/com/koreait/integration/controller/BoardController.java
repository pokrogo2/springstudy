package com.koreait.integration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.integration.domain.Board;
import com.koreait.integration.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@GetMapping(value="/")
	public String index() {
		return "index";
		
	}
	@GetMapping(value="selectAll.do" ,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String,Object> selectAll(){
		List<Board> list = boardService.totalList();
		Map<String, Object>resultMap = new HashMap<String, Object>();
		if(list.size()==0) {
			resultMap.put("status", 500);
			resultMap.put("list", null);
			resultMap.put("message", "목록이없다.");
		}else {
			resultMap.put("status", 200);
			resultMap.put("list", list);
			resultMap.put("message", "목록을 가져왔습니다.");
		}
		return resultMap;
		
	}
}
