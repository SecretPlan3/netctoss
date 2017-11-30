<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" >

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

    <link rel="stylesheet" href="<%=basePath%>static/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>static/css/admin.css">
    <!--引入自定义样式-->
    <link rel="stylesheet" href="<%=basePath%>static/css/custom.css">
    <%-- <script src="<%=basePath%>static/js/jquery.min.js"></script> --%>
    <script src="<%=basePath%>static/js/app.js"></script>

    <!--日历插件-->
    <script src="<%=basePath%>static/js/amazeui.min.js"></script>
    <script src="<%=basePath%>static/js/amazeui.datatables.min.js"></script>
    <script src="<%=basePath%>static/js/dataTables.responsive.min.js"></script>
    <script src="<%=basePath%>static/js/app.js"></script>
    
    <!-- jquery 和 json 的js -->
    <script src="<%=basePath%>static/js/jquery-3.2.1.min.js" charset="utf-8"></script>
	<script  src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
    
    <style>
        .header{
            width: 100%;
            height: 80px;
           /* border: red solid 1px;*/
        }
        .header h1{
            text-align: center;
            line-height: 80px;
        }
    </style>
</head>

<body>
  		<div class="header">
            <h1>欢迎来到账务查询！</h1>
       </div>
       
	 <!--模糊查询-->
	<form id = "form0" action="<%=basePath %>billtime/findAll"  method="POST">
   
       <div class="search">
           <ul class="am-nav am-nav-pills am-topbar-nav ">
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">  账务账号编号：</button>
                   </p>
                   <p class="ycfg">
                   		<input type="text" class="am-form-field am-input-sm" placeholder="账务账号编号" id="id" name="id"/>
                   </p>
               </li>
            
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">     身份证号：</button>
                   </p>
                   <p class="ycfg">
                   		<input type="text" class="am-form-field am-input-sm" placeholder="身份证号" id="idcard" name="idcard"/>
                   </p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">   用户姓名：</button>
                   </p>
                   <p class="ycfg">
                   		<input type="text" class="am-form-field am-input-sm" placeholder="   用户姓名"  id="username" name="username"/>
                   </p>
               </li>
       
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">  账号：</button>
                   </p>
                   <p class="ycfg">
                   		<input type="text" class="am-form-field am-input-sm" placeholder="账号" id="loginname" name="loginname"//>
                   </p>
               </li>
            
               <li class="soso">
                   <p><button onclick = "search()" class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
               </li>
            </ul>
       </div>
        <!--模糊查询表单数据-->
        
<!--    账务账号编号：	<input type="text" id="id" name="id"/> 
   身份证号：	<input type="text" id="idcard" name="idcard"/> 
   用户姓名：	<input type="text" id="username" name="username"/> 
   账号：		<input type="text" id="loginname" name="loginname"/>  
    <input type="submit"  value="查询"/><br/> -->
</form>

<!-- 表格描述部分 -->
     <div class="listbiaoti am-cf ">
           <ul class="am-icon-flag on">
           <li>  账务账单 </li>  
           </ul>
           <dl class="am-icon-home" style="float: right;">
           <dd> 当前位置： 首页 &gt;</dd>
           </dl>
       </div>
       
<!-- <table id = "table0" border="1px">
<thead>
	<tr>
		<th>账务账单编号</th>
		<th>账务账号</th>
		<th>用户姓名</th>
		<th>身份证</th>
		<th>（拥有实验室数量）</th>
	</tr>
</thead>
<tbody></tbody>
</table> -->
<form class="am-form am-g">
           <table id = "table0" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
               <thead>
               <tr class="am-success">
                   <th class="table-title">账务账单编号</th>
                   <th class="table-title">账务账号</th>
                   <th class="table-title">用户姓名</th>
                   <th class="table-title">身份证</th>
                   <th class="table-title">（拥有实验室数量）</th>
                   <th class="table-set" width="125px">操作</th>
               </tr>
               </thead>
               <tbody></tbody>
           </table>
  		<div class="am-btn-group am-btn-group-xs am-fl">
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 删除</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 上架</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 下架</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 移动</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
           </div>
           <ul class="am-pagination " style="text-align: right">
               <li class="am-disabled"><a href="javascript:first();">«</a></li>
               <li class="am-active"><a href="javascript:pre()"><</a></li>
               <li><a href="#">跳转</a></li>
               <li>
               	<input type="text" class="am-form-field am-input-sm" placeholder="转到" id="page" name="page"/>
               </li>
               <li><a href="javascript:next()">></a></li>
               <li><a href="javascript:end()">»</a></li>
           </ul>
           <hr>
</form>
</body>
<script type="text/javascript">

	//定义全局变量
	
	//pagerBean相关的属性
	var page = 1;
	var rows = 5;
	var totalRows = 0;
	var totalPage = 0;
	
	//查询条件相关的属性
	var id = "";
	var idcard = "";
	var username = "";
	var loginname = "";
	
	//查询条件
	var params = {};
	

	//页面加载完组件后，直接执行的内容
	$(function(){
		showData();	
	});
	
	// 分页查询显示表格数据的方法
	function showData(){
		var url = "billtime/findAll";
		$.ajax({
			type : "POST",
			url : url,
			async : true,
			data : {
				page:page,
				rows:rows,
				params:params
			},
			success : function(msg) {
				alert("成功返回");
				var s = "";
				var datas = msg.datas;
				for ( var obj in datas) {
					s 
					+= "<tr><td class='am-text-center'>"
					+obj.id+"</td> <td>"
					+obj.loginName+"</td><td>"
					+obj.userName+"</td><td>"
					+obj.idcard+"</td><td></td> </tr>"
				}
				$("#table0 tbody").html(s);
			}
		});
	}
	
	function search(){
		/*param中数据的形式为键值对存放的条件,如：
		{
			idcard:idcard,
			username:username,
			loginname:loginname
		}; */
		params = $("#form0").serialize();	//获取查询条件键值对
		showData();	//调用显示数据函数，ajax刷新页面
	}
	
	
	//翻页按钮 绑定监听事件
	function jump(){
		var input = $("#page").val();
		var inputPage = parseInt(input);
		if(isNaN(inputPage)){
			alert("请输入范围内的页数：(1~" + totalPage + ")");
		}else{
			if( inputPage > 0 && inputPage <= totalPage ){
				if(page != inputPage){//若页数相同 则不进行跳转
					page = inputPage;
					showData();
				}
			}else{
				alert("页数(" + inputPage + ")超出范围!\n请输入范围内的页数：1~" + totalPage ) ;
			}
		}
		 $("#page").val("");
		
	}
	
	function first(){
		if(page != 1){
			page = 1;
			showData();
		}
	}
	
	function pre(){
		if(page > 1){
			page = page-1;
			showData();
		}
	}
	
	function next(){
		if(page < totalPage){
			page = page+1;
			showData();
		}
	};
	
	function end(){
		if(page != totalPage){
			page = totalPage;
			showData();
		}
		
	}
	
</script>

</html>