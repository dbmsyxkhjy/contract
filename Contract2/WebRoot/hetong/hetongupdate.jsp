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
      
       <script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        <script type="text/javascript" src="<%=path %>/js/popup.js"></script>
      
      
      
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
    <script type="text/javascript">
	   function up()
		    {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
	            pop.setContent("contentUrl","<%=path %>/upload/upload.jsp");
	            pop.setContent("title","文件上传");
	            pop.build();
	            pop.show();
	            //另一红上传方式可以参照进销存
		    }
	</script>
  <script language="javascript" type="text/javascript">
function checkform()
{
	 
	 if (document.getElementById('biaotiid').value=="")
	{
		alert("合同名称不能为空");
		return false;
	}
	if (document.getElementById('contentid').value=="")
	{
		alert("内容不能为空");
		return false;
	}
    if (document.getElementById('uid').value=="")
	{
		alert("客户不能为空");
		return false;
	}
	 if (document.getElementById('riqid').value=="")
	{
		alert("开始时间不能为空");
		return false;
	}
	if (document.getElementById('fujianYuanshiming').value=="")
	{
		alert("附件不能为空");
		return false;
	}
	
	return true;
	
}
</script>
   
   <title></title>
 </head>
 <body>
  <form action="method!hetongupdate2" method="post"  >
<input type="hidden" name="id" value="${bean.id }"/>
  
  <div class="container">
    
     <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">合同修改</b></div>
            <div class="box_center">
             
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">

                 <tr>
                  <td class="td_right">合同名称:</td>
                  <td class="">
                  <input type="text" name="biaoti" id="biaotiid" value="${bean.biaoti }" class="input-text lh30" size="40">
                  </td>
                 </tr>
                 
                 <tr>
                  <td class="td_right">内容:</td>
                  <td class="">
                     <textarea class="textarea" name="content" id="contentid"  rows="5" cols="30">${bean.content }</textarea>
                  </td>
                 </tr>
                 
                 
                 
                <tr>
                  <td class="td_right">客户:</td>
                  <td><input type="text" name="bianhao" id="biaotiid" value="${bean.user.truename }" class="input-text lh30" size="40" readonly="readonly"/></td>
                </tr>
                 
                 
                  <tr>
                  <td class="td_right">开始时间:</td>
                  <td class="">
                  <input type="text" name="riq" id="riqid" value="${bean.riq }" class="input-text lh30" size="40" onfocus="WdatePicker({isShowWeek:true})"><img onclick="WdatePicker({el:'d12'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
                  </td>
                 </tr>
                 
                   <tr>
                  <td class="td_right">结束时间:</td>
                  <td class="">
                  <input type="text" name="endriq" id="endriqid" value="${bean.endriq }" class="input-text lh30" size="40" onfocus="WdatePicker({isShowWeek:true})"><img onclick="WdatePicker({el:'d12'})" src="js/My97DatePicker/skin/datePicker.gif" width="16" height="22" align="absmiddle">
                  </td>
                 </tr>
                 
                 
                
                 
                 
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" name="submit" class="btn btn82 btn_save2" value="保存"> 
                    <input type="reset"  class="btn btn82 btn_res" value="重置"> 
                   </td>
                 </tr>
               </table>
               
            </div>
          </div>
        </div>
     </div>
   </div> 
   </form>
 </body>
 </html>
  