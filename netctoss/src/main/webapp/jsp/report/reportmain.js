//定义全局变量
	//pagerBean相关的属性
	var page = 1;
	var rows = 5;
	var totalRows = 0;
	var totalPage = 0;
	//查询条件
	var params = {};
	var theLoginName = "";
	var theUserID = "";
	var theYear = "";
	var theOSName = "";
	
	//初始化echarts实例
    var myChart;
    var myChart2;
    
    //图表格式对象 
    var theNormal = {formatter: '{b}：{d}%'};
	var theLabel = {normal: theNormal};

	//页面加载完组件后，直接执行的内容
	$(function(){
		showData();	
	});
	
	// 分页查询显示表格数据的方法
	function showData(){
		var url = "billtime/findAll";
		$.ajax({
			type : "POST",
			url : url,
			async : true,
			data : {
				"page":page,
				"rows":rows,
				"params":params,
			},
			success : function(msg) {
				//alert("成功返回");
				//处理返回数据，给全局变量赋值等
				page = msg.page;
				rows = msg.rows;
				totalRows = msg.totalRows;
				totalPage = msg.totalPage;
				var datas = msg.datas;
				var s = "";
				for (var i = 0; i < datas.length; i++) {
					s+= "<tr value="+datas[i].userId+" data-toggle='modal' data-target='#myModal_001'><td id='userIDTd' class='am-text-center'>"
					+datas[i].userId+"</td> <td id='loginNameTd'>"
					+datas[i].loginName+"</td><td>"
					+datas[i].userName+"</td><td>"
					+datas[i].idcard+"</td></tr>"
				}
				$("#table0 tbody").html(s);
				
				$("th").addClass("table-title am-text-center");
				$("td").addClass("am-text-center");
				//给每行添加点击事件
			 	//绑定事件******************************************************
					$("tr").each(function(i,val){ 
						if(i != 0){//第一行不绑定
							$(this).on("click",function(){
								//动态显示模态框账务账号
								theLoginName = $(this).children("#loginNameTd").html();
								$("#loginNameSP").html("账务账号：" + theLoginName);
								//动态显示年
								//动态显示业务账号
								theUserID = $(this).children("#userIDTd").html();
								
								findAllServiceByUserID();
								
								$("#OSNameSel").html("");
								
								$(".div_asss").removeClass("asss");
								$("#userChartBtn").addClass("asss");
								$("#serviceChart").hide();
								$("#userChart").show();
								$(".OSNameSel").show();
							})  
						}
						
					})
			//***************************************************************
				
			}
		});
	}
	
	//查询函数 ---查询按钮点击事件
	function search(){
		/*param 中d的条件数据的形式为键值对存放的json对象,如：*/
		params = {
			idcard:$("#idcard").val(),
			userName:$("#userName").val(),
			loginName:$("#loginName").val()
		}; 
		showData();	//调用显示数据函数，ajax刷新页面
	}

	//翻页按钮 绑定的监听事件 ++++++++++++++++++++++++++
	//跳转
	 function jump(){
		var input = $("#page").val();
		var inputPage = parseInt(input);
		if(isNaN(inputPage)){
			alert("请输入范围内的页数：(1~" + totalPage + ")");
		}else{
			if( inputPage > 0 && inputPage <= totalPage ){
				if(page != inputPage){//若页数相同 则不进行跳转
					page = inputPage;
					showData();
				}
			}else{
				alert("页数(" + inputPage + ")超出范围!\n请输入范围内的页数：1~" + totalPage ) ;
			}
		}
		 $("#page").val("");
	}
	//首页
	function first(){
		if(page != 1){
			page = 1;
			showData();
		}
	}
	//上一页
	function pre(){
		if(page > 1){
			page = page-1;
			showData();
		}
	}
	//下一页
	function next(){
		if(page < totalPage){
			page = page+1;
			showData();
		}
	};
	//尾页
	function end(){
		if(page != totalPage){
			page = totalPage;
			showData();
		}
	}
	
	
function showChart(){
	//初始化echarts实例
    myChart = echarts.init(document.getElementById("main"));
	 // 绘制饼图。
    myChart.setOption({
        //设置背景颜色
//        backgroundColor: '#E8E8E8',
        //提示工具，鼠标移入时
        tooltip : {
            trigger: 'item',
            formatter: "{b} <br/> {c}元 ({d}%)"  //设置提示格式
        },
        //设置项开关
        legend: {
            orient: 'vertical', //垂直排列，去掉就水平排列
            top: 'top',    //上边位置
            left: '20px',   //左边位置,也可以设置像素
            data: [
            	//动态数据
            ], //项名称必须和以下数据名称对应，也可以设置样式，也可以引入自己的图标'image://url'
        },
        series: {
            type: 'pie',   //设置图表类型
            radius: '55%', //设置饼图半径
            center: ['50%', '50%'], //设置饼图位置
            selectedMode: 'single', //设置被点击时孤立项
            data: [ //设置数据
            	//动态数据
            ]
        },
    });
    getDatePieChart();
}

//条件查询图表
$(function (){
	$("#serviceChart").hide();
	
	$("#yearSel").change(function (){
		getDatePieChart();
		showChartZhe();
	});
	$("#OSNameSel").change(function (){
		getDatePieChart();
	});
});

