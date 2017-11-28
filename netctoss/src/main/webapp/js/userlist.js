$(function(){
	
	$('#tt').datagrid({
		url:'User/page',
		method:'GET',
		loadMsg:'玩命的加载中……',
		queryParams:queryParams()
	});
	
	
	function queryParams(){
		var name = $('#name').val();
		var pwd = $('#pwd').val();
		
		var datas = {name:name,pwd:pwd};
		return datas;
	}
	
	
	
	
	
	
	
	
	
	$('#add').bind('click', function(){   
    	$('#user-save-dialog').dialog('open');//打开窗体
    	$('#user-add-form').form('clear');//清除表单缓存
    });
	$('#cancel-save-btn').bind('click', function(){   
    	$('#user-add-form').form('clear');//清除表单缓存
    	$('#user-save-dialog').dialog('close');//关闭窗体
    });
	//条件查询就OK
    $('#query').bind('click', function(){   
    	$('#tt').datagrid('load',queryParams());
    }); 
	
   
	
});