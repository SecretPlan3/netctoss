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
     <!-- 网站地图 -->
	<div class="listbiaoti am-cf "  ><!-- style="display:inline" -->
		<ul class="am-icon-flag on">账务查询</ul>
		<dl class="am-icon-home" style="float: right;">当前位置： 首页 &gt;&nbsp;<a href="<%=basePath%>jsp/billtime/billtimemain.jsp">账务查询</a> &gt;&nbsp;<a href="<%=basePath%>jsp/billtime/billtimeDetailMonthly.jsp">开放实验室使用时长信息</a></dl>
	</div>
	
	<!-- 页面标题 --> 
  		<div class="header">
            <h1>开放实验室使用时长信息</h1>
       </div>
             
	 <!--模糊查询-->
	<form id = "form0" method="POST">
       <div class="search">
           <ul class="am-nav am-nav-pills am-topbar-nav ">
               <li class="soso"> 
               		<p><button class="am-btn am-btn-xs am-btn-default am-xiao">账务账号：</button></p>
                   	<p class="ycfg"><input readonly type="text" class="am-form-field am-input-sm"  id="loginName" name="loginName"/></p></li>    
               <li class="soso">
               		<p><button class="am-btn am-btn-xs am-btn-default am-xiao">用户姓名：</button></p>
                   	<p class="ycfg"><input readonly  type="text" class="am-form-field am-input-sm"  id="userName" name="userName"/></p> </li>

              <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">年份</button>
                   </p>
                   <p>
                       <select data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}">
                           <option value="1">2013</option>
                           <option value="2">2014</option>
                           <option value="3">2015</option>
                           <option value="4">2016</option>
                           <option value="5">2017</option>
                       </select>
                   </p>
                </li>
              <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">月份</button>
                   </p>
                   <p>
                       <select data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}">
                           <option value="1">1</option>
                           <option value="2">2</option>
                           <option value="3">3</option>
                           <option value="4">4</option>
                           <option value="5">5</option>
                       </select>
                   </p>
                </li>
          
               <li class="soso">
               		<p><button type="button" onclick = "search()" class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p></li>
            </ul>
       </div>
        <!--/模糊查询-->
        
	</form>

	<form class="am-form am-g">
 			<!-- 主表格 -->  
           <table id = "table0" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
               <thead>
               <tr class="am-success">
               		<input type="hidden" id = "chosenId">
                   <th class="table-title">服务器编号</th>
                   <th class="table-title">服务器信息</th>
                   <th class="table-title">年总时长</th>
                   <th class="table-title">1月总时长</th>
                   <th class="table-title">2月总时长</th>
                   <th class="table-title">3月总时长</th>
                   <th class="table-title">4月总时长</th>
                   <th class="table-title">5月总时长</th>
                   <th class="table-title">6月总时长</th>
                   <th class="table-title">7月总时长</th>
                   <th class="table-title">8月总时长</th>
                   <th class="table-title">9月总时长</th>
                   <th class="table-title">10月总时长</th>
                   <th class="table-title">11月总时长</th>
                   <th class="table-title">12月总时长</th>
                   <th class="table-set" width="125px">详细</th>
               </tr>
               </thead>
               <tbody></tbody>
           </table>
            <!-- 主表格 -->  
           
          <!-- 功能按钮组div-->
  		<div class="am-btn-group am-btn-group-xs am-fl">
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 删除</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 上架</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 下架</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 移动</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
           </div>
           <!-- 翻页按钮组 ul-->
           <ul class="am-pagination " style="text-align: right">
               <li  onclick ="first()"><a href="javascript:void(0)">«</a></li>
               <li  onclick ="pre()" ><a href="javascript:void(0)"> < </a></li>
               <li  onclick ="jump()"><a href="javascript:void(0)">跳转</a></li>
               <li >
               	<input type="text" class="am-input-sm" placeholder="转到" id="page" name="page"/>
               </li>
               <li onclick ="next()"><a href="javascript:void(0)" >></a></li>
               <li onclick ="end()"><a href="javascript:void(0)" >»</a></li>
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
	
	//查询条件
	var params = {};
	

	//页面加载完组件后，直接执行的内容
	$(function(){
		$("#userId").val("");
		showData();	
	});
	
	// 分页查询显示表格数据的方法
	function showData(){
		var url = "billtime/findMonthly";
		$.ajax({
			type : "POST",
			url : url,
			async : true,
			data : {
				"page":page,
				"rows":rows,
				"params":params,
			},
			success : function(msg) {
				//alert("成功返回");
				//处理返回数据，给全局变量赋值等
				page = msg.page;
				rows = msg.rows;
				totalRows = msg.totalRows;
				totalPage = msg.totalPage;
				var datas = msg.datas;

				var s = "";
				for (var i = 0; i < datas.length; i++) {
					s+= "<tr value="+datas[i].id+"><td class='am-text-center'>"
					+datas[i].id+"</td>" + "<td class='am-text-center'>"
					+datas[i].osName+"</td>";
					var y = datas[i].serviceYear;
					for ( var j = 0; j < y.length; j++ ) {
						s+="<td>"+y[j].onlineTime +"</td> ";
						var m = y[j].serviceMonthly;
						for ( var k = 0; k < m.length; k++) {
							var time = timeLongToString(m[k].onlineTime);
							s+="<td>"+ time +"</td> ";
						}
					}
					s+="</tr>";
				}
				$("#table0 tbody").html(s);
				$("#loginName").val(datas[0].user.loginName);
				$("#userName").val(datas[0].user.userName);
				
				
				//给每行添加点击事件
			 	//绑定事件******************************************************
					$("tr").each(function(i,val){ 
						if(i != 0){//第一行不绑定
							$(this).on("click",function(){
								var value = $(this).attr("value");
								$("#chosenId").attr("value",value);//给隐藏的表单元素 赋值 当前行对应的ID
								alert($("#chosenId").attr("value"));
								window.location.href="jsp/billtime/billtimeDetailDaily.jsp" + "?id="+ value ;
							})  
						}
						
					})
			//***************************************************************
				
			}
		});
	}
	
	
	//long 转String 
	function timeLongToString(longTime){	
		var s =  longTime / 1000; //总秒数
		var hs = parseInt(s /3600); //小时数
		var mins =  parseInt((s - hs * 3600) / 60) ; //分钟数
		var ss =  parseInt((s -  hs * 3600 - mins * 60)); //秒数 
		var time = "" + hs + ":" + mins +  ":" + ss;
		return time;
	}
	
	//查询函数 ---查询按钮点击事件
	function search(){
		/*param 中d的条件数据的形式为键值对存放的json对象,如：*/
		params = {
			idcard:$("#idcard").val(),
			userName:$("#userName").val(),
			loginName:$("#loginName").val()
		}; 
		showData();	//调用显示数据函数，ajax刷新页面
	}

	//翻页按钮 绑定的监听事件 ++++++++++++++++++++++++++
	//跳转
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
	//首页
	function first(){
		if(page != 1){
			page = 1;
			showData();
		}
	}
	//上一页
	function pre(){
		if(page > 1){
			page = page-1;
			showData();
		}
	}
	//下一页
	function next(){
		if(page < totalPage){
			page = page+1;
			showData();
		}
	};
	//尾页
	function end(){
		if(page != totalPage){
			page = totalPage;
			showData();
		}
	}
	// /翻页按钮 绑定的监听事件 ----------------------------------
	
</script>

</html>