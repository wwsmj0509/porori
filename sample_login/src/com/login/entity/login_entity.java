package com.login.entity;

public class login_entity {
	
	private String userid;
	private String pwd;
	private String name;
	private String email;
	private String address;
	private String chk;
	
	
	

	public login_entity(String userid, String pwd) {
		super();
		this.userid = userid;
		this.pwd = pwd;
	}
	

	
	
	public login_entity(String userid, String pwd, String name, String email, String address, String chk) {
		super();
		this.userid = userid;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.chk = chk;
	}




	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getChk() {
		return chk;
	}
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	
	
	
	
	
	
	

}
