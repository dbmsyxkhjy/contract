package com.ruanko.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ToDhqhtListServlet extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		doGet(request,response);
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");//设置输出内容的类型
	response.setCharacterEncoding("UTF-8");//设置输出内容的编码
	PrintWriter out=response.getWriter();
	//输出头部声明
	//显示本账号用户的待签订合同
	//调用函数 首先查出state为0的cid再通过ca表查出cid下是否有此aid ，有的话 返回cid结果集,用来显示
	//点击某一合同查看具体内容，根据aid显示合同信息，返回合同内容
}

}

