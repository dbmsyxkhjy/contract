package com.ruanko.model;

import java.util.Date;

/**
 * Contract operation status entity classes
 */
public class ConState {
	
	private int id;			    //ID 
	private int conId;			// Contract id
	private int type;			// Operation type(1-draft,2-countersigned,3-finalized,4-approved,5-signed)
	private Date time;			// Operation time 
	private int del;			// Delete status(0-Not deleted, 1-Deleted)
	
	/**
	 * No-arg constructor assigns initial values to object attributes
	 */
	public ConState(){
		this.id = 0;
		this.conId = 0;
		this.type = 0;
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

	public int getConId() {
		return conId;
	}

	public void setConId(int conId) {
		this.conId = conId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
