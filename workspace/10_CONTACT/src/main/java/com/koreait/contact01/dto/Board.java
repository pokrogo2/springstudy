package com.koreait.contact01.dto;

public class Board {
	private int no;
	private String name;
	private String tel;
	private String addr;
	private String email;
	private String note;
	
	
	public Board() {}


	public Board(int no, String name, String tel, String addr, String email, String note) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
		this.note = note;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}
	
}
