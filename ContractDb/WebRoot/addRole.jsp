<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addRole.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Add Role</title>
	<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />

  </head>
  
  <body>
    <div class="mtitle">
			Add role
		</div>
		<br />
		
		<div style="font-size:18px;color:green;width:500px;text-align:center;">
			Add successed!			
		</div>

		<br />
		<form>
			<table class="update" style="width:700px;">
				<tr height="28">
					<td width="100">Role name:</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr height="28">
					<td>Description：</td>
					<td>
						<textarea rows="4" cols="40" name="content" style="width:400px;height:100px;"></textarea>
					</td>
				</tr>
				<tr>
					<td>Configure permission:</td>	
					<td>
						<div>
							Contract Management:<br />
							<input name="" type="checkbox" value="1" />Draf Contract
							<input name="" type="checkbox" value="2" />Edit Contract
							<input name="" type="checkbox" value="3" />Query Contract
							<input name="" type="checkbox" value="4" />Delete Contract
							<br /><br />
							Process Management:<br />
							<input name="" type="checkbox" value="5" />Cuntersign
							<input name="" type="checkbox" value="6" />Approve
							<input name="" type="checkbox" value="7" />Sign
							<br />
							<input name="" type="checkbox" value="8" />Assign countersign
							<input name="" type="checkbox" value="9" />Assign Approval
							<input name="" type="checkbox" value="10" />Assign Sign
							<br />
							<input name="" type="checkbox" value="11" />Query Process
							<br /><br />
							User Management:<br />
							<input name="" type="checkbox" value="12" />Add User
							<input name="" type="checkbox" value="13" />Edit User
							<input name="" type="checkbox" value="14" />Query User
							<input name="" type="checkbox" value="15" />Delete User
							<br /><br />
							Role Management:<br />
							<input name="" type="checkbox" value="16" />Add Role
							<input name="" type="checkbox" value="17" />Edit Role
							<input name="" type="checkbox" value="18" />Query Role
							<input name="" type="checkbox" value="19" />Delete Role
							<br /><br />
							Function Operation:<br />
							<input name="" type="checkbox" value="20" />Add Function
							<input name="" type="checkbox" value="21" />Edit Function
							<input name="" type="checkbox" value="22" />Query Function
							<input name="" type="checkbox" value="23" />Delete Function
							<br /><br />
							Authorize:<br />
							<input name="" type="checkbox" value="24" />Configure permission
							<br /><br />
							Customer Management:<br />
							<input name="" type="checkbox" value="25" />Add Customer
							<input name="" type="checkbox" value="26" />Edit Customer
							<input name="" type="checkbox" value="27" />Query Customer
							<input name="" type="checkbox" value="28" />Delete Customer
							<br /><br />
							System Log:<br />
							<input name="" type="checkbox" value="29" />Query Log
							<input name="" type="checkbox" value="30" />Delete Log
						</div>
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
