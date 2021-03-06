<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 1.首先要导入一篇header.jsp ,引入工程名全路径：bathpath-->
    <%@ include file="../../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 2.使用base为本页面设置一个 在相对路径前自动拼接上的路径，此处代表工程名加斜杠，它会使相对路径都变成绝对路径 -->
<base href="<%=basePath%>" >

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 3.引入自己需要的js、css 文件 此处的basepath可以上略，因为2.中说过 相对路径会自动拼接 -->
    <link rel="stylesheet" href="<%=basePath%>static/css/amazeui.min.css"/>
    <link rel="stylesheet" href="static/css/admin.css">
    <!--引入自定义样式-->
    <link rel="stylesheet" href="<%=basePath%>static/css/custom.css">
    <%-- <script src="<%=basePath%>static/js/jquery.min.js"></script> --%>

    <!-- jquery 和 json 的js -->
    <script src="<%=basePath%>static/js/jquery-3.2.1.min.js" charset="utf-8"></script>
	<script  src="<%=basePath%>static/js/jquery.json-2.4.js"></script>
 <!-- 4.页面规范的样式 -->
    <style>
        .header{
            width: 100%;
            height: 80px;
           /* border: red solid 1px;*/
        }
        .header h1{
            text-align: center;
            line-height: 80px;
        }
    </style>
</head>

<body>
    <div class="div_all">
        <div class="header">
            <h1>用户管理系统</h1>
        </div>
        <div class="listbiaoti am-cf">
            <ul class="am-icon-flag on"> 增加用户</ul>
            <dl class="am-icon-home" style="float: right;"> 当前位置：增加用户 > <a href="#">用户管理系统</a></dl>
        </div>
        <div class="content">
            <div class="content_add">
                <form role="form">
                    <div class="form-group">
                        <label>用户名</label>
                        <input type="text" id="userName" class="form-control" placeholder="用户名">
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input type="password" id="passWord" class="form-control" placeholder="密码" >
                    </div>
                     <div class="form-group">
                        <label>登录名</label>
                        <input type="text" id="loginName" class="form-control" placeholder="登录名">
                    </div>
                    <div class="form-group">
                        <label>状态</label>
                        <select id="status" class="form-control">
                            <option value= "1">开通</option>
                            <option value= "2">暂停</option>
                            <option value= "3">关闭</option>
                        </select> 
                    </div>
                    <div class="form-group">
                        <label>性别</label>
                        <select id="gender" class="form-control">
                            <option value= "1">男性</option>
                            <option value= "2">女性</option>
                            <option value ="3">未知</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>身份证号</label>
                        <input type="text" id="idcard" class="form-control" placeholder="身份证号">
                    </div>
                    <div class="form-group">
                        <label>电话号码</label>
                        <input type="text" id="tel" class="form-control" placeholder="电话号码">
                    </div>
                    <div class="form-group">
                        <label>地址</label>
                        <input type="text" id="address" class="form-control" placeholder="地址">
                    </div>
                    <div class="form-group">
                        <label>邮箱</label>
                        <input type="text" id="postcode" class="form-control" placeholder="邮箱" >
                    </div>
                     <div class="form-group">
                        <label>QQ号码</label>
                        <input type="text" id="qq" class="form-control" placeholder="QQ号码" >
                    </div>
                   	<div class="form-group">
                        <label>账户余额</label>
                        <input type="text" id="balance" class="form-control" placeholder="账户余额" >
                    </div>
                    <button type="submit" id="btn" class="btn  btn-xs">确定</button>
                    <button type="submit" id="btn2" class="btn  btn-xs">返回</button>
                </form>
            </div>
        </div>
    </div>
    
    <script type="text/javascript" src="<%=basePath%>static/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript">
    	$(function(){  
        $("#btn2").click(function(){  
        	window.location.href="jsp/user/usermain.jsp";
             
           
        });  
    });  
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
        $(function(){  
            $("#btn").click(function(){  
                
                var user = {
                	"userName":$("#userName").val(),	
                	"passWord":$("#passWord").val(),	
                	"loginName":$("#loginName").val(),
                	"status":$("#status").val(),
                	"gender":$("#gender").val(),
                	"idcard":$("#idcard").val(),
                	"address":$("#address").val(),
                	"postcode":$("#qq").val(),
                	"qq":$("#loginName").val(),
                	"tel":$("#tel").val(),
                	"balance":$("#balance").val(),
                	
                }
                
                
                $.ajax({  
                    type:"POST",  
                    url:"usermag/add",
                    async: true,
                    data:user,
                    success:function(e){   
                    	
                    }  
                });  
            });  
        });  
       
    </script>
    
</body>
</html>