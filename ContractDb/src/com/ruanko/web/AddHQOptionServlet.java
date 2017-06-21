package com.ruanko.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruanko.model.Contract;
import com.ruanko.service.AdminService;
import com.ruanko.service.ContractService;
import com.ruanko.utils.AppException;

public class AddHQOptionServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//设置字符集编码utf-8
		request.setCharacterEncoding("UTF-8");
		//调用函数 首先查出state为0的cid再通过ca表查出cid下是否有此aid ，有的话 返回cid结果集,用来显示
		
		
		HttpSession session=null;
		session=request.getSession();
		String Aid=(String) session.getAttribute("userId");
		
		boolean flag=false;
		if(Aid==null)
		{
			//跳转到登录界面
			System.out.println(request.getAttribute("message"));
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			response.sendRedirect("login.jsp");
		}
		
		ContractService contractService=new ContractService();
		Contract  contract[];
		//获取state为0的合同的个数
		//int count=0;
		//count=contractService.NumCounterS();
		//contract = new Contract[count];
		//将state为0的合同信息存在Contract的数组中
		//contract=contractService.ToHQList();
		int sugges=-1;
		String cid = request.getParameter("cid");
		System.out.println("aaa");
		System.out.println(cid);
		System.out.println("dddd");
		
		String suggestion = request.getParameter("approve");
		if(suggestion.equals("1"))
		{
			sugges=1;
		}
		else
		{
			sugges=0;
		}
		String detail = request.getParameter("content");		
		
		
		flag=contractService.ConterSign(cid, Aid, sugges, detail);
		
		if(flag)
		{   
			response.sendRedirect("dshphtList.jsp");
			//request.getRequestDispatcher("/dshphtList.jsp").forward(request,response);
		}else
		{
			//request.getRequestDispatcher("/dshphtList.jsp").forward(request,response);
			response.sendRedirect("dshphtList.jsp");
		}
		
		
	
	//	request.getRequestDispatcher("ToLoginAdmin").forward(request,response);
		
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
	}

}
