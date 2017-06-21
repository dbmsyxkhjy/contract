<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   	<title>Approve contract</title>
    
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
			Approve contract
		</div>
		<br />
		<form action="CounterSign">
			<table class="update" style="width:600px;">	
				<tr height="28">
					<td width="140px">Contract name:</td>
					<td><%=request.getParameter("param1")%> </td>
					<input style="display: none" type="text" name="cid" value="<%=request.getParameter("param1")%>">
				</tr>
				<tr>
					<td>
						&nbsp;<input name="approve" type="radio" value="1" checked="checked"/>
						Pass
						<br /><br />
						&nbsp;<input name="approve" type="radio" value="0" />
						Refuse
					</td>
					<td>
						<textarea rows="10" cols="40" name="content" style="width:400px;height:100px;">...opinion
						</textarea>
					</td>
				</tr>
				<tr height="28">
					<td align="center" colspan="2">
						<input type="submit" value="Submit" class="button">
						 &nbsp; &nbsp; &nbsp;
						<input type="reset" value="Reset" class="button">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
