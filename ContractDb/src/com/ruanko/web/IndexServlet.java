package com.ruanko.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		this.doGet(request, response);
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
	response.setContentType("text/html");//设置输出内容的类型
	response.setCharacterEncoding("UTF-8");//设置输出内容的编码
	PrintWriter out=response.getWriter();
	out.println("<!DOCTYPE HTML PUBLIC\"-//w3c//DTD HTML 4.01 Transitional//EN\">");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta http-equiv='Content=Type' content='text/html' charset='utf-8'/> ");
	out.println("<title>IndexServlet</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("欢迎进入合同管理系统");
	out.println("</body>");
	out.println("</html>");
	out.flush();
	out.close();
	}
}
