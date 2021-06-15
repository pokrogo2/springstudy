package com.koreait.mvc03.quiz;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {
	@RequestMapping("quiz/v01")
	public String a(HttpServletRequest request,Model model) {
		String title= request.getParameter("title");
		int hit = (Integer.parseInt(request.getParameter("hit")));
		model.addAttribute("title",title);
		model.addAttribute("hit",hit);
		return "quiz/quiz01";
	}
}
