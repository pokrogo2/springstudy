package com.koreait.myproject01.fcommand;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.myproject01.dao.FBoardDAO;
import com.koreait.myproject01.dao.GBoardDAO;
import com.koreait.myproject01.dto.GalleryBoardDTO;

public class UpdateFBoardCommand implements FBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		// DB 삭제
		int fno = Integer.parseInt(request.getParameter("no"));
		String fcontent = request.getParameter("content");
		FBoardDAO boardDAO = sqlSession.getMapper(FBoardDAO.class);
	
			
			

			
			boardDAO.updateFBoard(fcontent,fno);
			
		}
		
	}


