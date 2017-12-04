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
            <h1>资费管理系统</h1>
       </div>
       <!--模糊查询-->
       <form>
       		<div class="search">
           <ul class="am-nav am-nav-pills am-topbar-nav ">
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">套餐编号</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="套餐编号" id="costNumber"/></p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">套餐名称</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="套餐名称" id="costName"/></p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">套餐类型</button>
                   </p>
                   <p>
                       <select data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}" id="costType">
                           <option value="3">所有资费套餐</option>
                           <option value="0">包月资费套餐</option>
                           <option value="1">计时资费套餐</option>
                           <option value="2">自助资费套餐</option>
                       </select>
                   </p>
                   <p><button type="button" onclick="check()" class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
               </li>
            </ul>
       </div>
       </form>
        <!--表单数据-->

       <div class="listbiaoti am-cf ">
           <ul class="am-icon-flag on">
              	 资费管理
           </ul>
           <dl class="am-icon-home" style="float: right;">
               	当前位置： 资费管理系统 &gt; <a href="#">主页</a>
           </dl>
           <dl>
               <!-- <a href="addcost.html" target="_self"></a> -->
               <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" data-toggle="modal" data-target="#myModal_001">增加资费套餐</button>
               <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" onclick="updateStatus()">开通/暂停</button>
           </dl>
           <!--data-am-modal="{target: '#my-popup'}" 弹出层 ID  弹出层 190行 开始  271行结束-->

       </div>
       <form class="am-form am-g">
           <table id = "table" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
               <thead>
               <tr class="am-success">
                   <th class="table-title">套餐编号</th>
                   <th class="table-title">套餐名称</th>
                   <th class="table-type">套餐类型</th>
                   <th class="table-type">套餐状态</th>
                   <th class="table-type">创建时间</th>
                   <th class="table-type">开通时间</th>
                   <th class="table-type">关闭时间</th>
                   <th class="table-author am-hide-sm-only">备注</th>
                   <!-- <th class="table-set" width="125px">操作</th> -->
               </tr>
               </thead>
               <tbody>
               <tr>
                   <td class="am-text-center">14</td>
                   <td><a href="#">冰淇淋套餐</a></td>
                   <td>自助资费套餐</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td><div class="am-btn-toolbar">
                       <div class="am-btn-group am-btn-group-xs" style="text-align: center">
                           <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改资费套餐"><span class="am-icon-pencil-square-o"></span></button>
                           <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改资费套餐"><span class="am-icon-trash-o"></span></button>
                       </div>
                   </div></td>
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

	<!--添加资费套餐弹框-开始-->
    <div class="modal fade btn" id="myModal_001" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">增加资费套餐</h4>
                </div>
                <div class="modal-body">
                    <div class="tc001_body_content">
                         <form role="form" id="formObj">
		                    <div class="form-group">
		                        <label>套餐名称</label>
		                        <input type="text" class="form-control" placeholder="套餐名称" name="name">
		                    </div>
		                    <div class="form-group">
		                        <label>套餐编号</label>
		                        <input type="text" class="form-control" placeholder="套餐编号" name="costNumber">
		                    </div>
		                    <div class="form-group">
		                        <label>套餐类型</label>
		                        <select class="form-control" name="type">
		                            <option value="0">包月资费套餐</option>
		                            <option value="1">计时资费套餐</option>
		                            <option value="2">自助资费套餐</option>
		                        </select>
		                    </div>
		                    <div class="form-group">
		                        <label>基本费用</label>
		                        <input  id="basicCost"  type="text" class="form-control" placeholder="基本费用(元/月)" name="basicCost">
		                    </div>
		                    <div class="form-group">
		                        <label>单位费用</label>
		                        <input id="unitCost" disabled="disabled" type="text" class="form-control" placeholder="单位费用(元/时)" name="unitCost">
		                    </div>
		                    <div class="form-group">
		                        <label>基本时长</label>
		                        <input id="basicTime" disabled="disabled" type="text" class="form-control" placeholder="基本时长(小时)" name="basicTime">
		                    </div>
		                    <div class="form-group">
		                        <label>当前日期</label>
		                        <input type="text" class="form-control" placeholder="当前日期" data-am-datepicker="" readonly="" name="createTime">
		                    </div>
		                    <div class="form-group">
		                        <label>业务状态</label>
		                        <select class="form-control" name="status">
		                            <option value="0">暂停</option>
		                            <option value="1">开通</option>
		                        </select>
		                    </div>
		                    <div class="form-group">
		                        <label>资费说明</label>
		                        <input type="text" class="form-control" placeholder="资费说明" name="description">
		                    </div>
		                </form>
                        
                    </div>
                </div>
                <div class="tc001_footer_btn" style="align-content:center">
                	<button type="button" class="btn btn-primary" onclick="addCost()">添加</button>
                	<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
	<!--添加资费套餐弹框-结束-->
	
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
			var url = "cost/findAllCosts";
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
						//资费类型
						var typeStr = null;
						if(datas[i].type == 0 ){
							typeStr = "包月资费套餐";
						}else if(datas[i].type == 1){
							typeStr = "计时资费套餐";
						}else if(datas[i].type == 2){
							typeStr = "自助资费套餐";
						}
						//套餐状态
						var statusStr = null;
						if(datas[i].status == 0){
							statusStr = "暂停";
						}else if(datas[i].status == 1){
							statusStr = "开通";
						}
						
						s+= "<tr value="+datas[i].id+"><td class='am-text-center am-hide-sm-only'>"
						+datas[i].costNumber+"</td> <td>"
						+datas[i].name+"</td><td>"
						+typeStr+"</td><td>"
						+statusStr+"</td><td>"
						+datas[i].createTime+"</td><td>"
						+datas[i].startTime+"</td><td>"
						+datas[i].closeTime+"</td><td>"
						+datas[i].description+"</td></tr>"
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
				}
			});
		}
	 	//模糊查询
	 	function check(){
	 		var costNumber = $("#costNumber").val();
	 		var costName = $("#costName").val();
	 		/* var costType = parseInt($("#costType").val()); */
	 		alert(costNumber + costName);
	 		if(costNumber == "" && costName == ""){
	 			alert("测试");
	 			showData();
	 		}else{
	 			params = {
		 				costNumber:costNumber,
		 				costName:costName,
		 				/* costType:parseInt($("#costType").val()) */
		 			}; 
		 			showData();	//调用显示数据函数，ajax刷新页面
	 		}
	 	}
		//增加资费
		function addCost(){
			var url = "cost/insertCosts";
			var costBean = $("#formObj").serialize();
			$.ajax({
				   type: "POST",
				   url: url,
				   data: costBean,
				   success: function(msg){
				     alert(msg);
				   }
				});
		}
		
        $("#formObj input").on({
            "blur":function(){
                checkNotNull($(this));
            }
        });
        
        //传入一个obj，判断value是否为空，分别返回true/false
        function checkNotNull(obj){
            var txt = obj.val();
            if( txt == ""){
                /* 	alert("不能为空"); */
                obj.css({"border":"1px red solid"})
                return false;
            }
            obj.css({"border":"1px greenyellow solid"})
            return true;
        }
        //提交事件
        $("form").on({"submit":function(){
            if(checkAll()){
                return true;
            }
            alert("字段为空，提交失败")
            return false;
        }});
        function checkAll(){//一次性检查所有方法的返回值 是否为true
            var flag = true;
            $("form input").each(function(i,obj){
                flag = checkNotNull($(this)) && flag;
            });
            return flag;//如果都为true ,那么本方法将返回true,任意一个为false,则本方法返回false
        }
        //根据选择的资费套餐类型，显示课填的数据表
        $("form select").on({
            "change":function(){
            	choiceSelect($(this));
            }
        });
        
        function choiceSelect(obj){
        	var text = obj.val();
        	/* alert(text) */
        	if(text == 0){
        		$("#basicCost").attr("disabled", false)
        		$("#unitCost").attr("disabled", true)
        		$("#basicTime").attr("disabled", true)
        	}else if(text == 1){
        		$("#unitCost").attr("disabled", false)
        		$("#basicTime").attr("disabled", true)
        		$("#basicCost").attr("disabled", true)
        	}else if(text == 2){
        		$("#basicCost").attr("disabled", false)
        		$("#basicTime").attr("disabled", false)
        		$("#unitCost").attr("disabled", false)
        	}
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
    		  alert("请选择你要修改的内容！")
    	  }else{
    		  window.location.href="cost/selectCost" + "?id="+ trId + "&task=update";
    	  }
      }
      //修改状态
      function updateStatus(){
    	  if(trId == 0 ){
    		  alert("请选择你要修改的内容！")
    	  }else{
    		  window.location.href="cost/selectCost" + "?id="+ trId + "&task=updateStatus";
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