package com.ruanko.dao;

import java.sql.ResultSet;

import com.ruanko.model.Admin;
import com.ruanko.model.User;
import com.ruanko.utils.AppException;

public interface AdminDao {

	public boolean isExistAdmin(String Id) throws AppException;
	//�����û���Ϣ
	public boolean addAdmin(Admin admin) throws AppException;

	public int login(String id,String password) throws AppException;
	
	public int judgeAdmin(String aid) throws AppException;
	
	public ResultSet showDetail();
}
