package com.koreait.myproject01.gcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.command.MemberCommand;
import com.koreait.myproject01.dao.GBoardDAO;

public class DeleteReplyCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		int no = Integer.parseInt(request.getParameter("gno"));
		
		GBoardDAO boardDAO = sqlSession.getMapper(GBoardDAO.class);
		boardDAO.deleteReply(no);

	}

}
