package com.ruanko.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ToDraftServlet extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		doGet(request,response);
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");//设置输出内容的类型
	response.setCharacterEncoding("UTF-8");//设置输出内容的编码
	PrintWriter out=response.getWriter();
	//输出头部声明
	/*out.println("<!DOCTYPE HTML PUBLIC\"-//w3c//DTD HTML 4.01 Transitional//EN\">");
	//输出标准的HTML结构
	out.println("<html>");
	out.println("<head>");
	//设置页面字符集编码
	out.println("<meta http-equiv='Content=Type' content='text/html' charset='utf-8'/> ");
	out.println("<title>Regiser</title>");
	out.println("</head>");
	out.println("<body>");
	//form表单
	out.println("<form action=\"draft\" method=\"post\">");
	out.println("合&nbsp同&nbsp标&nbsp题：<input type=\"text\" name=\"name\" value=\"\"><br/> \r\n");
	out.println("合&nbsp同&nbsp编&nbsp号：<input type=\"text\" name=\"id\" value=\"\" ><br/>\r\n");
	out.println("起始时间：<input type=\"text\" name=\"Starttime\" value=\"\"><br/>\r\n");
	out.println("起始时间：<input type=\"text\" name=\"Endtime\" value=\"\"><br/>\r\n");
	out.println("合&nbsp同&nbsp&nbsp内&nbsp&nbsp容：<input type=\"text\" name=\"content\" value=\"\"><br/>\r\n");
	
	
	
	

	if(request.getAttribute("message")!=null)
	{
		out.println(request.getAttribute("message"));
	}
	
	out.println("<input type=\"submit\" value=\"提交\"><br/>\r\n");
	out.println("</form><br/>\r\n");
	
	
	out.println("</body>");
	out.println("</html>");
	out.flush();
	out.close();
	*/
	
	
	}

}

