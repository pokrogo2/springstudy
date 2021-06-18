package com.koreait.contact01.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.contact01.dao.BoardDAO;

public class DeleteBoardCommand implements BoardCommand {
	@Autowired
	private BoardDAO boardDAO;
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		int no = (Integer)map.get("no");
		boardDAO.deleteBoard(no);
	}

}
