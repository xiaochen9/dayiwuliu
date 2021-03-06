<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!Doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>平台运单管理</title>
    <meta name="keywords" content=" 天瑞"/>
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${stylesRoot }/bootstrap.css" rel="stylesheet">
    <link href="${stylesRoot }/base.css" rel="stylesheet">
    <link href="${stylesRoot }/style.css" rel="stylesheet">
    <link href="${stylesRoot }/tr-media.css" rel="stylesheet">
    <link href="${stylesRoot }/easyTree.css" rel="stylesheet">
    <link href="${stylesRoot }/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="Shortcut Icon" href="${imagesRoot}/favicon.ico" type="image/x-icon">
    <!--这个日历控件js必须放头部-->
    <script language="javascript" type="text/javascript" src="${scriptsRoot }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" type="text/css" href="${stylesRoot }/pagination/pagination.css" />
	<style type="text/css">
		.assessBody {
		    height: 35px;
		    line-height: 35px;
		}
		
		.assessBody label {
		    margin-left: 40px;
		}
		
		.assessBody label input {
		    vertical-align: text-top;
		    margin-top: 2px;*
		    margin-bottom:-4px;
		    margin-right: 10px;
		}
	</style>
</head>
<body>

<div class="container-fluid">
 <!--公共头部begin-->
    <jsp:include page="../../common/header.jsp" flush="false"></jsp:include>
     <!--后台左侧布局end-->
    <!--后台右侧布局begin-->
    <div class="col-md-10 ">
        <div class="ht_content">
            <div id="content-header">
                <h3>运单管理</h3>
            </div>
            <!--查询框begin-->
            <div class="row">
                <div class="col-md-12">
                    <div class="contuser_search">
                        <div class="ht_div">
                            <label>运单编码：</label>
                            <input type="text" id="waybillno" placeholder=" ">
                        </div>
                        <div class="ht_div">
                            <label>状态：</label>
                            <select class="form-control" id="status">
                                <option value="">请选择</option>
                                <option value="-1">车主回收</option>
                                <option value="0">司机未确认</option>
                                <option value="1">司机已接受</option>
                                <option value="2">司机已装货</option>
                                <option value="3">司机运输中</option>
                                <option value="4">司机已到达</option>
                                <option value="5">司机已卸货</option>
                                <option value="6">已签收</option>
                                <option value="7">司机拒绝接单</option>
                            </select>
                        </div>
                        <div class="ht_div">
		                    <label>支付类型：</label>
							<select class="form-control" id="payType">
								<option value="">请选择</option>
								<option value="0">在线支付</option>
								<option value="1">发票单支付</option>
							</select>
		                </div>
		               <div class="ht_div">
		                    <label>发票类型：</label>
							<select class="form-control" id="payDesc1">
								<option value="">请选择</option>
								<option value="540100000003">熟料运输费用</option>
								<option value="540100000016">原煤运输费用</option>
								<option value="540100000018">水泥运输费用</option>
							</select>
		                </div>
                    <div class="ht_divbtn">
                        <button class="btn btnblue " onclick="searchFile();" type="button">搜索</button>
                    </div>
                </div>
            </div>
            <!--查询框end-->
            <div class="row mt15">
                <div class="col-md-12">
                    <div class="content-user">
<!--                         <div class="content-tou">
                            <button><i class="iconfont icon-daochu1"></i><span>导出</span></button>
                        </div> -->
                        <!--用户表格begin-->
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>运单编码</th>
                                <th>支付类型</th>
                                <th>发票类型</th>
                                <th>司机姓名</th>
                                <th>司机电话</th>
                                <th>组织名称</th>
                               	<th>提货地偏差</th>
                               	<th>卸货地偏差</th>
                                <th>承运商</th>
                                <th>创建时间</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody id="innhml">
                            </tbody>
                        </table>
                        <!--用户表格end-->
                    </div>
                </div>
            </div>
          					  <!-- 分页部分  开始-->
						            <div class="row pr20 fr">
										<%@include file="../../common/pagination.jsp" %>
						            </div>
						         <!-- 分页部分 结束 -->
        </div>
    </div>
    <!--后台右侧布局end-->
