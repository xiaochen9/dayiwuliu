
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!Doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>签收运单</title>
    <meta name="keywords" content=" 天瑞"/>
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="${trRoot}/tianrui/css/bootstrap.css" rel="stylesheet">
    <link href="${trRoot}/tianrui/css/base.css" rel="stylesheet">
    <link href="${trRoot}/tianrui/css/style.css" rel="stylesheet">
    <link href="${trRoot}/tianrui/css/imgcut.css"  rel="stylesheet">
    <link href="${trRoot}/tianrui/css/tr-media.css"  rel="stylesheet">
    <link href="${trRoot}/tianrui/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
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
                <label>当前位置：运单</label><span>></span> <label>签收运单</label>
            </div>
    </div>
    <div class="row">
       <!-- 引用公共left部分 -->
			<jsp:include page="../../common/member/left_busi.jsp"></jsp:include>
        <!--个人中心左侧end-->
   <!--个人中心右侧begin-->
            <div class="rz_right">
                <div class="car_title bgblue">
                    <h2>签收运单</h2>
                </div>
                <!--个人中心右侧搜索框begin-->
                <div class="plan_search">
                    <input type="text" id="searchKey" placeholder="请出入搜索内容">
                    <button type="button" class="btn btnblue searchBtn">搜索</button>
                </div>
                <!--个人中心右侧搜索框end-->
                <div class="plan_fege"></div>
                <!--计划模板表格begin-->
                <div class="bill_table" id="dateContent" >
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>运单号</th>
                            <th>运单类型 </th>
                            <th>货物名称</th>
                            <th>车牌号</th>
                            <th>运单状态</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="innhtml">
                        
                        </tbody>
                    </table>
                    <div class="goods_more pageNone" style="display:hide">
	                     <h4>暂无数据</h4>
	                 </div>
                    <div class="goods_more pageMore" style="display:hide">
	                     <h4>查看更多</h4>
	                 </div>
                </div>
                <!--tab切换的内容end-->
            </div>
            <!--计划模板表格end-->
        </div>
        <!--个人中心右侧end-->
        </div>
</div>
</div>
<!--内容部分end-->

<!-- 普通签收modal -->
<div class="modal fade" id="signModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id=" ">运单签收</h4>
            </div>
            <div class="modal-body">
                <div class="bdimg">
	                <div class="modal-body">
		                <ul class="nav nav-tabs">
		                    <li class="active"><a href="#single" id="pickupweight_li" data-toggle="tab">提货磅单</a></li>
		                    <li><a href="#multiple" id="signweight_li" data-toggle="tab">卸货磅单</a></li>
		                </ul>
		                <div class="tab-content">
		                    <div class="tab-pane fade in active" id="single">
		                        <div class="bdimg">
				                    <a target="_blank"><img src="${trRoot}/tianrui/images/bd.png" id="qhbdImgUrl"></a>
				                    <label></label>
				                    <div id="notImg" class="bd_note" hidden>
	                        			<label>司机未上传磅单</label>
					                </div>
		                        </div>
		                    </div>
		                    <div class="tab-pane fade" id="multiple">
		                        <div class="bdimg">
				                    <a target="_blank"><img src="${trRoot}/tianrui/images/bd.png" id="bdimgurl"></a>
		                        </div>
		                    </div>
		                </div>
		            </div>
                    <p><label>签收重量：</label>
                    <input type="text" id="weighttext">
                    <input type="hidden" id="bill_id">
                    <input type="hidden" id="pickupweight">
                    <input type="hidden" id="signweight">
                    <label id="stateWeightLabel" style="padding-left: 50px;"></label></p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="signerWeight" class="btn btn-primary signsubmitbtn">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!-- 签收moal结束 -->

<!-- 安联签收modal -->
<div class="modal fade" id="anlian_signModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id=" ">安联运单签收</h4>
            </div>
            <div class="modal-body">
                <div class="bdimg">
	                <div class="modal-body">
		                <ul class="nav nav-tabs">
		                    <li class="active"><a href="#single_al" id="pickupweight_li" data-toggle="tab">提货磅单</a></li>
		                    <li><a href="#multiple_al" id="signweight_li" data-toggle="tab">卸货磅单</a></li>
		                </ul>
		                <div class="tab-content">
		                    <div class="tab-pane fade in active" id="single_al">
		                        <div class="bdimg">
				                    <div class="img_upload">
										<input id="pickupimgurlReq" onchange="fileupload('pickupimgurlReq')" class="file" type="file"> <span
											class="annotation">* 图片大小不超过5M，限上传1张，只支持JPG、JPEG、PNG格式</span>
										<input type="hidden" id="pickupimgurlReq_str" value="" >
									</div>
		                        </div>
		                    </div>
		                    <div class="tab-pane fade" id="multiple_al">
		                        <div class="bdimg">
									 <div class="img_upload">
										<input id="signimgurlReq" onchange="fileupload('signimgurlReq')" class="file" type="file"> <span
											class="annotation">* 图片大小不超过5M，限上传1张，只支持JPG、JPEG、PNG格式</span>
										<input type="hidden" id="signimgurlReq_str" value="" >
									</div>
		                        </div>
		                    </div>
		                </div>
		            </div>
                    <p>
                    <label>提货重量：</label>
                    <input type="text" id="al_pickupweight">
                    <label>卸货重量：</label>
                    <input type="text" id="al_signweight">
                    </p>
                    <p><label>签收重量：</label>
                    <input type="text" id="al_trueweight">
                    <input type="hidden" id="al_signBill_id">
                    </p>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary signsubmitbtn_al">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!-- 签收moal结束 -->
<!--上传进度条-->
	<a id="showload" data-toggle="modal" data-target="#detail"></a>
	<div class="modal fade" id="detail" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document" style="width: 400px;">
		<div class="upmodal">
			<div class="modal-content">
				<div class="modal-body">
					<div class="upload">
						<img src="${trRoot}/tianrui/images/upload.gif">
						<div class="upload_font">
							<img src="${trRoot}/tianrui/images/sc.png">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--上传进度条end-->
<!-- 引用公共footer部分 -->
<jsp:include page="../../common/member/footer_busi.jsp"></jsp:include>
<script type="text/javascript" src="${trRoot}/tianrui/js/cropbox.js"></script>
<script type="text/javascript" src="/resources/js/common/member/header_busi.js" ></script>
<script type="text/javascript" src="${trRoot}/tianrui/js/fileinput.js"></script>
<script type="text/javascript" src="${trRoot}/tianrui/js/fileinput_locale_zh.js"></script>
<script type="text/javascript">
var type = "owner";
</script>
<script type="text/javascript" src="/resources/js/bill/signer_page.js?06.221" ></script>
<script type="text/javascript">
		$(".file").fileinput({
			language : 'zh',
			showUpload : false,
			dropZoneEnabled : false,
			maxFileCount : 1,
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