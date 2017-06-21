package com.ruanko.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruanko.model.User;
import com.ruanko.service.AdminService;
import com.ruanko.service.UserService;
import com.ruanko.utils.AppException;

public class LoginAdminServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//设置字符集编码utf-8
		request.setCharacterEncoding("UTF-8");
		//获取注册信息
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		//System.out.println(id);
		//实例化User，userService
		String message="";
		//验证
		//输出提示信息
		if(id==""||password=="")
		{
			System.out.println("注册信息不能为空");
			message="用户编号和密码都不能为空";
			request.setAttribute("message", message);
			request.getRequestDispatcher("ToLoginAdmin").forward(request,response);
		}
	
		else 
		{
			//封装注册信息

			//调用业务逻辑
		int userId=-1;
			try {
				
				AdminService adminService = new AdminService();
				
				
				userId=adminService.login(id, password);
								
				if(userId>0)
				{
					message="登录成功";
					request.setAttribute("message", message);
					HttpSession session = null;
					session=request.getSession();
					session.setAttribute("userId",userId);
					//此处需要修改
					request.getRequestDispatcher("ToLoginUser").forward(request,response );
					
				}
			
				else {
					message="用户名或密码错误";
					request.setAttribute("message", message);
					request.setAttribute("userId",userId);
					request.getRequestDispatcher("ToLoginUser").forward(request,response );
				}
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//设置提示信息
		}
		
		
	
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
	}
}


