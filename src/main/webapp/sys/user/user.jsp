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

</head>
<body>
	<div id="toolbar">
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add">添加</a>
		<a href="javascript:updateUser();" class="easyui-linkbutton" plain="true" iconCls="icon-save">保存</a>
		<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit">修改</a>
		<a href="javascript:deleteUser();" class="easyui-linkbutton" plain="true" iconCls="icon-remove">删除</a>
	</div>
    <table id="dg"></table>
    
    <script type="text/javascript">
	    var index = 0;
	    $('#dg').datagrid({
	        url:'sys/user/query',
	        fit:true,
	        loadMsg:'加载中...',
	        pagination:true,
	        rownumbers:true,
	        singleSelect:true,
	        striped:true,
	        toolbar:'#toolbar',
	        rowStyler: function(index,row){
	    		 /* if (row.id==62){
	    			return 'background-color:#6293BB;'; // return inline style
	    			// the function can return predefined css class and inline style
	    			// return {class:'r1', style:{'color:#fff'}};	
	    		}  */
	    	},
	        columns:[[
				{
					field:''
					,title:''
					,checkbox:true
				},
	    		{
	    			field:'user.id'
	    			,title:'编号'
	    			,width:100
	    		},
	    		{
	    			field:'user.username'
	    			,title:'账号'
	    			,width:100
	    			,editor:'textbox'
	    		},
	    		{
	    			field:'user.pwd'
	    			,title:'密码'
	    			,width:100
	    			,editor:'textbox'
	    		},
	    		{
	    			field:'user.realname'
	    			,title:'姓名'
	    			,width:100
	    			,align:'left'
	    			,editor:'textbox'
	    		},
	    		{
	    			field:'deptname'
	    			,title:'部门'
	    			,width:100
	    			,editor:'textbox'
	    		}
	        ]]
	    	,onDblClickRow:function(rowIndex, rowData){ // 行双击事件
	        	//alert(rowData.id+" "+rowIndex);
	    		 $('#dg').datagrid("endEdit",index);
	    		// 让当前行进入编辑状态
	    		 $('#dg').datagrid("beginEdit",rowIndex);
	    		 index = rowIndex;
	        }
	    });
    
	    // 保存修改的数据
	    function updateUser(){
	    	
	    	// 要获取修改的那行数据
	    	var row = $("#dg").datagrid("getSelected");
	    	// 获取对应的行号
	    	var rowIndex = $("#dg").datagrid("getRowIndex",row);
	    	// 关闭行
	    	$('#dg').datagrid("endEdit",rowIndex);
	    	//alert(row.id+" "+row.username+" "+rowIndex);
	    	// 将数据传递到服务端
	    	$.post("user/update"
	    		,{"username":row.username
	    		,"pwd":row.pwd
	    		,"realname":row.realname
	    		,"id":row.id}
	    		,function(msg){
	    			if(msg=='1'){
	    				$.messager.alert('提示信息','修改成功');
	    				//重新加载数据
	    				$('#dg').datagrid('reload');
	    			}
	    	});
	    }
	    
	 // 保存修改的数据
	    function deleteUser(){
	    	
	    	// 要获取修改的那行数据
	    	var row = $("#dg").datagrid("getSelected");
	    	// 获取对应的行号
	    	var rowIndex = $("#dg").datagrid("getRowIndex",row);
	    	// 关闭行
	    	$('#dg').datagrid("endEdit",rowIndex);
	    	//alert(row.id+" "+row.username+" "+rowIndex);
	    	// 将数据传递到服务端
	    	$.post("user/delete"
	    		,{"id":row.id}
	    		,function(msg){
	    			if(msg=='1'){
	    				$.messager.alert('提示信息','删除成功');
	    				//重新加载数据
	    				$('#dg').datagrid('reload');
	    			}
	    	});
	    }
	    
    </script>
</body>
</html>