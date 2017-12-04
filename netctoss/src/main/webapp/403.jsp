<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="header.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <title>权限错误</title>
	</head>
	<body>
		<h1>403，You don't have permission to access / on this server</h1>
		<a href="javascript:history.go(-1)">返回上一步</a>
		<a href="managermag/logout">退出</a>
	</body>
</html>