<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1.首先要导入一篇header.jsp ,引入工程名全路径：bathpath-->
    <%@ include file="../../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 2.使用base为本页面设置一个 在相对路径前自动拼接上的路径，此处代表工程名加斜杠，它会使相对路径都变成绝对路径 -->
<base href="<%=basePath%>" >

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 3.引入自己需要的js、css 文件 此处的basepath可以上略，因为2.中说过 相对路径会自动拼接 -->
    <link rel="stylesheet" href="<%=basePath%>static/css/amazeui.min.css"/>
    <link rel="stylesheet" href="static/css/admin.css">
    <!--引入自定义样式-->
    <link rel="stylesheet" href="<%=basePath%>static/css/custom.css">
    <%-- <script src="<%=basePath%>static/js/jquery.min.js"></script> --%>

    <!-- jquery 和 json 的js -->
    <script src="<%=basePath%>static/js/jquery-3.2.1.min.js" charset="utf-8"></script>
	<script  src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
 <!-- 4.页面规范的样式 -->
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
   <div>
       <div class="header">
            <h1>用户管理系统</h1>
       </div>
       <!--模糊查询-->
       <div class="search">
           <ul class="am-nav am-nav-pills am-topbar-nav ">
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">登录名</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="登录名" /></p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">姓名</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="姓名" /></p>
               </li>
               <li class="soso">
                  <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">身份证号</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="身份证号" /></p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">账号状态</button>
                   </p>
                   <p>
                       <select data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}">
                           <option value="1">开启</option>
                           <option value="2">暂停</option>
                           <option value="3">关闭</option>
                      	</select>
                   </p>
                   <p><button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
               </li>
            </ul>
       </div>
      
      </form>


  
	<form class="am-form am-g">
 			<!-- 主表格 -->  
           <table id = "table0" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
               <thead>
               <tr class="am-success">
               		
               		
               		
               		
                   <th class="table-title">账务账单编号</th>
                   <th class="table-title">账务账号</th>
                   <th class="table-title">用户姓名</th>
                   <th class="table-title">身份证</th>
                   <th class="table-type">联系电话</th>
                   <th class="table-author am-hide-sm-only">状态</th>
                   <!-- <th class="table-title">（拥有实验室数量）</th>
                   <th class="table-set" width="125px">操作</th> -->
               </tr>
               </thead>
               <tbody></tbody>
           </table>
            <!-- 主表格 -->  
           
            
          <!-- 功能按钮组div-->
          <!-- 功能按钮组div-->
  		  <div class="am-btn-group am-btn-group-xs ">
               <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus findfeikong" data-toggle="modal" data-target="#find">查看详细信息</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 查看对应业务</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 暂停</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 修改</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 恢复</button>
               <button type="button" class="am-btn am-btn-default" id="addbtn" ><span class="am-icon-archive"></span> 新增</button>
               <button type="button" class="am-btn am-btn-default" id="deletebtn" ><span class="am-icon-trash-o"></span> 删除</button>
               <button type="button" id="addbtns" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 批量新增</button>
                <dl>
               
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
	
	
    <!-- 查看详细信息的模态框  -->
    
    <div class="modal fade btn" id="find" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">管理员详细信息</h4>
                </div>
                <div class="modal-body">
                    <div class="tc001_body_content">
                         <form role="form" id="findform">
		                    <div class="form-group">
		                        <input type="hidden" class = "find0" name = "id">
		                        <label>姓名</label>
		                        <input type="text" class="form-control find1" disabled="disabled" name="magName">
		                    </div>
		                    <div class="form-group">
		                        <label>登录账号</label>
		                        <input type="text" class="form-control find2" disabled="disabled" name="loginName">
		                    </div>
		                    <div class="form-group">
		                        <label>登录密码</label>
		                        <input type="text" class="form-control find3" disabled="disabled" name="password">
		                    </div>
		                    <div class="form-group">
		                        <label>手机号</label>
		                        <input type="text" class="form-control find4" disabled="disabled" name="tel">
		                    </div>
		                    <div class="form-group">
		                        <label>邮箱</label>
		                        <input type="text" class="form-control find5" disabled="disabled" name="email">
		                    </div>
		                </form>
                        
                    </div>
                </div>
                <div class="tc001_footer_btn" style="align-content: center">
                	<button type="submit" class="btn btn-primary " data-dismiss="modal">确定</button>
                	<button type="button" class="btn btn-primary " data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
	       
</body>

<!-- 6.js脚本，使用本jsp的分页 模块 可以将 以下 js脚本全部复用 修改showData()  和 search() 在按需添加 功能按钮的方法  即可-->
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
		showData();	
	});
	
	// 分页查询显示表格数据的方法
	function showData(){
		var url = "usermag/findUserByPager";
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
				var s = "<input type='hidden' id = 'chosenId'>";
				for (var i = 0; i < datas.length; i++) {
					s+= "<tr value="+datas[i].userId+"><td class='am-text-center'>"
					+datas[i].userId+"</td> <td>"
					+datas[i].loginName+"</td><td>"
					+datas[i].userName+"</td><td>"
					+datas[i].idcard+"</td><td>"
					+datas[i].tel+"</td><td>"
					+datas[i].status+"</td></tr>"
				}
				$("#table0 tbody").html(s);
				//给每行添加点击事件
			 	//绑定事件******************************************************
					$("tr").each(function(i,val){ 
						if(i != 0){//第一行不绑定
							$(this).on("click",function(){
								var value = $(this).attr("value");
								$("#chosenId").attr("value",value);//给隐藏的表单元素 赋值 当前行对应的id

							})  
						}
						
					})
			//***************************************************************
				
			}
		});
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
	//删除函数 ---查询按钮点击事件
	function delete0(){
		$.ajax({  
             type:"POST",  
             url:"usermag/delete",
             async: true,
             data:{"userId":$("#chosenId").attr("value"),status:3},
             success:function(e){   
             	alert("啊 输出成功了");
             	showData();
             }  
         });  
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
	
      $("#addbtn").click(function(){  
      	window.location.href="jsp/user/adduser.jsp";
       });  

      $("#addbtns").click(function(){  
      	window.location.href="jsp/user/addusers.jsp";
 	});  
      $("#deletebtn").click(function(){  
    	  delete0();
   	});  
	</script>
</body>
</html>
