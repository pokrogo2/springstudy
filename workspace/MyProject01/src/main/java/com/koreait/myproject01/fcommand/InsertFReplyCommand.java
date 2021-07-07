package com.koreait.myproject01.fcommand;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.dao.FBoardDAO;
import com.koreait.myproject01.dao.GBoardDAO;
import com.koreait.myproject01.dto.FreeBoardDTO;
import com.koreait.myproject01.dto.FreeBoardReplyDTO;
import com.koreait.myproject01.dto.GalleryBoardReplyDTO;
import com.koreait.myproject01.dto.MemberDTO;


public class InsertFReplyCommand implements FBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		
		int fboard_no = Integer.parseInt(request.getParameter("fboard_no"));
		String content = request.getParameter("content");
		//String ip = request.getRemoteAddr();
		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("loginUser");
		
		FreeBoardReplyDTO dto =  new FreeBoardReplyDTO();
		dto.setFid(loginDTO.getMemberId());
		dto.setFcontent(content);
		dto.setFboard_no(fboard_no);
		//dto.setIp(ip);
		
		FBoardDAO boardDAO = sqlSession.getMapper(FBoardDAO.class);
		System.out.println(dto.getFid());
		System.out.println(dto.getFcontent());
		System.out.println(dto.getFboard_no());
		//System.out.println(dto.getIp());
		boardDAO.insertFReply(dto);
		
	}

}