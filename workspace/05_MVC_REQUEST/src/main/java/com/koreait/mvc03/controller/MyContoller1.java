package com.koreait.mvc03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyContoller1 {
	//요청 UrlMapping  처리는 메소드단위
	//get방식은 method생략가능
	//value 속성만 작성하는 경우 속성생략가능 
	//ex @RequestMapping("/")
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String a() {
		// 아래 return은 servlet context에 의해 다음과같이처리
		// return "/WEB-INF/views/index.jsp";
		return "index";//이동은 forward
	}
	@RequestMapping("view01")
	//@RequestMapping("/view01")
	public String b() {
		return "folder01/view01";
		//return "/folder01/view01"
	}
	@RequestMapping("/a/b/c/d/e/v02")
	public String c() {
		return "/folder01/view02";
		//return "/folder01/view01"
	}
	//매핑과 실제구조를 다르게설정해서 예상하지못하게
	
	//앞으로 매핑값 작성시 시작슬래시 넣지않음.
}
