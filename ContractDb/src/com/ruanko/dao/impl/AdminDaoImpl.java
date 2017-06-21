package com.ruanko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruanko.dao.AdminDao;
import com.ruanko.dao.UserDao;
import com.ruanko.model.Admin;
import com.ruanko.model.User;
import com.ruanko.utils.AppException;
import com.ruanko.utils.DBUtil;

public class AdminDaoImpl implements AdminDao {

	public boolean isExistAdmin(String Id) throws AppException {
	
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		boolean flag=false;
		try
		 {
			 conn=DBUtil.getConnection();
			 String sql="select aname from admin where aid=?";
			 psmt=conn.prepareStatement(sql);
			 psmt.setString(1, Id);
			
			 rs=psmt.executeQuery();
			 if(rs.next())
			 {
				 flag=true;
			 
			 }
			 
			 System.out.println(Id);
		 }
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new AppException("com.ruanko.dao.model.impl.AdminDaoImpl.isExistAdmin");
		}finally
		{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		 return flag;
	}

	public boolean addAdmin(Admin admin) throws AppException {
		
		//����������־ flag
		boolean flag=false;
		//�������ݿ��������
		Connection conn=null;
		PreparedStatement psmt=null;
		
		
	
		try {
			//�������ݿ�����
			conn=DBUtil.getConnection();
			
			String sql="insert into admin(aid,aname,apassword,level)"
					+ "values(?,?,?,-1)";
			
			//Ԥ����SQL���
			psmt=conn.prepareStatement(sql);
			
			//���ò���
			
			psmt.setString(1, admin.getAid());
			psmt.setString(2,admin.getAname());
			psmt.setString(3,admin.getApassword());
			
			
			//������������
			int result=-1;
			result=psmt.executeUpdate();
			//������
			if(result>0)
			{
				flag=true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//�ر����ӣ��ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}

		
		
		//���ؽ��
		return flag;
	}

	public int login(String id, String password) throws AppException {
		
int userId=-1;
		
		Connection conn = null;
		PreparedStatement psmt= null;
		ResultSet rs=null;
		try
		{
			conn = DBUtil.getConnection();
			String sql="select aname from Admin where aid=? and apassword=?  ";
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, password);
			
			rs=psmt.executeQuery();
			System.out.println(66);
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

	public int judgeAdmin(String aid)
	{
		int i=-1;
		Connection conn = null;
		PreparedStatement psmt= null;
		ResultSet rs=null;
		
		conn = DBUtil.getConnection();
		String sql="select level from Admin where aid=? ";
		
		
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, aid);
			rs=psmt.executeQuery();
			
			if(rs.next())
			{
				i=rs.getInt("level");
			}
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
		
		
		
		return i;
	}

	public ResultSet showDetail() {
	
		Connection conn = null;
		PreparedStatement psmt= null;
		ResultSet rs=null;
	
			
			
			try {
				conn = DBUtil.getConnection();
				String sql="select * from admin";
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			return rs;
	}


}
