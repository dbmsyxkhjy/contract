<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Edit Customer</title>
    
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
			Edit Customer
		</div>	
		<br />
		<div style="font-size:18px;color:green;width:700px;text-align:center;">
			Edit successfully!			
		</div>

		<br />
		<form>
			<table class="update" style="width:700px;">
				<tr height="28">
					<td width="140px">Customer name:</td>
					<td><input type="text" name="name" value="jaffson"/></td>
				</tr>
				<tr height="28">
					<td>Phone number:</td>
					<td><input type="text" name="" value="11111111111"/></td>
				</tr>
				<tr height="28">
					<td>Address:</td>
					<td><input type="text" name="" value="China Hubei Wuhan"/></td>
				</tr>
				<tr height="28">
					<td>Fax:</td>
					<td><input type="text" name="" value="22222222"/></td>
				</tr>
				<tr height="28">
					<td>Mailbox:</td>
					<td><input type="text" name="" value="1234@qq.com"/></td>
				</tr>
				<tr height="28">
					<td>Bank name:</td>
					<td><input type="text" name="" value="Agricultural Bank of China"/></td>
				</tr>
				<tr height="28">
					<td>Bank account:</td>
					<td><input type="text" name="" value="622848 ******"/></td>
				</tr>
				<tr>
					<td>Remark:</td>
					<td>
						<textarea rows="4" cols="40" name="content" style="width:400px;height:100px;">The traffic is not convenient</textarea>
					</td>
				</tr>
				
				<tr height="28">
					<td align="center" colspan="2">
						<input type="submit" value="Submit" class="button"> &nbsp; &nbsp; &nbsp;
						<input type="reset" value="Reset" class="button">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>