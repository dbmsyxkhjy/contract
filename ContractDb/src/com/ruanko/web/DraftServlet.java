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
		//�����ַ�������utf-8
		request.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		session=request.getSession();
		String  userId=(String)session.getAttribute("userId");
		String actionType = request.getParameter("action");
		System.out.println(actionType);
		if(userId==null)
		{
			//��ת����¼����
			response.sendRedirect("ToLoginUser");
		}
		//��ȡ������Ϣ
		String name=request.getParameter("name");
		String id=request.getParameter("contractId");
		String startTime=request.getParameter("beginTime");
		String endTime=request.getParameter("endTime");
		String content=request.getParameter("content");
		
		System.out.println(id);
		
		//ʵ����User��userService
		String message="";
		Contract contract = new Contract();
		ContractService contractService= new ContractService();
		//��֤
		//�����ʾ��Ϣ
		if(id==""||name==""||startTime==""||endTime==""||content=="")
		{
			System.out.println("������Ϣ����Ϊ��");
			message="������Ϣ����Ϊ��";

			//������ʾ��Ϣ
			session.setAttribute("message", message);
			request.setAttribute("message", message);
			//��ת�����ҳ��
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
			//��װע����Ϣ
			//����ҵ���߼�
			try {
				boolean flag;
				flag = contractService.addDraft(contract,userId);
				if(flag)
				{
					message="��ݺ�ͬ�ɹ�";
				}
				else {
					message="��ݺ�ͬʧ��";
				}
				//������ʾ��Ϣ
				session.setAttribute("message", message);
				request.setAttribute("message", message);
				//��ת�����ҳ��
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
					message="����ݸ�ɹ�";
				}
				else {
					message="����ݸ�ʧ��";
				}
				//������ʾ��Ϣ
				session.setAttribute("message", message);
				request.setAttribute("message", message);
				//��ת�����ҳ��
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


