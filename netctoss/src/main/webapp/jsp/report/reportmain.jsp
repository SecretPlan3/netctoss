<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
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
    <!-- ECharts图表 -->
    <script src="<%=basePath%>static/js/echarts.min.js"></script>
	<!-- 本页面的js代码 -->
	<script type="text/javascript" src="<%=basePath%>jsp/report/reportmain.js" charset="utf-8"></script>
	<title>图形报表</title>
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
        #div0001{
        	margin:0px auto!important;
        }
        #userChartBtn:hover{
        	background-color: #E8E8F6;
        }
         #serviceChartBtn:hover{
        	background-color: #E8E8F6;
        }
        .asss{
        	background-color: #E8E8E8;
        }
    </style>
</head>

<body>
<!-- 5.正文的各个模块 按需添加  -->
  		
     <!-- 网站地图 -->
	<div class="listbiaoti am-cf "  ><!-- style="display:inline" -->
		<ul class="am-icon-flag on">图形报表</ul>
		<dl class="am-icon-home" style="float: right;">当前位置： 首页 &gt;&nbsp;
		<a href="<%=basePath%>jsp/bill/chart.jsp">图形报表</a></dl>
	</div>
	
	<!-- 页面标题 -->
	<div class="header">
            <h1>欢迎来到图形报表系统</h1>
       </div>      
	<!--模糊查询-->
	<form id = "form0" method="POST">
       <div class="search">
           <ul class="am-nav am-nav-pills am-topbar-nav ">
               <li class="soso"> 
               		<p><button class="am-btn am-btn-xs am-btn-default am-xiao">账务账号编号：</button></p>
                   	<p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="账务账号编号" id="id" name="id"/></p></li>
               <li class="soso">
               		<p><button class="am-btn am-btn-xs am-btn-default am-xiao">身份证号：</button></p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="身份证号" id="idcard" name="idcard"/></p></li>
               <li class="soso">
               		<p><button class="am-btn am-btn-xs am-btn-default am-xiao">用户姓名：</button></p>
                   	<p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="用户姓名"  id="userName" name="userName"/></p> </li>
               <li class="soso">
               		<p> <button class="am-btn am-btn-xs am-btn-default am-xiao">账号：</button> </p>
               		<p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="账号" id="loginName" name="loginName"//> </p></li>
               <li class="soso">
               		<p><button type="button" onclick = "search()" class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p></li>
            </ul>
       </div>
	</form>
	
	<!-- 主表格 --> 
	<form class="am-form am-g">
           <table id = "table0" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
               <thead>
               <tr class="am-success">
               		<input type="hidden" id = "chosenId"/>
                   <th class="table-title">账务账单编号</th>
                   <th class="table-title">账务账号</th>
                   <th class="table-title">用户姓名</th>
                   <th class="table-title">身份证</th>
                   <!-- <th class="table-title">（拥有实验室数量）</th>
                   <th class="table-set" width="125px">操作</th> -->
               </tr>
               </thead>
               <tbody></tbody>
           </table>
      
          <!-- 功能按钮组div-->
          <!-- 功能按钮组div-->
  		<div class="am-btn-group am-btn-group-xs am-fl">
               <button onclick="delete0()" type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 删除</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 上架</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 下架</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 移动</button>
        </div>
          <!-- 翻页按钮组 ul-->
           <ul class="am-pagination " style="text-align: right">
              	<li  onclick ="first()"><a href="javascript:void(0)">«</a></li>
               	<li  onclick ="pre()" ><a href="javascript:void(0)"> < </a></li>
               	<li  onclick ="jump()"><a id="tza" href="javascript:void(0)">跳转</a></li>
               	<li>
               		<input style='width:40px;height:24px' type="text" class="am-input-sm" id="page" name="page"/>
               	</li>
               	<li onclick ="next()"><a href="javascript:void(0)" >></a></li>
               	<li onclick ="end()"><a href="javascript:void(0)" >»</a></li>
               	<li  id="yema1"></li><!-- 这是显示总条数的列表 -->
            </ul>
           <hr>
	</form>        
</body>

<!--图形报表弹出-开始-->
    <div class="modal fade btn" id="myModal_001" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                	<div id="div0002" style="display:block">
	                	<div id="div0001" style="width:600px;height:30px;magin:0px auto">
		                   	<div id="userChartBtn" style="float:left;width:50%;height:100%;border-right:1px black solid" class="asss div_asss" onclick="huan(this)"><h3 class="modal-title" id="myModalLabel">账单报表</h3></div>
		                    <div id="serviceChartBtn" style="float:right;width:50%;height:100%;border-left:1px black solid" class="div_asss" onclick="huan(this)"><h3 class="modal-title" id="myModalLabel">业务报表</h3></div>
	                     </div>
                	</div>
                </div>
                <div class="modal-body">
                
	                	<!--模糊查询-->
						<div >	<!-- style="border-bottom:1px #EFF2F7 solid" -->
							<span id="loginNameSP">账务账号：</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span>年份：</span>
							<select id="yearSel" > <!-- data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}" -->
								<!-- 动态数据 -->
								<option value="2017">2017</option>
								<option value="2016">2016</option>
								<option value="2015">2015</option>
								<option value="2014">2014</option>
							</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span class="OSNameSel">业务账号：</span>
							<select id="OSNameSel" class="OSNameSel"> <!-- data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}" -->
								<!-- 动态数据 -->
							</select>
						</div>
						
					<!-- 饼图 -->
                	<div id="userChart">
	    				<div id="main" style="width: 800px;height:400px;margin:0 auto">
	    					<!-- 内容 -->
	    				</div>
 					</div>
 					<!-- 折线图 -->
 					<div id="serviceChart" style="display:hidden">
	    				<div id="main2" style="width: 800px;height:400px;margin:0 auto">
	    					<!-- 内容 -->
	    				</div>
 					</div>
 					
 					
 					
                </div>
                <div class="tc001_footer_btn" style="align-content: center">
                	<button id="closeTC" type="submit" class="btn btn-primary" data-dismiss="modal" style="width:100px">关闭</button>
                </div>
                <hr>
            </div>
        </div>
    </div>
	<!--图形报表弹出-结束-->

</html>