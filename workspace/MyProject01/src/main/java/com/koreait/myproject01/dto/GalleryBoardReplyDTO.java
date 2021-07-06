package com.koreait.myproject01.dto;

import java.sql.Date;

public class GalleryBoardReplyDTO {
	private int gno;
	private String gid;
	private int gboard_no;
	private String gcontent;
	private Date postdate;
	private String ip;
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}

	public int getGboard_no() {
		return gboard_no;
	}
	public void setGboard_no(int gboard_no) {
		this.gboard_no = gboard_no;
	}
	public String getGcontent() {
		return gcontent;
	}
	public void setGcontent(String gcontent) {
		this.gcontent = gcontent;
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
