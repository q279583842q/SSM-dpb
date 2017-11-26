var index = 0;
$(function(){
	// 关闭相关窗口
	$('#addWin').window('close');
	// 获取所有的部门信息
	$('#dept').combobox({
	    url:'sys/dept/queryAll',
	    valueField:'id',
	    textField:'name'
	});
	
	$('#dg').datagrid({
        url:'sys/user/query',
        fit:true,
        loadMsg:'加载中...',
        pagination:true,
        sortName:'id',
        sortOrder:'asc',
        pageSize: 5,//每页显示的记录条数，默认为10 
		pageList: [5, 10,20,50, 100],//可以设置每页记录条数的列表 
        rownumbers:true,
        fitColumns:true,
        singleSelect:true,
        idField:'id',
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
			 {	field:'',title:'',checkbox:true}
    		,{  field:'id',title:'编号',width:100}
    		,{	field:'username',title:'账号',width:100,editor:'textbox'}
    		,{	field:'pwd',title:'密码',width:100,editor:'textbox'}
    		,{	field:'realname',title:'姓名',width:100,align:'left',editor:'textbox'}
    		,{	field:'sex',title:'性别',width:100,align:'left',editor:{
																		type:'combobox',
																		panelHeight:'auto',
																		options:{
																			valueField:'id',
																			textField:'name',
																			method:'get',
																			url:'sys/user/sex.json',
																			required:true
																			}
																		}
    			
    		 }
    		,{	field:'phone',title:'电话',width:100,align:'left',editor:'textbox'}
    		,{	field:'deptName',title:'部门',width:100,editor:{
																type:'combobox',
																panelHeight:'auto',
																options:{
																	valueField:'id',
																	textField:'name',
																	method:'get',
																	url:'sys/dept/queryAll',
																	required:true
																}
															}
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

    // 自定义分页提示信息
    $('#dg').datagrid('getPager').pagination({
		beforePageText: '第',//页数文本框前显示的汉字 
		afterPageText: '页 共 {pages} 页',
		displayMsg: '当前显示 {from} - {to} 条记录 共 {total} 条记录',
		//onBeforeRefresh: function (pageNumber, pageSize) {
		// $(this).pagination('loading');
		// alert('before refresh');
		// $(this).pagination('loaded');
		//}
	});
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
	$.post("sys/user/update"
		,{"username":row.username
			,"pwd":row.pwd
			,"realname":row.realname
			,"sex":row.sex
			,"phone":row.phone
			,"depid":row.depid
			,"id":row.id
		}
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
	 $.messager.confirm("确认", "确定要删除吗？", function (r) {
	        if (r) {
	        	// 要获取修改的那行数据
	    		var row = $("#dg").datagrid("getSelected");
	    		// 获取对应的行号
	    		var rowIndex = $("#dg").datagrid("getRowIndex",row);
	    		// 关闭行
	    		$('#dg').datagrid("endEdit",rowIndex);
	    		//alert(row.id+" "+row.username+" "+rowIndex);
	    		// 将数据传递到服务端
	    		$.post("sys/user/delete"
	    			,{"id":row.id}
	    			,function(msg){
	    				if(msg=='1'){
	    					$.messager.alert('提示信息','删除成功');
	    					//重新加载数据
	    					$('#dg').datagrid('reload');
	    				}
	    		});
	    	}
	        
	    });
		
	
}

// 点击添加按钮打开添加界面
function addUser(){
	$('#addWin').window('open');
}

//根据账号姓名搜索
function searcherKey(value,name){
        	//alert(value+":"+name)
    		$('#dg').datagrid('load',{
    			searchMsg: value
    		});
        }
// 关闭添加窗口    	
function closeWin(){
	$('#addForm').form("clear"); // 清空表单
	$('#addWin').window('close');
}
// 保存添加的数据
function saveUser(){
	$('#addForm').form('submit', {
	    onSubmit: function(){
			// do some check
			// return false to prevent submit;
	    },
	    success:function(data){
			//alert(data)
			if(data=='1'){
				$.messager.alert('提示信息','数据添加成功');
				closeWin();
				//重新加载数据
				$('#dg').datagrid('reload');
			}else{
				// 登录失败 给出提示
				$.messager.alert('警告','数据有误，核对后再录入!');
			}
	    }
	});
}

//confirm 
function Confirm(msg) {
    $.messager.confirm("确认", msg, function (r) {
        if (r==1) {
            return true;
        }
    });
    return false;
}

