<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath %>">
<title>登录页面</title>
    <script type="text/javascript" src="<%=basePath %>static/js/md5.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
</head>
<body>
<h1>登录页面</h1>
<form action="<%=basePath %>user/login" name="user" method="POST">
    用户名：<input type="text" name="userName"/> <br/>
    密&nbsp;&nbsp;码：<input type="password" id="password" name="passWord"/> <br/>
    <input type="button" onclick="submitform()" value="登录"/>
    <input type="reset" value="重置"/>
</form>
</body>
<script type="text/javascript">

    function submitform(){
    	var pwd=hex_md5($("#password").val());
    	$("#password").val(pwd);
        document.user.submit();
    }
</script>
</html>