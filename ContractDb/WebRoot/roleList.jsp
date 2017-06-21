<%@ page language="java" import="java.util.*" import="java.sql.ResultSet" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<jsp:useBean id="adminlist" class="com.ruanko.service.AdminService"/>
<% 
     ResultSet res = adminlist.showDetail();   
	boolean flag = true;
	ArrayList table1 = new ArrayList();
	ArrayList table2 = new ArrayList();
	ArrayList table3 = new ArrayList();	
	
	String[] str1 = null;
	String[] str2 = null;
	String[] str3 = null;
	  
    if(res.next())
    {    
    	    table1.add(res.getString(1));	
			str1 = (String[])table1.toArray(new String[0]);
			table2.add(res.getString(2));	
			str2 = (String[])table2.toArray(new String[0]);
			table3.add(res.getString(4));	
			str3 = (String[])table3.toArray(new String[0]); 
        while(res.next()){
	   	    table1.add(res.getString(1));	
 			str1 = (String[])table1.toArray(new String[0]);
 			table2.add(res.getString(2));	
 			str2 = (String[])table2.toArray(new String[0]);
 			table3.add(res.getString(4));	
 			str3 = (String[])table3.toArray(new String[0]); 		
 			
  	 	}
       
	}else{
		flag = false;
		out.println("mei you he t ");
  	}   	 	
%>	
	 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>Role list</title>
    
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
			Role list
		</div>
		<br />

		<div class="list">
		  <table>
			<tr>
				<th style="width:100px;">
					Admin ID
				</th>
				<th>
					Admin Name
				</th>	
				<th>
					Admin Level
				</th>					
			</tr>
			
			
			
			  <%
	          if(flag)
	          {
					for(int i=0;i < str1.length;i++)
					{		
						out.print("<tr>");
						%>
						<td>
							<%=str1[i]%>
						</td>
						<td>
							<%=str2[i]%>
						</td>
						<td>
							<%
							  if(str3[i].equals("1"))
								  out.print("boss");
							  else if(str3[i].equals("0"))
								  out.print("超管");
							  else
								  out.print("经理");
							%>
						</td>
						
					<%
					out.print("</tr>");	
					}
				}
				else{
				out.print("<tr>");
				out.print("<td colspan=\"3\">");						
				out.print("没有管理员");
				out.print("</td>");
				out.print("</tr>");		
				}
				%>		
				
		  </table>
		</div>		
	</body>
</html>
