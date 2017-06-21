<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" class="no-js">

<head>

<meta charset="utf-8">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->

<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/login.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/tooltips.js"></script>

</head>

<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
		
			<div class="login_logo">
				
			</div>
		 <span style="font-size: 35px; font-weight: bold;color: white; margin-left:35%;">合同管理
        </span>
			<div class="login_form">
				<form method="post"  action="method!login">
					<div class="form-group">
						<label for="j_username" class="t">用户名 ：</label> 
						<input id="email"  name="username" type="text" class="form-control x319 in" 
						autocomplete="off">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label> 
						<input id="password"  name="password" type="password" 
						class="password form-control x319 in">
					</div>
					<div class="form-group">
						<label for="j_captcha" class="t">角色：</label>
                        <select  name="role" id="roleid" class="select"> 
                         <option value="1">管理员</option>
                         <option value="2">用户</option>
                          <option value="3">操作员</option>
                         </select>
					</div>
					<div class="form-group">
						<label class="t"></label>
						
					</div>
					<div class="form-group space">
						<label class="t"></label>　　　
						<button type="submit"  id="submit_btn" class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>
					</div>
				</form>
			</div>
		</div>
		<div class="bottom"></div>
	</div>
</div>

<!-- Javascript -->

<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<script src="js/scripts.js"></script>
<div style="text-align:center;">
<p></p>
</div>
</body>
</html>