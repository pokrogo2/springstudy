package com.koreait.myproject01.dao;

import java.util.List;

import com.koreait.myproject01.dto.FreeBoardDTO;
import com.koreait.myproject01.dto.FreeBoardReplyDTO;
import com.koreait.myproject01.dto.PageDTO;



public interface FBoardDAO {
	public List<FreeBoardDTO> selectFBoardList();
	public  int insertFBoard(String id,  String content);
	public FreeBoardDTO selectFBoardByNo(int no);
	public int updateFBoard( String content,  int no);
	public int deleteFBoard(int no);
	public int deleteFReply(int no);
	public int insertFReply(FreeBoardReplyDTO dto);
	public List<FreeBoardDTO> selectFReplyList(int no);
	public int getTotalRecord();
	public List<FreeBoardDTO> searchAll(PageDTO pageDTO);
}

