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
      <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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
<div id="table" class="mt10">
        <div class="box span10 oh">
         <c:if test="${user.role!=2}">
<form action="method!hetonglist" method="post">
       <div class="box">
          <div class="box_border">
            <div class="box_top">
          
             <b class="pl15">编号</b>
            <input type="text" name="bianhao"  value="${bianhao }" class="input-text lh25" size="10">
             <b class="pl15">合同名称</b>
            <input type="text" name="biaoti"  value="${biaoti }" class="input-text lh25" size="10">
             <b class="pl15">客户姓名</b>
            <input type="text" name="truename"  value="${truename }" class="input-text lh25" size="10">
            <input type="submit" class="btn btn82 btn_search" value="查询">   
            </div>
          </div>
        </div>
        </form>
        </c:if>
     <div id="table" class="mt10">
        <div class="box span10 oh">
         
        
         <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                  
                  <tr>
                   <th width="100%" align="left">合同列表</th>
                    </tr>
                    </table>
                   
                    
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="10%">合同编号</th>
                   <th width="10%">合同名称</th>
                   <th width="10%">状态属性</th>
                   <th width="10%">客户姓名</th>
                    <th width="10%">会签状态</th>
                   <th width="10%">操作员</th>
                   <th width="20%">添加时间</th>
                   <th width="20%">操作</th>
                    </tr>
                    
                <c:forEach items="${list}" var="bean"> 
                <tr class="tr">
                 <td>${bean.bianhao }</td>
                <td>${bean.biaoti }</td>
                <td>${bean.stauts }</td>
                 <td>${bean.user.truename }</td>
                 <td>${bean.cg }</td>
                 <td>${bean.name }</td>
                <td>${bean.createtime }</td>
                   <td>  
                   <!-- 操作员 -->
                    <c:if test="${user.role==3}">
                     <c:if test="${bean.stauts=='已起草'}">
                    <c:if test="${bean.cg=='同意'}">
                   <input type="button"  class="btn btn82 btn_config" value="定稿"   onclick="location.href='method!hetongupdate?id=${bean.id }'"/>  
                   </c:if>
                    </c:if>
                   </c:if>
                   
                    <c:if test="${user.role==3}">
                   <input type="button"  class="btn btn82 btn_del" value="删除"   onclick="location.href='method!hetongdelete?id=${bean.id }'"/>
                    </c:if>
                    
                      <!--用户 -->
                     <c:if test="${user.role==2}">
                    <c:if test="${bean.cg=='待签署'}">
                   <input type="button"  class="btn btn82 btn_config" value="会签"   onclick="location.href='method!hq_hetongupdate?id=${bean.id }'"/>  
                    </c:if>
                    <c:if test="${bean.stauts=='审批通过'}">
                      <c:if test="${bean.dg==null}">
                   <input type="button"  class="btn btn82 btn_config" value="签订"   onclick="location.href='method!qd_hetongupdate?id=${bean.id }'"/>  
                    </c:if>
                   </c:if>
                   </c:if>
                   
                     <!--用户 -->
                     <c:if test="${user.role==1}">
                    <c:if test="${bean.stauts=='已定稿'}">
                   <input type="button"  class="btn btn82 btn_config" value="审批"   onclick="location.href='method!sp_hetongupdate?id=${bean.id }'"/>  
                    </c:if>
                   </c:if>
                    
                    
                   <input type="button"  class="btn btn82 btn_count" value="详情"  onclick="location.href='method!hetongupdate3?id=${bean.id }'"> 
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
   </div>
 </body>
 </html>
  