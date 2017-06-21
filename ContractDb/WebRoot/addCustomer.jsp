<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <title>Add Customer</title>

    <link href="css/style.css" rel="stylesheet" type="text/css" media="screen"/>

  </head>
  
  <body>
    <div class="mtitle">
			Add Customer
		</div>	
		<br />
		<div style="font-size:18px;color:green;width:700px;text-align:center;">
			Add successfully!			
		</div>

		<form>
			<table class="update" style="width:700px;">
				<tr height="28">
					<td width="140px">Customer name:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr height="28">
					<td>Phone number:</td>
					<td><input type="text" name="" /></td>
				</tr>
				<tr height="28">
					<td>Address:</td>
					<td><input type="text" name="" /></td>
				</tr>
				<tr height="28">
					<td>Fax:</td>
					<td><input type="text" name="" /></td>
				</tr>
				<tr height="28">
					<td>Mailbox:</td>
					<td><input type="text" name="" /></td>
				</tr>
				<tr height="28">
					<td>Bank name:</td>
					<td><input type="text" name="" /></td>
				</tr>
				<tr height="28">
					<td>Bank account:</td>
					<td><input type="text" name="" /></td>
				</tr>
				<tr>
					<td>Remark:</td>
					<td>
						<textarea rows="4" cols="40" name="content" style="width:400px;height:100px;">
						
						</textarea>
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
