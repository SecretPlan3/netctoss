<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"
	src="<%=basePath%>static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>jsp/bill/billmain.js"
	charset="utf-8"></script>
<title>用户账单</title>
</head>
<body>
	欢迎来到账务管理主页！
	<!-- 模糊查询 -->
	<table>
		<tr>
			<td>年份：</td>
			<td>
				<select id="year" name="year">
					<option value="2017">2017</option>
					<option value="2016">2016</option>
					<option value="2015">2015</option>
				</select>
			</td>
			<td>月份：</td>
			<td>
				<select id="month" name="month">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="10">10</option>
				</select>
			</td>
			<td>账务账号：</td>
			<td><input id="loginName" type="text" name="loginName" /></td>
			<td>用户姓名：</td>
			<td><input id="userName" type="text" name="userName" /></td>
			<td>身份证号：</td>
			<td><input id="idCard" type="text" name="idCard" /></td>
			<td colspan="2"><input id="queryBtn" type="button" value="查询" /></td>
		</tr>
	</table>

	<!-- 显示列表 -->
	<table id='table01' border=1>
		<!-- 动态数据 -->
	</table>
	<p id="p01"></p>
	<p id="p02"></p>
</body>
</html>

