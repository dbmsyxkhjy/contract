package com.ruanko.service;

import java.sql.ResultSet;

import com.ruanko.dao.AdminDao;
import com.ruanko.dao.UserDao;
import com.ruanko.dao.impl.AdminDaoImpl;
import com.ruanko.dao.impl.UserDaoImpl;
import com.ruanko.model.Admin;
import com.ruanko.model.User;
import com.ruanko.utils.AppException;

public class AdminService {

private AdminDao adminDao=null;
	
	public AdminService()
	{
		adminDao=new AdminDaoImpl();
	}
	
	
	public boolean register(Admin admin) throws AppException
	{
		boolean flag=false;
		//处理注册业务逻辑

		//验证不存在同Id 
		if(!adminDao.isExistAdmin(admin.getAid()))
		{
				flag=adminDao.addAdmin(admin);
			
		}

		//返回flag
		return flag;
	}
	
	
	public int login(String id,String password) throws AppException
	{
		
		int userId=-1;
		try{
		userId=adminDao.login(id, password);
		
		
		}catch(AppException e)
		{
			e.printStackTrace();
			throw new AppException("com.ruanko.service.UserService.login");
		}
		return userId;
	}
	
	
	public int judgeAdmin(String aid)
	{
		int level=-1;
		
		try {
			level=adminDao.judgeAdmin(aid);
		} catch (AppException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return level;
	}
	
	public ResultSet showDetail()
	{
		ResultSet rs=null;
		rs=adminDao.showDetail();
		
		return rs;
		
	}

}
