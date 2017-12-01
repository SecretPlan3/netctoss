var page = 1;
var rows = 5;
var year = getQueryString("year");
var month = getQueryString("month");
var userID = getQueryString("userID");
var loginName = getQueryString("loginName");
var userName = getQueryString("userName");

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
			"page":page,
			"rows":rows,
			"params":{
				"userID":getQueryString("userID"),
				"year":getQueryString("year"),
				"month":4,
			}
	}
	$.ajax({
		type: "GET",
		url: url,
		async: true,
		data: page,
		success: function(msg){
			showTable(msg);
//			console.info(msg);
		}
	});
}

//将数据显示在表格
function showTable(msg){
	//根据数组长度产生tr的数量
	var td = "";
	var th = "<thead><tr id='tableHead'>" +
			"<th>业务编号</th>" +
			"<th>业务账号</th>" +
			"<th>服务器信息</th>" +
			"<th>使用时长	时:分:秒</th>" +
			"<th>总费用/元</th>" +
			"<th>资费套餐</th>" +
			"</tr></thead><tbody>";
	for(var i=0;i<msg.datas.length;i++){
		td += "<tr index='"+msg.datas[i].id+"'>" +
				"<td>"+msg.datas[i].id+
				"</td><td>"+msg.datas[i].osName+
				"</td><td>"+msg.datas[i].unixHost+
				"</td><td>"+msg.datas[i].serviceYear[0].serviceMonthly[0].cost+
				"</td><td>"+msg.datas[i].serviceYear[0].serviceMonthly[0].onlineTime+
				"</td><td>"+msg.datas[i].cost.name+
				"</td></tr>"
		if(i = msg.datas.length - 1){
			td += "</tbody>";
		}
	}
	$("#table01").html(th + td);
	
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
			//得到被选中的元素的ID
			var id = $(this).attr("index");
			userID = parseInt(id);
			loginName = $(this).children("#loginName").html();
			userName = $(this).children("#userName").html();
			jumpShowServiceBill();
		})
	});
}

//跳转页面
function jumpShowServiceBill(){
	window.location.href="jsp/bill/servicetimebill.jsp?year="+year+"&month="+month+"&userID="+userID+"&loginName="+loginName+"&userName="+userName;
}





