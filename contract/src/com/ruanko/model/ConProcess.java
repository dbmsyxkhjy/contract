package com.ruanko.model;

import java.util.Date;

/**
 * Contract operation process entity classes
 */
public class ConProcess {

	private int id;			    //ID
	private int conId;			// Contract id
	private int userId;			// User id
	private int type;			// Operation type(1-countersign ,2-approve,3-sign)
	private int state;			// Operation status(0-unfinished,1-completed,2-rejected)
	private String content;		// Operation content
	private Date time;			// Operation time 
	private int del;			// Delete status(0-Not deleted, 1-Deleted)
	
	/**
	 * No-arg constructor assigns initial values to object attributes
	 */
	public ConProcess(){
		this.id = 0;
		this.conId = 0;
		this.userId = 0;
		this.type = 0;
		this.state = 0;
		this.content = "";
		this.time = new Date();
		this.del = 0;
	}

	/*
	 *  Provide setter and getter methods for attributes
	 *  setter is used for setting the attribute's value, getter is used for getting the attribute's value
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConId() {
		return conId;
	}

	public void setConId(int conId) {
		this.conId = conId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
}
