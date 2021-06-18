package com.koreait.contact01.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.contact01.dao.BoardDAO;

public class SelectBoardViewCommand implements BoardCommand{

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		int no = (Integer)map.get("no");
		model.addAttribute("board", boardDAO.selectBoardByNo(no));

	}
}
