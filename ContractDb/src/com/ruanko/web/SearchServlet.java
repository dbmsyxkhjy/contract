package com.ruanko.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruanko.model.Contract;
import com.ruanko.service.AdminService;
import com.ruanko.service.ContractService;
import com.ruanko.utils.AppException;

public class SearchServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//�����ַ�������utf-8
		request.setCharacterEncoding("UTF-8");
		//���ú��� ���Ȳ��stateΪ0��cid��ͨ��ca����cid���Ƿ��д�aid ���еĻ� ����cid�����,������ʾ
		ResultSet rs=null;
		String search=request.getParameter("searchInfo");
		ContractService contractService=new ContractService();
	    rs=contractService.search(search);
		
	    request.setAttribute("res", rs);
		response.sendRedirect("left1.jsp");
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
	}

}
