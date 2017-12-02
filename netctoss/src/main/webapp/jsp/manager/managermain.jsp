<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>" >
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员管理系统</title>
    <link rel="stylesheet" href="<%=basePath%>static/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>static/css/admin.css">
    <!--引入自定义样式-->
    <link rel="stylesheet" href="<%=basePath%>static/css/custom.css">
    <script src="<%=basePath%>static/js/jquery.min.js"></script>
    <script src="<%=basePath%>static/js/app.js"></script>
	<!-- bootstrap -->
	<link rel="stylesheet" href="<%=basePath%>static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="<%=basePath%>static/js/bootstrap.min.js"></script>
    <!--日历插件-->
    <script src="<%=basePath%>static/js/amazeui.min.js"></script>
    <script src="<%=basePath%>static/js/amazeui.datatables.min.js"></script>
    <script src="<%=basePath%>static/js/dataTables.responsive.min.js"></script>
    <script src="<%=basePath%>static/js/app.js"></script>
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
        .as{
            background-color: blue;
        }
    </style>
</head>
<body>
   <div>
       <div class="header">
            <h1>管理员管理系统</h1>
       </div>
        <!--表单数据-->

       <div class="listbiaoti "> <!-- am-cf  -->
           <ul class="am-icon-flag on">
              	 管理员管理
           </ul>
           <dl class="am-icon-home" style="float: right;">
               	当前位置： 首页 &gt; <a href="#">用户评论</a>
           </dl>
           <dl>
               <!-- <a href="addcost.html" target="_self"></a> -->
               
               <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus " data-toggle="modal" data-target="#add">增加</button>
               <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus updatefeikong" data-toggle="modal" data-target="#update">修改</button>
               <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus deletefeikong" data-toggle="modal">删除</button>
               <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus findfeikong" data-toggle="modal" data-target="#find">查看详细信息</button>
           </dl>

       </div>
        <!--模糊查询-->
       <input type='hidden' class='hidden1'/>
       <div class="search">
           <ul class="am-nav am-nav-pills am-topbar-nav ">
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">姓名</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" id="mname" placeholder="姓名" /></p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">手机</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" id="mtel" placeholder="手机" /></p>
                   <p><button class="am-btn am-btn-xs am-btn-default am-xiao" id="sousuo"><i class="am-icon-search"></i></button></p>
               </li>
            </ul>
       </div>
       <form class="am-form am-g">
           <table class="am-table am-table-bordered  am-table-hover " id="tt" width="100%">
           </table>
           <!-- 翻页按钮组 ul-->
           <ul class="am-pagination " style="text-align: right">
               
               <li  onclick ="first()"><a href="javascript:void(0)">«</a></li>
               <li  onclick ="pre()" ><a href="javascript:void(0)"> < </a></li>
               <li  onclick ="jump()"><a href="javascript:void(0)">跳转</a></li>
               <li >
               	<input type="text" class="am-input-sm" placeholder="跳到哪一页" id="page" name="page"/>
               </li>
               <li onclick ="next()"><a href="javascript:void(0)" >></a></li>
               <li onclick ="end()"><a href="javascript:void(0)" >»</a></li>
               <li  id="yema"></li>
           </ul>
       </form>
   </div>
    
	<!--添加管理员的模态框-->
    <div class="modal fade btn" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">添加管理员</h4>
                </div>
                <div class="modal-body">
                    <div class="tc001_body_content">
                         <form role="form" id="addform">
		                    <div class="form-group">
		                        <label>姓名</label>
		                        <input type="text" class="form-control " placeholder="姓名" name="magName">
		                    </div>
		                    <div class="form-group">
		                        <label>登录账号</label>
		                        <input type="text" class="form-control " placeholder="登录账号" name="loginName">
		                    </div>
		                    <div class="form-group">
		                        <label>登录密码</label>
		                        <input type="text" class="form-control " placeholder="登录密码" name="password">
		                    </div>
		                    <div class="form-group">
		                        <label>手机号</label>
		                        <input type="text" class="form-control " placeholder="手机号" name="tel">
		                    </div>
		                    <div class="form-group">
		                        <label>邮箱</label>
		                        <input type="text" class="form-control " placeholder="邮箱" name="email">
		                    </div>
		                </form>
                        
                    </div>
                </div>
                <div class="tc001_footer_btn" style="align-content: center">
                	<button type="submit" class="btn btn-primary quedingadd" data-dismiss="modal">添加</button>
                	<button type="button" class="btn btn-primary quxiao" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
    
    <!--修改管理员的模态框-->
    <div class="modal fade btn" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">修改管理员</h4>
                </div>
                <div class="modal-body">
                    <div class="tc001_body_content">
                         <form role="form" id="updateform">
		                    <div class="form-group">
		                        <input type="hidden" class = "update0" name = "id">
		                        <label>姓名</label>
		                        <label class="form-control update1" name="magName"></label>
		                    </div>
		                    <div class="form-group">
		                        <label>登录账号</label>
		                        <label class="form-control update2" name="loginName"></label>
		                    </div>
		                    <div class="form-group">
		                        <label>登录密码</label>
		                        <label class="form-control update3" name="password"></label>
		                    </div>
		                    <div class="form-group">
		                        <label>手机号</label>
		                        <input type="text" class="form-control" placeholder="手机号" name="tel">
		                    </div>
		                    <div class="form-group">
		                        <label>邮箱</label>
		                        <input type="text" class="form-control" placeholder="邮箱" name="email">
		                    </div>
		                </form>
                        
                    </div>
                </div>
                <div class="tc001_footer_btn" style="align-content: center">
                	<button type="submit" class="btn btn-primary quedingupdate" data-dismiss="modal">添加</button>
                	<button type="button" class="btn btn-primary quxiao" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
    
    <!--查看详细信息的模态框-->
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
	
	 <script type="text/javascript">
	 	
	//定义全局变量
			var page = 1;
			var rows = 5;
		//pagerBean相关的属性
		
		var totalRows = 0;
		var totalPage = 0;

		//页面加载完组件后，直接执行的内容
		$(function(){
			showData();	
		});
		
		// 模糊分页查询显示表格数据的方法
		function showData(){

			//如果页面没有输入东西，就赋值成空字符串装入params查询所有
			var magName = $("#mname").val();
			if(magName == null){
				magName = "";
			}
			
			var tel = $("#mtel").val();
			if(tel == null){
				tel = "";
			}
			//查询条件
			var pager = {
				"page":page,
				"rows":rows,
				"params":{
					"magName":magName,
					"tel":tel
				}
			};
			
			var url = "managermag/findall";
			$.ajax({
				type : "POST",
				url : url,
				async : true,
				data : pager,
				success : function(msg) {
					//处理返回数据，给全局变量赋值等
					page = msg.page;
					rows = msg.rows;
					totalRows = msg.totalRows;
					totalPage = msg.totalPage;
					var datas = msg.datas;
					
					var s = "<tr class='am-success th'><th class='table-author am-hide-sm-only'>管理员编号</th><th class='table-title'>管理员姓名</th><th class='table-title'>管理员账号</th><th class='table-title'>管理员密码</th><th class='table-title'>手机</th><th class='table-title'>邮箱</th><th class='table-set' width='125px'>操作</th></tr>";
					for (var i = 0; i < datas.length; i++) {
						s+= "<tr value='"+datas[i].id+"' index='"+datas[i].id+"'><td class='am-text-center'>"
						+datas[i].id+"</td> <td>"
						+datas[i].magName+"</td><td>"
						+datas[i].loginName+"</td><td>"
						+datas[i].password+"</td><td>"
						+datas[i].tel+"</td><td>"
						+datas[i].email+"</td><td></td> </tr>"
					}
					$("#tt").html(s);
						
						//动态显示关于页面的信息
						$("#yema").html("当前第"+page+"页/共"+totalPage+"页/一共"+totalRows+"条");
				//***************************************************************
				 
				//调用点击变色的方法
				addTableClick();	
				}
			});
		}
		//修改时根据id查单个的方法
		 function updatefindone(id){
			$.ajax({
					type : "POST",
					url : "managermag/findone",
					async : true,
					data : {"id":id},
					success : function(msg) {
		   				$(".update1").html(msg.magName);
		   				$(".update2").html(msg.loginName);
		   				$(".update3").html(msg.password);
		   				$(".update0").attr("index",msg.id);
					}
			 });		
					
		}
		
		//根据id查询详细信息方法
		function findone(id){
			$.ajax({
					type : "POST",
					url : "managermag/findone",
					async : true,
					data : {"id":id},
					success : function(msg) {
						$(".find0").attr("index",msg.id);
						$(".find1").val(msg.magName);
		   				$(".find2").val(msg.loginName);
		   				$(".find3").val(msg.password);
		   				$(".find4").val(msg.tel);
		   				$(".find5").val(msg.email);
		   				
					}
			 });		
					
		}
		
		
		
		
		//模糊查询点搜索按钮时：
		$("#sousuo").click(function(){
			showData();
		});
		
		//监听添加功能模块的确定键
		$(".quedingadd").click(function(){
			var manager = $("#addform").serialize();
			$.ajax({
				type : "POST",
				url : "managermag/manageradd",
				async : true,
				data : manager,
				success : function(msg) {
				}
			})
			showData();
		});
		
		//监听修改功能模块的确定键
		$(".quedingupdate").click(function(){
			var manager = $("#updateform").serialize();
			$.ajax({
				type : "POST",
				url : "managermag/manageradd",
				async : true,
				data : manager,
				success : function(msg) {
				}
			})
			showData();
		});
		
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
		
		//给每行表格添加点击事件
		    function addTableClick(){
		        $("table tr").click(function(){
		        $("table tr").removeClass("as");
		        if(!$(this).hasClass("th")){
		            $(this).addClass("as");
		            $(".hidden1").attr("index",$(this).attr("index"));
		        }
		       });
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
	 
		 //针对修改时没有选中行的情况
	    $(".updatefeikong").click(function(){
	        $(this).removeAttr("data-target");
	        if($(".hidden1").attr("index")
	         != null){
	             $(this).attr("data-target","#update");
	             updatefindone($(".hidden1").attr("index"));
	        }else{
	            alert("请选择需要修改的信息");
	        }
	        
	    });
		 
	  //针对删除时没有选中行的情况
	    $(".deletefeikong").click(function(){
	        if($(".hidden1").attr("index")!= null){
	      //  var manager = {"id":$(".hidden1").attr("index")};
	        //删除一个管理员的方法
	     			$.ajax({
	     					type : "POST",
	     					url : "managermag/managerdelete",
	     					async : true,
	     					data :  {"id":$(".hidden1").attr("index")},
	     					success : function(msg) {
	     						showData();
	     					}
	     			 })
	        }else{
	            alert("请选择需要删除的信息");
	        }
	        
	    });  
	  
	  //针对查看详细信息时没有选中行的情况
	    $(".findfeikong").click(function(){
	        $(this).removeAttr("data-target");
	        if($(".hidden1").attr("index")
	         != null){
	             $(this).attr("data-target","#find");
	             findone($(".hidden1").attr("index"));
	        }else{
	            alert("请选择需要查看的信息");
	        }
	        
	    });  
	 
       /*  $("form input").on({
            "blur":function(){
                checkNotNull($(this));
            }
        }); */
        //传入一个obj，判断value是否为空，分别返回true/false
          /* function checkNotNull(obj){
            var txt = obj.val();
            if( txt == ""){
                 	alert("不能为空");
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
        }  */
    </script>
	
</body>
</html>
