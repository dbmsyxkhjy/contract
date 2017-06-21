<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  <title>Contract Management System - Administrator menu bar</title>
    
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
	<link href="css/style.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
  <div class="menu">
		<!--  <div class="search">
			<form name="form1" action="search" method="post">
				<p>Search contract:</p>
				<input name="searchInfo" value="" />
				<a href="sh" target="main" onclick="s()">Search</a>
				 <br />
			</form>
		</div>
		-->	
	<dl>
			<dt>
				Role Management
			</dt>
			<dd>
				<a href="customerList.jsp" target="main">User List</a>
			</dd>
			<dd>
				<a href="roleList.jsp" target="main">Admin List</a>
			</dd>		
	  </dl>
	  <dl>
		  <dt>
			  Contract Management
		  </dt>
		  <dd><a href="dshphtList1.jsp" target="main">drafting Contract</a></dd>
		  <dd><a href="dqdhtList2.jsp" target="main">approval Contract</a></dd>
		  <dd><a href="yshphtList.jsp" target="main">Approved Contract</a></dd>
		  <dd>
			  <a href="yqdhtList.jsp" target="main">Assigned Contract</a>
		  </dd>
		  <dd>
	      <a href="yschtList.jsp" target="main">Denied Contract</a></dd>
		 
	  </dl>
	</div>
  </body>
  <script type="text/javascript">
   function s(){
	   form1.submit();
   }
  
  
  </script>
</html>

