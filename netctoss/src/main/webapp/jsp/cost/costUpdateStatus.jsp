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
				<h4 class="modal-title" id="myModalLabel">业务开通/业务暂停</h4>
			</div>
			<div class="modal-body">
				<div class="tc001_body_content">
					<form role="form" id="formObj">
						<div class="form-group">
							<input type="hidden" value = "${costBean.id}" name = "id">
							<label>业务状态</label> <select class="form-control" name="status">
								<option value="0">暂停</option>
								<option value="1">开通</option>
							</select>
						</div>
						<div class="tc001_footer_btn postion_center">
							<button type="button" class="btn btn-primary"
								 onclick="updateCost()" title="确认修改">确认</button>
							<a href="jsp/cost/costmag.jsp"><button type="button" class="btn btn-primary"
								 title="返回资费管理主页">返回</button></a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	
		//修改資費套餐
		function updateCost(){
			var costBean = $("#formObj").serialize();
			alert(costBean);
			var url = "cost/updateCosts";
			$.ajax({
				   type: "POST",
				   url: url,
				   data: costBean,
				   success: function(msg){
				     alert( "修改成功！" );
				     window.location.href="jsp/cost/costmag.jsp";
				   }
				});
		}
		
		
	</script>
</body>
</html>