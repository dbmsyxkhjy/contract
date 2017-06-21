<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>Finalize contract</title>
    
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
			Finalize contract
		</div>
		<br />
		<form action="ModifyReject">
			<table class="update" style="width:700px;">
				<tr height="28">
					<td width="140">Contract name:</td>
					<td><%=request.getParameter("param2") %></td>
				</tr>

				<tr height="28">
					<td>Contract ID:</td>
					<td>
						<%=request.getParameter("param1") %>
					</td>
				</tr>
				<tr>
					<td>Begin time:</td>	
					<td><%=request.getParameter("param4") %></td>
				</tr>
				<tr>
					<td>End time:</td>	
					<td><%=request.getParameter("param5") %></td>
				</tr>
				<tr>
					<td>Content:</td>	
					<td>
					<input style="display: none" type="text" name="cid" value="<%=request.getParameter("param1")%>">
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<textarea rows="40" cols="100" name="content" style="width:680px;height:400px;resize:none;"><%=request.getParameter("param3")%>
						</textarea>
					</td>
				</tr>
				<tr height="28">
					<td>Attachment:</td>
					<td><input type="file" /></td>
				</tr>
				
				<tr height="28">
					<td align="center" colspan="2">
						<input type="submit" value="Submit" class="button"> &nbsp; &nbsp; &nbsp;
						<input type="submit" value="Reset" class="button">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
