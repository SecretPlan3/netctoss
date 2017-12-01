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
				<h4 class="modal-title" id="myModalLabel">修改资费套餐</h4>
			</div>
			<div class="modal-body">
				<div class="tc001_body_content">
					<form role="form">
						<div class="form-group">
							<label>套餐名称</label> <input type="text" class="form-control"
								value="${costBean.name}">
						</div>
						<div class="form-group">
							<label>套餐编号</label> <input type="text" class="form-control"
								value="${costBean.costNumber}" disabled="disabled">
						</div>
						<div class="form-group">
							<label>套餐类型</label> <select class="form-control">
								<option>包月资费套餐</option>
								<option>计时资费套餐</option>
								<option>自助资费套餐</option>
							</select>
						</div>
						<div class="form-group">
							<label>基本费用</label> <input id="basicCost" type="text"
								class="form-control" value="${costBean.basicCost}">
						</div>
						<div class="form-group">
							<label>单位费用</label> <input id="unitCost" disabled="disabled"
								type="text" class="form-control" value="${costBean.unitCost}">
						</div>
						<div class="form-group">
							<label>基本时长</label> <input id="basicTime" disabled="disabled"
								type="text" class="form-control" value="${costBean.basicTime}">
						</div>
						<div class="form-group">
							<label>业务状态</label> <select class="form-control">
								<option>暂停</option>
								<option>开通</option>
							</select>
						</div>
						<div class="form-group">
							<label>资费说明</label> <input type="text" class="form-control"
								placeholder="${costBean.description}">
						</div>
						<div class="tc001_footer_btn postion_center">
							<button type="submit" class="btn btn-primary"
								data-dismiss="modal">确认修改</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		//根据选择的资费套餐类型，显示课填的数据表
		$("form select").on({
			"change" : function() {
				choiceSelect($(this));
			}
		});

		function choiceSelect(obj) {
			var text = obj.val();
			/* alert(text) */
			if (text == "包月资费套餐") {
				$("#basicCost").attr("disabled", false)
				$("#unitCost").attr("disabled", true)
				$("#basicTime").attr("disabled", true)
			} else if (text == "计时资费套餐") {
				$("#unitCost").attr("disabled", false)
				$("#basicTime").attr("disabled", true)
				$("#basicCost").attr("disabled", true)
			} else if (text == "自助资费套餐") {
				$("#basicCost").attr("disabled", false)
				$("#basicTime").attr("disabled", false)
				$("#unitCost").attr("disabled", false)
			}
		}
		
		 $("form input").on({
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
	</script>
</body>
</html>