<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>  
<!-- 引入jstl核心库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- 引入shiro标签库 --> 
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  
<%
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >  
<html>  
  <head>  
  <base href="<%=basePath%>">
    <title>用户列表</title>  
  </head>  
  <body>  
    <h1>${message }</h1>  
    <h1>用户列表<a href="user/loginout">退出登录</a></h1> 
    <h2>权限列表</h2>  
    <shiro:authenticated>登陆状态 ：已经登陆</shiro:authenticated><br/>  
    <shiro:hasRole name="admin">认证身份：普通管理员</shiro:hasRole>  
    <shiro:hasRole name="超级管理员">认证身份：超级管理员</shiro:hasRole>  
    <shiro:hasRole name="user">认证身份：普通用户</shiro:hasRole>  
    <br/><br/>
    <shiro:hasAnyRoles name="超级管理员,admin">superadmin 和 admin 角色用户登录显示此内容</shiro:hasAnyRoles>  
    <br/><br/>
    <h6>当前用户名 :</h6>
    <%-- <shiro:principal/> --%>
    <br/><br/>
    <h6>权限列表:</h6>
    <shiro:hasPermission name="用户管理权限">user权限用户显示此内容---<br></shiro:hasPermission>  
    <shiro:hasPermission name="/zifei">zifei权限用户显示此内容---<br/></shiro:hasPermission>
    <shiro:hasPermission name="/root">root权限用户显示此内容---<br></shiro:hasPermission> 
    <shiro:hasPermission name="/baobiao">baobiao权限用户显示此内容---<br/></shiro:hasPermission>  
	<br/><br/>
    <%-- <shiro:lacksPermission name="user:delete">不具有delete权限的用户显示此内容<br/> </shiro:lacksPermission>   --%>
    
    <h6>功能列表:</h6>
    <a href="manger01">superadmin用户的功能</a>
    <a href="manger02">admin用户的功能</a>
    <br/><br/>
    <h6>操作列表:</h6>
    <shiro:hasPermission name="用户管理权限"><a href="user/add">添加用户</a></shiro:hasPermission>
    <shiro:hasPermission name="/zifei"><a href="user/delete">删除用户</a></shiro:hasPermission>
    <shiro:hasPermission name="/root"><a href="user/update">修改用户</a></shiro:hasPermission>
    <shiro:hasPermission name="/baobiao"><a href="user/query">查询用户</a></shiro:hasPermission>
    <br/><br/>
    <h6>用户详细信息:</h6>
    <ul>  
       <li>用户：${user}</li>
       <li>用户名：${user.userName }----密码：${user.passWord }----<a href="/user/upadte/${user.id}">修改用户</a>----<a href="javascript:;" class="del" ref="${user.id }">删除用户</a></li>  
       
    </ul>
     
    <script type="text/javascript" src="<%=basePath%>static/jquery-easyui-1.5.1/jquery.min.js"></script>  
    <script>  
        $(function(){  
            $(".del").click(function(){  
                var id=$(this).attr("ref");  
                $.ajax({  
                    type:"delete",  
                    url:"/user/del/"+id,  
                    success:function(e){       
                    }  
                });  
            });  
        });  
    </script>  
  </body>  
</html>  