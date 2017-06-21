<%@ page language="java" import="java.util.*" import="java.sql.ResultSet" pageEncoding="utf-8"%>
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
	
	<title>Draft contract</title>

    <link href="css/style.css" rel="stylesheet" type="text/css" media="screen"/>

  </head>
  
  <jsp:useBean id="contract" class="com.ruanko.dao.impl.ContractDaoImpl" />
  <%
  	 String cid = null;
  	 cid = request.getParameter("param1");  
  	 String ctitle = null;
	 String ccontent = null;
	 String cstarttime = null;
	 String cendtime = null;
	 int state;
	 String uid = null;
  	 if(cid != null)
  	 {
  		 ResultSet res = contract.getContractDetail(cid);
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
  	 }
  %>
  
  
  
  
  <body>
    	<div class="mtitle">
			Draft Contract
		</div>
		<br />
		<div style="font-size:18px;color:green;width:700px;text-align:center;">
		    <% 
		      if(session.getAttribute("message") != null)
		      {
		        String message =(String)session.getAttribute("message");
		        if(!message.isEmpty())
		        	out.print(message);
		        
		        session.setAttribute("message",null);
		      }
		    %>
		</div>

		<form action='draft' method='post'>
			<table class="update" style="width:700px;">
				<tr height="28">
					<td width="140px">Contract Title:</td>
					<td><input type="text" id="name" name="name" value="<%=ctitle %>" /><font color="red">&nbsp;&nbsp;*</font>
					</td>
				</tr>

				<tr height="28">
					<td>Contract ID:</td>
					<td><input type="text" name="contractId" value="<%=cid %>" />
					</td>
				</tr>
				<tr>
					<td>Begin time:</td>	
					<td><input type="text" id="beginTime" name="beginTime" value="<%=cstarttime %>"/><font color="red">&nbsp;&nbsp;*Correct format:yyyy-mm-dd</font>
					</td>
				</tr>
				<tr>
					<td>End time:</td>	
					<td><input type="text" id="endTime" name="endTime" value="<%=cendtime %>"/><font color="red">&nbsp;&nbsp;*Correct format:yyyy-mm-dd</font>
					</td>
				</tr>
				<tr>
					<td>Content:</td>	
					<td><font color="red">&nbsp;&nbsp;*</font>
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<textarea rows="40" cols="100" name="content"   style="width:680px;height:400px;">
						   <%=ccontent %>
						</textarea>
					</td>
				</tr>
				<tr height="28">
					<td>Attachment:</td>
					<td><input type="file" /></td>
				</tr>
				<tr height="28">
					<td align="center" colspan="2">
						<input type="submit" value="Submit" name="action" class="button">
						 &nbsp; &nbsp; &nbsp;
						<input type="submit" value="SaveDrafts" name="action" class="button">
						  &nbsp; &nbsp; &nbsp;
						<input type="reset" value="Reset" class="button">
					</td>
				</tr>
			</table>
		</form>
  </body>
</html>
