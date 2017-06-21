<%@ page language="java" import="java.util.*" import="java.sql.ResultSet" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>Customter list</title>
    
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
		<!-- Use JavaScript script to open a new window display information when preview-->
		<script>
			function preview(url) {
				window.open(url,'Preview','toolbar=no,scrollbars=yes,width=720,height=560,top=50,left=100');
			}
		</script>
	</head>
    <jsp:useBean id="userlist" class="com.ruanko.dao.impl.UserDaoImpl" />	
	<%  
	  
		ResultSet res = userlist.showDetail();
 		boolean flag = false;
		ArrayList table1 = new ArrayList();
		ArrayList table2 = new ArrayList();
		ArrayList table3 = new ArrayList();
		ArrayList table4 = new ArrayList();
		ArrayList table5 = new ArrayList();
		
		
		String[] str1 = null;
		String[] str2 = null;
		String[] str3 = null;
		String[] str4 = null;
 		String[] str5 = null;
 		
       if(res.next()){
    	    flag = true;
    	 //String str=new String(rs.getString(2).getBytes("iso-8859-1"),"utf-8");
		   	table1.add(res.getString(1));	
 			str1 = (String[])table1.toArray(new String[0]);
 			
 			table2.add(res.getString(2));	
 			str2 = (String[])table2.toArray(new String[0]);
 			
 			table3.add(res.getString(3));	
 			str3 = (String[])table3.toArray(new String[0]);
 			
 			table4.add(res.getString(4));	
 			str4 = (String[])table4.toArray(new String[0]);
 			
 			table5.add(res.getString(5));	
 			str5 = (String[])table5.toArray(new String[0]);
			
 			while(res.next()){
			 	//String str=new String(rs.getString(2).getBytes("iso-8859-1"),"utf-8");
			   	table1.add(res.getString(1));	
	  			str1 = (String[])table1.toArray(new String[0]);
	  			
	  			table2.add(res.getString(2));	
	  			str2 = (String[])table2.toArray(new String[0]);
	  			
	  			table3.add(res.getString(3));	
	  			str3 = (String[])table3.toArray(new String[0]);
	  			
	  			table4.add(res.getString(4));	
	  			str4 = (String[])table4.toArray(new String[0]);
	  			
	  			table5.add(res.getString(5));	
	  			str5 = (String[])table5.toArray(new String[0]);
   	 	}
			
       }
   	 	
	%>
	<body>
		<div class="mtitle">
			Customter list
		</div>
				
		<br />
		<div class="list">
		  <table>
			<tr>
				<th>
					Customer name
				</th>
				<th>
					Address
				</th>
				<th>
					Phone Number
				</th>
				<th>
					Fax
				</th>
				<th>
					Mailbox
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
							<%=str3[i]%>
						</td>
						
			            <td>
							<%=str4[i]%>
						</td>
						
						<td>
							<%=str5[i]%>
						</td>
					<%
					out.print("</tr>");	
					}
				}
				else{
				out.print("<tr>");
				out.print("<td colspan=\"3\">");						
				out.print("没有用户");
				out.print("</td>");
				out.print("</tr>");		
				}
				%>				
		  </table>
		</div>
		
	</body>
</html>
