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
    <link href="${trRoot}/css/cropper.css" rel="stylesheet">
	<link href="${trRoot}/css/cycss.css" rel="stylesheet">
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
                        <h3>车辆管理</h3>
                    </div>
                    <!--查询框begin-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="contuser_search">
                                <div class="ht_div">
                                    <label>车牌号前缀：</label>
                                    <input type="text" id="prefix" placeholder=" ">
                                </div>
                                <div class="ht_div">
                                    <label>车牌号：</label>
                                    <input type="text" id="vehicleno" placeholder=" ">
                                </div>
                                <div class="ht_div">
                                    <label>所有人姓名：</label>
                                    <input type="text" id="userName" placeholder=" ">
                                </div>
                                <div class="ht_div">
                                    <label>联系方式：</label>
                                    <input type="text" id="telphone" placeholder=" ">
                                </div>
                                <div class="ht_div">
                                    <label>车主姓名：</label>
                                    <input type="text" id="ownername" placeholder=" ">
                                </div>
                                <div class="ht_div">
                                    <label>车主电话：</label>
                                    <input type="text" id="ownerphone" placeholder=" ">
                                </div>
                                <div class="ht_div">
                                        <label>认证状态:</label>
                                        <select class="form-control" id="vehiclestatus">
                                            <option value="">请选择</option>
                                            <option value="2">认证中</option>
                                            <option value="-1">认证失败</option>
                                            <option value="1">认证成功</option>
                                        </select>
                                </div>
                                <div class="ht_div">
                                        <label>认证方式:</label>
                                        <select class="form-control" id="vehiclestatusType">
                                            <option value="">请选择</option>
                                            <option value="1">临时认证</option>
                                            <option value="2">完全认证</option>
                                        </select>
                                </div>
                                <div class="ht_div">
                                        <label>审核人:</label>
                                        <input type="text"  id="auditName" placeholder=" ">
                                    </div>
								<div class="ht_div">
									<label>车辆类型:</label> <select class="form-control"
										id="vehicletypename">
										<option value="">请选择</option>
										<c:forEach items="${vType }" var="vt">
											<option value="${vt.wlname }">${vt.wlname }</option>
										</c:forEach>
									</select>
								</div>
								<div class="ht_div">
                                        <label>安联认证:</label>
                                        <select class="form-control" id="desc1">
                                            <option value="">请选择</option>
                                            <option value="-1">认证失败</option>
                                            <option value="0">未认证</option>
                                            <option value="1">认证成功</option>
                                            <option value="2">认证中</option>
                                        </select>
                                </div>
								<div class="ht_div">
										<label>审核日期:</label> <input id="starttime" type="text"
											onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'endtime\');}',dateFmt:'yyyy-MM-dd'})"
											class="Wdate" style="width: 160px" placeholder="请选择开始日期" readonly/> <i>-</i> <input
											id="endtime" type="text"
											onfocus="WdatePicker({minDate:'#F{$dp.$D(\'starttime\');}',dateFmt:'yyyy-MM-dd'})"
											class="Wdate" style="width: 160px" placeholder="请选择结束日期" readonly/>
								</div>
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
                            <div class="content-user" style="overflow-x:scroll;">

                                <!--用户表格begin-->
                                <table class="table table-bordered" style="white-space: nowrap">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>车牌号</th>
                                        <th>所有人姓名</th>
                                        <th>联系方式</th>
                                        <th>车主姓名</th>
                                        <th>车主账号</th>
                                        <th>车型</th>
                                        <th>载重（吨）</th>
                                        <th>认证方式</th>
                                        <th>安联认证</th>
                                        <th>认证状态</th>
                                        <th>认证时间</th>
                                        <th>审核人</th>
                                        <th>审核时间</th>
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
         </div>
    <!--侧边栏end-->
    </div>
<!--查看详情begin-->
<div class="modal fade" id="detail" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >车辆信息详情</h4>
            </div>
            <div class="modal-body" id="detailid" style="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--查看详情end-->
<!--修改begin-->
<div class="modal fade" id="updateDeatil" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >车辆信息修改</h4>
            </div>
            <div class="modal-body" id="uptdetailid" style="">
            	
            </div>
            
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                <button type="button" id="closeupt" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--修改end-->

<!--修改照片begin-->
<div class="modal fade" id="againPice" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id=" ">修改照片</h4>
            </div>
	            <div class="modal-body">
	                <span id="showcode">
			     		证书编号：<input id="code" type="text">
			        </span>
	               <!--  <div class="reg_tel">
	                    <label></label>
	                    <div class="img_upload">
							<input id="file_yyzz" name="file" class="file" type="file">
							<input type="hidden" name="id" id="vehicid">
							<input type="hidden" name="type" id="vehictype">
							<span class="annotation">* 图片大小不超过5M，限上传1张，只支持JPG、JPEG、PNG格式</span>
						</div>
	                </div> -->
	                 <jsp:include page="../common/upload.jsp" flush="false"></jsp:include>
	            </div>
            <div class="modal-footer">
                <button type="button" onclick="uploadfile()" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--修改照片end-->

