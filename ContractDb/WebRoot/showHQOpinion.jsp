<%@ page language="java" import="java.util.*"  import="java.sql.ResultSet" pageEncoding="utf-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Display countersign opinion</title>
    
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
		
<jsp:useBean id="contractDetail" class="com.ruanko.dao.impl.ContractDaoImpl"/>
<% 
    String cid=request.getParameter("param1");
    
    
    String uid = (String)session.getAttribute("userId");
    ResultSet res = null;
    res=contractDetail.detail(cid);
    
   
	
    boolean flag = true;
	ArrayList table1 = new ArrayList();
	ArrayList table2 = new ArrayList();
	ArrayList table3 = new ArrayList();
	
	String[] str1 = null;
	String[] str2 = null;
	String[] str3 = null;
  
  
	   if(res.next())
	   {
	     //String str=new String(rs.getString(2).getBytes("iso-8859-1"),"utf-8");
		   	table1.add(res.getString(1));	
  			str1 = (String[])table1.toArray(new String[0]);
  			table2.add(res.getString(2));	
  			str2 = (String[])table2.toArray(new String[0]);
  			table3.add(res.getString(3));	
  			str3 = (String[])table3.toArray(new String[0]); 
      
	    while(res.next()){
	 	   //String str=new String(rs.getString(2).getBytes("iso-8859-1"),"utf-8");
		   	table1.add(res.getString(1));	
  			str1 = (String[])table1.toArray(new String[0]);
  			table2.add(res.getString(2));	
  			str2 = (String[])table2.toArray(new String[0]);
  			table3.add(res.getString(3));	
  			str3 = (String[])table3.toArray(new String[0]); 
  	 	 }
  	 }
  	 else
  	 {
  	    flag = false;
		System.out.println("mei you he t ");
  	 }
   	 	
%>	
	
	
	
	
		<div class="mtitle">
			Countersign opinion
		</div>
		
		<br />
		<div class="listOpinion">
			<table>
						
			</table>
			
			
			<table>
		<thead valign="middle">
         	<tr>
				<th width="100">
					Operator
				</th>
				<th width="600">
					Opinion
				</th>
				<th width="600">
					Detail
				</th>
			</tr>	
		</thead>
	        <tbody>
	          <%
	          if(flag)
	          {
					for(int i=0;i < str1.length;i++)
					{		
						out.print("<tr>");
						out.print("<td>");
						out.print(str1[i]);		
						out.print("</td>");
						out.print("<td>");
						out.print(str2[i]);		
						out.print("</td>");
						out.print("<td>");
						out.print(str3[i]);		
						out.print("</td>");					
						out.print("</tr>");							
					}
				}else{
					out.print("<tr>");
					out.print("<td colspan=\"3\">");						
					out.print("没有人会签");
					out.print("</td>");
					out.print("</tr>");		
				}
				%>
	        </tbody>
		</table>
			
		</div>
		<br />

	</body>
</html>