</div>
<!--后台整体布局end-->
</div>
<!--侧边栏end-->
</div>

<!--查看详情begin-->
<div class="modal fade" id="detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">运单详情</h4>
            </div>
            <div class="modal-body" style=" " id="dateilshml">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!--查看详情end-->

<!--停用begin-->
<div class="modal fade" id="tingyong" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <h4>确定要停用吗</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--停用end-->
<!--启用begin-->
<div class="modal fade" id="yunjia" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">运价确认</h4>
            </div>
            <div class="modal-body">
	            <input type="hidden" id="billid">
	            <div class='file_detail'><label> 提货磅单：</label><span id="pickupweight"></span>吨</div>
	            <div class='file_detail'><label> 签收磅单：</label><span id="signweight"></span>吨</div>
	            <div class='file_detail'><label> 签收重量：</label><span id="trueweight"></span>吨</div>
	            <div class='file_detail'><label> 当前运价：</label><span id="pricenow"></span></div>
	            <div class='file_detail'><label> 修改运价：</label><span><input style="width: 120px;height: 30px" id="trueprice" type="text"></span></div>
            <div class="clear"></div>
            </div>
            <div class="modal-footer">
                <button type="button" id="ncdisable" onclick="queren();" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--启用end-->
<div class="modal fade" id="assess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">信用评价</h4>
            </div>
            <div class="modal-body">
            	<input type="hidden" id="bid"/>
	            <div class="assessBody">
	            	<label>及时发车：</label>
		            <label><input name="timelystart" type="radio" value="1"/>是</label>
		            <label><input name="timelystart" type="radio" value="0"/>否</label>
	            </div>
	            <div class="assessBody">
	            	<label>及时送达：</label>
		            <label><input name="timelydelivery" type="radio" value="1"/>是</label>
		            <label><input name="timelydelivery" type="radio" value="0"/>否</label>
	            </div>
	            <div class="assessBody">
        			<label>及时回单：</label>
		            <label><input name="timelyreturn" type="radio" value="1"/>是</label>
		            <label><input name="timelyreturn" type="radio" value="0"/>否</label>
	            </div>
	            <div class="assessBody">
	            	<label>车质损耗：</label>
		            <label><input name="cardamage" type="radio" value="1"/>是</label>
		            <label><input name="cardamage" type="radio" value="0"/>否</label>
	            </div>
	            <div class="assessBody">
	            	<label>运输事故：</label>
		            <label><input name="transportaccident" type="radio" value="0"/>无</label>
		            <label><input name="transportaccident" type="radio" value="1"/>无责事故</label>
		            <label><input name="transportaccident" type="radio" value="2"/>责任事故</label>
	            </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary assessComfirm">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="showAssess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" style="width: 250px;" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">信用评价</h4>
            </div>
            <div class="modal-body">
	            <div class="assessBody">
	            	<label>及时发车：</label><label id="timelystart">是</label>
	            </div>
	            <div class="assessBody">
	            	<label>及时送达：</label><label id="timelydelivery"></label>
	            </div>
	            <div class="assessBody">
        			<label>及时回单：</label><label id="timelyreturn"></label>
	            </div>
	            <div class="assessBody">
	            	<label>车质损耗：</label><label id="cardamage"></label>
	            </div>
	            <div class="assessBody">
	            	<label>运输事故：</label><label id="transportaccident"></label>
	            </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<%@include file="../../common/footer.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        // 表格列宽度手动调整
        $("table").resizableColumns({});
    });
    var CONTEXTPATH="${contextPath}";
    var imagesRoot="${imagesRoot }";
</script>
<script type="text/javascript" src="/resources/js/waybill/file_bill.js?05.9" ></script>
<script type="text/javascript" src="${scriptsRoot }/jquery.pagination.js"></script>
<script type="text/javascript" src="${scriptsRoot }/pagination.js"></script>
</body>
</html>