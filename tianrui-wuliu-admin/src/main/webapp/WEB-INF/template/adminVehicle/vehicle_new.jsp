<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!Doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>平台车辆管理</title>
    <meta name="keywords" content=" 天瑞" />
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${stylesRoot }/bootstrap.css" rel="stylesheet">
    <link href="${stylesRoot }/base.css" rel="stylesheet">
    <link href="${stylesRoot }/style.css" rel="stylesheet">
    <link href="${stylesRoot }/tr-media.css" rel="stylesheet">
    <link href="${stylesRoot }/easyTree.css" rel="stylesheet">
    <link href="${trRoot}/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
    <!--这个日历控件js必须放头部-->
    <script language="javascript" type="text/javascript" src="${scriptsRoot }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" type="text/css" href="${stylesRoot }/pagination/pagination.css" />
</head>
<body>

<div class="container-fluid">
     <input type="hidden" id="recPage" value="${pageNo }">
     <!--公共头部begin-->
    <jsp:include page="../common/header.jsp" flush="false"></jsp:include>
     <!--后台左侧布局end-->
            <!--后台右侧布局begin-->
           <div class="col-md-10 ">
                <div class="ht_content">
                    <div id="content-header">
                        <h3>new_车辆管理</h3>
                    </div>
                    <!--查询框begin-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="contuser_search">
                                <div class="ht_div">
                                    <label>车牌号：</label>
                                    <input type="text" id="vehicleno" placeholder=" ">
                                </div>
                                <div class="ht_div">
                                    <label>所有人：</label>
                                    <input type="text" id="ownerName" placeholder=" ">
                                </div>
                                <div class="ht_div">
                                    <label>随车电话：</label>
                                    <input type="text" id="vehiclemobile" placeholder=" ">
                                </div>
                                <div class="ht_div">
                                        <label>车辆来源:</label>
                                        <select class="form-control" id="vehiclesource">
                                            <option value="">请选择</option>
                                            <option value="2">用户添加</option>
                                            <option value="1">历史数据导入</option>
                                        </select>
                                </div>
                                <div class="ht_div">
                                        <label>认证方式:</label>
                                        <select class="form-control" id="authtype">
                                            <option value="">请选择</option>
                                            <option value="1">临时认证</option>
                                            <option value="2">完全认证</option>
                                        </select>
                                </div>
                            </div>
                            <div class="contuser_search">
                                <div class="ht_divbtn">
                                    <button class="btn btnblue " onclick="loadSearch()" type="button">搜索</button>
                                    <button class="btn btngreen" onclick="clearSearch()" type="button">重置</button>
                                </div>
                            </div>
                    </div>
                    </div>
                    <!--查询框end-->
                    <div class="row mt15">
                        <div class="col-md-12">
                            <div class="content-user">

                                <!--用户表格begin-->
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>车牌号</th>
                                        <th>随车电话</th>
                                        <th>车辆类型</th>
                                        <th>所有人</th>
                                        <th>载重（吨）</th>
                                        <th>认证方式</th>
                                        <th>车辆来源</th>
                                        <th>认证时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="innerhml">
                                    
                                    </tbody>
                                </table>
                                <!--用户表格end-->
                            </div>
                        </div>
                    </div>
                        <div class="clear"> </div>
                    <!-- 分页部分  开始-->
						            <div class="row pr20 fr">
										<%@include file="../common/pagination.jsp" %>
						            </div>
					<!-- 分页部分 结束 -->
                </div>
            </div>
            <!--后台右侧布局end-->
           </div>
            <!--后台整体布局end-->
    <!--侧边栏end-->
<!--查看详情begin-->
<div class="modal fade" id="detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 780px;">
        <div class="modal-content">
            <div class="modal-header" >
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <div class="car_yhtab">
                    <ul>
                        <li class="select"> <h4 class="modal-title" >车辆信息详情</h4></li>
                    </ul>
                </div>
            </div>
            <div class="modal-body">
                <div class="intel_tabbox">
                    <!--车辆信息详情begin-->
                    <div class="intel_tabcont">
                        <div class="car_yhline">
                            <label>车牌号：</label><span id="vehicleNo_mg"></span>
                        </div>
                        <div class="car_yhline">
                            <label>所有人姓名：</label><span id="vehicleOwner_mg"></span>
                        </div>
                        <div class="car_yhline">
                            <label>联系方式：</label><span id="vehicleOwnerTel_mg"></span>
                        </div>
                        <div class="car_yhline">
                            <label>车型：</label><span id="vehicleType_mg"></span>
                        </div>
                        <div class="car_yhline">
                            <label>载重：</label><span id="vehicleLoad_mg"></span>
                        </div>
                        <div class="car_yhline">
                            <label>长度：</label><span id="vehicleLen_mg"></span>
                        </div>
                        <div class="car_yhline">
                            <label>认证时间：</label><span id="createTime_mg"></span>
                        </div>
                        <div class="car_yhline">
                            <label>随车电话：</label><span id="vehicleMobile_mg"></span>
                        </div>
                    </div>
                    <!--车辆信息详情end-->
                </div>
                <div class="clear"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--查看详情end-->

<%@include file="../common/footer.jsp" %>
<script type="text/javascript" src="${scriptsRoot }/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${scriptsRoot }/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript">
    $('.form_date').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
</script>
<script type="text/javascript">
    var CONTEXTPATH="${contextPath}";
    var imagesRoot="${imagesRoot }";
</script>
<script type="text/javascript" src="${trRoot}/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${trRoot}/js/bootstrap.js"></script>
<script type="text/javascript" src="${trRoot}/js/fileinput.js"></script>
<script type="text/javascript" src="${trRoot}/js/fileinput_locale_zh.js"></script>
<script type="text/javascript" src="/resources/js/adminVehicle/vehicle_new.js?05.23" ></script>
<script type="text/javascript" src="${scriptsRoot }/jquery.pagination.js"></script>
<script type="text/javascript" src="${scriptsRoot }/pagination.js"></script>
<script type="text/javascript">
    // 弹出信息的tab切换菜单
    var alt_li = $('.car_yhtab ul li');
    alt_li.click(function () {
        $(this).addClass('select').siblings().removeClass('select');
        var index = alt_li.index(this);
        $('.intel_tabbox > .intel_tabcont').eq(index).show().siblings().hide();
    });

</script>
<script type="text/javascript">
		$("#file_yyzz").fileinput({
			language : 'zh',
			showUpload : false,
			dropZoneEnabled : false,
			maxFileCount : 1,
//       	minImageWidth: 50, //图片的最小宽度
//	  	 	minImageHeight: 50,//图片的最小高度
//   	  	maxImageWidth: 600,//图片的最大宽度
//	 	  	maxImageHeight: 600,//图片的最大高度
			maxFileSize : 5120,//单位为kb，如果为0表示不限制文件大小
			resizeImage : true,
			showCaption : true,
			showPreview : true,
			allowedFileExtensions : [ 'jpg', 'png', 'jpeg' ]// 支持的图片类型
		}).on('fileuploaderror',function(event, data, previewId, index) {
			var form = data.form, files = data.files, extra = data.extra, response = data.response, reader = data.reader;
			console.log(data);
			console.log('File upload error');
		}).on('fileerror', function(event, data) {
			console.log(data.id);
			console.log(data.index);
			console.log(data.file);
			console.log(data.reader);
			console.log(data.files);
		}).on('fileuploaded',function(event, data, previewId, index) {
			var form = data.form, files = data.files, extra = data.extra, response = data.response, reader = data.reader;
			console.log('File uploaded triggered');
		});
	</script>

</body>
</html>