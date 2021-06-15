package com.koreait.mvc03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.mvc03.dto.Person;

@Controller
public class MyController {
	/*
	 * 전달 받은 파라미터
	 * 1.httpServletRequest request\
	 * 2.request param
	 * 3.DTO
	 * 4.@ModelAttribute
	 * */
	@RequestMapping("f5/v01")
	public String a(HttpServletRequest request,Model model) {
		//request는 요청 처리(name,age) model은 응답처리
		String name =request.getParameter("name");
		int age =Integer.parseInt(request.getParameter("age"));
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "folder05/view01";
	}
	
	@RequestMapping("f5/v02")
	public String b(@RequestParam("name") String name, //@requestParam(파라미터 명) 저장할 변수
					@RequestParam("age") int age, // String name = request.getparameter(name)
					Model model) {
		
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "folder05/view02";
		
	}
	//@RequestParam(value="파라미터")
	//@RequestParam("파라미터")
	//defaultvalue="0"
	//
	@RequestMapping("f5/v03")
	public String c(@RequestParam(value="name",required=false) String name,//required false =  파라미터 필수아님
					@RequestParam(value="age",required=false,defaultValue="0") int age, Model model) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "folder05/view03";
	}
	//dto
	@RequestMapping("f5/v04")
	public String d(Person person,Model model) {
		//name,age가 person에저장
		model.addAttribute("person",person);
		return "folder05/view04";
	}
	@RequestMapping("f5/v05")
	public String e(@ModelAttribute(value="name") String name,
					@ModelAttribute("age") int age) {
		return "folder05/view05";
	}
	@RequestMapping("f5/v06")
	public String f(@ModelAttribute("person") Person person) {
		return "folder05/view06";
	}
}
