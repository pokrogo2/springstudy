package com.koreait.myproject01.dao;

import java.util.List;


import com.koreait.myproject01.dto.GalleryBoardDTO;
import com.koreait.myproject01.dto.GalleryBoardReplyDTO;

public interface GBoardDAO {
	public List<GalleryBoardDTO> selectBoardList();
	public  int insertBoard(String id, String title, String content, String filename);
	public GalleryBoardDTO selectBoardByNo(int no);
	public int updateBoard(String id, String content, String filename, int no);
	public int deleteBoard(int no);
	public int insertReply(GalleryBoardReplyDTO dto);
	public List<GalleryBoardReplyDTO> selectReplyList(int no);
}
