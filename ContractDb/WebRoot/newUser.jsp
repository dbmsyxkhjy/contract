<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>Contract Management System - New User</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<link href="css/frame.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="header">
			<div class="toplinks">
				<span>Hello:jack, Welcome to contract management system!
				[<a href="login.htm" target="_top">Logout</a>]</span>
			</div>
			<h1>
				<img src="images/logo_title.png"  alt="Contract Management System" />
			</h1>
		</div>
		
		<div class="content">
			<p>
			You hava no contract operation privileges,<br />
				please waiting for the administrators to configure permissions for
				you!	
			<br />			
			Current time12:26:24
			</p>
		</div>

		<div class="footer">
			<ul>
				<li>
					<a target="_blank" href="#">Contract Management System</a>
				</li>
				<li>
					｜
				</li>
				<li>
					<a target="_blank" href="#">Help</a>
				</li>
			</ul>

			<p>
				Copyright&nbsp;&copy;&nbsp;Ruanko COE &nbsp;
				<a href="http://www.ruanko.com" title="www.ruanko.com"
					target="_blank"><strong>www.ruanko.com</strong> </a>&nbsp;Copyright
				Reserved
			</p>
		</div>
	</body>
</html>