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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.postion_center{
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
		                        <label>套餐名称:</label>
		                        
		                    </div>
		                    <div class="form-group">
		                        <label>套餐编号：</label>
		                    </div>
		                    <div class="form-group">
		                        <label>套餐类型：</label>
		                    </div>
		                    <div class="form-group">
		                        <label>基本费用：</label>
		                    </div>
		                    <div class="form-group">
		                        <label>单位费用：</label>
		                    </div>
		                    <div class="form-group">
		                        <label>基本时长：</label>
		                    </div>
		                    <div class="form-group">
		                        <label>业务状态：</label>
		                    </div>
		                    <div class="form-group">
		                        <label>资费说明：</label>
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
</html>