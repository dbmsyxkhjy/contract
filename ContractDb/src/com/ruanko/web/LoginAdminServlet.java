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
		//�����ַ�������utf-8
		request.setCharacterEncoding("UTF-8");
		//��ȡע����Ϣ
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		//System.out.println(id);
		//ʵ����User��userService
		String message="";
		//��֤
		//�����ʾ��Ϣ
		if(id==""||password=="")
		{
			System.out.println("ע����Ϣ����Ϊ��");
			message="�û���ź����붼����Ϊ��";
			request.setAttribute("message", message);
			request.getRequestDispatcher("ToLoginAdmin").forward(request,response);
		}
	
		else 
		{
			//��װע����Ϣ

			//����ҵ���߼�
		int userId=-1;
			try {
				
				AdminService adminService = new AdminService();
				
				
				userId=adminService.login(id, password);
								
				if(userId>0)
				{
					message="��¼�ɹ�";
					request.setAttribute("message", message);
					HttpSession session = null;
					session=request.getSession();
					session.setAttribute("userId",userId);
					//�˴���Ҫ�޸�
					request.getRequestDispatcher("ToLoginUser").forward(request,response );
					
				}
			
				else {
					message="�û������������";
					request.setAttribute("message", message);
					request.setAttribute("userId",userId);
					request.getRequestDispatcher("ToLoginUser").forward(request,response );
				}
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//������ʾ��Ϣ
		}
		
		
	
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
	}
}


