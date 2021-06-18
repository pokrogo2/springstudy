package com.koreait.contact01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.koreait.contact01.dto.Board;

public class BoardDAO {

	@Autowired
	private JdbcTemplate template;
	private String sql;
	
	
	// 1. list
	public List<Board> selectBoardList() {
		sql = "SELECT NO, NAME, TEL, ADDR, EMAIL,NOTE FROM CONTACT";
		return template.query(sql, new BeanPropertyRowMapper<Board>(Board.class));
	}
	public Board selectBoardByNo(int no) {
		sql = "SELECT NO, NAME, TEL, ADDR, EMAIL,NOTE FROM CONTACT WHERE NO = ?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<Board>(Board.class), no);
	}
	public int insertBoard(final Board board) {
		// PreparedStatementSetter로 작업해도 됨
		return template.update(new PreparedStatementCreator() {			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO 매개변수 con으로 ps를 만들어서 반환
				String sql = "INSERT INTO CONTACT VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, board.getName());
				ps.setString(2, board.getTel());
				ps.setString(3, board.getAddr());
				ps.setString(4, board.getEmail());
				ps.setString(5, board.getNote());
				return ps;
			}
		});
	}
	public int updateBoard(final Board board) {
		sql = "UPDATE CONTACT SET NAME = ?,TEL=?,ADDR = ?, EMAIL = ? ,NOTE=? WHERE NO = ?";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO 매개변수 ps를 이용해서 ?를 채움
				ps.setString(1, board.getName());
				ps.setString(2, board.getTel());
				ps.setString(3, board.getAddr());
				ps.setString(4, board.getEmail());
				ps.setString(5,board.getNote());
				ps.setInt(6, board.getNo());
			}
		});
	}
	public int deleteBoard(final int no) {
		sql = "DELETE FROM CONTACT WHERE NO = ?";
		return template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, no);
			}
		});
	}
}
