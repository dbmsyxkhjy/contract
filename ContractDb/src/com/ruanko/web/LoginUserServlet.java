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
		// �����ַ�������utf-8
		request.setCharacterEncoding("UTF-8");
		// ��ȡע����Ϣ
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
					message = "��¼�ɹ�";
					request.setAttribute("message", message);
					HttpSession session = null;
					session = request.getSession();
					session.setAttribute("userId", id);
					// �˴���Ҫ�޸�
				//	request.getRequestDispatcher("/frame2.jsp").forward(
						//	request, response);
					response.sendRedirect("frame2.jsp");
				}

				else {
					message = "�û������������";
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
		// ��Ϊ�û��͹���Ա��½
		else {
			int userId = -1;
			int level=-1;
			try {

				AdminService adminService = new AdminService();

				userId = adminService.login(id, password);
				

				if (userId > 0) {
					
					level=adminService.judgeAdmin(id);
					
					if(level==2){
					message = "��¼�ɹ�";
					request.setAttribute("message", message);
					HttpSession session = null;
					session = request.getSession();
					session.setAttribute("userId", id);
					// �˴���Ҫ�޸�
					//request.getRequestDispatcher("/frame3.jsp").forward(
					//		request, response);
					response.setContentType("text/html;charset = utf-8");
					response.sendRedirect("frame3.jsp");
					}
					
					else if(level==1)
					{
						message = "��¼�ɹ�";
						request.setAttribute("message", message);
						HttpSession session = null;
						session = request.getSession();
						session.setAttribute("userId", id);
						// �˴���Ҫ�޸�
						//request.getRequestDispatcher("/frame3.jsp").forward(
						//		request, response);
						response.setContentType("text/html;charset = utf-8");
						response.sendRedirect("frame4.jsp");
					}
					
					else
					{
						message = "��¼�ɹ�";
						request.setAttribute("message", message);
						HttpSession session = null;
						session = request.getSession();
						session.setAttribute("userId", id);
						// �˴���Ҫ�޸�
						//request.getRequestDispatcher("/frame3.jsp").forward(
						//		request, response);
						response.setContentType("text/html;charset = utf-8");
						response.sendRedirect("frame1.jsp");
					}
  
				}

				else {
					message = "�û������������";
				//	request.setAttribute("message", message);
				//	request.setAttribute("userId", userId);
					request.getRequestDispatcher("ToLoginUser").forward(
							request, response);
				}
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// ������ʾ��Ϣ
		}
	}

	// ������ʾ��Ϣ

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