<!--安联认证begin-->
<div class="modal fade" id="anlian" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >安联认证</h4>
            </div>
            <form id="anlian_form">
            <div class="modal-body" style=" ">
            	<div class="usermodal userlabel3">
	            	<div class="model_width">
						<label>车牌号：</label>
						<input type="text" id="anlian_vehicleNo" readonly="readonly">
						<input type="hidden" id="anlian_vehicleid" name="vehicleid">
					</div>
					<div class="model_width">
						<label>使用性质：</label>
						<input type="radio" name="nature" checked="checked" value="1"> 营运
						<input type="radio" name="nature" value="2"> 非营运
					</div>
					<div class="model_width">
						<label>总质量：</label>
						<span>
						<input type="text" name="quality" id="anlian_quality">
						</span>
					</div>
					<div class="model_width">
						<label>所有人：</label>
						<input type="text" name="owner" id="anlian_owner">
					</div>
					<div class="model_width">
						<label>证件号码：</label>
						<input type="text" name="idcard" id="anlian_idcard">
					</div>
					<div class="model_width" >
						<label>登记证书编号：</label>
						<input type="text" name="certificateno" id="anlian_certificateno">
					</div>
					<div class="model_width">
						<label>道路运输证号检验有效期止：</label>
						<input type="text" name="expirydata" placeholder="yyyy-MM-dd" id="anlian_expirydata">
					</div>
					<div class="model_width">
						<label>车辆识别码：</label>
						<input type="text" name="identification" id="anlian_identification">
					</div>
					<div class="model_width">
						<label>发动机号：</label>
						<input type="text" name="motor" id="anlian_motor">
					</div>
					<div class="model_width">
						<label>发动机型号：</label>
						<input type="text" name="motorno" id="anlian_motorno">
					</div>
				</div>
            </div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary anlian_renzheng" >确定</button>
                <button type="button" id="alhide" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--安联认证end-->
<!--安联认证详情begin-->
<div class="modal fade" id="anlian_detail" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >详情</h4>
            </div>
            <form id="anlian_form">
            <div class="modal-body" style=" ">
            	<div class="usermodal userlabel3">
	            	<div class="model_width">
						<label>车牌号：</label>
						<input type="text" id="anlian_vehicleNo_detail" readonly="readonly">
					</div>
					<div class="model_width">
						<label>使用性质：</label>
						<input type="text" id="anlian_nature_detail" readonly="readonly">
					</div>
					<div class="model_width">
						<label>总质量：</label>
						<span>
						<input type="text" id="anlian_quality_detail" readonly="readonly">
						</span>
					</div>
					<div class="model_width">
						<label>所有人：</label>
						<input type="text" id="anlian_owner_detail" readonly="readonly">
					</div>
					<div class="model_width">
						<label>证件号码：</label>
						<input type="text" id="anlian_idcard_detail" readonly="readonly">
					</div>
					<div class="model_width" >
						<label>登记证书编号：</label>
						<input type="text" id="anlian_certificateno_detail" readonly="readonly">
					</div>
					<div class="model_width">
						<label>道路运输证号检验有效期止：</label>
						<input type="text" readonly="readonly" placeholder="yyyy-MM-dd" id="anlian_expirydata_detail">
					</div>
					<div class="model_width">
						<label>车辆识别码：</label>
						<input type="text" readonly="readonly" id="anlian_identification_detail">
					</div>
					<div class="model_width">
						<label>发动机号：</label>
						<input type="text" readonly="readonly" id="anlian_motor_detail">
					</div>
					<div class="model_width">
						<label>发动机型号：</label>
						<input type="text" readonly="readonly" id="anlian_motorno_detail">
					</div>
				</div>
            </div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--安联认证end-->

<!--删除begin-->
<div class="modal fade" id="dele" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">物料删除</h4>
            </div>
            <div class="modal-body">
                <h4>确定要删除此条信息吗?</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!--删除end-->
<!--停用begin-->
<div class="modal fade" id="tingyong" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >提示</h4>
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
<div class="modal fade" id="qiyong" role="dialog" aria-labelledby="myModalLabel">
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
<script type="text/javascript">
    var CONTEXTPATH="${contextPath}";
    var imagesRoot="${imagesRoot }";
</script>
<script type="text/javascript" src="${trRoot}/js/cropper.js" ></script>
<script type="text/javascript" src="/resources/js/adminMember/car_manager.js?10.21" ></script>
<script type="text/javascript" src="${scriptsRoot }/jquery.pagination.js"></script>
<script type="text/javascript" src="${scriptsRoot }/pagination.js"></script>
<script type="text/javascript">
    upImg();
</script>

</body>
</html>