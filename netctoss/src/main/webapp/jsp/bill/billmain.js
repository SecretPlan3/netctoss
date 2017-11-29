var page = 1;
var rows = 5;

function showUserBill(){
	var url = "bill/findUserBill";
	var page = {"page":page,"rows":rows}
	$.ajax({
		type: "GET",
		url: url,
		async: true,
		data: page,
		success: function(msg){
			alert(msg);
		}
	});
	
	
}

showUserBill();