<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	
	<link href="css/style.css" rel="stylesheet" type="text/css" media="screen"/>
  
  </head>
  
  <body>
    <!-- header start -->
		<div class="header">
			<div class="toplinks">
				<span> [<a href="login.jsp" target="_top">Login</a>]
					&nbsp;|&nbsp; [<a href="register.jsp">Register</a>] </span>
			</div>

			<h1>
				<img src="images/logo_title.png" alt="Contract Management System" />
			</h1>
		</div>
		<!-- header end -->
  </body>
</html>
