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
    <title>车主档案管理</title>
    <meta name="keywords" content=" 天瑞" />
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="${stylesRoot }/bootstrap.css" rel="stylesheet">
    <link href="${stylesRoot }/base.css" rel="stylesheet">
    <link href="${stylesRoot }/style.css" rel="stylesheet">
    <link href="${stylesRoot }/tr-media.css" rel="stylesheet">
    <link href="${stylesRoot }/easyTree.css" rel="stylesheet">
    <link href="${stylesRoot }/imgcut.css" rel="stylesheet">
    <link href="${stylesRoot }/jquery-ui.min.css" rel="stylesheet">
    <!--这个日历控件js必须放头部-->
    <script language="javascript" type="text/javascript" src="${scriptsRoot }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" type="text/css" href="${stylesRoot }/pagination/pagination.css" />
</head>
<body>

<div class="container-fluid">
    <!--公共头部begin-->
    <jsp:include page="../common/header.jsp" flush="false"></jsp:include>
     <!--后台左侧布局end-->
            <!--后台右侧布局begin-->
           <div class="col-md-10 ">
                <div class="ht_content">
                    <div id="content-header">
                        <h3>车主管理</h3>
                    </div>
                    <!--查询框begin-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="contuser_search">
                                <div class="ht_div">
                                    <label>车主类别：</label>
                                    <select id="personalType" class="form-control">
                                        <option value="">请选择</option>
                                        <option value="1">企业用户</option>
                                        <option value="2">个人用户</option>
                                    </select>
                                </div>
                                <div class="ht_div">
                                    <label>车主账号：</label>
                                    <input type="text" id="cellphone" placeholder=" ">
                                </div>
                                <div class="ht_div">
                                    <label>公司/车主名：</label>
                                    <input type="text" id="username" placeholder=" ">
                                </div>
                            </div>
                            <div class="contuser_search">
                                <div class="ht_div">
                                    <label>认证时间：</label>
                                    <input type="text" id="subtimefor" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00'})" class="Wdate" style="width:160px"/>
                                    <i>-</i>
                                    <input type="text" id="subtimeend"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:00:00'})" class="Wdate" style="width:160px"/>
                                </div>
                                
                                <div class="ht_divbtn">
                                    <button class="btn btnblue " onclick="driverSearch();" type="button">搜索</button>
                                    <button class="btn btngreen" onclick="clearSearch();" type="button">重置</button>
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
                                        <th>车主类别</th>
                                        <th>车主账号</th>
                                        <th>公司名称/车主名称</th>
                                        <th>负责人姓名/联系方式</th>
                                        <th>公司营业执照/车主身份证号</th>
                                        <th>认证时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="innerHml">
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
         </div>
    <!--侧边栏end-->
    </div>
<!--查看详情begin-->
<div class="modal fade" id="detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width: 700px">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >车辆司机信息</h4>
            </div>
            <div class="modal-body" >
                <div class="contuser_search">
                    <div class="chezhu_div">
                    <div class="chezhu_div">
                        <label>司机姓名：</label>
                        <input id="drivername" type="text" placeholder=" ">
                    </div>
                        <label>车型：</label><!-- (1:箱式,2:车板,3:冷藏) -->
                        <select id="dvehicletype" class="form-control">
                            <option value="">请选择</option>
                            <option value="1">箱式</option>
                            <option value="2">车板</option>
                            <option value="3">冷藏</option>
                        </select>
                    </div>
                    
                </div>
                <div class="contuser_search">
                    <div class="chezhu_div">
                        <label>联系方式：</label>
                        <input id="dtelPhone" type="text" placeholder=" ">
                        <input type="hidden" value="" id="vehicleownerid">
                    </div>
                    <div class="ht_divbtn">
                        <button class="btn btnblue" onclick="driverdetails();" type="button">搜索</button>
                        <button class="btn btngreen" onclick="clearDriver()" type="button">重置</button>
                    </div>
                </div>

                <div class="chezhu_box">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>车牌号</th>
                            <th>车型</th>
                            <th>载重(吨)</th>
                            <th>长度(米)</th>
                            <th>司机姓名</th>
                            <th>联系方式</th>
                        </tr>
                        </thead>
                        <tbody id="drivlist">
                        </tbody>
                    </table>
                </div>

                <div class="clear"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--查看详情end-->
<!--银行查看详情begin-->
<div class="modal fade" id="credit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >银行信息详情</h4>
            </div>
            <div class="modal-body" >
                <div class="file_detail">
                    <label>银行帐号：</label><span>tr15451212</span>
                </div>

                <div class="file_detail">
                    <label>户名：</label><span>认证成功</span>
                </div>
                <div class="file_detail">
                    <label>开户行：</label><span>10吨</span>
                </div>
                <div class="file_detail">
                    <label>银行类别：</label><span>20米</span>
                </div>
                <div class="file_detail">
                    <label>币种：</label><span>shhnkdjl</span>
                </div>
                <div class="file_detail">
                    <label>默认：</label><span>315641212</span>
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
<!--删除begin-->
<div class="modal fade" id="dele" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">会员删除</h4>
            </div>
            <div class="modal-body">
            	<input type="hidden" id="memberid" value="">
                <h4>确定要删除此条信息吗?</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="deleteMember()">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--删除end-->
<!--停用begin-->
<div class="modal fade" id="tingyong" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >提示</h4>
            </div>
            <div class="modal-body">
            	<input type="hidden" id="memid" value="">
            	<input type="hidden" id="statustype" value="">
                <h4><span id="satus"></span></h4>
            </div>
            <div class="modal-footer">
                <button type="button" onclick="changeType();" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--停用end-->
<!--启用begin-->
<div class="modal fade" id="qiyong" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >提示</h4>
            </div>
            <div class="modal-body">
                <h4>确定要启用吗</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--启用end-->
<%@include file="../common/footer.jsp" %>
<script type="text/javascript" src="${scriptsRoot }/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${scriptsRoot }/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script type="text/javascript" src="${scriptsRoot }/jquery-ui.min.js"></script>
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
    $(function(){
        $("table").resizableColumns({});
        });
    var CONTEXTPATH="${contextPath}";
    var imagesRoot="${imagesRoot }";
</script>
<script type="text/javascript" src="/resources/js/adminMember/chezhu_manager.js" ></script>
<script type="text/javascript" src="${scriptsRoot }/jquery.pagination.js"></script>
<script type="text/javascript" src="${scriptsRoot }/pagination.js"></script>
</body>
</html>