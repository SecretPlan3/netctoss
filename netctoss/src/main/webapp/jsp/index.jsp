<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入头文件 -->
<%@ include file="../header.jsp"%>
<!-- 引入jstl核心库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 引入shiro标签库 -->
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>
<html>
<head>

<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>电信后台计费管理系统</title>
<meta name="keywords" content="index">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" href="static/css/amazeui.min.css" />
<link rel="stylesheet" href="static/css/admin.css">
<!--引入自定义样式-->
<link rel="stylesheet" href="static/css/custom.css">
<script src="static/js/jquery.min.js"></script>
<script src="static/js/app.js"></script>

<!--引入当前时间-->
<script src="static/js/custom/clock.js" type=text/javascript></script>
</head>
<body>
	<header class="am-topbar admin-header">
		<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">
				<li class="kuanjie"><a href="personinfo.jsp">个人信息</a> <a
					href="chgpwd.jsp">修改密码</a> <a href="setting.jsp">系统设置</a> <a
					href="managermag/logout">退出登录</a></li>

				<li class="soso">

					<p>
						<select
							data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}">
							<option value="b">全部</option>
							<option value="o">产品</option>
							<option value="o">会员</option>
						</select>
					</p>

					<p class="ycfg">
						<input type="text" class="am-form-field am-input-sm"
							placeholder="圆角表单域" />
					</p>
					<p>
						<button class="am-btn am-btn-xs am-btn-default am-xiao"
							style="border: greenyellow solid 1px">
							<i class="am-icon-search"></i>
						</button>
					</p>
				</li>

				<li class="am-hide-sm-only" style="float: right;"><a
					href="javascript:;" id="admin-fullscreen"><span
						class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
			</ul>
		</div>
	</header>





	<div class="am-cf admin-main">
		<div class="nav-navicon admin-main admin-sidebar">
			<div class="sideMenu am-icon-dashboard"
				style="color: #aeb2b7; margin: 10px 0 0 0;">


				<!-- 验证登录后shiro中所携带的信息 -->
				<shiro:authenticated>登陆状态 ：已经登陆</shiro:authenticated>
				<br />

				<h6>欢迎您 :</h6>
				<shiro:principal />
				，

				<shiro:hasRole name="超级管理员">超级管理员</shiro:hasRole>
				<shiro:hasRole name="普通用户">普通用户</shiro:hasRole>
				<shiro:hasRole name="资费管理员">资费管理员</shiro:hasRole>
				<shiro:hasRole name="用户管理员">用户管理员</shiro:hasRole>
				<shiro:hasRole name="账单管理员">账单管理员</shiro:hasRole>
				<shiro:hasRole name="账务管理员">账务管理员</shiro:hasRole>
				<shiro:hasRole name="报表管理员">报表管理员</shiro:hasRole>
				<shiro:hasRole name="日志管理员">日志管理员</shiro:hasRole>
				<shiro:hasRole name="权限管理员">权限管理员</shiro:hasRole>
				

				<%-- <shiro:hasAnyRoles name="超级管理员,用户管理员"> 超级管理员,用户管理员 角色用户登录显示此内容</shiro:hasAnyRoles>  
  --%>



				<%--  <h6>权限列表:</h6>
    <shiro:hasPermission name="用户管理权限">用户权限用户显示此内容---<br></shiro:hasPermission>  
    <shiro:hasPermission name="资费管理权限">资费权限用户显示此内容---<br/></shiro:hasPermission>
    <shiro:hasPermission name="权限管理权限">权限权限用户显示此内容---<br></shiro:hasPermission> 
    <shiro:hasPermission name="/baobiao">baobiao权限用户显示此内容---<br/></shiro:hasPermission>  
	<br/><br/> --%>
				<!-- /验证登录后shiro中所携带的信息 -->

			</div>
			<div class="sideMenu">
				<h3 class="am-icon-flag">
					<em></em> <a onclick="javascript:showUser();return false;" href="#"
						target="myiframe">用户管理系统</a>
				</h3>
				<ul>
					<li>xxxx</li>
				</ul>
				<h3 class="am-icon-cart-plus">
					<em></em> <a onclick="javascript:showCost();return false;" href="#"
						target="myiframe"> 资费管理系统</a>
				</h3>
				<ul>
					<li>所有资费套餐</li>
					<li>自助资费套餐</li>
					<li>计时资费套餐</li>
					<li>包月资费套餐</li>
				</ul>
				<h3 class="am-icon-users">
					<em></em> <a onclick="javascript:showManager();return false;"
						href="#" target="myiframe">管理员管理系统</a>
				</h3>
				<ul>
					<li>xxxx</li>
				</ul>
				<h3 class="am-icon-volume-up">
					<em></em> <a onclick="javascript:showBill();return false;" href="#"
						target="myiframe">账单查询系统</a>
				</h3>
				<ul>
					<li><a href="javaScript:showBill();return false;">账单查询</a></li>
				</ul>
				<h3 class="am-icon-gears">
					<em></em> <a onclick="javascript:showBilltime();return false;" href="#"
						target="myiframe">账务查询系统</a>
				</h3>
				<ul>
					<li>年详情</li>
					<li>月详情</li>
				</ul>


				<h3 class="am-icon-gears">
					<em></em> <a onclick="javascript:showPermission();return false;"
						href="#" target="myiframe">权限管理系统</a>
				</h3>
				<ul>
					<li>用管理员管理</li>
					<li>权限管理</li>

				</ul>

				<h3 class="am-icon-gears">
					<em></em> <a onclick="javascript:showLog();return false;" href="#"
						target="myiframe">前台日志系统</a>
				</h3>
				<ul>
					<li>登陆日志</li>
					<li>操作日志</li>

				</ul>

				<h3 class="am-icon-gears">
					<em></em> <a onclick="javascript:showReport();return false;"
						href="#" target="myiframe">报表查询系统</a>
				</h3>
				<ul>
					<li>比例图</li>
					<li>走势图</li>

				</ul>
			</div>
			<!-- 左侧导航栏效果 -->
			<script type="text/javascript">
				jQuery(".sideMenu").slide({
					titCell : "h3", //鼠标触发对象
					targetCell : "ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
					effect : "slideDown", //targetCell下拉效果
					delayTime : 300, //效果时间
					triggerTime : 150, //鼠标延迟触发时间（默认150）
					defaultPlay : true,//默认是否执行效果（默认true）
					returnDefault : false
				//鼠标从.sideMen移走后返回默认状态（默认false）
				});
			</script>

		</div>

		<div class=" admin-content">
			<!--系统当前时间-->
			<div class="daohang">
				<p id="clock" class="time"></p>
				<script type="text/javascript">
					var clock = new Clock();
					clock.display(document.getElementById("clock"));
				</script>
			</div>

			<div class="admin">
				<iframe id="iframe1" class="iframe1" src="jsp/cost/costmag.jsp"
					frameborder="0" name="myiframe"> </iframe>
				<div class="foods">
					<ul>版权所有@2017 LOVO有限责任公司
					</ul>
					<dl>
						<a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
					</dl>
				</div>
			</div>

		</div>
	</div>


	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="static/js/polyfill/rem.min.js"></script>
