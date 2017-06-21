<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>Contract Management System - Exception page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link href="css/style.css" rel="stylesheet" type="text/css" media="screen"/>
	
	<script type="text/javascript">  
			// Make the page as the parent window display
			if(top!=self){
				top.location.href=self.location.href;
			}  
 		</script>
 </head>
 
  <body>
    <div class="header">
			<div class="toplinks">
				Welcome to Contract Management System!
			</div>
			<h1>
				<img src="images/logo_title.png"  alt="Contract Management System" />
			</h1>
		</div>
		
		<div class="error">
			<p>
				System is under maintenance......
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
			
			<p>Copyright&nbsp;&copy;&nbsp;Ranko COE&nbsp;<a href="http://www.ruanko.com" title="www.ruanko.com" target="_blank"><strong>www.ruanko.com</strong></a>&nbsp;Copyright Reserved</p>
		</div>
  </body>
</html>
