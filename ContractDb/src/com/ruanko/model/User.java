package com.ruanko.model;

public class User {

	private String uid;//用户编号
	private String uname;//用户名
	private String upassword;//密码
	private String ucorporation;//法人代表
	private String uaddress;//地址
	private String utel;//电话
//	private int del;//改用户是否被删除，1为存在，0为被删除
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUcorporation() {
		return ucorporation;
	}
	public void setUcorporation(String ucorporation) {
		this.ucorporation = ucorporation;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	/*public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}*/
	
	
	
	
	
	
}
