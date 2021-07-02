package com.koreait.myproject01.dao;



import com.koreait.myproject01.dto.MemberDTO;

public interface MemberDAO {

	public int idCheck(String id);
	public int join(MemberDTO member);
	public MemberDTO login(MemberDTO member);
	public int leave(int no);
	public MemberDTO findId(String email);
	public int changePw(MemberDTO member);
}
