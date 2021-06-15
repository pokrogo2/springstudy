package com.koreait.mvc5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.mvc5.dto.Person;

@Controller
public class MyController {
	@RequestMapping("/")
	public String contextPath() {
		return "index";
	}
	
	@RequestMapping(value="v01" ,
			method=RequestMethod.GET,
			produces="application/json;charset=utf-8")
	@ResponseBody// ajax를위한 필수애너테이션
	public Person v01(@RequestParam("name") String name,
					@RequestParam("age") int age){
		Person p  =new Person();
		p.setName(name);
		p.setAge(age);
		return p; // bean반환 . produces="application/json; charset=utf-8" 을 통해 bean은 json으로 변경/ jackson에 의해
			//return은 viewResolver에 의해 jsp로 처리되는데 이를 방지하기위해
	}
	
	
	
	
	
}
