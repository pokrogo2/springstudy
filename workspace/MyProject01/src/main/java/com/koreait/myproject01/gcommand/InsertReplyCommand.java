package com.koreait.myproject01.gcommand;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;


import com.koreait.myproject01.dao.GBoardDAO;
import com.koreait.myproject01.dto.GalleryBoardReplyDTO;
import com.koreait.myproject01.dto.MemberDTO;


public class InsertReplyCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		
		int gboard_no = Integer.parseInt(request.getParameter("gboard_no"));
		String content = request.getParameter("content");
		//String ip = request.getRemoteAddr();
		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginUser");
		
		GalleryBoardReplyDTO dto =  new GalleryBoardReplyDTO();
		dto.setGid(loginDTO.getMemberId());
		dto.setGcontent(content);
		dto.setGboard_no(gboard_no);
		//dto.setIp(ip);
		
		GBoardDAO boardDAO = sqlSession.getMapper(GBoardDAO.class);
		System.out.println(dto.getGid());
		System.out.println(dto.getGcontent());
		System.out.println(dto.getGboard_no());
		//System.out.println(dto.getIp());
		boardDAO.insertReply(dto);
		
	}

}