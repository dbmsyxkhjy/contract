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
		//设置字符集编码utf-8
		request.setCharacterEncoding("UTF-8");
		//获取合同编号
		String cid=request.getParameter("cid");
	 	String message=request.getParameter("content");
	 	String aid = request.getParameter("aid");
	    System.out.println(cid);
	    System.out.println(message);
	    System.out.println(aid);
	  // String cid = "11";
	  // String message = "ttg";
		//验证
		//输出提示信息
		if(cid.equals("") || cid == null)
		{
			message="系统出现错误";
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				
			}
		}
		
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
	}
}
