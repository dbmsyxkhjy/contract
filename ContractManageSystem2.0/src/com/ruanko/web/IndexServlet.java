package com.ruanko.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IndexServlet extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		this.doGet(request, response);
	}
	
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		response.setContentType("text/html");//设置输出内容的类型
		response.setCharacterEncoding("UTF-8");//设置输出内容的编码
		PrintWriter out=response.getWriter();//获取输出对象
		//输出头部声明
		out.println("<!DOCTYPE HTML PUBLIC'-//W3C//DTD HTML 4.01 Transitional//EN'>");
		//输出标准的HTML结构
		out.println("<html>");
		out.println("<head>");
		//设置页面字符集编码
		out.println("<meta http-equiv='Cnotent-Type' content='text/html';charset='tuf-8'/>");
		out.println("<title>IndexxServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("欢迎进入合同管理系统");//页面主体中信息
		out.println("</body>");
		out.println("</html>");
		//清空并关闭输出流
		out.flush();
		out.close();
	}
}
