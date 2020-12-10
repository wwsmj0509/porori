package com.board.entity;

public class imgBoard_entity {
	
	
	private int idx;
	private String userid;
	private String content;
	private String img;
	private String logtime;
	public imgBoard_entity() {
		super();
	}
	public imgBoard_entity(int idx, String userid, String content, String img, String logtime) {
		super();
		this.idx = idx;
		this.userid = userid;
		this.content = content;
		this.img = img;
		this.logtime = logtime;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
}
