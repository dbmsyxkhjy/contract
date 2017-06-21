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
		//�����ַ�������utf-8
		request.setCharacterEncoding("UTF-8");
		//��ȡע����Ϣ
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password1");
		String password2=request.getParameter("password2");
		System.out.println(id);
		
		//ʵ����User��userService
		String message="";
		Admin admin=new Admin();
		AdminService adminService=new AdminService();
		//��֤
		//�����ʾ��Ϣ
		if(id==""||password==""||password2=="")
		{
		
			System.out.println("ע����Ϣ����Ϊ��");
			message="ע����Ϣ����Ϊ��";
		}
		
		else if(!password2.equals(password))
		{
			
			System.out.println("�ظ�����Ҫ�����뱣��һ�£�");
			message="�ظ�����Ҫ�����뱣��һ�£�";
		}
		else 
		{
			//��װע����Ϣ

			//����ҵ���߼�
		
			try {
				admin.setAid(id);
				admin.setAname(name);
				admin.setApassword(password);
				
				//user.setDel(1);
				boolean flag;
				flag = adminService.register(admin);
				if(flag)
				{
					message="ע��ɹ�";
				}
				else {
					message="ע��ʧ��";
				}
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//������ʾ��Ϣ
			request.setAttribute("message", message);
			//��ת�����ҳ��
			request.getRequestDispatcher("toRegisterAdmin").forward(request,response );
		}
		
		
	
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
	}
}
