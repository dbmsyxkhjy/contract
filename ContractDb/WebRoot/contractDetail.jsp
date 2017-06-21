<%@ page language="java" import="java.util.*"  import= "java.sql.ResultSet" import = "java.sql.Timestamp" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:useBean id="contractDetail" class="com.ruanko.dao.impl.ContractDaoImpl" />

<%
    String cid = null;
    cid = request.getParameter("param1");    
    ResultSet res = contractDetail.getContractDetail(cid);
	String ctitle = null;
	String ccontent = null;
	String cstarttime = null;
	String cendtime = null;
	int state;
	String uid = null;
    
	if(res.next())
    {
	    cid = res.getString("cid");
	 	ctitle = res.getString("ctitle");
	    ccontent = res.getString("ccontent");
	 	cstarttime = res.getString("cstarttime");
 		cendtime = res.getString("cendtime");
 		state = res.getInt("state");
 		uid = res.getString("uid");
		
	}
	else
	{ 
		out.println("系统出错");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Contract details</title>
    
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
		<div class="preview">
		   <div class="viewbox">
			<div class="title">
					<%=ctitle %>
			</div>
			<div class="info">
				<small>Customer:</small><%=uid%>
		     	<small>Contract id:</small><%=cid%>
				<small>Begin time:</small><%=cstarttime%>
				<small>End time:</small><%=cendtime%>
			</div>
			<div class="content">	
				<%=ccontent%>	
			</div>
		</div>

		<div class="pfooter">
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
					<a href="http://www.ruanko.com" title="www.ruanko.com" target="_blank"><strong>www.ruanko.com</strong>
					</a>&nbsp;Copyright Reserved
				</p>
			</div>
		</div>
	</body>
</html>
