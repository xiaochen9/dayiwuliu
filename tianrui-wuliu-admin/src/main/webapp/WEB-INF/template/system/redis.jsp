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
    <title>会员管理</title>
    <meta name="keywords" content=" 天瑞" />
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="${stylesRoot }/bootstrap.css" rel="stylesheet">
    <link href="${stylesRoot }/base.css" rel="stylesheet">
    <link href="${stylesRoot }/style.css" rel="stylesheet">
    <link href="${stylesRoot }/tr-media.css"  rel="stylesheet">
    <link href="${stylesRoot }/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
	<link href="${trRoot}/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
	<script language="javascript" type="text/javascript" src="${scriptsRoot }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" type="text/css" href="${stylesRoot }/pagination/pagination.css" />
</head>
<body>

<div class="container-fluid">
    <input type="hidden" id="recPageNo" value="${pageNo }">
    <!--公共头部begin-->
    <jsp:include page="../common/header.jsp" flush="false"></jsp:include>
     <!--后台左侧布局end-->
                <!--后台右侧布局begin-->
            <div class="col-md-10 ">
                <div class="ht_content">
                    <div id="content-header">
                        <h3>redis数据管理</h3>
                    </div>
                    <!--查询框begin-->
                    <!--查询框end-->
                    <div class="row mt15">
                         <div class="col-md-12">
                             <div class="content-user">
                                <select id="searchtype" onchange="search();">
									<option value="number">访问次数</option>
									<option value="pass">禁用IP</option>
								</select>
                                <!--用户表格begin-->
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>IP地址</th>
                                        <th id="htmlType">访问次数</th>
                                        <th>创建时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="innerhml">
                                    <tr>
                                    </tr>
                                    </tbody>
                                </table>
                                <!--用户表格end-->
                             </div>
                         </div>
                    </div>
                </div>
            </div>
                <!--后台右侧布局end-->
            </div>
            <!--后台整体布局end-->
    </div>
    <!--侧边栏end-->
</div>
<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>

<script type="text/javascript">
	var CONTEXTPATH="${contextPath}";
</script>
<script type="text/javascript" src="/resources/js/redis/redis.js?0223"></script>
</body>
</html>