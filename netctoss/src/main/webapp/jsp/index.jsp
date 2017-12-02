<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<li class="kuanjie"><a href="#">个人信息</a> <a href="#">修改密码</a> <a
				href="#">系统设置</a></li>

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
				style="color: #aeb2b7; margin: 10px 0 0 0;">欢迎系统管理员：杨鹏</div>
			<div class="sideMenu">
				<h3 class="am-icon-flag">
					<em></em> <a href="#">用户管理系统</a>
				</h3>
				<ul>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
				</ul>
				<h3 class="am-icon-cart-plus">
					<em></em> <a onclick="javascript:showuser();return false;" href="#"
						target="myiframe"> 资费管理系统</a>
				</h3>
				<ul>
					<li>所有资费套餐</li>
					<li>自助资费套餐</li>
					<li>计时资费套餐</li>
					<li>包月资费套餐</li>
				</ul>
				<h3 class="am-icon-users">
					<em></em> <a href="#">管理员管理系统</a>
				</h3>
				<ul>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
				</ul>
				<h3 class="am-icon-volume-up">
					<em></em> <a href="#">账单查询系统</a>
				</h3>
				<ul>
					<li><a href="javaScript:showbill()">账单查询</a></li>
				</ul>
				<h3 class="am-icon-gears">
					<em></em> <a href="#">账务查询系统</a>
				</h3>
				<ul>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
				</ul>


				<h3 class="am-icon-gears">
					<em></em> <a href="#">权限管理系统</a>
				</h3>
				<ul>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
				</ul>

				<h3 class="am-icon-gears">
					<em></em> <a href="#">前台日志系统</a>
				</h3>
				<ul>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
				</ul>

				<h3 class="am-icon-gears">
					<em></em> <a href="#">报表查询系统</a>
				</h3>
				<ul>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
					<li>xxxx</li>
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
					<ul>版权所有@2017 LOVO有限责任公司</ul>
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
		function showuser() {
			$("#iframe1").attr("src", "jsp/cost/costmag.jsp");
		}

		//跳转IFrame到账单页面
		function showbill() {
			$("#iframe1").attr("src", "../../jsp/bill/billmain.jsp");
		};
	</script>
</body>
</html>