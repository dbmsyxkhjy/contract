<%@ page language="java" import="java.util.*" import="java.sql.ResultSet" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ddghtList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>List of contract to be finalized</title>
	<link href="css/style.css" rel="stylesheet" media="screen"
			type="text/css" />
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
    String uid = (String)session.getAttribute("userId");
    ResultSet res = contractDetail.getContractLevel1(uid);
	
    boolean flag = true;
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

  
    if(res.next())
    {    
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
       
	}else{
	   flag = false;
	
  	}   	 	
%>	
	 
	<div class="mtitle">
		Contract to be finalized
	</div>
		
	<div class="search">
		<form>
			Search contract to be finalized:
			<input value="Enter the search conditions.." />
			&nbsp;&nbsp;
			<input type="submit" value="Search" class="search-submit"/> <br />
		</form>
	</div>

	<div class="list">	
	
	<table>
		<thead valign="middle">
          <tr>
			<th>
				Contract name
			</th>
			<th class="th1">
				Draft time
			</th>
			<th width="270px">
				Operation
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
						%>
						<td>
							<a href = "contractDetail.jsp?param1=<%=str1[i]%>"><%=str1[i]%></a>
						</td>
						<%

						out.print("<td>");
						out.print(str4[i]);		
						
						%>
						<td>
							<a href = "showHQOpinion.jsp?param1=<%=str1[i]%>"> 
								<img src="images/information.png"  alt="Countersign  opinion" />
					            Countersign  opinion
							</a>
						    |
							<a href = "dgContract.jsp?param1=<%=str1[i]%>&param2=<%=str2[i]%>&param3=<%=str3[i]%>&param4=<%=str4[i]%>&param5=<%=str5[i]%>"> 
								<img src="images/icon-edit.png"  alt="Finalize " />
					             Finalize 
							</a>
						</td>
						<%
						out.print("</tr>");							
					}
				}else{
					out.print("<tr>");
					out.print("<td colspan=\"3\">");						
					out.print("没有合同");
					out.print("</td>");
					out.print("</tr>");		
				}
				%>
	        </tbody>
		</table>	
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