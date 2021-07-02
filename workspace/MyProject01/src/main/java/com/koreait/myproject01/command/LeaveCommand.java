package com.koreait.myproject01.command;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.dao.MemberDAO;
import com.koreait.myproject01.dto.MemberDTO;

public class LeaveCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpSession session = (HttpSession)map.get("session");
		
		int no = ((MemberDTO)session.getAttribute("loginUser")).getMemberNo();
		System.out.println(no);
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int count = memberDAO.leave(no);
		
		if (count > 0) {
			session.invalidate();
		}

	}

}
