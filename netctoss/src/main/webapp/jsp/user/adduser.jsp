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
<title>增加用户</title>
    <script type="text/javascript" src="<%=basePath %>static/js/md5.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
</head>
<body>
<h1>增加用户</h1>
<form action="<%=basePath %>user/adduser" method="POST">
    用户名：<input type="text" name="userName"/> <br/>
    密&nbsp;&nbsp;码：<input type="password" id="password" name="passWord"/> <br/>
    登录名：<input type="text" id="loginName" name="loginName"/> <br/>
    状&nbsp;&nbsp;态：<input type="text" id="status" name="status"/> <br/>
    性&nbsp;&nbsp;别：<input type="text" id="gender" name="gender"/> <br/>
    身份证号：<input type="text" id="idcard" name="idcard"/> <br/>
    电话号码：<input type="text" id="tel" name="tel"/> <br/>
    地&nbsp;&nbsp;址：<input type="text" id="address" name="address"/> <br/>
    邮&nbsp;&nbsp;编：<input type="text" id="postcode" name="postcode"/> <br/>
  QQ号码：<input type="text" id="qq" name="qq"/> <br/>
    角&nbsp;&nbsp;色：<input type="text" id="roler" name="roler"/> <br/>
    账户余额：<input type="text" id="balance" name="balance"/> <br/>  
    <input type="submit"  value="添加"/>
   	
</form>
</body>


</html>