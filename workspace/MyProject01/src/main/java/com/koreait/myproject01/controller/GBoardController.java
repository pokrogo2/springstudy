package com.koreait.myproject01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.myproject01.gcommand.DeleteBoardCommand;
import com.koreait.myproject01.gcommand.InsertBoardCommand;
import com.koreait.myproject01.gcommand.SelectBoardListCommand;
import com.koreait.myproject01.gcommand.SelectBoardViewCommand;
import com.koreait.myproject01.gcommand.UpdateBoardCommand;

@Controller
public class GBoardController {
	private SqlSession sqlSession;
	private SelectBoardListCommand selectBoardListCommand;
	private SelectBoardViewCommand selectBoardViewCommand;
	private InsertBoardCommand insertBoardCommand;
	private UpdateBoardCommand updateBoardCommand;
	private DeleteBoardCommand deleteBoardCommand;
	


	
	public GBoardController(SqlSession sqlSession, SelectBoardListCommand selectBoardListCommand,
			SelectBoardViewCommand selectBoardViewCommand, InsertBoardCommand insertBoardCommand,
			UpdateBoardCommand updateBoardCommand, DeleteBoardCommand deleteBoardCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectBoardListCommand = selectBoardListCommand;
		this.selectBoardViewCommand = selectBoardViewCommand;
		this.insertBoardCommand = insertBoardCommand;
		this.updateBoardCommand = updateBoardCommand;
		this.deleteBoardCommand = deleteBoardCommand;
	}
	@GetMapping(value="gBoard.do")
	public String gBoard(Model model) {
		selectBoardListCommand.execute(sqlSession, model);
		return "galleryBoard/listPage";
	}
	
	@GetMapping(value="selectBoardList.do")
	public String selectBoardList(Model model) {
		selectBoardListCommand.execute(sqlSession, model);
		return "galleryBoard/listPage";
	}
	
	@GetMapping(value="insertBoardPage.do")
	public String insertBoardPage() {
		return "galleryBoard/insert";
	}
	
	@PostMapping(value="insertBoard.do")
	public String insertBoard(MultipartHttpServletRequest multipartRequest,
							  Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		insertBoardCommand.execute(sqlSession, model);
		return "redirect:selectBoardList.do";
	}
	
	@GetMapping(value="selectBoardByNo.do")
	public String selectBoardByNo(HttpServletRequest request,
								  Model model) {
		model.addAttribute("request", request);
		selectBoardViewCommand.execute(sqlSession, model);
		return "galleryBoard/view";
	}
	
	@PostMapping(value="updateBoard.do")
	public String updateBoard(MultipartHttpServletRequest multipartRequest,
							  Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		updateBoardCommand.execute(sqlSession, model);
		return "redirect:selectBoardByNo.do?no=" + multipartRequest.getParameter("no");
	}
	@GetMapping(value="updatePage.do")
	public String updatePage() {
		return "galleryBoard/update";
	}
	@PostMapping(value="deleteBoard.do")
	public String deleteBoard(MultipartHttpServletRequest multipartRequest,
							  Model model) {
		model.addAttribute("multipartRequest", multipartRequest);
		deleteBoardCommand.execute(sqlSession, model);
		return "redirect:selectBoardList.do";
	}
	
	
	
	
	
}
