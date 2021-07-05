package com.koreait.myproject01.gcommand;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.dao.GBoardDAO;

public class SelectBoardListCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		GBoardDAO boardDAO = sqlSession.getMapper(GBoardDAO.class);
		model.addAttribute("list", boardDAO.selectBoardList());

	}

}
