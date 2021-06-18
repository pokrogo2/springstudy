package com.koreait.contact01.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.contact01.dao.BoardDAO;

public class SelectBoardListCommand implements BoardCommand {
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void execute(Model model) {
		model.addAttribute("list", boardDAO.selectBoardList());
	}
	
	
}
