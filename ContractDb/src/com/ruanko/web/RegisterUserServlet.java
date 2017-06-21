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
		// �����ַ�������utf-8
		request.setCharacterEncoding("UTF-8");
		// ��ȡע����Ϣ
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
		// ʵ����User��userService
		if (true)
		{
			String message = "";
			User user = new User();
			UserService userService = new UserService();
			// ��֤
			// �����ʾ��Ϣ

			if (!password2.equals(password)) {

				System.out.println("�ظ�����Ҫ�����뱣��һ�£�");
				message = "�ظ�����Ҫ�����뱣��һ�£�";

				// ������ʾ��Ϣ
				request.setAttribute("message", message);
				// ��ת�����ҳ��
				request.getRequestDispatcher("toRegisterUser").forward(request,
						response);
			} else {
				// ��װע����Ϣ

				// ����ҵ���߼�

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
						message = "ע��ɹ�";
						request.setAttribute("message", message);
						request.getRequestDispatcher("ToLoginUser").forward(
								request, response);
					} else {
						message = "ע��ʧ��";
						request.setAttribute("message", message);
						request.getRequestDispatcher("toRegisterUser").forward(
								request, response);
					}
				} catch (AppException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// ������ʾ��Ϣ

				// ��ת�����ҳ��

			}

		}
		
		
		else
		{
			
			//ʵ����User��userService
			String message="";
			Admin admin=new Admin();
			AdminService adminService=new AdminService();
			//��֤
			//�����ʾ��Ϣ
	
			 if(!password2.equals(password))
			{
				
				System.out.println("�ظ�����Ҫ�����뱣��һ�£�");
				message="�ظ�����Ҫ�����뱣��һ�£�";
				request.setAttribute("message", message);
				request.getRequestDispatcher("toRegisterUser").forward(request,response );
			}
			 
			else 
			{
				//��װע����Ϣ

				//����ҵ���߼�
			
				try {
					admin.setAid(id);
					admin.setAname(name);
					admin.setApassword(password);
					
					
					boolean flag;
					flag = adminService.register(admin);
					if(flag)
					{
						message="ע��ɹ�";
						request.setAttribute("message", message);
						request.getRequestDispatcher("ToLoginUser").forward(
								request, response);
						
					}
					else {
						message="ע��ʧ��";
						
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
