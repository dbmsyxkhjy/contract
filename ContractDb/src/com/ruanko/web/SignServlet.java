package com.ruanko.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruanko.service.ContractService;
import com.ruanko.utils.AppException;

public class SignServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//�����ַ�������utf-8
		request.setCharacterEncoding("UTF-8");
		//��ȡ��ͬ���
		String cid=request.getParameter("cid");
	 	String message=request.getParameter("content");
	 	String aid = request.getParameter("aid");
	    System.out.println(cid);
	    System.out.println(message);
	    System.out.println(aid);
	  // String cid = "11";
	  // String message = "ttg";
		//��֤
		//�����ʾ��Ϣ
		if(cid.equals("") || cid == null)
		{
			message="ϵͳ���ִ���";
			System.out.println(message);
			request.setAttribute("message", message);
			//request.getRequestDispatcher("toLogin").forward(request,response);
			response.setContentType("text/html;charset = utf-8");
			response.sendRedirect("dqdhtList3.jsp");
			
		}
		else 
		{
			ContractService cs = new ContractService();
			try {
				if(cs.signContract(cid,aid, message))
				{
					response.setContentType("text/html;charset = utf-8");
					response.sendRedirect("dqdhtList3.jsp");
				}
			} catch (AppException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				
			}
		}
		
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
	}
}
