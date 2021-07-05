package com.koreait.integration1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.koreait.integration1.domain.Board;
import com.koreait.integration1.repository.BoardRepository;

public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository repository;
	@Override
	public List<Board> totalList() {
		// TODO Auto-generated method stub
		return repository.selectAll();
	}

	@Override
	public List<Board> searchList(Map<String, String> map) {
		// TODO Auto-generated method stub
		return repository.selectQuery(map);
	}
}
