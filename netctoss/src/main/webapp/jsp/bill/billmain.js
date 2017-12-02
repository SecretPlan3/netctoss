var thePage = 1;
var rows = 5;
var totalRows = 0;
var totalPage = 0;

var year = "";
var month = "";
var userID = 0;
var loginName = "";
var userName = "";

$(function(){
	//初始化年份//未使用
//	findAllYear();
	//初始化表格数据
	showUserBill();
	//点击模糊查询按钮
	$("#queryBtn").click(function(){
		showUserBill();
	}); 
	//点击模糊查询账务账号按钮
	$("#loginNameBtn").click(function(){
		$("#loginName").val("");
	});
	//点击模糊查询用户姓名按钮
	$("#userNameBtn").click(function(){
		$("#userName").val("");
	});
	//点击模糊查询身份证按钮
	$("#idCardBtn").click(function(){
		$("#idCard").val("");
		getDate();
	});
	
	
});

//请求表格数据
function showUserBill(){
	var url = "bill/findUserBill";
	
	var page = {
			"page":thePage,
			"rows":rows,
			"params":{
				"userName":$("#userName").val(),
				"loginName":$("#loginName").val(),
				"idcard":$("#idCard").val(),
				"year":$("#yearSel").val(),
				"month":$("#monthSel").val(),
			}
	}
	$.ajax({
		type: "GET",
		url: url,
		async: true,
		data: page,
		success: function(msg){
			thePage = msg.page;
			rows = msg.rows;
			totalRows = msg.totalRows;
			totalPage = msg.totalPage
			showTable(msg);
		}
	});
}
//请求后台得到年
//function findAllYear(){
//	var page = {};
//	$.ajax({
//		type: "GET",
//		url: "bill/findAllYear",
//		async: false,
//		data: page,
//		success: function(msg){
//			setSelectBtn(msg);
//		}
//	});
//}

//将数据显示在表格
function showTable(msg){
	//根据数组长度产生tr的数量
	var td = "";
	var th = "<tr id='tableHead'>" +
			"<th>账单编号</th>" +
			"<th>账务账号</th>" +
			"<th>用户姓名</th>" +
			"<th>身份证号</th>" +
			"<th>总费用/元</th>" +
			"<th>支付状态</th>" +
			"<th>支付方式</th>" +
			"<th>支付时间</th>" +
			"</tr>";
	for(var i=0;i<msg.datas.length;i++){
		td += "<tr index='"+msg.datas[i].id+"'>" +
				"<td>"+msg.datas[i].id+
				"</td><td id='loginName'>"+msg.datas[i].user.loginName+
				"</td><td id='userName'>"+msg.datas[i].user.userName+
				"</td><td>"+msg.datas[i].user.idcard+
				"</td><td>"+msg.datas[i].cost+
				"</td><td>"+payStatusRing(msg.datas[i].payStatus)+
				"</td><td>"+payTypeRing(msg.datas[i].payMethod)+
				"</td><td>"+msg.datas[i].payTime+
				"</td></tr>"
	}
	$("#table01").html(th + td);
	//动态显示关于页面的信息
	$("#yema").html("当前第"+msg.page+"页/共"+msg.totalPage+"页/一共"+msg.totalRows+"条");
	
	$("#tableHead").addClass("am-success");
	$("th").addClass("table-title am-text-center");
	$("td").addClass("am-text-center");
	if(msg.datas.length == 0){
		$("#table_div").append("<div class='alert_notfound am-alert am-alert-warning' data-am-alert>" +
				"<button type='button' class='am-close'>&times;" +
				"</button><p>未找到匹配数据</p></div>");
		window.setTimeout(function(){
			$('.alert_notfound').alert('close');
		},1500);
	}
	year = $("#yearSel").val();
	month = $("#monthSel").val();
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

//将年显示在下拉框中//未使用
//function setSelectBtn(msg){
//	var ht = "";
//	var hb = "";
//	for(var i=0;i<msg.datas.length;i++){
//		$("#yearSel").append("<option value="+msg.datas[i].year+">"+ msg.datas[i].year +"</option>");
//		if(i == 0){
//			ht += "<button type='button' class='am-selected-btn am-btn am-dropdown-toggle am-btn-sm am-btn-default' style='width: 110px;'>" +
//					"<span class='am-selected-status am-fl'>"+
//					msg.datas[0].year+"</span> " +
//					"<i class='am-selected-icon am-icon-caret-down'>" +
//					"</i></button>"
//			hb += "<li class='am-checked' data-index='0' data-group='0' data-value='"+
//					msg.datas[i].year+"'><span class='am-selected-text'>"+
//					msg.datas[i].year+"</span> " +
//					"<i class='am-icon-check'></i></li>"
//		}
//		hb = "<li class='data-index=&quot;"+(i+1)+
//				"&quot;' data-group='0' data-value='"+
//				msg.datas[i].year+"'><span class='am-selected-text'>"+
//				msg.datas[i].year+"</span> " +
//				"<i class='am-icon-check'></i></li>";	
//	}
//	$("#selPPP").children().children("button").html(ht);
//	$("#selPPP").children().children().children("ul").html(hb);
//}

//生成年和月//未使用
//function getDate(){
//	var nowDate = new Date();
//	var nowYear = nowDate.getFullYear(); 
//	var nowMonth = nowDate.getMonth() + 1;
//}

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
	window.location.href="jsp/bill/servicebill.jsp?year="+year+"&month="+month+"&userID="+userID+"&loginName="+loginName+"&userName="+userName;
}

//支付状态数据转换
function payStatusRing(args){
	if(args == "0"){
		return "<a href='#'>未支付</a>";
	}else if(args == "1"){
		return "已支付";
	}
}

//支付方式数据转换
function payTypeRing(args){
	if(args == "1"){
		return "柜台支付";
	}else if(args == "2"){
		return "在线支付";
	}else if(args == "3"){
		return "微信支付";
	}
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


