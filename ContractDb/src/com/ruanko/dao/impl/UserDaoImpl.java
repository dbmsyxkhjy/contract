package com.ruanko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruanko.dao.UserDao;
import com.ruanko.model.User;
import com.ruanko.utils.AppException;
import com.ruanko.utils.DBUtil;

public class UserDaoImpl implements UserDao {

	public boolean addUser(User user) throws AppException {
		
	    //声明操作标志 flag
		boolean flag=false;
		//定义数据库操作对象
		Connection conn=null;
		PreparedStatement psmt=null;
		
		
	
		try {
			//创建数据库链接
			conn=DBUtil.getConnection();
			
			String sql="insert into user(uid,uname,upassword,ucorporation,utel,uaddress)"
					+ "values(?,?,?,?,?,?)";
			
			//预处理SQL语句
			psmt=conn.prepareStatement(sql);
			
			//设置参数
			
			psmt.setString(1, user.getUid());
			psmt.setString(2,user.getUname());
			psmt.setString(3,user.getUpassword());
			psmt.setString(4,user.getUcorporation());
			psmt.setString(5,user.getUtel());
			psmt.setString(6,user.getUaddress());
			
			//操作新增操作
			int result=-1;
			result=psmt.executeUpdate();
			//处理结果
			if(result>0)
			{
				flag=true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//关闭链接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}

		
		
		//返回结果
		return flag;
	}

	public boolean isExistUser(String Id)throws AppException
	{
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		boolean flag=false;
		try
		 {
			 conn=DBUtil.getConnection();
			 String sql="select uname from User where uid=?";
			 psmt=conn.prepareStatement(sql);
			 psmt.setString(1, Id);
			 
			 rs=psmt.executeQuery();
			 if(rs.next())
			 {
				 flag=true;
			 }
		 }
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new AppException("com.ruanko.dao.model.impl.UserDaoImpl.isExist");
		}finally
		{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		 return flag;
		 } 
	
	
	
	public int login(String id,String password)throws AppException
	{
		int userId=-1;
		
		Connection conn = null;
		PreparedStatement psmt= null;
		ResultSet rs=null;
		try
		{
			conn = DBUtil.getConnection();
			String sql="select uname from User where uid=? and upassword=?  ";
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, password);
			
			rs=psmt.executeQuery();
			System.out.println(id);
			System.out.println(password);
			
			
			
			
			if(rs.next())
			{
				userId=Integer.parseInt(id);
				System.out.println(userId);
			}
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.Login");
		}finally
		{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		
		return userId;
	}

	public ResultSet showDetail() {
		
		Connection conn = null;
		PreparedStatement psmt= null;
		ResultSet rs=null;
	
			
			
			try {
				conn = DBUtil.getConnection();
				String sql="select uid,uname,ucorporation,utel,uaddress from user";
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			return rs;
	}
	
	
	
}
