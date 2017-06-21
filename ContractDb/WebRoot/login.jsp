<%@page pageEncoding="utf-8" %>
<%@page language="java" import="java.util.*"%>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html;charset=utf-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>合同管理系统-登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
    <link href="css/style.css" rel="stylesheet" type="text/css" media="screen"/>
	
	<script type="text/javascript">  
		function check(){
		  var  Company_ID = getElementById("Company_ID");
		  var  password = getElementById("password");
		  
		  if(Company_ID,value == ""){
		      alert("Company ID not be null!")
		      Company_ID.foucs();
		      return false;
		  }
		  if(password.value == ""){
		      alter("Password can not be null!")
		      password.foucs();
		      return false;
		  }			
		}
  	</script>		

  </head>
  
  <body>
    <!-- ---Header Start ------>
     <jsp:include page="header.jsp"></jsp:include>  
    <!-- ---Header End -->
    
    <!-- ---Main Start -------->
    <div class="main">
		<form action="loginUser" method="post">

			<div class="register_main">
				<table>
					<tr>
						<td class="title" colspan="3">
							Company Login
						</td>
					</tr>
					<tr>
						<td width="60">
							Company ID:
						</td>
						<td width="200">
							<input type="text" name="Company_ID" id="Company_ID" value="" height="40" autofocus required/>
						</td>
						<td width="200"></td>
					</tr>

					<tr>
						<td>
							Password:
						</td>
						<td>
							<input type="password" name="password" id="password" value="" autofocus required/>
						</td>
						<td></td>
					</tr>
					<tr>
						<td >							
							&nbsp;role:
						</td>
						<td>
							&nbsp;<input name="approve" type="radio" value="pass" checked="checked"/>
								admin
							&nbsp;<input name="approve" type="radio" value="refuse" />
								user
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="Login" class="button" />
						</td>
						<td align="left">
							 <a href="register.jsp">Register an Account?</a>
						</td>
					</tr>
				</table>
			</div>

		</form>
	</div>
    <!-- ---Main End -------->
    
    <!-- ---Footer Start ------>
    <jsp:include page="footer.jsp"></jsp:include>    
    <!-- ---Footer End -->
  </body>
</html>
