package com.ruanko.web;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruanko.service.AdminService;
import com.ruanko.service.ContractService;
import com.ruanko.service.UserService;
import com.ruanko.utils.AppException;

public class showUserDetailServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//ÉèÖÃ×Ö·û¼¯±àÂëutf-8
		request.setCharacterEncoding("UTF-8");
		UserService userService=new UserService();
		ResultSet rs=null;
		rs=userService.showDetail();
		
		
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
	}
}
