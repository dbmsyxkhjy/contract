package com.ruanko.model;

/**
 * User entity class
 */
public class User {

	private int id;			    //ID
	private String name;		//User name
	private String password;	//Password
	private int del;			//Delete status(0-Not deleted, 1-Deleted)
	
	/**
	 * No-arg constructor assigns initial values to object attributes
	 */
	public User(){
		this.id = 0;
		this.name = "";
		this.password = "";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

}
