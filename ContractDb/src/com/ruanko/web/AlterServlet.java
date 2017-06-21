package com.ruanko.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruanko.service.ContractService;
import com.ruanko.utils.AppException;

public class AlterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		
		String cid = request.getParameter("cid");
	    String message = request.getParameter("contend");
	    String aid = request.getParameter("aid");
		
		if(cid.equals("") || cid == null)
		{
			message="系统出现错误";
			request.setAttribute("message", message);
			//request.getRequestDispatcher("toLogin").forward(request,response);
			response.setContentType("text/html;charset = utf-8");
			response.sendRedirect("dqdhtList3.jsp");
			
		}
		else 
		{
			ContractService cs = new ContractService();
			try {
				if(cs.alterContract(cid,aid, message))
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
