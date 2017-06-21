package com.ruanko.utils;

public class AppException extends Exception{

	//˽������
	private int exceptionCode;//�쳣���
	private String message;//�쳣��Ϣ
	
	//���췽��

	public AppException(String message)
	{
		this.message=message;
	
	}
	
	public AppException(String message,int exceptionCode)
	{
		this.message=message;
		this.exceptionCode=exceptionCode;
	}
	
	//����
	
	public int getExceptionCode()
	{
		return exceptionCode;
	}
	
	public String getExceptionMessage()
	{
		String detailMessage="";
		detailMessage=exceptionCode+" "+message;
		
		return detailMessage;
	}
}
