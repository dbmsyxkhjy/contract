<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>User permission list</title>
    
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
			User permission list
		</div>

		<div class="search">
			<form>
				Search user:
				<input value="Enter search conditions.." />
				&nbsp;&nbsp;
				<input type="submit" value="Search" class="search-submit" />
				<br />
			</form>
		</div>

		<div class="list">
			<table>
				<tr>
					<th>
						User name
					</th>
					<th class="th2">
						Role name
					</th>
					<th class="th2">
						Operation
					</th>
				</tr>
			<tr>
				<td class="tdname">
					admin
				</td>
				<td>
					admin
				</td>
				<td>
					<a href="assignPermission.jsp">
						<img src="images/cog_edit.png"  alt="Authorize" />
						Authorize
					</a>
				</td>
			</tr>
			<tr>
				<td class="tdname">
					jack
				</td>
				<td>
					operator
				</td>
				<td>
					<a href="assignPermission.jsp">
						<img src="images/cog_edit.png"  alt="Authorize" />
						Authorize
					</a>
				</td>
			</tr>
			<tr>
				<td class="tdname">
					lily
				</td>
				<td>
					
				</td>
				<td>
					<a href="assignPermission.jsp">
						<img src="images/cog_edit.png"  alt="Authorize" />
						Authorize
					</a>
				</td>
			</tr>
			
			<tr>
				<td colspan="3"> </td>
			</tr>
		  </table>
		</div>

		<div align="right" class="pagelist">					
			<a href="#"><img src="images/page/first.png"  alt="" /></a> &nbsp;
			<a href="#"><img src="images/page/pre.png"  alt="" /></a>&nbsp;
			<a href="#"><img src="images/page/next.png"  alt="" /></a>&nbsp;
			<a href="#"><img src="images/page/last.png"  alt="" /></a>&nbsp;
					
			<span class="pageinfo">
				Total&nbsp;<strong>2</strong>&nbsp;pages&nbsp;<strong>13</strong>&nbsp;records
			</span>		
		</div>
	</body>
</html>
