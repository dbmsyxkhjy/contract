package com.ruanko.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ruanko.model.Contract;
import com.ruanko.model.User;
import com.ruanko.service.ContractService;
import com.ruanko.service.UserService;
import com.ruanko.utils.AppException;

public class DraftServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		//设置字符集编码utf-8
		request.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		session=request.getSession();
		String  userId=(String)session.getAttribute("userId");
		String actionType = request.getParameter("action");
		System.out.println(actionType);
		if(userId==null)
		{
			//跳转到登录界面
			response.sendRedirect("ToLoginUser");
		}
		//获取输入信息
		String name=request.getParameter("name");
		String id=request.getParameter("contractId");
		String startTime=request.getParameter("beginTime");
		String endTime=request.getParameter("endTime");
		String content=request.getParameter("content");
		
		System.out.println(id);
		
		//实例化User，userService
		String message="";
		Contract contract = new Contract();
		ContractService contractService= new ContractService();
		//验证
		//输出提示信息
		if(id==""||name==""||startTime==""||endTime==""||content=="")
		{
			System.out.println("所有信息不能为空");
			message="所有信息不能为空";

			//设置提示信息
			session.setAttribute("message", message);
			request.setAttribute("message", message);
			//跳转到诸恶页面
			request.getRequestDispatcher("/addContract.jsp").forward(request,response );
		}
		
		contract.setCid(id);
		contract.setCtitle(name);
		contract.setCstarttime(startTime);
		contract.setCendtime(endTime);
		contract.setContent(content);
		contract.setState(1);
		if(actionType.equals("Submit")) 
		{
			//封装注册信息
			//调用业务逻辑
			try {
				boolean flag;
				flag = contractService.addDraft(contract,userId);
				if(flag)
				{
					message="起草合同成功";
				}
				else {
					message="起草合同失败";
				}
				//设置提示信息
				session.setAttribute("message", message);
				request.setAttribute("message", message);
				//跳转到诸恶页面
				request.getRequestDispatcher("/addContract.jsp").forward(request,response );
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			
			try {
				boolean flag;
				flag = contractService.addDraftBox(contract,userId);
				if(flag)
				{
					message="保存草稿成功";
				}
				else {
					message="保存草稿失败";
				}
				//设置提示信息
				session.setAttribute("message", message);
				request.setAttribute("message", message);
				//跳转到诸恶页面
				request.getRequestDispatcher("/addContract.jsp").forward(request,response );
			} catch (AppException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
		
		
		
		
		
		
		
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
	}

}


