<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
 String uname = (String)session.getAttribute("userId");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>Contract Management System - Head</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link href="css/frame.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
		<div class="header">
			<div class="toplinks">
				<span>Hello:<%=uname %>，Welcome to Contract Management System [<a href="login.jsp"
					target="_top">Logout</a>]</span>
			</div>
			<h1>
				<img src="images/logo_title.png" alt="Contract Management System" />
			</h1>
		</div>
 </body>
</html>
