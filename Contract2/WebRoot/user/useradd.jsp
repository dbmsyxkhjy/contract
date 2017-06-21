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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		
		
	<style type="text/css">
#regdiv {
	position: absolute;
	width: 600px;
	height: 700px;
	background-image: url(img/b2c_04.jpg);
}
</style>
   <link rel="stylesheet" href="css/common.css"/>
   <link rel="stylesheet" href="css/main.css"/>
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

<script language="javascript" type="text/javascript" src="js/jquery.min.js"></script>
      <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
function checkform()
{
	 if (document.getElementById('usernameid').value=="")
	{
		alert("用户不能为空");
		return false;
	}
	var valid=/^\w+$/;
	if(!valid.test(document.getElementById('usernameid').value)){
		alert("用户必须是数字、字母或下划线");
		return false;
	}

	if (document.getElementById('passwordid').value=="")
	{
		alert("密码不能为空");
		return false;
	}
	if (document.getElementById('passwordid').value.length<6)
	{
		alert("密码长度必须大于6位");
		return false;
	}
	if (document.getElementById('password2id').value != document.getElementById('passwordid').value)
	{
		alert("确认密码与密码不一致");
		return false;
	}	 
	if (document.getElementById('truenameid').value=="")
	{
		alert("真实姓名不能为空");
		return false;
	}

   if(document.getElementById('telephoneid').value==""){
    alert("电话不能为空");
    return false;
   }	
   if(document.getElementById('telephoneid').value.length!=11){
    alert("电话必须为11位 ");
    return false;
   }
   if(document.getElementById('jiguanid').value==""){
    alert("籍贯不能为空");
    return false;
   }	
	if(document.getElementById('addressid').value==""){
    alert("地址不能为空 ");
    return false;
   }	
   if(document.getElementById('ageid').value==""){
    alert("年龄不能为空 ");
    return false;
   }
   if(document.getElementById('ageid').value.length!=2){
    alert("年龄必须为0-100间的整数  ");
    return false;
   }  
	
	 
	
	
	return true;
	
}
</script>
</head>


	<body>
<form action="method!useradd2" method="post" onsubmit="return checkform()" >
    <div id="regdiv">
         <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">添加用户信息</b></div>
            <div class="box_center">
              
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 
                
                <tr>
                  <td class="td_right">用户名:</td>
                  <td class=""> 
                    <input type="text" name="username"  id="usernameid" class="input-text lh30" size="40"/>
                  </td>
                 </tr>
                <tr>
                  <td class="td_right">密码:</td>
                  <td><input type="password" name="password"  id="passwordid" class="input-text lh30" size="40"/></td>
                </tr>
                <tr>
                  <td class="td_right">姓名:</td>
                  <td><input type="text" name="truename"  id="truenameid" class="input-text lh30" size="40"/></td>
                </tr>
               
             
                <tr>
                  <td class="td_right">手机号:</td>
                  <td><input type="text" name="telephone"  id="telephoneid" class="input-text lh30" size="40"/></td>
                </tr>
                <tr>
                  <td class="td_right">籍贯:</td>
                  <td><input type="text" name="jiguan"  id="jiguanid" class="input-text lh30" size="40"/></td>
                </tr>
                <tr>
                  <td class="td_right">家庭地址:</td>
                  <td><input type="text" name="address" id="addressid" class="input-text lh30" size="40"/></td>
                </tr>
                <tr>
                  <td class="td_right">年龄:</td>
                  <td><input type="text" name="age"  id="ageid" class="input-text lh30" size="40"/></td>
                </tr>
               
                <tr>
                  <td class="td_right">性别:</td>
                  <td class="">
 
                    <span class="fl">
                      <div class="select_border"> 
                        <div class="select_containers "> 
                        <select  name="xingbie" id="xingbieid" class="select"> 
                         <option value="男">男</option>
                         <option value="女">女</option>
                        </select> 
                        </div> 
                      </div> 
                    </span>
                  </td>
                 </tr>
                 
                
                 
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" class="btn btn82 btn_save2" value="保存" onclick="checkregisterform()"/>
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
