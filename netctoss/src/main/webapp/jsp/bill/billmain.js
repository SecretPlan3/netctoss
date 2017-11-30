var page = 1;
var rows = 5;

$(function(){
	
	showUserBill();
	
	$("#queryBtn").click(function(){
		console.info("-----")
		showUserBill();
	});
});


function showUserBill(){
	var url = "bill/findUserBill";
	
	var page = {
			"page":page,
			"rows":rows,
			"params":{
				"userName":$("#userName").val(),
				"loginName":$("#loginName").val(),
				"idcard":$("#idCard").val(),
				"year":$("#year").val(),
				"month":$("#month").val(),
			}
	}
	$.ajax({
		type: "GET",
		url: url,
		async: true,
		data: page,
		success: function(msg){
			console.info(msg);
			showTable(msg);
		}
	});
	
	
}



function showTable(msg){
	//根据数组长度产生tr的数量
	var td = "";
	var th = "<tr id='tableHead'><th>账单编号</th><th>账务账号</th><th>用户姓名</th><th width='150'>身份证号</th><th>总费用/元</th><th>支付状态</th><th>支付方式</th><th>支付时间</th></tr>";
	for(var i=0;i<msg.datas.length;i++){
		td += "<tr index='"+msg.datas[i].id+"'><td>"+msg.datas[i].id+"</td><td>"+msg.datas[i].user.loginName+"</td><td>"+msg.datas[i].user.userName+"</td><td>"+ msg.datas[i].user.idcard+"</td><td>"+msg.datas[i].cost+"</td><td>"+msg.datas[i].payStatus+"</td><td>"+msg.datas[i].payMethod+"</td><td>"+msg.datas[i].payTime+"</td></tr>"
	}
	$("#table01").html(th + td);
	//添加页数和条数信息
	$("#p01").html("当前第"+msg.page+"页/共"+msg.totalPage+"页/一共"+msg.totalRows+"条");
	//动态显示页码按钮
	var ss = "";
	for(var j=1;j<=msg.totalPage;j++){
		ss+="<a href='javascript:showUserBill("+j+","+rows+")'>"+j+"</a>&nbsp;&nbsp;"
	}
	$("#p02").html(ss);

}