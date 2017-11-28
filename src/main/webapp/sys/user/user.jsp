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
<base href="<%=basePath%>">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>	
	<script type="text/javascript" src="<%=basePath%>sys/user/user.js"></script>
<style type="text/css">
	#addForm td{
	   padding: 10px;
	}
</style>
</head>
<body>
	<!-- 工具栏 -->
	<div id="toolbar">
		<a href="javascript:addUser();" class="easyui-linkbutton" plain="true" iconCls="icon-add">添加</a>
		<a href="javascript:updateUser();" class="easyui-linkbutton" plain="true" iconCls="icon-save">保存</a>
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit">分配角色</a>
		<a href="javascript:deleteUser();" class="easyui-linkbutton" plain="true" iconCls="icon-remove">删除</a>
		<input id="ss" class="easyui-searchbox" style="width:150px" data-options="searcher:searcherKey,prompt:'账号姓名查询'"></input>
        
	</div>
	<!-- 数据网格 -->
    <table id="dg"></table>
    
    <!---------------------------------- 添加用户界面窗口------------------------------------------>
    <div id="addWin" class="easyui-window" data-options="shadow:true,modal:true" title="添加用户" icon="icon-help" 
    	style="width:650px;height:300px;padding:10px;background: #fafafa;">
		<div class="easyui-layout" fit="true">
			
			<div region="center" border="false"  >
				<form id="addForm" method="post" action="<%=basePath%>sys/user/save">
					<!-- 边框变细 border-collapse:collapse; -->
					<table border="1" cellspacing="0" bordercolor="#95B8E7" width="100%" style="border-collapse:collapse;">
			    	<tr>
			    		<td>账号:</td><td><input class="easyui-validatebox" type="text" name="username" data-options="required:true" /></td>
			    		<td>密码:</td><td><input class="easyui-validatebox" type="password" name="pwd" data-options="required:true" /></td>
			    	</tr>
			    	<tr>
			    		<td>姓名:</td><td><input class="easyui-validatebox" type="text" name="realname" /></td>
			    		<td>性别:</td><td>
			    						<select id="cc" class="easyui-combobox" data-options="panelHeight:'auto'" 
			    						name="sex" style="width:150px;">
										    <option value="男">男</option>
										    <option value="女">女</option>
										</select>
			    					</td>
			    	</tr>
			    	<tr>
			    		<td>电话:</td><td><input class="easyui-validatebox"  type="text" name="phone" /></td>
			    		<td>部门:</td><td><input id="dept" name="depid" style="width:150px;" data-options="panelHeight:'auto'" ></td>
			    	</tr>
			    	<tr>
			    		<td>分配角色:</td><td colspan="3">
			    			<input class="easyui-combobox" 
								name="roles" style="width:300px;"
								data-options="
										url:'sys/role/queryAll',
										method:'get',
										valueField:'id',
										textField:'rolename',
										multiple:true,
										multiline:true,
										panelHeight:'auto'
								">
			    		</td>
			    	</tr>
			    	
			    	</table>
			</form>
			</div>
			<div region="south" border="false" style="text-align:right;height:30px;line-height:30px;">
				<a class="easyui-linkbutton" icon="icon-save" href="javascript:saveUser();">保存</a>
				<a class="easyui-linkbutton" icon="icon-cancel" href="javascript:closeWin();">取消</a>
			</div>
		</div>
	</div>
</body>
</html>