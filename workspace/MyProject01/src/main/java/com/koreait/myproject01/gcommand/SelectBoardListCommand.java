package com.koreait.myproject01.gcommand;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.dao.GBoardDAO;
import com.koreait.myproject01.dto.GalleryBoardDTO;
import com.koreait.myproject01.dto.PageDTO;
import com.koreait.myproject01.util.PagingUtils;


public class SelectBoardListCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		GBoardDAO gboardDAO = sqlSession.getMapper(GBoardDAO.class);
		int totalRecord = gboardDAO.getTotalRecord();
		
		PageDTO pageDTO = PagingUtils.getPage(totalRecord, page);
		
		List<GalleryBoardDTO> list = gboardDAO.searchAll(pageDTO);
		String paging = PagingUtils.getPaging("gBoard.do", page);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);

	}

}