//请求数据动态设置图表数据
function getDatePieChart(){
	//设置图表加载提示
    myChart.showLoading();  
	theOSName = $("#OSNameSel").val();
	theYear = $("#yearSel").val();
	params = {
		"userID":theUserID,
		"year":theYear,
		"theOSName":theOSName,
		"month":""
	}

	var url = "billtime/findMonthly";
	$.ajax({
		type : "POST",
		url : url,
		async : true,
		data : {
			"page":1,
			"rows":20,
			"params":params,
		},
		success : function(msg) {

			var theData = [];
			for(var i = 0;i < msg.datas.length;i++){
				if(msg.datas[i].osName == $("#OSNameSel").find("option:selected").text()){
					for(var j = 0;j < msg.datas[i].serviceYear[0].serviceMonthly.length;j++){
						//json排序  
						if(j == 0){
							 //根据月份（month）排序  
				              function sortprice(a,b){  
				                 return a.month-b.month
				              }  
				              //利用js中的sort方法  
				              msg.datas[i].serviceYear[0].serviceMonthly.sort(sortprice);
						}

						var theValue = {name: chinanum(msg.datas[i].serviceYear[0].serviceMonthly[j].month)+"月",value:msg.datas[i].serviceYear[0].serviceMonthly[j].cost,label:theLabel};
						theData.push(theValue);
					}
				}
			}
			//隐藏图表加载提示
		    myChart.hideLoading();  
		   
			// 异步加载数据
			// 填入数据
		    myChart.setOption({
		    	legend: {
		        	data: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
		        },
		        series: {
		        	data: theData
		        } 
		    });
		}
	});
}

//请求数据得到账务账号的所有业务账号
function findAllServiceByUserID(){
	var url = "report/findAllServcie";
	$.ajax({
		type : "GET",
		url : url,
		async : true,
		data : {
			"page":page,
			"rows":rows,
			"params":{
				"userID":theUserID
			},
		},
		success : function(msg) {
			for(var i=0;i < msg.datas.length;i++){
				$("#OSNameSel").append("<option value='"+msg.datas[i].osName+"'>"+msg.datas[i].osName+"</option>"); 
			}
			//动态显示图表
			showChart();
		}
	});
	
	//添加子元素
	
}
 
//切换界面
function huan(args){
	$(".div_asss").removeClass("asss");
	$(args).addClass("asss");
	if($(args).attr('id') == "userChartBtn"){
		$("#serviceChart").hide();
		$("#userChart").show();
		$(".OSNameSel").show();
		showChart();
	}else{
		$("#serviceChart").show();
		$("#userChart").hide();
		$(".OSNameSel").hide();
		showChartZhe();
	};
}

//折线图
function showChartZhe(){
//初始化echarts实例
myChart2 = echarts.init(document.getElementById("main2"));

option = {
	    title: {
//	        text: '业务账号月使用情况'
	    },
	    tooltip: {
	        trigger: 'axis'
	    },
	    legend: {
	        data:[
	        	//动态数据
	        ]
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    toolbox: {
	        feature: {
//	            saveAsImage: {}	//下载图表
	        }
	    },
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: [
	        	//动态数据
	        ]
	    },
	    yAxis: {
	        type: 'value',
	        axisLabel: {
	        	formatter: '{value} 元'
	        }
	    },
	    series: [
	        //动态数据
	    ]
	};
myChart2.setOption(option);
getDateZheChart();
}

//请求数据动态设置图表数据2
function getDateZheChart(){
	//设置图表加载提示
    myChart2.showLoading();  
	
	theYear = $("#yearSel").val();
	params = {
		"userID":theUserID,
		"year":theYear,
		"month":""
	}
	var url = "billtime/findMonthly";
	$.ajax({
		type : "GET",
		url : url,
		async : true,
		data : {
			"page":1,
			"rows":20,
			"params":params,
		},
		success : function(msg) {
		    myChart2.hideLoading();  //隐藏图表加载提示
		    
		    //填装项数据
		    var legendData = [];
		    for(var i = 0;i < msg.datas.length;i++){
		    	legendData.push(msg.datas[i].osName);
			}
		    
		    //填装值数据
		    var seriesData = [];
			for(var i = 0;i < msg.datas.length;i++){
				var theData = [];
				if(msg.datas[i].serviceYear != undefined){
					if(msg.datas[i].serviceYear[0].serviceMonthly != undefined){
						//json排序  
						if(i == 0){
							 //根据月份（month）排序  
				              function sortprice(a,b){  
				                 return a.month-b.month
				              }  
				              //利用js中的sort方法  
				              msg.datas[i].serviceYear[0].serviceMonthly.sort(sortprice);
						}
						
						for(var j = 0;j < msg.datas[i].serviceYear[0].serviceMonthly.length;j++){
							theData.push(msg.datas[i].serviceYear[0].serviceMonthly[j].cost);
						}
					}
				}
				var data = {name:msg.datas[i].osName,type:'line',data:theData};
				seriesData.push(data);
			}
		    
		    
			// 异步加载数据
			// 填入数据
		    myChart2.setOption({
		    	legend: {
		            data: legendData
		        },
		        xAxis: {
			        data: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
			    },
		        series: seriesData
		    });

		}
	});
}
//数字转中文
function chinanum(num){
	if(num == 10){
		 return "十"
	}else if(num == 11){
		return "十一"
	}else if(num == 12){
		return "十二"
	}else{
		 var china = new Array('零','一','二','三','四','五','六','七','八','九');  
		    var arr = new Array();  
		    var english = num.split("")  
		    for(var i=0;i<english.length;i++){  
		        arr[i] = china[english[i]];  
		    }  
		    return arr.join("")  
	}
} 
