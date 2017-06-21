package com.ruanko.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruanko.model.Admin;
import com.ruanko.model.User;
import com.ruanko.service.AdminService;
import com.ruanko.service.UserService;
import com.ruanko.utils.AppException;

public class RegisterAdminServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//设置字符集编码utf-8
		request.setCharacterEncoding("UTF-8");
		//获取注册信息
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password1");
		String password2=request.getParameter("password2");
		System.out.println(id);
		
		//实例化User，userService
		String message="";
		Admin admin=new Admin();
		AdminService adminService=new AdminService();
		//验证
		//输出提示信息
		if(id==""||password==""||password2=="")
		{
		
			System.out.println("注册信息不能为空");
			message="注册信息不能为空";
		}
		
		else if(!password2.equals(password))
		{
			
			System.out.println("重复密码要和密码保持一致！");
			message="重复密码要和密码保持一致！";
		}
		else 
		{
			//封装注册信息

			//调用业务逻辑
		
			try {
				admin.setAid(id);
				admin.setAname(name);
				admin.setApassword(password);
				
				//user.setDel(1);
				boolean flag;
				flag = adminService.register(admin);
				if(flag)
				{
					message="注册成功";
				}
				else {
					message="注册失败";
				}
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//设置提示信息
			request.setAttribute("message", message);
			//跳转到诸恶页面
			request.getRequestDispatcher("toRegisterAdmin").forward(request,response );
		}
		
		
	
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
	}
}
