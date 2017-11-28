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
<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>sys/role/role.js"></script>
</head>
<body>
	<!-- 工具栏 -->
	<div id="toolbar">
		<a href="javascript:addUser();" class="easyui-linkbutton" plain="true" iconCls="icon-add">添加</a>
		<a href="javascript:updateUser();" class="easyui-linkbutton" plain="true" iconCls="icon-save">保存</a>
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit">修改</a>
		<a href="javascript:deleteUser();" class="easyui-linkbutton" plain="true" iconCls="icon-remove">删除</a>
		<input id="ss" class="easyui-searchbox" style="width:150px" data-options="searcher:searcherKey,prompt:'角色查询'"></input>
	</div>
	<!-- 数据网格 -->
    <table id="dg"></table>
</body>
</html>