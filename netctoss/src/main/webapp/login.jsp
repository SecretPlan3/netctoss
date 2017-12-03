<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ include file="header.jsp" %>  
<!DOCTYPE html>
<html>
<head>
	<title>登录页面</title>
<!-- 跟路径 -->
	<base href="<%=basePath %>">
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    
<!-- CSS -->
	<link rel='stylesheet'
		href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
	<link rel="stylesheet" href="static/css/reset.css">
	<link rel="stylesheet" href="static/css/supersized.css">
	<link rel="stylesheet" href="static/css/style.css">

<!-- js -->
    <script type="text/javascript" src="static/js/md5.js"></script>
 <!--    <script type="text/javascript" src="static/js/jquery.min.js"></script> -->
    
<!--自定义js-->
    <script src="static/js/custom.js"></script>
    

</head>
<body>
        <div class="page-container">
            <h1>中国电信</h1>
            <form action="<%=basePath %>user/login" id = "form0" name="user" method="post">
                <input type="text" name="userName" class="userName" placeholder="账号">
                <input type="password" name="password" id="password" class="password" placeholder="密码">
                <button type="submit">登 陆</button>
                <input type="reset" value="重置"/> 
                <div class="error"><span>+</span></div>
            </form>

            <div class="connect">
                <a style="color: white;font-size: 14px;width: 100px" href="managerlogin.jsp" target="_self" title="管理员登陆">管理员登陆</a>
                <p>
                    <a class="facebook" href="http://www.facebook.com"></a>
                    <a class="twitter" href="http://www.twitter.com/ "></a>
                </p>
            </div>
        </div>
        <div align="center">Collect from <a href="http://www.189.cn/" target="_blank" title="中国电信">中国电信</a></div>

 <!-- Javascript -->
 		<script src="static/js/jquery-1.8.2.min.js"></script>
        <script src="static/js/supersized.3.2.7.min.js"></script>
        <script src="static/js/supersized-init.js"></script>
        <script src="static/js/scripts.js"></script>
   <!-- js脚本 -->     
	<script>
	//表单提交事件
		$("#form0").on({"submit":submitform});
	    function submitform(){
	    	var pwd=hex_md5($("#password").val());
	    	$("#password").val(pwd);
	        document.user.submit();
	    }
	</script>

</body>
</html>