var thePage = 1;
var rows = 5;
var totalRows = 0;
var totalPage = 0;

var osName = "";
var costName = "";

var year = getQueryString("year");
var month = getQueryString("month");
var userID = getQueryString("userID");
var loginName = getQueryString("loginName");
var userName = getQueryString("userName");
var loginTime = year + "-" +month + "-" + 01;
var logoutTime = year + "-" +month + "-" + 32;

$(function(){
	$("#h4_loginName").html("账务账号：<strong>"+loginName+"</strong>");
	$("#h4_userName").html("用户姓名：<strong>"+userName+"</strong>");
	$("#h4_date").html("日期：<strong>"+year+"</strong> 年 <strong>"+month+"</strong> 月");
	//初始化表格数据
	showUserBill();
	
});

//解析URL地址参数
function getQueryString(value) {
    var reg = new RegExp("(^|&)" + value + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]); 
    return null;
}

//请求表格数据
function showUserBill(){
	var url = "bill/findServiceBill";
	var page = {
			"page":thePage,
			"rows":rows,
			"params":{
				"userID":getQueryString("userID"),
				"year":getQueryString("year"),
				"month":getQueryString("month"),
			}
	}
	$.ajax({
		type: "GET",
		url: url,
		async: true,
		data: page,
		success: function(msg){
			showTable(msg);
		}
	});
}

//将数据显示在表格
function showTable(msg){
	//根据数组长度产生tr的数量
	var td = "";
	var th = "<tr id='tableHead'>" +
			"<th>业务编号</th>" +
			"<th>业务账号</th>" +
			"<th>服务器信息</th>" +
			"<th>使用时长	时:分:秒</th>" +
			"<th>总费用/元</th>" +
			"<th>资费套餐</th>" +
			"</tr>";
	for(var i=0;i<msg.datas.length;i++){
		td += "<tr index='"+msg.datas[i].id+"' data-toggle='modal' data-target='#myModal_001'>" +
				"<td>"+msg.datas[i].id+
				"</td><td id='osName'>"+msg.datas[i].osName+
				"</td><td>"+msg.datas[i].unixHost+
				"</td><td>"+timeLongToString(msg.datas[i].serviceYear[0].serviceMonthly[0].onlineTime)+
				"</td><td>"+msg.datas[i].serviceYear[0].serviceMonthly[0].cost+
				"</td><td id='costName'>"+msg.datas[i].cost.name+
				"</td></tr>"
	}
	$("#table01").html(th + td);
	//动态显示关于页面的信息
	$("#yema1").html("当前第"+msg.page+"页/共"+msg.totalPage+"页/一共"+msg.totalRows+"条");
	
	$("#tableHead").addClass("am-success");
	$("th").addClass("table-title am-text-center");
	$("td").addClass("am-text-center");
	if(msg.datas.length == 0){
		$("#table_div").append("<div class='alert_notfound am-alert am-alert-warning' data-am-alert>" +
				"<button type='button' class='am-close'>&times;" +
				"</button><p>未找到匹配数据</p></div>");
	}
	setClick();
//	//添加页数和条数信息
//	$("#p01").html("当前第"+msg.page+"页/共"+msg.totalPage+"页/一共"+msg.totalRows+"条");
//	//动态显示页码按钮
//	var ss = "";
//	for(var j=1;j<=msg.totalPage;j++){
//		ss+="<a href='javascript:showUserBill("+j+","+rows+")'>"+j+"</a>&nbsp;&nbsp;"
//	}
//	$("#p02").html(ss);
	
}



//表格点击事件
function setClick(){
	$("#table01").children().children("tr").not("#tableHead").each(function(){
		$(this).click(function (){
			osName = $(this).children("#osName").html();
			costName = $(this).children("#costName").html();
			
			thePage = 1;
			rows = 5;
			totalRows = 0;
			totalPage = 0;
			
			jumpShowServiceBill(osName,costName);
		})
	});
}

//请求数据
function jumpShowServiceBill(arge,arge6){
	var url = "bill/findServiceTimeBill";
	var page = {
			"page":thePage,
			"rows":rows,
			"params":{
				"osName":osName,
				"loginTime":loginTime,
				"logoutTime":logoutTime,
			}
	}
	$.ajax({
		type: "GET",
		url: url,
		async: true,
		data: page,
		success: function(msg){
			showServiceTimeBillTable(msg,arge6);
		}
	});
}

