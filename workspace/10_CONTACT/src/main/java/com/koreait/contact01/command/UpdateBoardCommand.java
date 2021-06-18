package com.koreait.contact01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.koreait.contact01.dao.BoardDAO;
import com.koreait.contact01.dto.Board;

public class UpdateBoardCommand implements BoardCommand {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("req");
		
		Board board = new Board();
		board.setName(request.getParameter("name"));
		board.setTel(request.getParameter("tel"));
		board.setAddr(request.getParameter("addr"));
		board.setEmail(request.getParameter("email"));
		board.setNote(request.getParameter("note"));
		board.setNo(Integer.parseInt(request.getParameter("no")));
		boardDAO.updateBoard(board);
		
	}

}
