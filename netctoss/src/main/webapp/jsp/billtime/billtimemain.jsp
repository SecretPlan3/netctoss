<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>static/js/jquery-3.2.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
</head>
<body>
	欢迎来到账务查询！
	<%=basePath %>
<form action="<%=basePath %>billtime/findAll"  method="POST">
   账务账号编号：	<input type="text" id="id" name="id"/> 
   身份证号：	<input type="text" id="idcard" name="idcard"/> 
   用户姓名：	<input type="text" id="username" name="username"/> 
   账号：		<input type="text" id="loginname" name="loginname"/> 
    <input type="submit"  value="查询"/><br/>
</form>
<table id = "table0" border="1px">
<thead>
	<tr>
		<th>账务账单编号</th>
		<th>账务账号</th>
		<th>用户姓名</th>
		<th>身份证</th>
		<th>（拥有实验室数量）</th>
	</tr>
</thead>
<tbody>
</tbody>
</table>

</body>
<script type="text/javascript">
	$(function(){
		showData();	
	});
	//定义全局变量
	var page = 0;
	var rows = 5;
	var id = 0;
	var idcard = "";
	var username = "";
	var loginname = "";
	
	function showData(){
		var url = "billtime/findAll";
		var pageBean = {
				page:page,
				rows:rows,
				"params":{
					id:id,
					idcard:idcard,
					username:username,
					loginname:loginname
				}
			}
		
		$.ajax({
			type : "POST",
			url : url,
			async : true,
			data : {
				pageBean:pageBean
			},
			success : function(msg) {
				alert("成功返回");
				alert(msg.datas);
			}
		});
	}
</script>

</html>