<script src="static/js/polyfill/respond.min.js"></script>
<script src="static/js/amazeui.legacy.js"></script>
<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="static/js/amazeui.min.js"></script>
	<!--<![endif]-->
	<script>
		//给下拉导航菜单绑定监听事件

		// 跳转IFrame到账单页面
		function showCost() {
			$("#iframe1").attr("src", "jsp/cost/costmag.jsp");
		}

		//跳转IFrame到账单页面
		function showBill() {
			$("#iframe1").attr("src", "jsp/bill/billmain.jsp");
		};

		//跳转IFrame到账务查询页面
		function showBilltime() {
			$("#iframe1").attr("src", "jsp/billtime/billtimemain.jsp");
		};

		//跳转IFrame到管理员管理页面
		function showManager() {
			$("#iframe1").attr("src", "jsp/manager/managermain.jsp");
		};

		//跳转IFrame到权限管理页面
		function showPermission() {
			$("#iframe1")
					.attr("src", "jsp/permission/permissionmain.jsp");
		};

		//跳转IFrame到用户管理页面
		function showUser() {
			$("#iframe1").attr("src", "jsp/user/usermain.jsp");
		};

		//跳转IFrame到报表查询页面
		function showReport() {
			$("#iframe1").attr("src", "jsp/report/reportmain.jsp");
		};
	</script>
</body>
</html>