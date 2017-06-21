package com.ruanko.model;

/**
 * Function entity classes
 */
public class Function {
	
	private int id;			    //ID
	private String num;			//Function number
	private String name;		//Function name
	private String url;			//Access path
	private String description;	//Description
	private int del;			//Delete status(0-Not deleted, 1-Deleted)
	
	/**
	 * No-arg constructor assigns initial values to object attributes
	 */
	public Function(){
		this.id = 0;
		this.num = "";
		this.name = "";
		this.url = "";
		this.description = "";
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
}
