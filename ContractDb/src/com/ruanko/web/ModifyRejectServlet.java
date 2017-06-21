package com.ruanko.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruanko.model.Admin;
import com.ruanko.model.User;
import com.ruanko.service.AdminService;
import com.ruanko.service.ContractService;
import com.ruanko.service.UserService;
import com.ruanko.utils.AppException;

public class ModifyRejectServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置字符集编码utf-8
		request.setCharacterEncoding("UTF-8");
		// 获取注册信息
		
		String cid = request.getParameter("cid");	
		String content = request.getParameter("content");	
		ContractService contractService = new ContractService();
		
		 if(contractService.ModifyReject(content, cid)){
			 
			 response.sendRedirect("/frame2.jsp");
			 
		 }
		 


	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
