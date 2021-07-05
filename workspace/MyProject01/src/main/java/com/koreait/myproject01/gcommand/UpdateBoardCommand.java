package com.koreait.myproject01.gcommand;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import com.koreait.myproject01.dao.GBoardDAO;
import com.koreait.myproject01.dto.GalleryBoardDTO;

public class UpdateBoardCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)map.get("multipartRequest");
		
		// DB 삭제
		int no = Integer.parseInt(multipartRequest.getParameter("no"));
		GBoardDAO boardDAO = sqlSession.getMapper(GBoardDAO.class);
		boardDAO.deleteBoard(no);
		
		// 첨부 삭제
		String filename1 = multipartRequest.getParameter("filename1");
		String realPath = multipartRequest.getServletContext().getRealPath("resources/archive");
		File file = new File(realPath, filename1);
		if (file != null) {
			if (file.exists()) {
				file.delete();
			}
		}

	}

}
