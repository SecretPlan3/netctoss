<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
	<!-- 本页面的js代码 -->
	<script type="text/javascript" src="<%=basePath%>jsp/bill/billmain.js" charset="utf-8"></script>
	<!-- 样式 -->
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
<title>用户账单</title>
</head>
<body>
<div>
<div class="header">
		<h1>账单查询系统</h1>
</div>
	<!--模糊查询-->
	<div class="search">
		<ul class="am-nav am-nav-pills am-topbar-nav ">
			<li class="soso">
            	<p>
            		<button class="am-btn am-btn-xs am-btn-default am-xiao">年份</button>
            	</p>
                <p>
                	<select id="year" data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}">
                    	<option value="2015" >2015</option>
                        <option value="2016" >2016</option>
                        <option value="2017" selected="selected">2017</option>
                    </select>
            	</p>
            </li>
            <li class="soso">
            	<p>
            		<button class="am-btn am-btn-xs am-btn-default am-xiao">月份</button>
            	</p>
                <p>
                	<select id="month" data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}">
                    	<option value="1" >1</option>
                    	<option value="2" >2</option>
                        <option value="4" >4</option>
                        <option value="10" selected="selected">10</option>
                    </select>
            	</p>
            </li>
			<li class="soso">
				<p>
					<button id="loginNameBtn" class="am-btn am-btn-xs am-btn-default am-xiao">账务账号</button>
				</p>
				<p class="ycfg">
					<input id="loginName" type="text" class="am-form-field am-input-sm" placeholder="账务账号" />
				</p>
			</li>
			<li class="soso">
				<p>
					<button id="userNameBtn" class="am-btn am-btn-xs am-btn-default am-xiao">用户姓名</button>
				</p>
				<p class="ycfg">
					<input id="userName" type="text" class="am-form-field am-input-sm" placeholder="用户姓名" />
				</p>
			</li>
			<li class="soso">
				<p>
					<button id="idCardBtn" class="am-btn am-btn-xs am-btn-default am-xiao">身份证号</button>
				</p>
				<p class="ycfg">
					<input id="idCard" type="text" class="am-form-field am-input-sm" placeholder="身份证号" />
				</p>
				
				<p>
					<button id="queryBtn" class="am-btn am-btn-xs am-btn-default am-xiao">
						<i class="am-icon-search"></i>
					</button>
				</p>
			</li>
		</ul>
		<!-- 网站地图 -->
		<div class="listbiaoti am-cf "  style="display:inline">
			<ul class="am-icon-flag on">账单查询</ul>
			<dl class="am-icon-home" style="float: right;">当前位置： 首页 &gt;&nbsp;<a href="#">账单查询</a></dl>
		</div>
	</div>
	
	<!--表单数据-->
	<form class="am-form am-g">
		<table id="table01" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
			<thead>
				<!-- 动态数据 -->
			</thead>
			<tbody>
				<!-- 动态数据 -->
			</tbody>
		</table>
		<div class="am-btn-group am-btn-group-xs am-fl">
			<button type="button" class="am-btn am-btn-default">
				<span class="am-icon-plus"></span> 删除
			</button>
			<button type="button" class="am-btn am-btn-default">
				<span class="am-icon-save"></span> 上架
			</button>
			<button type="button" class="am-btn am-btn-default">
				<span class="am-icon-save"></span> 下架
			</button>
			<button type="button" class="am-btn am-btn-default">
				<span class="am-icon-plus"></span> 新增
			</button>
			<button type="button" class="am-btn am-btn-default">
				<span class="am-icon-save"></span> 保存
			</button>
			<button type="button" class="am-btn am-btn-default">
				<span class="am-icon-archive"></span> 移动
			</button>
			<button type="button" class="am-btn am-btn-default">
				<span class="am-icon-trash-o"></span> 删除
			</button>
		</div>
		<ul class="am-pagination " style="text-align: right">
			<li class="am-disabled"><a href="#">«</a></li>
			<li class="am-active"><a href="#"><</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">></a></li>
			<li><a href="#">»</a></li>
		</ul>
		<hr>
	</form>
	</div>  
	
	<!-- 日历插件 -->
	<div>
		<div class="am-form-group">
			<label class="am-u-sm-3 am-form-label">这是一个日历插件自己可以自行选择使用 </label>
			<div class="am-u-sm-9">
				<input type="text" class="am-form-field tpl-form-no-bg" placeholder="选择年月" data-am-datepicker="{format:'yyyy-mm',viewMode:0,minViewMode:1}" readonly>
			</div>
		</div>
	</div>
	
</body>
</html>