//显示表格
function showServiceTimeBillTable(msg,arge7){
	//根据数组长度产生tr的数量
	var td = "";
	var th = "<tr id='tableHead2'>" +
			"<th>服务器信息</th>" +
			"<th>登录时间</th>" +
			"<th>登出时间</th>" +
			"<th>使用时长	时:分:秒</th>" +
			"<th>总费用/元</th>" +
			"<th>资费套餐</th>" +
			"</tr>";
	for(var i=0;i<msg.datas.length;i++){
		td += "<tr index='"+msg.datas[i].id+"'>" +
				"</td><td >"+msg.datas[i].serviceTime.unxiHost+
				"</td><td >"+msg.datas[i].serviceTime.loginTime+
				"</td><td>"+msg.datas[i].serviceTime.logoutTime+
				"</td><td>"+timeLongToString(msg.datas[i].serviceTime.onlineTime)+
				"</td><td>"+msg.datas[i].cost+
				"</td><td>"+arge7+
				"</td></tr>"
	}
	$("#table02").html(th + td);
	//动态显示关于页面的信息
	$("#yema2").html("当前第"+msg.page+"页/共"+msg.totalPage+"页/一共"+msg.totalRows+"条");
	
	$("#tableHead2").addClass("am-success");
	$("th").addClass("table-title am-text-center");
	$("td").addClass("am-text-center");
	if(msg.datas.length == 0){
		$("#table_div2").append("<div class='alert_notfound am-alert am-alert-warning' data-am-alert>" +
				"<button type='button' class='am-close'>&times;" +
				"</button><p>未找到匹配数据</p></div>");
		var time1 = setTimeout(function(){
			$('.alert_notfound').alert('close');
		},1500);
//		//关闭弹框按钮
//		$("closeTC").click(function(){
//			$('.alert_notfound').alert('close');
//			window.clearTimeout(time1);
//		});
	}
}

//时间数据转换
function timeLongToString(longTime){
	//总秒数
	var s =  longTime / 1000;
	//小时数
	var hs = parseInt(s/3600); 
	//分钟数
	var mins =  parseInt((s-hs*3600)/60); 
	 //秒数 
	var ss =  parseInt((s-hs*3600-mins*60));
	 //最后的String格式的时间
	var time = "" + hs + ":" + mins +  ":" + ss;
	return time;
}

//首页
function first(){
	if(thePage != 1){
		thePage = 1;
		showUserBill();
	}
}
//上一页
function pre(){
	if(thePage > 1){
		thePage = thePage-1;
		showUserBill();
	}
}

//跳转
function jump(){
	var input = $("#page").val();
	var inputPage = parseInt(input);
	if(isNaN(inputPage)){
		$("#tza").html("<lable id='tza_tza' style='color:red'>请输入范围内的页数：(1~" + totalPage + ")</lable>");
		$("#tza_tza").mouseout(function () { 
			window.setTimeout(function(){
				$("#tza").html("跳转");  
			},1000);
	    });
	}else{
		if( inputPage > 0 && inputPage <= totalPage ){
			if(thePage != inputPage){//若页数相同 则不进行跳转
				thePage = inputPage;
				showUserBill();
			}
		}else{
			$("#tza").html("<lable id='tza_tza2' style='color:red'>页数(" + inputPage + ")超出范围!\n请输入范围内的页数：1~" + totalPage + ")</lable>");
			$("#tza_tza2").mouseout(function () {  
				window.setTimeout(function(){
					$("#tza").html("跳转");  
				},1000);
		    });
		}
	}
	 $("#page").val("");
}
//下一页
function next(){
	if(thePage < totalPage){
		thePage = thePage+1;
		showUserBill()
	}
};
//尾页
function end(){
	if(thePage != totalPage){
		thePage = totalPage;
		showUserBill()
	}
}

//首页2
function first2(){
	if(thePage != 1){
		thePage = 1;
		jumpShowServiceBill(osName,costName);
	}
}
//上一页2
function pre2(){
	if(thePage > 1){
		thePage = thePage-1;
		jumpShowServiceBill(osName,costName);
	}
}
//跳转2
function jump2(){
	var input = $("#page2").val();
	var inputPage = parseInt(input);
	if(isNaN(inputPage)){
		$("#tza2").html("<lable id='tza_tza3' style='color:red'>请输入范围内的页数：(1~" + totalPage + ")</lable>");
		$("#tza_tza3").mouseout(function () { 
			window.setTimeout(function(){
				$("#tza2").html("跳转");  
			},1000);
	    });
	}else{
		if( inputPage > 0 && inputPage <= totalPage ){
			if(thePage != inputPage){//若页数相同 则不进行跳转
				thePage = inputPage;
				jumpShowServiceBill(osName,costName);
			}
		}else{
			$("#tza2").html("<lable id='tza_tza4' style='color:red'>页数(" + inputPage + ")超出范围!\n请输入范围内的页数：1~" + totalPage + ")</lable>");
			$("#tza_tza4").mouseout(function () {  
				window.setTimeout(function(){
					$("#tza2").html("跳转");  
				},1000);
		    });
		}
	}
	 $("#page").val("");
}
//下一页2
function next2(){
	if(thePage < totalPage){
		thePage = thePage+1;
		jumpShowServiceBill(osName,costName);
	}
};
//尾页2
function end2(){
	if(thePage != totalPage){
		thePage = totalPage;
		jumpShowServiceBill(osName,costName);
	}
}

