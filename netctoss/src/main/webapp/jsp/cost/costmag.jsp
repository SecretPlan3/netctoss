<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
    <title>资费管理系统</title>
    <link rel="stylesheet" href="../../static/css/amazeui.min.css"/>
    <link rel="stylesheet" href="../../static/css/admin.css">
    <!--引入自定义样式-->
    <link rel="stylesheet" href="../../static/css/custom.css">
    <script src="../../static/js/jquery.min.js"></script>
    <script src="../../static/js/app.js"></script>
	<!-- bootstrap -->
	<link rel="stylesheet" href="../../static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>
    <!--日历插件-->
    <script src="../../static/js/amazeui.min.js"></script>
    <script src="../../static/js/amazeui.datatables.min.js"></script>
    <script src="../../static/js/dataTables.responsive.min.js"></script>
    <script src="../../static/js/app.js"></script>
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
        th,td{
        	text-align: center;
        }
    </style>
</head>
<body>
	<div>
       <div class="header">
            <h1>资费管理系统</h1>
       </div>
       <!--模糊查询-->
       <div class="search">
           <ul class="am-nav am-nav-pills am-topbar-nav ">
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">套餐编号</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="套餐编号" /></p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">套餐名称</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="套餐名称" /></p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">套餐类型</button>
                   </p>
                   <p>
                       <select data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}">
                           <option value="1">所有资费套餐</option>
                           <option value="2">包月资费套餐</option>
                           <option value="3">计时资费套餐</option>
                           <option value="4">自助资费套餐</option>
                       </select>
                   </p>
                   <p><button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
               </li>
            </ul>
       </div>
        <!--表单数据-->

       <div class="listbiaoti am-cf ">
           <ul class="am-icon-flag on">
              	 资费管理
           </ul>
           <dl class="am-icon-home" style="float: right;">
               	当前位置： 首页 &gt; <a href="#">用户评论</a>
           </dl>
           <dl>
               <!-- <a href="addcost.html" target="_self"></a> -->
               <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" data-toggle="modal" data-target="#myModal_001">增加资费套餐</button>
           </dl>
           <!--data-am-modal="{target: '#my-popup'}" 弹出层 ID  弹出层 190行 开始  271行结束-->

       </div>
       <form class="am-form am-g">
           <table class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
               <thead>
               <tr class="am-success">
                   <th class="table-title">套餐编号</th>
                   <th class="table-title">套餐名称</th>
                   <th class="table-type">套餐类型</th>
                   <th class="table-type">套餐状态</th>
                   <th class="table-type">创建时间</th>
                   <th class="table-type">开通时间</th>
                   <th class="table-type">关闭时间</th>
                   <th class="table-author am-hide-sm-only">备注</th>
                   <th class="table-set" width="125px">操作</th>
               </tr>
               </thead>
               <tbody>
               <tr>
                   <td class="am-text-center">14</td>
                   <td><a href="#">冰淇淋套餐</a></td>
                   <td>自助资费套餐</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td><div class="am-btn-toolbar">
                       <div class="am-btn-group am-btn-group-xs" style="text-align: center">
                           <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改资费套餐"><span class="am-icon-pencil-square-o"></span></button>
                           <button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改资费套餐"><span class="am-icon-trash-o"></span></button>
                       </div>
                   </div></td>
               </tr>
               </tbody>
           </table>
           <div class="am-btn-group am-btn-group-xs am-fl">
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 删除</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 上架</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 下架</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-save"></span> 保存</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-archive"></span> 移动</button>
               <button type="button" class="am-btn am-btn-default"><span class="am-icon-trash-o"></span> 删除</button>
           </div>
           <ul class="am-pagination " style="text-align: right">
               <li class="am-disabled"><a href="#">«</a></li>
               <li class="am-active"><a href="#"><</a></li>
               <li><a href="#">2</a></li>
               <li><a href="#">3</a></li>
               <li><a href="#">4</a></li>
               <li><a href="#">></a></li>
               <li><a href="#">»</a></li>
           </ul>
           <hr>
       </form>
   </div>

	<!--添加资费套餐弹框-开始-->
    <div class="modal fade btn" id="myModal_001" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">增加资费套餐</h4>
                </div>
                <div class="modal-body">
                    <div class="tc001_body_content">
                         <form role="form">
		                    <div class="form-group">
		                        <label>套餐名称</label>
		                        <input type="text" class="form-control" placeholder="套餐名称">
		                    </div>
		                    <div class="form-group">
		                        <label>套餐编号</label>
		                        <input type="text" class="form-control" placeholder="套餐编号" >
		                    </div>
		                    <div class="form-group">
		                        <label>套餐类型</label>
		                        <select class="form-control">
		                            <option>包月资费套餐</option>
		                            <option>计时资费套餐</option>
		                            <option>自助资费套餐</option>
		                        </select>
		                    </div>
		                    <div class="form-group">
		                        <label>基本费用</label>
		                        <input  id="basicCost"  type="text" class="form-control" placeholder="基本费用(元/月)">
		                    </div>
		                    <div class="form-group">
		                        <label>单位费用</label>
		                        <input id="unitCost" disabled="disabled" type="text" class="form-control" placeholder="单位费用(元/时)">
		                    </div>
		                    <div class="form-group">
		                        <label>基本时长</label>
		                        <input id="basicTime" disabled="disabled" type="text" class="form-control" placeholder="基本时长(小时)">
		                    </div>
		                    <div class="form-group">
		                        <label>业务状态</label>
		                        <select class="form-control">
		                            <option>暂停</option>
		                            <option>开通</option>
		                        </select>
		                    </div>
		                    <div class="form-group">
		                        <label>资费说明</label>
		                        <input type="text" class="form-control" placeholder="资费说明" >
		                    </div>
		                </form>
                        
                    </div>
                </div>
                <div class="tc001_footer_btn" style="align-content: center">
                	<button type="submit" class="btn btn-primary" data-dismiss="modal">添加</button>
                	<button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                </div>
            </div>
        </div>
    </div>
	<!--添加资费套餐弹框-结束-->
	
	 <script type="text/javascript">
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
        //根据选择的资费套餐类型，显示课填的数据表
        $("form select").on({
            "change":function(){
            	choiceSelect($(this));
            }
        });
        
        function choiceSelect(obj){
        	var text = obj.val();
        	/* alert(text) */
        	if(text == "包月资费套餐"){
        		$("#basicCost").attr("disabled", false)
        		$("#unitCost").attr("disabled", true)
        		$("#basicTime").attr("disabled", true)
        	}else if(text == "计时资费套餐"){
        		$("#unitCost").attr("disabled", false)
        		$("#basicTime").attr("disabled", true)
        		$("#basicCost").attr("disabled", true)
        	}else if(text == "自助资费套餐"){
        		$("#basicCost").attr("disabled", false)
        		$("#basicTime").attr("disabled", false)
        		$("#unitCost").attr("disabled", false)
        	}
        }
    </script>
</body>
</html>