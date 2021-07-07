package com.koreait.myproject01.fcommand;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.dao.FBoardDAO;
import com.koreait.myproject01.dto.FreeBoardDTO;
import com.koreait.myproject01.dto.PageDTO;
import com.koreait.myproject01.util.PagingUtils;


public class SelectFBoardListCommand implements FBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		FBoardDAO fboardDAO = sqlSession.getMapper(FBoardDAO.class);
		int totalRecord = fboardDAO.getTotalRecord();
		
		PageDTO pageDTO = PagingUtils.getPage(totalRecord, page);
		
		List<FreeBoardDTO> list = fboardDAO.searchAll(pageDTO);
		String paging = PagingUtils.getPaging("fBoard.do", page);
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
	}

}
