<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if((model.User)session.getAttribute("user")==null){
	response.sendRedirect("login.jsp");
	return;
}
%>
 <!doctype html>
 <html lang="zh-CN">
 <head>
   <link rel="stylesheet" href="css/common.css">
   <link rel="stylesheet" href="css/main.css">
   <script type="text/javascript" src="js/jquery.min.js"></script>
   <script type="text/javascript" src="js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="js/common.js"></script>
   
   <script type="text/javascript">
      $(function(){  
        $(".list_table").colResizable({
          liveDrag:true,
          gripInnerHtml:"<div class='grip'></div>", 
          draggingClass:"dragging", 
          minWidth:30
        }); 
        
      }); 
   </script>
   
   <title>Document</title>
 </head>
 <body >
<div id="search_bar" class="mt10">
<form action="method!userlist" method="post">
       <div class="box">
          <div class="box_border">
            <div class="box_top">
          
             <b class="pl15">用户名</b>
            <input type="text" name="username"  value="${username }" class="input-text lh25" size="10">
             <b class="pl15">姓名</b>
             <input type="text" name="truename"  value="${truename }" class="input-text lh25" size="10">
           <input type="submit"  class="btn btn82 btn_search" value="查询">   
            </div>
          </div>
        </div>
        </form>
      </div>
 
  <div class="container">
   
    
     <div id="table" class="mt10">
        <div class="box span10 oh">
         <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                  <tr>
                   <th width="100%" align="left">用户信息列表</th>
                    </tr>
                    </table>
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
              
                <tr>
                   <th width="auto%">用户名</th>
                    <th width="auto">密码</th>
                    <th width="auto" >姓名</th>
                    <th width="auto" >手机号</th>
                    <th width="auto" >籍贯</th>
                    <th width="auto" >家庭地址</th>
                    <th width="auto" >性别</th>
                    <th width="auto" >年龄</th>
                    <th width="20%">操作</th>
                    </tr>
                    
                <c:forEach items="${list}" var="bean">
                <tr class="tr">
                    <td >${bean.username }</td>
                    <td >${bean.password }</td>
                    <td >${bean.truename }</td>
                    <td >${bean.telephone }</td>
                    <td >${bean.jiguan }</td>
                    <td >${bean.address }</td>
                    <td >${bean.xingbie }</td>
                    <td >${bean.age }</td>
                   <td>  
                    <input type="button" class="btn btn82 btn_config" value="修改" onclick="location.href='method!userupdate?id=${bean.id }'"/>
                   <input type="button"  class="btn btn82 btn_del"  value="删除"  onclick="javascript:if(confirm('确定要删除此信息吗？')){location.href='method!userdelete?id=${bean.id }';return true;}return false;"  />
                   </td>
                 </tr>
                 </c:forEach> 
              </table>
              
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="50%" align="left"> ${pagerinfo }</th>
                    </tr>
              </table>
        </div>
     </div>
    
   </div> 
   
 </body>
 </html>
  