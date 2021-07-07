package com.koreait.myproject01.fcommand;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.myproject01.dao.FBoardDAO;
import com.koreait.myproject01.dao.GBoardDAO;


public class InsertFBoardCommand implements FBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		
		
		FBoardDAO boardDAO = sqlSession.getMapper(FBoardDAO.class);
		
	
		
		boardDAO.insertFBoard(id, content);  // 첨부가 없는 경우
	}

}