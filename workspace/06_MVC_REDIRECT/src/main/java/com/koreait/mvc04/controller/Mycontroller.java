package com.koreait.mvc04.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mvc04.dto.Person;

@Controller
public class Mycontroller {
	@RequestMapping("/")
	public String contextPath() {
		return "index";
	}
	@RequestMapping("v01")
	public String v01(@RequestParam("name") String name,
					 @RequestParam("age") int age) {
		return "result"; //forward 이동 :result.jsp로 이동
	}
	@RequestMapping("v02")
	public String v02(Person person) {
		System.out.println(person);
		return "redirect:v03";//redirect는 : 매핑
	}
	
	@RequestMapping("v04")
	public String v04(Person person) {
		System.out.println(person);
		return "redirect:v05?name=" +person.getName() + "&age="+person.getAge();
	}
	public String v05(Person person) {
		System.out.println(person);
		return "result";
	}
	@RequestMapping("v06")
	public String v06(Person person,RedirectAttributes rttr) { // 요청  jsp에서 전달한 파라미터로 생성되는 person)
		System.out.println(person);
		rttr.addFlashAttribute("name",person.getName());
		rttr.addFlashAttribute("age",person.getAge());
		return "redirect:v07";
	}
}
