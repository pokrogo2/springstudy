package com.koreait.myproject01.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.myproject01.fcommand.DeleteFBoardCommand;
import com.koreait.myproject01.fcommand.DeleteFReplyCommand;
import com.koreait.myproject01.fcommand.InsertFBoardCommand;
import com.koreait.myproject01.fcommand.InsertFReplyCommand;
import com.koreait.myproject01.fcommand.SelectFBoardListCommand;
import com.koreait.myproject01.fcommand.SelectFBoardViewCommand;
import com.koreait.myproject01.fcommand.UpdateFBoardCommand;
import com.koreait.myproject01.fcommand.UpdateFBoardPage;

@Controller
public class FBoardController {
	private SqlSession sqlSession;
	private SelectFBoardListCommand selectFBoardListCommand;
	private SelectFBoardViewCommand selectFBoardViewCommand;
	private InsertFBoardCommand insertFBoardCommand;
	private UpdateFBoardCommand updateFBoardCommand;
	private DeleteFBoardCommand deleteFBoardCommand;
	private InsertFReplyCommand insertFReplyCommand;
	private UpdateFBoardPage updateFBoardPage;
	private DeleteFReplyCommand deleteFReplyCommand;
	
	
	public FBoardController(SqlSession sqlSession, SelectFBoardListCommand selectFBoardListCommand,
			SelectFBoardViewCommand selectFBoardViewCommand, InsertFBoardCommand insertFBoardCommand,
			UpdateFBoardCommand updateFBoardCommand, DeleteFBoardCommand deleteFBoardCommand,
			InsertFReplyCommand insertFReplyCommand, UpdateFBoardPage updateFBoardPage,
			DeleteFReplyCommand deleteFReplyCommand) {
		super();
		this.sqlSession = sqlSession;
		this.selectFBoardListCommand = selectFBoardListCommand;
		this.selectFBoardViewCommand = selectFBoardViewCommand;
		this.insertFBoardCommand = insertFBoardCommand;
		this.updateFBoardCommand = updateFBoardCommand;
		this.deleteFBoardCommand = deleteFBoardCommand;
		this.insertFReplyCommand = insertFReplyCommand;
		this.updateFBoardPage = updateFBoardPage;
		this.deleteFReplyCommand = deleteFReplyCommand;
	}

	@GetMapping(value="fBoard.do")
	public String gBoard(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		selectFBoardListCommand.execute(sqlSession, model);
		return "freeBoard/listPage";
	}
	
	@GetMapping(value="selectFBoardList.do")
	public String selectBoardList(HttpServletRequest request,Model model) {
		model.addAttribute("request", request);
		selectFBoardListCommand.execute(sqlSession, model);
		return "freeBoard/listPage";
	}
	
	@GetMapping(value="insertFBoardPage.do")
	public String insertBoardPage() {
		return "freeBoard/insert";
	}
	
	@PostMapping(value="insertFBoard.do")
	public String insertBoard(HttpServletRequest request,
							  Model model) {
		model.addAttribute("request", request);
		insertFBoardCommand.execute(sqlSession, model);
		return "redirect:selectFBoardList.do";
	}
	
	@GetMapping(value="selectFBoardByNo.do")
	public String selectBoardByNo(HttpServletRequest request,
								  Model model) {
		model.addAttribute("request", request);
		selectFBoardViewCommand.execute(sqlSession, model);

		return "freeBoard/view";
	}
	
	@PostMapping(value="updateFBoard.do")
	public String updateBoard(HttpServletRequest request,
							  Model model) {
		model.addAttribute("request", request);
		updateFBoardCommand.execute(sqlSession, model);
		return "redirect:selectFBoardList.do";
	}
	@PostMapping(value="deleteFBoard.do")
	public String deleteBoard(HttpServletRequest request,
							  Model model) {
		model.addAttribute("request", request);
		deleteFBoardCommand.execute(sqlSession, model);
		return "redirect:selectFBoardList.do";
	}
	
	@GetMapping(value="insertFReply.do")
	public String inertReply(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		insertFReplyCommand.execute(sqlSession,model);
		return "redirect:selectFBoardList.do";
	}
	@GetMapping(value="updateFPage.do")
	public String updateBoardPage(HttpServletRequest request,
								  Model model) {
		model.addAttribute("request", request);
		updateFBoardPage.execute(sqlSession, model);

		return "freeBoard/update";
	}
	@GetMapping(value="deleteFReply.do")
	public String deleteReply(HttpServletRequest request,
							  Model model) {
		model.addAttribute("request", request);
		deleteFReplyCommand.execute(sqlSession, model);
		return "redirect:selectFBoardList.do";
	}
}
