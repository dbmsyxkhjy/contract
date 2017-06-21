package com.ruanko.web;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruanko.dao.impl.ContractDaoImpl;


public class DeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		request.setCharacterEncoding("utf-8");
		
		String cid = request.getParameter("cid");
	    String message = request.getParameter("cid");

		if(cid.equals("") || cid == null)
		{
			message="系统出现错误";
			request.setAttribute("message", message);
			response.setContentType("text/html;charset = utf-8");
			response.sendRedirect("draftBoxList.jsp");
			
		}
		else 
		{
			ContractDaoImpl cs = new ContractDaoImpl();
			if(cs.deleteBox(cid))
			{
				response.setContentType("text/html;charset = utf-8");
				response.sendRedirect("draftBoxList.jsp");
			}
		}
	}

}
