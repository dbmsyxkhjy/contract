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

public class LoginUserServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集编码utf-8
		request.setCharacterEncoding("UTF-8");
		// 获取注册信息
		String id = request.getParameter("Company_ID");
		String password = request.getParameter("password");
		String role = request.getParameter("approve");

		String message = "";

		if (role.equals("refuse")) {
			int userId = -1;
			try {
				UserService userService = new UserService();

				userId = userService.login(id, password);
				System.out.println(88);

				if (userId > 0) {
					message = "登录成功";
					request.setAttribute("message", message);
					HttpSession session = null;
					session = request.getSession();
					session.setAttribute("userId", id);
					// 此处需要修改
				//	request.getRequestDispatcher("/frame2.jsp").forward(
						//	request, response);
					response.sendRedirect("frame2.jsp");
				}

				else {
					message = "用户名或密码错误";
				//	request.setAttribute("message", message);
				//	request.setAttribute("userId", userId);
					request.getRequestDispatcher("ToLoginUser").forward(
							request, response);
		
				}
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 分为用户和管理员登陆
		else {
			int userId = -1;
			int level=-1;
			try {

				AdminService adminService = new AdminService();

				userId = adminService.login(id, password);
				

				if (userId > 0) {
					
					level=adminService.judgeAdmin(id);
					
					if(level==2){
					message = "登录成功";
					request.setAttribute("message", message);
					HttpSession session = null;
					session = request.getSession();
					session.setAttribute("userId", id);
					// 此处需要修改
					//request.getRequestDispatcher("/frame3.jsp").forward(
					//		request, response);
					response.setContentType("text/html;charset = utf-8");
					response.sendRedirect("frame3.jsp");
					}
					
					else if(level==1)
					{
						message = "登录成功";
						request.setAttribute("message", message);
						HttpSession session = null;
						session = request.getSession();
						session.setAttribute("userId", id);
						// 此处需要修改
						//request.getRequestDispatcher("/frame3.jsp").forward(
						//		request, response);
						response.setContentType("text/html;charset = utf-8");
						response.sendRedirect("frame4.jsp");
					}
					
					else
					{
						message = "登录成功";
						request.setAttribute("message", message);
						HttpSession session = null;
						session = request.getSession();
						session.setAttribute("userId", id);
						// 此处需要修改
						//request.getRequestDispatcher("/frame3.jsp").forward(
						//		request, response);
						response.setContentType("text/html;charset = utf-8");
						response.sendRedirect("frame1.jsp");
					}
  
				}

				else {
					message = "用户名或密码错误";
				//	request.setAttribute("message", message);
				//	request.setAttribute("userId", userId);
					request.getRequestDispatcher("ToLoginUser").forward(
							request, response);
				}
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 设置提示信息
		}
	}

	// 设置提示信息

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
