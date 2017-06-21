package com.ruanko.model;

import java.util.Date;

/**
 * Log entity class
 */
public class Log {
	
	private int id;			    //ID
	private int userId;			//Operator id
	private String content;		//Log content
	private Date time;			//Operation time
	private int del;			//Delete status(0-Not deleted, 1-Deleted)
	
	/**
	 * No-arg constructor assigns initial values to object attributes
	 */
	public Log(){
		this.id = 0;
		this.userId = 0;
		this.content = "";
		this.time = new Date();
		this.del = 0;
	}

	/*
	 * Provide setter and getter methods for attributes
	 * setter is used for setting the attribute's value, getter is used for getting the attribute's value
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
