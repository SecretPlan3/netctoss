<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>" >
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
    <title>资费管理系统</title>
    <link rel="stylesheet" href="static/css/amazeui.min.css"/>
    <link rel="stylesheet" href="static/css/admin.css">
    <!--引入自定义样式-->
    <link rel="stylesheet" href="static/css/custom.css">
    <script src="static/js/jquery.min.js"></script>
    <script src="static/js/app.js"></script>
	<!-- bootstrap -->
	<link rel="stylesheet" href="static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>
    <!--日历插件-->
    <script src="static/js/amazeui.min.js"></script>
    <script src="static/js/amazeui.datatables.min.js"></script>
    <script src="static/js/dataTables.responsive.min.js"></script>
    <script src="static/js/app.js"></script>
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
        th,td{
        	text-align: center;
        }
    </style>
</head>
<body>
	<div>
       <div class="header">
            <h1>日志管理系统</h1>
       </div>
       <!--模糊查询-->
       <div class="search">
           <ul class="am-nav am-nav-pills am-topbar-nav ">
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">管理员</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="管理员名字" /></p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">起始日期</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="登陆时间" data-am-datepicker="" readonly=""></p>
              	
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">截至日期</button>
                   </p>
                   <p>
                       <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="退出时间" data-am-datepicker="" readonly=""></p>
                   </p>
                   <p><button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
               </li>
            </ul>
       </div>
        <!--表单数据-->

       <div class="listbiaoti am-cf ">
           <ul class="am-icon-flag on">
              	 日志操作信息
           </ul>
           <dl class="am-icon-home" style="float: right;">
               	当前位置： 日志管理系统 &gt; <a href="#">主页</a>
           </dl>
       </div>
       <form class="am-form am-g">
           <table id = "table" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
               <thead>
               <tr class="am-success">
                   <th class="table-title">管理员</th>
                   <th class="table-title">操作类型</th>
                   <th class="table-type">操作位置</th>
                   <th class="table-type">操作时间</th>
               </tr>
               </thead>
               <tbody>
               <tr>
                   <td class="am-text-center">14</td>
                   <td><a href="#">冰淇淋套餐</a></td>
                   <td>自助资费套餐</td>
               </tr>
               </tbody>
           </table>
           <div class="am-btn-group am-btn-group-xs ">
               <button onclick ="seeInfo()"  type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 查看</button>
               <button onclick ="updateInfo()" type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span>修改</button>
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
   </div>
	
	 <script type="text/javascript">
		//定义全局变量
		//pagerBean相关的属性
		var page = 1;
		var rows = 5;
		var totalRows = 0;
		var totalPage = 0;
		
		//查询条件
		var params = {};
		//获取id值
		var trId = 0 ;

		//页面加载完组件后，直接执行的内容
		$(function(){
			showData();	
		});
		
		// 分页查询显示表格数据的方法
		function showData(){
			var url = "logmag/findManagerOperationLog";
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
						s+= "<tr value="+datas[i].id+"><td class='am-text-center am-hide-sm-only'>"
						+datas[i].operationManager+"</td> <td>"
						+datas[i].type+"</td><td>"
						+datas[i].address+"</td><td>"
						+datas[i].operationTime+"</td></tr>"
					}
					$("#table tbody").html(s);
					//给每行添加点击事件
				 	//绑定事件******************************************************
						$("tr").each(function(i,val){ 
							if(i != 0){//第一行不绑定
								$(this).on("click",function(){
									trId = $(this).attr("value");
									/* $("#chosenId").attr("value",trId);//给隐藏的表单元素 赋值 当前行对应的id */
									//alert($("#chosenId").attr("value"));
									/* window.location.href="cost/selectCost" + "?id="+ trId ; */
								})  
							}
							
						})
				//***************************************************************
					
				}
			});
		}
	 
      //查看/修改/删除/新增按钮点击事件
      function seeInfo(){
    	  if(trId == 0 ){
    		  alert("请选择你要查看的内容！")
    	  }else{
    		  window.location.href="cost/selectCost" + "?id="+ trId + "&task=see";
    	  }
      }
      
      function updateInfo(){
    	  if(trId == 0 ){
    		  alert("请选择你要查看的内容！")
    	  }else{
    		  window.location.href="cost/selectCost" + "?id="+ trId + "&task=update";
    	  }
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
    </script>
</body>
</html>