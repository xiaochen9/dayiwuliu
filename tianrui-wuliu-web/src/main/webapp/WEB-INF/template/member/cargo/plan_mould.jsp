<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!Doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>发货模板</title>
    <meta name="keywords" content=" 天瑞"/>
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${trRoot}/tianrui/css/bootstrap.css" rel="stylesheet">
    <link href="${trRoot}/tianrui/css/base.css" rel="stylesheet">
    <link href="${trRoot}/tianrui/css/style.css" rel="stylesheet">
    <link href="${trRoot}/tianrui/css/imgcut.css"  rel="stylesheet">
    <link href="${trRoot}/tianrui/css/tr-media.css"  rel="stylesheet">
</head>
<body>
<!-- 引用公共header部分 -->
<jsp:include page="../../common/member/header_busi.jsp"></jsp:include>
<!--Header-->
<!--内容部分begin-->
<div class="bghui">
<div class="container">
    <!--网站位置-->
    <div class="row">
            <div class="rz_line">
                <label>当前位置：首页</label><span>></span> <label>账号</label><span>></span><label>个人中心</label>
            </div>
    </div>
    <div class="row">
        <!--个人中心左侧begin-->
       	<jsp:include page="../../common/member/left_busi.jsp"></jsp:include>
        <!--个人中心左侧end-->
        <!--个人中心右侧begin-->
        <div class="rz_right">
            <div class="car_title bgblue">
                <h2>计划模板</h2>
            </div>
            <!--个人中心右侧搜索框begin-->
            <div class="plan_search">
                <input type="text" placeholder="请出入搜索内容" id="search_v">
                <button type="submit" class="btn btnblue searchBtn">搜索货源</button>
            </div>
            <!--个人中心右侧搜索框end-->
            <div class="plan_fege">  </div>
            <!--计划模板表格begin-->
             <div class="planfabu">
                 <table class="table table-hover" >
                     <thead>
                     <tr>
                         <th >计划编码	</th>
                         <th >货主姓名	</th>
                         <th >货主电话 </th>
                         <th > 始发地-目的地	 </th>
                         <th>更新时间</th>
                         <th > 操作</th>
                     </tr>
                     </thead>
                     <tbody id="plan_tbody">

                     </tbody>
                 </table>
                    <div class="goods_more pageNone" style="display:none">
	                     <h4>暂无数据</h4>
	                 </div>
                    <div class="goods_more pageMore" style="display:none">
	                     <h4>查看更多</h4>
	                 </div>
             </div>
            <!--计划模板表格end-->
        </div>
        <!--个人中心右侧end-->
        </div>
</div>
</div>
<!--内容部分end-->


<!--发布模板begin-->
<div class="modal fade" id="publish" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id=" ">发布计划</h4>
            </div>
            <div class="modal-body">
            	<input type="hidden" id="planId" value="">
                <h4>您确定要发布此计划模板吗？</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="releasePlan();">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--发布模板end-->

<!--删除模板begin-->
<div class="modal fade" id="deleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id=" ">删除</h4>
            </div>
            <div class="modal-body">
             <input type="hidden" id="deleteid">
                <h4>您确定要删除此计划模板吗？</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="delPlanById();">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--删除模板end-->



<!--底部begin-->
<jsp:include page="../../common/member/footer_busi.jsp"></jsp:include>
<!--底部end-->
<script type="text/javascript" src="${trRoot}/tianrui/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${trRoot}/tianrui/js/bootstrap.js"></script>
<script type="text/javascript" src="${trRoot}/tianrui/js/cropbox.js"></script>
<script type="text/javascript" src="/resources/js/common/member/header_busi.js" ></script>
<script type="text/javascript" src="/resources/js/member/cargo/plan_mould.js" ></script>
</body>
</html>