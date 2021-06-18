package com.koreait.contact01.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.contact01.dao.BoardDAO;
import com.koreait.contact01.dto.Board;

public class InsertBoardCommand implements BoardCommand {

		@Autowired
		private BoardDAO boardDAO;
		
		@Override
		public void execute(Model model) {
			
			Map<String, Object> map = model.asMap();
			Board board = (Board)map.get("board");
			boardDAO.insertBoard(board);
	}

}
