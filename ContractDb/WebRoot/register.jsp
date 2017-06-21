<%@page pageEncoding="utf-8" %>
<%@page language="java" import="java.util.*"%>
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
    
    <title>Contract Management System - Registrater page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
		
	<link href="css/style.css" rel="stylesheet" type="text/css" media="screen"/>
	
  </head>
  
  <body>
    <!-- header start -->
		<div class="header">
			<div class="toplinks">
				<span>[<a href="register.jsp">Register</a>][<a
					href="login.jsp">Login</a>]</span>
			</div>

			<h1>
				<img src="images/logo_title.png" alt="Contract Management System" />
			</h1>
		</div>
		<!-- header end -->

		<!-- main start -->
		<div class="main">
			<form  name="register_form" action="registerUser" method="post">

				<div class="register_main">
					<table>
						<tr>
							<td class="title" colspan="2">
								Company register
							</td>
						</tr>
						
						<!-----------------公司名字------------------>
						<tr>
							<td width="120" align="center">
								Company name:
							</td>
							<td>
								<input type="text" name="name" id="name" value="" required/>
							</td>
						</tr>
						<tr>
							<td class="info" colspan="2">
								Company name must begin with a letter, at least four words(letters,
								Numbers, underscores).
							</td>
						</tr>
						
						<!-----------------账号------------------>
						<tr>
							<td width="120" align="center">
								Company ID:
							</td>
							<td>
								<input type="text" name="Company_ID" id="Company_ID" value="" required/>
							</td>
						</tr>
						<tr>
							<td class="info" colspan="2">
								Company ID must begin with a letter, at least four words(letters,
								Numbers, underscores).
							</td>
						</tr>

						<!-----------------法人------------------>
						<tr>
							<td width="120" align="center">
								Juridical person:
							</td>
							<td>								
								<input type="text" name="corporation" id="corporation" value="" required/>
							</td>
						</tr>
						<tr>
							<td class="info" colspan="2">
								Juridical person must begin with a letter, at least four words(letters,
								Numbers, underscores).
							</td>
						</tr>
						
						<!-----------------联系方式------------------>
						<tr>
							<td width="120" align="center">
								Tell:
							</td>
							<td>
								<input type="text" name="tell" id="tell" value="" required/>
							</td>
						</tr>
						<tr>
							<td class="info" colspan="2">
								Tell must begin with a letter, at least four words(letters,
								Numbers, underscores).
							</td>
						</tr>
						
						<!-----------------公司地址------------------>
						<tr>
							<td width="120" align="center">
								Address:
							</td>
							<td>
								<input type="text" name="address" id="address" value="" required/>
							</td>
						</tr>
						<tr>
							<td class="info" colspan="2">
								Address must begin with a letter, at least four words(letters,
								Numbers, underscores).
							</td>
						</tr>
						
						<!-----------------密码设置------------------>						
						<tr>
							<td align="center">
								Password:
							</td>
							<td>
								<input type="password" name="password" id="password" value="" required/>
							</td>
						</tr>
						<tr>
							<td class="info" colspan="2">
								Password can not be too simple, at least contain six words;
								Recommend to use numbers and letters mixed arrangement,
								case-insensitive.
							</td>
						</tr>                        
						<!-----------------密码确认------------------>	
						<tr>
							<td align="center">
								Repeat Password:
							</td>
							<td>
								<input onblur="checkPassword()" type="password" name="password2" id="password2" value="" required/>
							</td>
						</tr>
						<tr>
							<td class="info" colspan="2">
								Repeat password and password should keep consistent!
							</td>
						</tr>
						
						
						<tr>
							<td >							
								&nbsp;role:
							</td>
							
					    </tr>
					    
						<!-----------------法律条款------------------>	
						<tr>
							<td align="left" colspan="2">
								<input type="checkbox" name="name" id="name" > 
								<a href="##">I Accept Terms Of Service！</a>
							</td>
						</tr>
						
						<!-----------------提交内容------------------>	
						<tr>
							<td align="center">
								<input type="submit" value="Submit" class="button" />
							</td>
							<td align="left">
								 <a href="login.jsp">Already Have an Account?</a>
							</td>
						</tr>
					</table>
				</div>

			</form>
		</div>
		<!-- main end -->

		<div class="footer">
			<ul>
				<li>
					<a target="_blank" href="#">Contract Management System</a>
				</li>
				<li>
					｜
				</li>
				<li>
					<a target="_blank" href="#">Help</a>
				</li>
			</ul>

			<p>
				Copyright&nbsp;&copy;&nbsp;Ruanko COE&nbsp;
				<a href="http://www.ruanko.com" title="wwww.ruanko.com"
					target="_blank"><strong>www.ruanko.com</strong> </a>&nbsp;Copyright
				Reserved
			</p>
		</div>
  </body>
</html>
