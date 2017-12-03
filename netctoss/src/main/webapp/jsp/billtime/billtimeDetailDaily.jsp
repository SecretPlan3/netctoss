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
        #div_table0{
        	
        	width: 100%!important;
        	overflow: scroll!important;
        }
    </style>
</head>

<body>
     <!-- 网站地图 -->
	<div class="listbiaoti am-cf "  ><!-- style="display:inline" -->
		<ul class="am-icon-flag on">账务查询</ul>
		<dl class="am-icon-home" style="float: right;">当前位置： 首页 &gt;&nbsp;<a href="<%=basePath%>jsp/billtime/billtimemain.jsp">账务查询</a> &gt;&nbsp;<a href="<%=basePath%>jsp/billtime/billtimeDetailMonthly.jsp">开放实验室月使用时长信息</a>&gt;&nbsp;<a href="<%=basePath%>jsp/billtime/billtimeDetailDaily.jsp">开放实验室日使用时长信息</a></dl>
	</div>
	
	<!-- 页面标题 --> 
  		<div class="header">
            <h1>开放实验室日使用时长信息</h1>
       </div>
	<!-- 隐藏元素，存放信息 -->        
    <input type="hidden" id ="serviceId">
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
                       <select id = "year" data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}">                   
                           <option >2016</option>
                           <option >2015</option>
                           <option >2014</option>
                           <option >2013</option>
                       </select>
                   </p>
                </li>
              <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">月份</button>
                   </p>
                   <p>
                       <select id = "month" data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}">
                           <option>1</option>
                           <option>2</option>
                           <option>3</option>
                           <option>4</option>
                           <option>5</option>
                           <option>6</option>
                           <option>7</option>
                           <option>8</option>
                           <option>9</option>
                           <option>10</option>
                           <option>11</option>
                           <option>12</option>
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
 			<input type="hidden" id = "chosenId">
 			<div id = "div_table0">
 			    <table id = "table0" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
               <thead></thead>
               <tbody></tbody>
           		</table>
 			</div>
       
            <!-- /主表格 -->  
           
          
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
               <li  id="yema"></li><!-- 这是显示总条数的列表 -->
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
		$("#serviceId").val("${serviceId}");
		params = {
				serviceId:$("#serviceId").val(),
				year:$("#year").val(),
				month: $("#month").val(),
			}; 
		showData();	
	});
	
	// 分页查询显示表格数据的方法
	function showData(){
		var url = "billtime/findDaily";
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
				console.info(msg);
				
				var s = "";
				
				var totalDays = 0;
				

				
				for (var i = 0; i < datas.length; i++) {
					
					s+= "<tr  value="+datas[i].id+"><td class='am-text-center'>"
					+datas[i].id+"</td>" + "<td class='am-text-center'>"
					+datas[i].osName+"</td>";
					var y = datas[i].serviceYear;
					for ( var j = 0; j < y.length; j++ ) {
						
						s+="<td>"+timeLongToString(y[j].onlineTime); +"</td> ";
						var mon = y[j].serviceMonthly;
						var m =mon.sort(function(a,b){ return parseInt(a.month) - parseInt(b.month); }); //给数组排序 ，形参ab用来制定规则
						console.info(m);
						for ( var k = 0; k < m.length; k++) {
							s+="<td>"+ timeLongToString(m[k].onlineTime); +"</td> ";
							
							var day = m[k].serviceDaily;
							var d =day.sort(function(a,b){ return parseInt(a.day) - parseInt(b.day); }); //给数组排序 ，形参ab用来制定规则
							console.info(d);
							for ( var l = 0; l < d.length; l++) {
								s+="<td>"+ timeLongToString(d[l].onlineTime); +"</td> ";
								totalDays += 1;
							}	
						}
					}
					s+="</tr>";
				}
				//拼接表头+++++++++++
				var head0 = "<tr ><th>编号</th><th>服务器信息</th><th>全年总时长</th><th>月总时长</th>";
				for (var i = 0; i < totalDays; i++) {
					head0 +=  "<th>"+ (i+1) +  "日" + "</th>"; 
				}
				s = head0 + "</tr>" + s; 
				//+++++++++++++++++++
				
				$("#table0 tbody").html(s);
				//动态显示关于页面的信息
				$("#yema").html("当前第"+page+"页/共"+totalPage+"页/一共"+totalRows+"条");
				
				$("#loginName").val(datas[0].user.loginName);
				$("#userName").val(datas[0].user.userName);
				
				
				//给每行添加点击事件
			 	//绑定事件******************************************************
					/* $("tr").each(function(i,val){ 
						if(i != 0){//第一行不绑定
							$(this).on("click",function(){
								var value = $(this).attr("value");
								$("#chosenId").attr("value",value);//给隐藏的表单元素 赋值 当前行对应的ID
								alert($("#chosenId").attr("value"));
								window.location.href="jsp/billtime/billtimeDetailDaily.jsp" + "?id="+ value ;
							})  
						}
						
					}) */
			//***************************************************************
				
			}
		});
	}
	
	
	//long 转String 
	function timeLongToString(longTime){
		//总秒数
		var s =  longTime / 1000;
		//小时数
		var hs = parseInt(s/3600); 
		//分钟数
		var mins =  parseInt((s-hs*3600)/60); 
		 //秒数 
		var ss =  parseInt((s-hs*3600-mins*60));
		 //最后的String格式的时间
		var time = "" + hs + ":" + mins +  ":" + ss;
		return time;
	}
	
	
	//查询函数 ---查询按钮点击事件
	function search(){
		/*param 中d的条件数据的形式为键值对存放的json对象,如：*/
			params = {
				serviceId:$("#serviceId").val(),
				year:$("#year").val(),
				month: $("#month").val(),
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