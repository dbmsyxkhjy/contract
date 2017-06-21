package com.ruanko.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruanko.service.ContractService;
import com.ruanko.utils.AppException;

public class DeniedServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		this.doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		
		String cid = request.getParameter("cid");
	    String message = request.getParameter("content");
	    String aid = request.getParameter("aid");
		
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
				if(cs.deniedContract(cid,aid, message))
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

}
