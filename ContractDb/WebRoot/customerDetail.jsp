<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>






<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Customer Detail</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
	</head>

	<body>
		<div class="mtitle">
			Customer Detail
		</div>	
		<br />
		<table class="update" style="width:500px;">
				<tr height="28">
					<td width="140px">Customer name:</td>
					<td>jaffson</td>
				</tr>
				<tr height="28">
					<td>Phone number:</td>
					<td>11111111111</td>
				</tr>
				<tr height="28">
					<td>Address:</td>
					<td>China Hubei Wuhan</td>
				</tr>
				<tr height="28">
					<td>Fax:</td>
					<td>22222222</td>
				</tr>
				<tr height="28">
					<td>Mailbox:</td>
					<td>1234@qq.com</td>
				</tr>
				<tr height="28">
					<td>Bank name:</td>
					<td>Agricultural Bank of China </td>
				</tr>
				<tr height="28">
					<td>Bank account:</td>
					<td>622848 ****** </td>
				</tr>
				<tr>
					<td>Remark:</td>
					<td>
						The traffic is not convenient
					</td>
				</tr>
				
			</table>
	</body>
</html>
