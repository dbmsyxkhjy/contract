package com.ruanko.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToRegisterUserServlet extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		doGet(request,response);
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");//����������ݵ�����
	response.setCharacterEncoding("UTF-8");//����������ݵı���
	PrintWriter out=response.getWriter();
	request.getRequestDispatcher("/register.jsp").forward(request, response);
	System.out.println(request.getAttribute("message"));

}
}