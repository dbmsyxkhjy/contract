package com.ruanko.service;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruanko.dao.UserDao;
import com.ruanko.dao.impl.UserDaoImpl;
import com.ruanko.model.User;
import com.ruanko.utils.AppException;

public class UserService {
	
	private UserDao userDao=null;
	
	public UserService()
	{
		userDao=new UserDaoImpl();
	}
	
	
	public boolean register(User user) throws AppException
	{
		boolean flag=false;
		//处理注册业务逻辑

		//验证不存在同Id 
		if(!userDao.isExistUser(user.getUid()))
		{
				flag=userDao.addUser(user);
			
		}

		//返回flag
		return flag;
	}
	
	
	public int login(String id,String password) throws AppException
	{
		
		int userId=-1;
		try{
		userId=userDao.login(id, password);
	
		
		}catch(AppException e)
		{
			e.printStackTrace();
			throw new AppException("com.ruanko.service.UserService.login");
		}
		return userId;
	}
	
	public ResultSet showDetail()
	{
		ResultSet rs=null;
		rs=userDao.showDetail();
		try {
			System.out.println(rs.getString(1));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return rs;
		
	}

}
