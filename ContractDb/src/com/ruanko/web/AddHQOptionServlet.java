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
		//�����ַ�������utf-8
		request.setCharacterEncoding("UTF-8");
		//���ú��� ���Ȳ��stateΪ0��cid��ͨ��ca����cid���Ƿ��д�aid ���еĻ� ����cid�����,������ʾ
		
		
		HttpSession session=null;
		session=request.getSession();
		String Aid=(String) session.getAttribute("userId");
		
		boolean flag=false;
		if(Aid==null)
		{
			//��ת����¼����
			System.out.println(request.getAttribute("message"));
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			response.sendRedirect("login.jsp");
		}
		
		ContractService contractService=new ContractService();
		Contract  contract[];
		//��ȡstateΪ0�ĺ�ͬ�ĸ���
		//int count=0;
		//count=contractService.NumCounterS();
		//contract = new Contract[count];
		//��stateΪ0�ĺ�ͬ��Ϣ����Contract��������
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
