package com.ruanko.dao;

import java.sql.ResultSet;

import com.ruanko.model.User;
import com.ruanko.utils.AppException;

public interface UserDao {
	
	public boolean isExistUser(String Id) throws AppException;
	//保存用户信息
	public boolean addUser(User user) throws AppException;

	public int login(String id,String password) throws AppException;
	
	public ResultSet showDetail();

}
