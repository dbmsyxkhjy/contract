package com.ruanko.model;

public class Contract {
	private String cid;
	private String ctitle;
	private String cstarttime;
	private String cendtime;
	private String content;
	private int state;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public String getCstarttime() {
		return cstarttime;
	}
	public void setCstarttime(String cstarttime) {
		this.cstarttime = cstarttime;
	}
	public String getCendtime() {
		return cendtime;
	}
	public void setCendtime(String cendtime) {
		this.cendtime = cendtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

	

}
