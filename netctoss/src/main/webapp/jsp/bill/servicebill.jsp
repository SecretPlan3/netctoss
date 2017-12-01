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
	<script type="text/javascript" src="<%=basePath%>jsp/bill/servicebill.js" charset="utf-8"></script>
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
	<!-- 网站地图 -->
	<div class="listbiaoti am-cf "  ><!-- style="display:inline" -->
		<ul class="am-icon-flag on">账单查询</ul>
		<dl class="am-icon-home" style="float: right;">当前位置： 首页 &gt;&nbsp;
		<a href="<%=basePath%>jsp/bill/billmain.jsp">账单查询</a>&gt;&nbsp;
		<a href="<%=basePath%>jsp/bill/servicebill.jsp">业务账号账单</a></dl>
	</div>
	
	<!-- 页面标题 -->
	<div class="header">
			<h1>业务账号账单</h1>
	</div>
	<hr>
	<div style="width:100%" >
		<table style="width:100%">
			<tr>
				<td id="h4_loginName" style="color:gray">账务账号：</td>
				<td id="h4_userName" style="color:gray">用户姓名：</td>
				<td id="h4_date" style="color:gray">日期：</td>
				
			</tr>
		</table>
	</div>
	<!--表单数据-->
	<form class="am-form am-g">
		<div id="table_div">
			<table id="table01" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
				<thead>
					<!-- 动态数据 -->
				</thead>
				<tbody>
					<!-- 动态数据 -->
				</tbody>
			</table>
		</div>
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
		<!-- 翻页 -->
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
	
	<!--业务账号详细账单弹框-开始-->
    <div class="modal fade btn" id="myModal_001" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">业务账号账单详细信息</h4>
                </div>
                <div class="modal-body">
                    <div id='table_div2' class="tc001_body_content">
                    	<table id="table02" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
							<thead>
								<!-- 动态数据 -->
							</thead>
							<tbody>
								<!-- 动态数据 -->
							</tbody>
						</table>
                    </div>
                    <!-- 翻页 -->
					<ul class="am-pagination " style="text-align: right">
						<li class="am-disabled"><a href="#">«</a></li>
						<li class="am-active"><a href="#"><</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">></a></li>
						<li><a href="#">»</a></li>
					</ul>
                </div>
                <div class="tc001_footer_btn" style="align-content: center">
                	<button type="submit" class="btn btn-primary" data-dismiss="modal" style="width:100px">关闭</button>
                </div>
                <hr>
            </div>
        </div>
    </div>
	<!--业务账号详细账单弹框-结束-->

</body>
</html>

