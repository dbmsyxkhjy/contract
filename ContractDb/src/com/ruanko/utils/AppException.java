package com.ruanko.utils;

public class AppException extends Exception{

	//私有属性
	private int exceptionCode;//异常编号
	private String message;//异常信息
	
	//构造方法

	public AppException(String message)
	{
		this.message=message;
	
	}
	
	public AppException(String message,int exceptionCode)
	{
		this.message=message;
		this.exceptionCode=exceptionCode;
	}
	
	//方法
	
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
