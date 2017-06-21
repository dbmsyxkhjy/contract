package com.ruanko.utils;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	
	//����:URL user password
	private static String url="jdbc:mysql://127.0.0.1:3306/CMS?useUnicode=true&amp;"+
	"characterEncoding=utf-8";
	private static String user="root";
	private static String password="550610";
	
	//��������
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//�������������ӣ��ر�����
	public static Connection getConnection()
	{
		//��������
		Connection conn=null;
		
		
		//��������
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn)
	{
		try {
			if(conn!=null && !conn.isClosed())
			{
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void closeStatement(Statement st)
	{
		try {
			if(st!=null && !st.isClosed())
			{
				st.close();
				st=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void closeResultSet(ResultSet rs)
	{
		
		try {
			if(rs!=null && !rs.isClosed())
			{
				rs.close();
				rs=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void main(String []args)
	{
		Connection conn=null;
		conn=getConnection();
		if(conn!=null)
		{
			System.out.println("connect success!");
		}
		
	}
}
