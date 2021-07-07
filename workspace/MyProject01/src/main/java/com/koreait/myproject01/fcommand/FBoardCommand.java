package com.koreait.myproject01.fcommand;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

public interface FBoardCommand {
	public void execute(SqlSession sqlSession, Model model);

}
