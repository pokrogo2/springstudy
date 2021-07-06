package com.koreait.apptest;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.apptest.config.BeanConfiguration;
import com.koreait.apptest.dao.MemberDAO;
import com.koreait.apptest.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {BeanConfiguration.class})
public class MemberTest {
//junit테스트는 스프링을 다돌리지않음, 
	//autowired는 동작을안함
	//oracle jdbc도 tomcat에 넣어두면 실행 x
	//현재 프로젝트에 있어야함
	//pom.xml참고
	//junit테스트시 스프링 모든 기능 활요을위해
	//spring-test 디펜던시 추가(스프링 프레임워크랑버전맞춤)
	//spring-test디펜던시가 지원 애너테이션
	//@RunWith : 이 테스트는 스프링과 함께 돌려달라
	//@ContextConfiguration : 빈을 여기서 찾아라
	@Autowired
	private SqlSession sqlsession;
	@Before
	public void joinTest() {
		Member member = new Member();
		member.setId("test");
		member.setPw("1111");
		member.setName("테스트");
		member.setEmail("test@web.com");
		MemberDAO memberDAO = sqlsession.getMapper(MemberDAO.class);
		int count=memberDAO.join(member);
		
		assertEquals("가입실패",1,count);
		//1과 카운트가 같으면 검사통과
		
	}
	


	//로그인 점검테스트
	//test라는 아이디를 가진 아이디가 있으면 통과,없으면실패
	@Test
	public void idCheckTest() {
	
		MemberDAO memberDAO = sqlsession.getMapper(MemberDAO.class);
		int count = memberDAO.idCheck("admin");
		assertEquals("체크실패", 1,count);
	}
	
	
	
	
	
	
}