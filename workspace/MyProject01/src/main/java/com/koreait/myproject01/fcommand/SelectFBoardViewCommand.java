package com.koreait.myproject01.fcommand;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.dao.FBoardDAO;
import com.koreait.myproject01.dao.GBoardDAO;
import com.koreait.myproject01.dto.FreeBoardDTO;
import com.koreait.myproject01.dto.GalleryBoardDTO;

public class SelectFBoardViewCommand implements FBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		FBoardDAO boardDAO = sqlSession.getMapper(FBoardDAO.class);
		FreeBoardDTO board = boardDAO.selectFBoardByNo(no);
		model.addAttribute("board", board);
		model.addAttribute("replyList", boardDAO.selectFReplyList(no));

	}

}
