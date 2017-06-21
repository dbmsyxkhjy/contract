package com.ruanko.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToLoginAdminServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		doGet(request,response);
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");//����������ݵ�����
		response.setCharacterEncoding("UTF-8");//����������ݵı���
		PrintWriter out=response.getWriter();
		//���ͷ������
		out.println("<!DOCTYPE HTML PUBLIC\"-//w3c//DTD HTML 4.01 Transitional//EN\">");
		//�����׼��HTML�ṹ
		out.println("<html>");
		out.println("<head>");
		//����ҳ���ַ�������
		out.println("<meta http-equiv='Content=Type' content='text/html' charset='utf-8'/> ");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		//form��
		out.println("<form action=\"loginAdmin\" method=\"post\">");
		out.println("��&nbsp��&nbsp��&nbsp�ţ�<input type=\"text\" name=\"id\" value=\"\" ><br/>\r\n");
		out.println("��&nbsp��&nbsp&nbsp&nbsp&nbsp��<input type=\"text\" name=\"password\" value=\"\"><br/> \r\n");

		
		

		if(request.getAttribute("message")!=null)
		{
			out.println(request.getAttribute("message"));
		}
		out.println("<input type=\"submit\" value=\"�ύ\"><br/>\r\n");
		out.println("</form><br/>\r\n");
		
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
		}
}
