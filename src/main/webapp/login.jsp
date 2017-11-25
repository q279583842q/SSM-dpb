<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		if(window.top != window){
			window.top.location.href = window.location;
		}
	</script>
	
	<div style="margin:20px 0;margin-top: 200px;" align="center">
		<div class="easyui-panel" title="派车管理系统" style="width:350px;">
			<div style="padding:10px 60px 20px 60px">
		    <form id="ff" method="post" action="<%=basePath %>/login">
		    	<table cellpadding="5">
		    		<tr>
		    			<td>账号:</td>
		    			<td><input class="easyui-textbox" type="text" name="username" 
		    				data-options="required:true,missingMessage:'账号不能为空!'"></input></td>
		    		</tr>
		    		<tr>
		    			<td>密码:</td>
		    			<td><input class="easyui-textbox" type="password" name="pwd" 
		    				data-options="required:true,missingMessage:'密码不能为空!'"></input></td>
		    		</tr>
		    		
		    	</table>
		    </form>
		    <div style="text-align:center;padding:5px">
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">登录</a>
		    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">取消</a>
		    </div>
		    </div>
		</div>
	</div>
	<script>
		function submitForm(){
			$('#ff').form('submit', {
			    onSubmit: function(){
					// do some check
					// return false to prevent submit;
			    },
			    success:function(data){
					//alert(data)
					if(data=='1'){
						// 跳转到home界面
						location.href='home.jsp';
					}else{
						// 登录失败 给出提示
						$.messager.alert('登录警告','账号密码错误!');
					}
			    }
			});
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>