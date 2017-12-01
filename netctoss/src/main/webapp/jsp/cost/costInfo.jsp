<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>资费管理系统</title>
<link rel="stylesheet" href="static/css/amazeui.min.css" />
<link rel="stylesheet" href="static/css/admin.css">
<link rel="stylesheet" href="static/css/app.css" />
<!--引入自定义样式-->
<link rel="stylesheet" href="static/css/custom.css">
<script src="static/js/jquery.min.js"></script>
<script src="static/js/app.js"></script>
<!-- bootstrap -->
<link rel="stylesheet" href="static/css/bootstrap.min.css" />
<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.postion_center {
	text-align: center;
}
</style>
</head>
<body>
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title postion_center">资费套餐详细信息</h4>
			</div>
			<div class="modal-body">
				<div class="tc001_body_content">
					<form role="form">
						<div class="form-group">
							<label>套餐名称:
								<p style="display: inline">${costBean.name}</p>
							</label>

						</div>
						<div class="form-group">
							<label>套餐编号：
								<p style="display: inline">${costBean.costNumber}</p>
							</label>
						</div>
						<div class="form-group">
							<label>套餐类型：<p style="display: inline">${costBean.type}</p></label>
						</div>
						<div class="form-group">
							<label>基本费用：<p style="display: inline">${costBean.basicCost}</p></label>
						</div>
						<div class="form-group">
							<label>单位费用：<p style="display: inline">${costBean.unitCost}</p></label>
						</div>
						<div class="form-group">
							<label>基本时长：<p style="display: inline">${costBean.basicTime}</p></label>
						</div>
						<div class="form-group">
							<label>业务状态：<p style="display: inline">${costBean.status}</p></label>
						</div>
						<div class="form-group">
							<label>资费说明：<p style="display: inline">${costBean.description}</p></label>
						</div>
					</form>

				</div>
			</div>
			<div class="tc001_footer_btn postion_center">
				<button type="submit" class="btn btn-primary" data-dismiss="modal">返回</button>
			</div>
		</div>
	</div>
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
	$(function() {
		showData();
	});

	// 分页查询显示表格数据的方法
	function showData() {
		var url = "cost/selectCost";
		$.ajax({
			type : "GET",
			url : url,
			async : true,
			data : {
				"page" : page,
				"rows" : rows,
				"params" : params,
			},
			success : function(msg) {
				//alert("成功返回");
				//处理返回数据，给全局变量赋值等
				page = msg.page;
				rows = msg.rows;
				totalRows = msg.totalRows;
				totalPage = msg.totalPage;
				var datas = msg.datas;
			}
		});
	}
</script>
</html>