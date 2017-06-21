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
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
		<title>List of contract to be approved</title>
		<!-- Use JavaScript script to open a new window display information when preview-->
		<script>
			function preview(url) {
				window.open(url,'Preview','toolbar=no,scrollbars=yes,width=720,height=560,top=50,left=100');
			}
		</script>
	</head>

	<body>
	
	<jsp:useBean id="contractDetail" class="com.ruanko.dao.impl.ContractDaoImpl"/>
<% 
    ResultSet res = contractDetail.getContractLevel2();
	
    boolean flag = true;
	ArrayList table1 = new ArrayList();
	ArrayList table2 = new ArrayList();
	
	String[] str1 = null;
	String[] str2 = null;
  
	String uid = null;
    if(res.next())
    {   
        //String str=new String(rs.getString(2).getBytes("iso-8859-1"),"utf-8");
		   	table1.add(res.getString(1));	
  			str1 = (String[])table1.toArray(new String[0]);
  			table2.add(res.getString(4));	
  			str2 = (String[])table2.toArray(new String[0]); 
  			
  			 while(res.next()){
	 	   //String str=new String(rs.getString(2).getBytes("iso-8859-1"),"utf-8");
		   	table1.add(res.getString(1));	
  			str1 = (String[])table1.toArray(new String[0]);
  			table2.add(res.getString(4));	
  			str2 = (String[])table2.toArray(new String[0]);
  	 	}
       
	}else{
	    flag = false;
		
  	}
   	 	
%>	
	
	
		<div class="mtitle">
			Contract to be approved
		</div>
		
		<div class="search">
			<form>
				Search contract to be approved:
				<input value="Enter the search conditions.." />
				&nbsp;&nbsp;
				<input type="submit" value="Search" class="search-submit"/> <br />
			</form>
		</div>
		
		<div class="list">
		<table>
			<thead valign="middle">
	          <tr>			          	
	            <th>Contract Name</th>
	            <th>Draft Time</th>
	            <th>Operation</th>
	          </tr>
			</thead>
		        <tbody>
		          <%
		          if(flag)
		          {
						for(int i=0;i < str1.length;i++)
						{		
							out.print("<tr>");
							%>
							<td>
								<a href = "contractDetail.jsp?param1=<%=str1[i]%>"><%=str1[i]%></a>
							</td>
							<%
	
							out.print("<td>");
							out.print(str2[i]);						
							%>
							<td>
								<a href = "addSHPOpinion.jsp?param1=<%=str1[i]%>&param2=<%=str2[i]%>"> 
									<img src="images/icon-edit.png"  alt="Approve" />
									Approve 
								</a>
							</td>
							<%
							out.print("</tr>");							
						}
					}else{
						out.print("<tr>");
						out.print("<td colspan=\"3\">");						
						out.print("没有未签订的合同");
						out.print("</td>");
						out.print("</tr>");		
					}
					%>
		        </tbody>
			      </table>
			      <!-- -----
					    <tr>
						<td class="tdname">
							<a href="javascript:preview('contractDetail.jsp');">Labor Contract</a>
						</td>
						<td>
							2013-12-21
						</td>
						<td>
							<a href="addSHPOpinion.jsp">
								<img src="images/icon-edit.png"  alt="Approve" />
								Approve
							</a>
						</td>
					</tr>
					<tr>
						<td colspan="3"> </td>
					</tr>
				  </table>
		  ---- -->
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
