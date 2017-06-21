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

public class RegisterUserServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集编码utf-8
		request.setCharacterEncoding("UTF-8");
		// 获取注册信息
		String id = request.getParameter("Company_ID");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String corporation = request.getParameter("corporation");
		String address = request.getParameter("address");
		String tel = request.getParameter("tell");
		//String role = request.getParameter("approve");
		System.out.println(id);
		
		//String role = "user";
		// 实例化User，userService
		if (true)
		{
			String message = "";
			User user = new User();
			UserService userService = new UserService();
			// 验证
			// 输出提示信息

			if (!password2.equals(password)) {

				System.out.println("重复密码要和密码保持一致！");
				message = "重复密码要和密码保持一致！";

				// 设置提示信息
				request.setAttribute("message", message);
				// 跳转到诸恶页面
				request.getRequestDispatcher("toRegisterUser").forward(request,
						response);
			} else {
				// 封装注册信息

				// 调用业务逻辑

				try {
					user.setUid(id);
					user.setUname(name);
					;
					user.setUaddress(address);
					user.setUcorporation(corporation);
					user.setUpassword(password);
					user.setUtel(tel);
					// user.setDel(1);
					boolean flag;
					flag = userService.register(user);
					if (flag) {
						message = "注册成功";
						request.setAttribute("message", message);
						request.getRequestDispatcher("ToLoginUser").forward(
								request, response);
					} else {
						message = "注册失败";
						request.setAttribute("message", message);
						request.getRequestDispatcher("toRegisterUser").forward(
								request, response);
					}
				} catch (AppException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 设置提示信息

				// 跳转到诸恶页面

			}

		}
		
		
		else
		{
			
			//实例化User，userService
			String message="";
			Admin admin=new Admin();
			AdminService adminService=new AdminService();
			//验证
			//输出提示信息
	
			 if(!password2.equals(password))
			{
				
				System.out.println("重复密码要和密码保持一致！");
				message="重复密码要和密码保持一致！";
				request.setAttribute("message", message);
				request.getRequestDispatcher("toRegisterUser").forward(request,response );
			}
			 
			else 
			{
				//封装注册信息

				//调用业务逻辑
			
				try {
					admin.setAid(id);
					admin.setAname(name);
					admin.setApassword(password);
					
					
					boolean flag;
					flag = adminService.register(admin);
					if(flag)
					{
						message="注册成功";
						request.setAttribute("message", message);
						request.getRequestDispatcher("ToLoginUser").forward(
								request, response);
						
					}
					else {
						message="注册失败";
						
						request.setAttribute("message", message);
						request.getRequestDispatcher("toRegisterUser").forward(
								request, response);
					}
				} catch (AppException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			}
			
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
