<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
 	<title>Contract Management System - Operator menu bar</title>
    
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
		<div class="menu">
		  <dl>
	  <dt>cotract management</dt>
	  <dd>
      <a href="yschtList.jsp" target="main">Denied Contract</a>
      </dd>
				<dd>
					<a href="dqdhtList3.jsp" target="main">Contract to be signed</a>
				</dd>
				<dd>
					<a href="yqdhtList.jsp" target="main">Signed Contract</a>
				</dd>
		  </dl>
	</div>
	</body>
</html>

