package com.ruanko.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ToDhqhtListServlet extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		doGet(request,response);
	}
	
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.setContentType("text/html");//����������ݵ�����
	response.setCharacterEncoding("UTF-8");//����������ݵı���
	PrintWriter out=response.getWriter();
	//���ͷ������
	//��ʾ���˺��û��Ĵ�ǩ����ͬ
	//���ú��� ���Ȳ��stateΪ0��cid��ͨ��ca����cid���Ƿ��д�aid ���еĻ� ����cid�����,������ʾ
	//���ĳһ��ͬ�鿴�������ݣ�����aid��ʾ��ͬ��Ϣ�����غ�ͬ����
}

}

