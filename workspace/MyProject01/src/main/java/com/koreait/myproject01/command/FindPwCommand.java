package com.koreait.myproject01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.dao.MemberDAO;
import com.koreait.myproject01.dto.MemberDTO;
import com.koreait.myproject01.util.SecurityUtils;


public class FindPwCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map =model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		
		MemberDTO member = new MemberDTO();
		member.setMemberPw(SecurityUtils.encodeBase64(pw));
		member.setMemberEmail(email);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		memberDAO.changePw(member);
	}

}
