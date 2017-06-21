<%@ page language="java" import="java.util.*" import="java.sql.ResultSet" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="signInfo" class="com.ruanko.dao.impl.ContractDaoImpl" />
<%
      String aid = (String)session.getAttribute("userId");
      String cid = null;
      cid = request.getParameter("param1");  
      ResultSet res = signInfo.getContractDetail(cid);
	   String contractName = null;
     String uid = null;
     String ccontent = null;
     if( res.next())
     {
        contractName = res.getString("ctitle");
       uid = res.getString("uid");
       ccontent = res.getString("ccontent");
        //cid = res.getString("cid");
    
     }else
     {
          out.println("系统出错");
     }
        
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>签订合同</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />

  </head>
  
  <body>
    <div class="mtitle">
			Sign contract
		</div>
		<br />
		<form action="Sign" method="post">
			<table class="update" style="width:600px;">	
				<tr height="28">
					<td>Contract name:</td>
					<td><%=contractName %></td>
				</tr>
				<tr height="28">
					<td>Contract id:</td>
					<td> <%=cid %> </td>
					<input style="display: none" type="text" id = "cid" name="cid" value="<%=cid%>"/>
				</tr>
				
					
					<input style="display: none" type="text" id = "aid" name="aid" value="<%=aid %>"/>
				
				
				<tr height="28">
					<td>Customer:</td>
					<td><%=uid %></td>
				</tr>
				<tr>
					<td>Signed information:</td>	
					<td>
						<textarea rows="10" cols="40" name="content" id="content" style="width:400px;height:100px;">...information:
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
