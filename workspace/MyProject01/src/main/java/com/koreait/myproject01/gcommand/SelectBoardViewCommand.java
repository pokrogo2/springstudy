package com.koreait.myproject01.gcommand;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.dao.GBoardDAO;
import com.koreait.myproject01.dto.GalleryBoardDTO;

public class SelectBoardViewCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		GBoardDAO boardDAO = sqlSession.getMapper(GBoardDAO.class);
		GalleryBoardDTO board = boardDAO.selectBoardByNo(no);
		model.addAttribute("board", board);
		try { 
			model.addAttribute("filename", URLDecoder.decode(board.getFilename(), "utf-8")); 
		} catch(Exception e) { }

	}

}
