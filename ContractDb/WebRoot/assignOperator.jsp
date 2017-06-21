<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Assign operator</title>
    
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
		<script type="text/javascript">
			function moveOption(s1,s2){
				// Cteate cache array to store value and text
				var arrSelValue = new Array();  
				var arrSelText = new Array();  
				// This array stores the selected options, corresponding to value
				var arrValueTextRelation = new Array();  
				var index = 0;// Assist to establish the cache array
				  
				// Store all data in the source list to the cache, and establish the corresponding relationship of value and selected option 
			   for ( var i = 0; i < s1.options.length; i++) {  
					if (s1.options[i].selected) {  
						arrSelValue[index] = s1.options[i].value;  
						arrSelText[index] = s1.options[i].text;  
						// Build the corresponding relationship of value and selected option
						arrValueTextRelation[arrSelValue[index]] = s1.options[i];  
						index++;  
					}  
				}  
		  
				// Increase cache data to purpose list, and delete the corresponding item in source list  
				for ( var i = 0; i < arrSelText.length; i++) {  
					var oOption = document.createElement("option");  
					oOption.text = arrSelText[i];  
					oOption.value = arrSelValue[i];  
					s2.add(oOption);
					s2.options[i].selected=true;  
					// Delete the corresponding item in source list
					s1.removeChild(arrValueTextRelation[arrSelValue[i]]);  
				} 
			}
			
			//Judgment whether user has assigned operator, if does not assign, giving prompt message; Or submit form to assign operator
			function check(){
				// Build cache array to store assigned operator
      		   	var assignedOperator = new Array(3); 
				assignedOperator[0] = document.assignOperForm.hqht;
				assignedOperator[1] = document.assignOperForm.spht;
				assignedOperator[2] = document.assignOperForm.qdht;

				// If there is no assigned operator, giving a prompt message
				if((assignedOperator[0].length) < 1){
					alert("Please assign countersign people!");
					return false;
				} 
				
				if((assignedOperator[1].length) < 1){
					alert("Please assign approver!");
					return false;
				} 
				
				if((assignedOperator[2].length) < 1){
					alert("Please assign signer!");
					return false;
				} 
			}
		</script>
	</head>

	<body>
		<div class="mtitle">
			Assign operator: Labor Contract
		</div>
		
		<br />
		<form method="post" name="assignOperForm" action="">
			<h3>
				<img src="images/cog_edit.png"  alt="Assign countersign people" />
				Assign countersign operator
			</h3>
			<table border="0" width="400" class="update"> 
				<tr>
					<td width="45%"> 
						operator to be assigned: 
						<select style="WIDTH:100%" multiple name="dfphqht" size="12"> 
							<option value="U1">jack</option> 
							<option value="U2">lily</option> 
							<option value="U3">lucy</option> 
							<option value="U4">tamara</option> 
							<option value="U5">Angelia</option> 
							<option value="U6">michelle</option> 
						</select> 
					</td> 
					<td width="10%" align="center"> 
						<input type="button" value="&gt&gt" 
					onclick="moveOption(document.assignOperForm.dfphqht, document.assignOperForm.hqht)">
						<br/> <br/> 
						<input type="button" value="&lt&lt" 
					onclick="moveOption(document.assignOperForm.hqht, document.assignOperForm.dfphqht)"> 
					</td> 
					<td width="45%"> 
						assigned operator:
						<select style="WIDTH:100%" multiple name="hqht" size="12"> 
						</select> 
					</td> 
				</tr> 				
			</table> 
			<br />
			<h3>
				<img src="images/cog_edit.png"  alt="Assign approver" />
				Assign approver
			</h3>
			<table border="0" width="400"  class="update"> 
				<tr>
					<td width="45%"> 
						operator to be assigned: 
						<select style="WIDTH:100%" multiple name="dfpspht" size="12"> 
							<option value="U1">jack</option> 
							<option value="U2">lily</option> 
							<option value="U3">lucy</option> 
							<option value="U4">tamara</option> 
							<option value="U5">Angelia</option> 
							<option value="U6">michelle</option> 
						</select> 
					</td> 
					<td width="10%" align="center"> 
						<input type="button" value="&gt&gt" 
					onclick="moveOption(document.assignOperForm.dfpspht, document.assignOperForm.spht)">
						<br/> <br/> 
						<input type="button" value="&lt&lt" 
					onclick="moveOption(document.assignOperForm.spht, document.assignOperForm.dfpspht)"> 
					</td> 
					<td width="45%"> 
						assigned operator:
						<select style="WIDTH:100%" multiple name="spht" size="12"> 
						</select> 
					</td> 
				</tr> 				
			</table>
			<br />
			<h3>
				<img src="images/cog_edit.png"  alt="Assign signer" />
				Assign signer
			</h3>
			<table border="2" width="400"  class="update"> 
				<tr>
					<td width="45%"> 
						operator to be assigned: 
						<select style="WIDTH:100%" multiple name="dfpqdht" size="12"> 
							<option value="U1">jack</option> 
							<option value="U2">lily</option> 
							<option value="U3">lucy</option> 
							<option value="U4">tamara</option> 
							<option value="U5">Angelia</option> 
							<option value="U6">michelle</option> 
						</select> 
					</td> 
					<td width="10%" align="center"> 
						<input type="button" value="&gt&gt" 
					onclick="moveOption(document.assignOperForm.dfpqdht, document.assignOperForm.qdht)">
						<br/> <br/> 
						<input type="button" value="&lt&lt" 
					onclick="moveOption(document.assignOperForm.qdht, document.assignOperForm.dfpqdht)"> 
					</td> 
					<td width="45%"> 
						assigned operator:
						<select style="WIDTH:100%" multiple name="qdht" size="12"> 
						</select> 
					</td> 
				</tr> 				
			</table>
			<table width="400" class="update"> 
				<tr>
					<td colspan="2" style="text-align:center;">
				<input type="submit" value="Submit" class="button" onclick="return check()"> &nbsp; &nbsp; &nbsp; 
				<input type="reset" value="Reset" class="button">
				</td>
				</tr>
			</table>
			<br/>
		</form> 
	</body>
</html>
