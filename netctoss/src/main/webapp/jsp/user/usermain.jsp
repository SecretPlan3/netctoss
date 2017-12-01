<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="../css/amazeui.min.css"/>
    <link rel="stylesheet" href="../css/admin.css">
    <!--引入自定义样式-->
    <link rel="stylesheet" href="../css/custom.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/app.js"></script>

    <!--日历插件-->
    <script src="../js/amazeui.min.js"></script>
    <script src="../js/amazeui.datatables.min.js"></script>
    <script src="../js/dataTables.responsive.min.js"></script>
    <script src="../js/app.js"></script>
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
   <div>
       <div class="header">
            <h1>用户管理系统</h1>
       </div>
       <!--模糊查询-->
       <div class="search">
           <ul class="am-nav am-nav-pills am-topbar-nav ">
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">用户姓名</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="用户姓名" /></p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">OS账号</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="账号名称" /></p>
               </li>
               <li class="soso">
                  <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">身份证号</button>
                   </p>
                   <p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="身份证号" /></p>
               </li>
               <li class="soso">
                   <p>
                       <button class="am-btn am-btn-xs am-btn-default am-xiao">账号状态</button>
                   </p>
                   <p>
                       <select data-am-selected="{btnWidth: 110, btnSize: 'sm', btnStyle: 'default'}">
                           <option value="1">开启</option>
                           <option value="2">暂停</option>
                           <option value="3">关闭</option>
                      	</select>
                   </p>
                   <p><button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
               </li>
            </ul>
       </div>
      
       <form class="am-form am-g">
           <table class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover" width="100%">
               <thead>
               <tr class="am-success">
                   <th class="table-check"><input type="checkbox"></th>
                   <th class="table-title">OS账号</th>
                   <th class="table-title">账务账号</th>
                   <th class="table-type">实验室IP</th>
                   <th class="table-author am-hide-sm-only">状态</th>
                   <th class="table-set" width="125px">操作</th>
               </tr>
               </thead>
               <tbody>
               <tr>
                   <td><input type="checkbox"></td>
                   <td class="am-text-center">14</td>
                   <td><a href="#">Business management</a></td>
                   <td>进货：456件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;销售：677件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;库存： 555件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;损耗：5件</td>
                   <td class="am-hide-sm-only">访问</td>
                   <td><div class="am-btn-toolbar">
                       <div class="am-btn-group am-btn-group-xs">
                           <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="详细库存信息（这里包含 销量 库存  损耗，会员全部购买信息  客服备注  销售的全部金额）"></a>


                           <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="修改库存信息"><span class="am-icon-pencil-square-o"></span></button>
                           <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->
                           <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span class="am-icon-trash-o"></span></button>
                       </div>
                   </div></td>
               </tr>

               <tr>
                   <td><input type="checkbox"></td>
                   <td class="am-text-center">3</td>
                   <td><a href="#">Business management</a></td>
                   <td>default</td>
                   <td class="am-hide-sm-only">访问</td>

                   <td><div class="am-btn-toolbar">
                       <div class="am-btn-group am-btn-group-xs">
                           <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="置顶（前台显示热门评论）"></a>
                           <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="添加（随机虚拟用户ID ）"><span class="am-icon-pencil-square-o"></span></button>
                           <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->
                           <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span class="am-icon-trash-o"></span></button>
                       </div>
                   </div></td>
               </tr>

               <tr>
                   <td><input type="checkbox"></td>
                   <td class="am-text-center">4</td>
                   <td><a href="#">Business management</a></td>
                   <td>default</td>
                   <td class="am-hide-sm-only">访问</td>

                   <td><div class="am-btn-toolbar">
                       <div class="am-btn-group am-btn-group-xs">
                           <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="置顶（前台显示热门评论）"></a>
                           <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="添加（随机虚拟用户ID ）"><span class="am-icon-pencil-square-o"></span></button>
                           <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->
                           <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span class="am-icon-trash-o"></span></button>
                       </div>
                   </div></td>
               </tr>

               <tr>
                   <td><input type="checkbox"></td>
                   <td class="am-text-center">5</td>
                   <td><a href="#">Business management</a></td>
                   <td>default</td>
                   <td class="am-hide-sm-only">访问</td>

                   <td><div class="am-btn-toolbar">
                       <div class="am-btn-group am-btn-group-xs">
                           <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="置顶（前台显示热门评论）"></a>
                           <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="添加（随机虚拟用户ID ）"><span class="am-icon-pencil-square-o"></span></button>
                           <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->
                           <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span class="am-icon-trash-o"></span></button>
                       </div>
                   </div></td>
               </tr>

               <tr>
                   <td><input type="checkbox"></td>
                   <td class="am-text-center">6</td>
                   <td><a href="#">Business management</a></td>
                   <td>default</td>
                   <td class="am-hide-sm-only">访问</td>

                   <td><div class="am-btn-toolbar">
                       <div class="am-btn-group am-btn-group-xs">
                           <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="置顶（前台显示热门评论）"></a>
                           <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="添加（随机虚拟用户ID ）"><span class="am-icon-pencil-square-o"></span></button>
                           <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->
                           <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span class="am-icon-trash-o"></span></button>
                       </div>
                   </div></td>
               </tr>

               <tr>
                   <td><input type="checkbox"></td>
                   <td class="am-text-center">15</td>
                   <td><a href="#">Business management</a></td>
                   <td>default</td>
                   <td class="am-hide-sm-only"><i class="am-icon-close am-text-primary"></i></td>

                   <td><div class="am-btn-toolbar">
                       <div class="am-btn-group am-btn-group-xs">
                           <a class="am-btn am-btn-default am-btn-xs am-text-success am-round am-icon-file" data-am-modal="{target: '#my-popups'}" title="置顶（前台显示热门评论）"></a>
                           <button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" data-am-modal="{target: '#my-popups'}" title="添加（随机虚拟用户ID ）"><span class="am-icon-pencil-square-o"></span></button>
                           <!-- 用按钮的时候 弹层 后缀需要加 问好 ？#的 时候才有效 真恶心 .html?# -->
                           <button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除"><span class="am-icon-trash-o"></span></button>
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


    <div>
        <div class="am-form-group">
            <label class="am-u-sm-3 am-form-label">这是一个日历插件自己可以自行选择使用 </label>
            <div class="am-u-sm-9">
                <input type="text" class="am-form-field tpl-form-no-bg" placeholder="发布时间" data-am-datepicker="" readonly="">
            </div>
        </div>
    </div>

</body>
</html>
