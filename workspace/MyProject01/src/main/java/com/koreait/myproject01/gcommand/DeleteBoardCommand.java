package com.koreait.myproject01.gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.dao.GBoardDAO;

public class DeleteBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		GBoardDAO boardDAO = sqlSession.getMapper(GBoardDAO.class);
		boardDAO.deleteBoard(no);

	}

}
