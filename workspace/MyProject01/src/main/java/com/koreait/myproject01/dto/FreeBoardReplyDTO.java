package com.koreait.myproject01.dto;

import java.sql.Date;

public class FreeBoardReplyDTO {
	private int fno;
	private String fid;
	private int fboard_no;
	private String fcontent;
	private Date postdate;
	private String ip;
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public int getFboard_no() {
		return fboard_no;
	}
	public void setFboard_no(int fboard_no) {
		this.fboard_no = fboard_no;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
