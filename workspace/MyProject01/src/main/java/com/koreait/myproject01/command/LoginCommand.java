package com.koreait.myproject01.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.myproject01.dao.MemberDAO;
import com.koreait.myproject01.dto.MemberDTO;
import com.koreait.myproject01.util.SecurityUtils;

public class LoginCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDTO member = new MemberDTO();
		member.setMemberId(id);
		member.setMemberPw(SecurityUtils.encodeBase64(pw));  // 암호화 된 pw
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		MemberDTO loginUser = memberDAO.login(member);
		
		if (loginUser != null) {
			System.out.println(loginUser.getMemberId());
			System.out.println(loginUser.getMemberPw());
			System.out.println(loginUser.getMemberAddress());
			System.out.println(loginUser.getMemberTel());
			System.out.println(loginUser.getMemberName());
			System.out.println(loginUser.getMemberNo());
			System.out.println(loginUser.getMemberEmail());
			System.out.println(loginUser.getStatus());
			request.getSession().setAttribute("loginUser", loginUser);
		}
		
	}

}
