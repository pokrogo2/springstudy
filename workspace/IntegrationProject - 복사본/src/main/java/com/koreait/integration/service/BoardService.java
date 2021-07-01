package com.koreait.integration.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.integration.domain.Board;
import com.koreait.integration.repository.BoardRepository;

public interface BoardService {
	
	public List<Board> totalList();
	public List<Board> searchList(Map<String, String>map);
	
	
	
}
