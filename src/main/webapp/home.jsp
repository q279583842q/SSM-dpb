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
	<style type="text/css">
		ul.nav li{
			float:right;
			list-style: none;
			margin-left: 10px;
			line-height: 40px;
		}
	</style>
</head>
<body class="easyui-layout">
	<!-- 上 -->
    <div data-options="region:'north',split:true,border:true" style="height:60px;">
    	<div id="header">
			<div class="headerNav" style="padding-right: 20px;">
				
				<ul class="nav">
					
					<li><a href="<%=basePath %>logout">退出</a></li>
					<li>欢迎 <font color='red'>${user.realname }</font>光临</li>
				</ul>
				
			</div>

			<!-- navMenu -->

		</div>
    </div>
    <!-- 左侧 -->
   <div data-options="region:'west',title:'导航',split:true" style="width:150px;">
   			<ul id="tt" class="easyui-tree">
			    
			</ul>
    </div>
    <!-- 右侧 -->
    <div data-options="region:'east',title:'公告栏',split:true" style="width:100px;">
    
    </div>
    <!-- 居中 -->
    <div data-options="region:'center'" style="padding:0px;background:#eee;">
    	<div id="tabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true,border:false">
		    <div title="首页" style="padding:20px;display:none;" data-options="closable:false,fit:true">
				欢迎光临
		    </div>
		    
		</div>
    </div>
    <!-- 下 -->
     <div data-options="region:'south',title:'',split:true" style="height:0px;">
    	
    </div>
    <script type="text/javascript">
    	function addUserTab(){
    		$('#tabs').tabs('add',{
    		    title:'用户管理',
    		    content:'<iframe scrolling="auto" frameborder="0" src="user.jsp" height="100%" width="100%"></iframe>',
    		    closable:true
    		});
    	}
    	$(function(){
    		$("#tt").tree({
        		url:"<%=basePath%>getTreeNode",
        		onClick: function(node){
        			if(node.url != null){
        				//window.location.href=<%=basePath%>+node.url;
        				// 打开一个新的窗口
        				$('#tabs').tabs('add',{
        				    title:node.text,
        				    content:'<iframe src="<%=basePath%>'+node.url+'" width="99.5%" height="99%"></iframe>',
        				    closable:true
        				});
        			}
        			//alert(node.url);  // alert node text property when clicked
        		}
        	});
    	});
    	
    </script>
    
</body>
</html>