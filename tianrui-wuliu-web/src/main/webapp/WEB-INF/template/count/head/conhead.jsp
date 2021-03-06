<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<div class="bghui">
    <div class="wrap">
        <!--登录头部行begin-->
        <head>
            <div class="headerhy">
                <div class="headhy_logo" >
                    <img  src="${trRoot}/tianrui/images/hylogo.png">
                </div>
                <div class="headerhy_tit">
                    <ul>
                        <li class="withbg"><a href="/count/route"><h4>首页</h4></a></li>
                        <li><a href="/count/freightDemand"><h4>货源中心</h4></a></li>
                        <li><a href="/count/freightPlan"><h4>货运计划</h4></a></li>
                        <li><a href="/count/onWaybill"><h4>在途运单</h4></a></li>
                    </ul>
                </div>
                <div class="headerhy_right">
                    <label><a href="/publicMember/registerPage" class="colorreg"> [免费注册]</a></label>
                    <!-- 
                    <label class="indexlogin"><a href="/count/route">请[登录]</a></label>
                     -->
                    
                    <label class="indexlogin">请[登录]</label>
                    <label>欢迎来到大易物流平台！</label>
                </div>
            </div>
        </head>
        <!--登录头部行end-->
    </div>
</div>
<div class="banner">
	<div class="indexbanner">
	    <div class="advertise">
	        <div>
	            <h5>河南省</h5><h5 class="h5dy">首批</h5>
	        </div>
	        <h4>无车承运人物流试点企业</h4>
	        <div class="adverbott">
	            <div class="adverline"></div>
	            <div class="advernet">
	                <label class="advernet1">互联网</label>
	                <span class="advernet2">/</span>
	                <label class="advernet3">物流 </label>
	                <span class="advernet4">/</span>
	                <label class="advernet5">组建货源</label>
	            </div>
	            <div class="adverline"></div>
	        </div>
	    </div>
	    <div class="dywid">
	            <div class="w2000">
	                <img src="${trRoot}/tianrui/images/bannerl6.png" id="car1">
	                <img src="${trRoot}/tianrui/images/bannerl1.png" id="car2">
	                <img src="${trRoot}/tianrui/images/bannerl1.png" id="car3">
	                <img src="${trRoot}/tianrui/images/bannerl2.png" id="car4">
	                <img src="${trRoot}/tianrui/images/bannerl3.png" id="car5">
	                <img src="${trRoot}/tianrui/images/bannerl5.png" id="car6">
	                <img src="${trRoot}/tianrui/images/bannerl4.png" id="car7">
	            </div>
	        <div class="truck2"><img src="${trRoot}/tianrui/images/bannercar2.png"></div>
	        <div class="truck1"><img src="${trRoot}/tianrui/images/bannercar1.png" ></div>
	    </div>
	</div>
    <div class="login">
	    <div class="loginclose">
	    <img src="${trRoot}/tianrui/images/lgclose.png" >
	    </div>
        <h2>用户登录</h2>
        <div class="lg_cont">
            <div class="login_tel">
                <i class="icononline"> &#xe616;</i><span>|</span>
                <input type="text" maxlength="11" id="login_tel" placeholder="请输入手机号">
            </div>
            <div class="login_tel">
                <i class="icononline">&#xe618;</i><span>|</span>
                <input type="password" id="login_psw" placeholder="请输入密码">
            </div>
            <div class="note">
                <h4><span id="message_loginError" style="color: white;"></span></h4>
            </div>
            <div class="lg_reg">
                <label class="colorblue">没有账号？</label>
                <a href="/publicMember/registerPage" class="colorreg">立即注册</a>
                <a href="/publicMember/lostPass" class="colorreg">忘记密码</a>
            </div>
            <div class="lg_btn" onclick="loginIn()">
                <h4>立即登录</h4>
            </div>
        </div>
    </div>
</div>
<!--消息滚动开始-->
<div class="bgdata">
   <div class="wrap">
      <div class="realtime ">
        <div class="real_title">
            <h3>实时动态</h3>
            <div class="blueline"></div>
            <img src="${trRoot}/tianrui/images/hymessge.png">
        </div>
		<div class="swiper-container">
			<div class="swiper-wrapper" id="messgeloop">
			</div>
		</div>
      </div>
   </div>
</div>
<!--数据总览-->
<div class="wrap">
  <div class="data_total">
     <div class="data_title">
         <h3>数据总览</h3>
         <div class="blueline"></div>
         <img src="${trRoot}/tianrui/images/indexdata.png">
     </div>
         <ul class="data_tta">
             <li class="bgred">
         	<a href="/count/plan">
                 <div class="dtail_tit">
                     <label>货运计划总量</label>
                     <span class="fr">
                     	<%-- <c:if test="${plan.sumdate - monthplan.sumdate >= 0}">
                     	同比上月增长
                     	<fmt:formatNumber value="${(plan.sumdate - monthplan.sumdate)/monthplan.sumdate }" type="number" pattern="0.00%" />
                     	</c:if>
                     	<c:if test="${plan.sumdate - monthplan.sumdate < 0}">
                     	同比上月减少
                     	<fmt:formatNumber value="${(monthplan.sumdate - plan.sumdate)/monthplan.sumdate }" type="number" pattern="0.00%" />
                     	</c:if> --%>
                     	
                    	</span>
                 </div>
                 <div class="divder_tm"></div>
                 <div class="dtail_body">
                     <%-- <label><fmt:formatNumber value="${plan.sumdate/10000 }" type="number" pattern="0.00"></fmt:formatNumber></label><span>万吨</span> --%>
                     <label>61291.14</label><span>万吨</span>
                 </div>
                <div class="dtail_foot">
                    <label>本月</label><i class="icononline">
					<%-- <c:if test="${plan.sumdate - monthplan.sumdate >= 0}">
					&#xe617;</i>
					<span>
					<fmt:formatNumber value="${plan.sumdate - monthplan.sumdate }" type="number" pattern="0.00"></fmt:formatNumber>
					</span>
					</c:if>
					<c:if test="${plan.sumdate - monthplan.sumdate < 0}">
					&#xe619;</i>
					<span><fmt:formatNumber value="${monthplan.sumdate - plan.sumdate }" type="number" pattern="0.00"></fmt:formatNumber></span>
					</c:if> --%>
					&#xe617;</i>
			        <span>2500.6975</span>
                </div>
         	</a>
             </li>
             <li class="bgyello">
         	<a href="/count/vehicle">
                 <div class="dtail_tit">
                     <label>车辆总数</label>
                     <span class="fr">
                     <%-- 	<c:if test="${vehicle.sumdate - monthvehicle.sumdate >= 0}">
                    		同比上月增长
                    		<fmt:formatNumber value="${(vehicle.sumdate - monthvehicle.sumdate)/monthvehicle.sumdate }" type="number" pattern="0.00%" />
                     	</c:if>
                     	<c:if test="${vehicle.sumdate - monthvehicle.sumdate < 0}">
                    		同比上月减少
                    		<fmt:formatNumber value="${(monthvehicle.sumdate - vehicle.sumdate)/monthvehicle.sumdate }" type="number" pattern="0.00%" />
                     	</c:if>
                    		 --%>
                    		</span>
                 </div>
                 <div class="divder_tm"></div>
                 <div class="dtail_body">
                     <label><fmt:formatNumber type="number" value="${vehicle.sumdate }" maxFractionDigits="0"/></label><span>辆</span>
                 </div>
                 <div class="dtail_foot">
                     <label>本月</label><i class="icononline">
			<c:if test="${vehicle.sumdate - monthvehicle.sumdate >= 0}">&#xe617;
			</i>
                     <span><fmt:formatNumber type="number" value="${vehicle.sumdate - monthvehicle.sumdate }" maxFractionDigits="0"/></span>
			</c:if>
			<c:if test="${vehicle.sumdate - monthvehicle.sumdate < 0}">&#xe619;
			</i>
                     <span><fmt:formatNumber type="number" value="${monthvehicle.sumdate - vehicle.sumdate }" maxFractionDigits="0"/></span>
			</c:if>
			
                 </div>
         	</a>
             </li>
             <li class="bggreen">
         	<a href="/count/bill">
                 <div class="dtail_tit">
                     <label>交易总量</label>
                     <span class="fr">
                     	<%-- <c:if test="${bill.sumdate - monthbill.sumdate >= 0}">
                     	同比上月增长
                     	<fmt:formatNumber value="${(bill.sumdate - monthbill.sumdate)/monthbill.sumdate }" type="number" pattern="0.00%" />
                     	</c:if>
                     	<c:if test="${bill.sumdate - monthbill.sumdate < 0}">
                     	同比上月减少
                     	<fmt:formatNumber value="${(monthbill.sumdate - bill.sumdate)/monthbill.sumdate }" type="number" pattern="0.00%" />
                     	</c:if> --%>
                    	</span>
                 </div>
                 <div class="divder_tm"></div>
                 <div class="dtail_body">
                     <label><fmt:formatNumber type="number" value="${bill.sumdate }" maxFractionDigits="0"/></label><span>单</span>
                 </div>
                 <div class="dtail_foot">
                     <label>本月</label><i class="icononline">
			<c:if test="${bill.sumdate - monthbill.sumdate >= 0}">&#xe617;
			</i>
                     <span><fmt:formatNumber type="number" value="${bill.sumdate - monthbill.sumdate }" maxFractionDigits="0"/></span>
			</c:if>
			<c:if test="${bill.sumdate - monthbill.sumdate < 0}">&#xe619;
			</i>
                     <span><fmt:formatNumber type="number" value="${monthbill.sumdate - bill.sumdate }" maxFractionDigits="0"/></span>
			</c:if>
			
                 </div>
         	</a>
             </li>
             <li class="bgblue">
         	<a href="/count/pay">
         	<!-- 
         		<div class="dtail_tit">
                     <label>运费总额</label>
                     <span class="fr">
                     	同比上月增长16.28%
                     </span>
                 </div>
                 <div class="divder_tm"></div>
                 
                 <div class="dtail_body">
                     <label>
                     <input type="hidden" value="${pay.id }">
                     447.35
                     </label>
                     <span>万元</span>
                 </div>
		
                 <div class="dtail_foot">
                     <label>本月</label><i class="icononline">
			&#xe617;
			</i>
                     <span>
                     39.10万元
                     </span>
                 </div>
         	 -->
                 <div class="dtail_tit">
                     <label>运费总额</label>
                     <span class="fr">
                     <%-- <c:if test="${pay.sumdate - monthpay.sumdate >= 0}">
                     	同比上月增长
                     <fmt:formatNumber value="${(pay.sumdate - monthpay.sumdate)/monthpay.sumdate }" type="number" pattern="0.00%" />
                     </c:if>
                     <c:if test="${pay.sumdate - monthpay.sumdate < 0}">
                     	同比上月增长
                     <fmt:formatNumber value="${(monthpay.sumdate - pay.sumdate)/monthpay.sumdate }" type="number" pattern="0.00%" />
                     </c:if> --%>
                     
                     </span>
                 </div>
                 <div class="divder_tm"></div>
                 
                 <div class="dtail_body">
                     <label>
                     <input type="hidden" value="${pay.id }">
                    	<fmt:formatNumber value="${pay.sumdate/10000 }" pattern="#.##" minFractionDigits="2" />
                     </label>
                     <span>万元</span>
                 </div>
		
                 <div class="dtail_foot">
                     <label>本月</label><i class="icononline">
			<c:if test="${pay.sumdate - monthpay.sumdate >= 0}">&#xe617;
			</i>
                     <span>
                     <fmt:formatNumber value="${(pay.sumdate - monthpay.sumdate)/10000 }" pattern="#.##" minFractionDigits="2" />万元
                     </span>
			</c:if>
			<c:if test="${pay.sumdate - monthpay.sumdate < 0}">&#xe619;
			</i>
                     <span>
                     <fmt:formatNumber value="${(monthpay.sumdate - pay.sumdate)/10000 }" pattern="#.##" minFractionDigits="2" />万元
                     </span>
			</c:if>
			
                 </div>
         	</a>
             </li>
         </ul>
     </div>
 </div>

<!--公共弹出模态框begin-->
<div class="modal fade" id="commonModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document" style="width:400px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modal_del_title">确认信息</h4>
            </div>
            <div class="modal-body">
                <h4 id="modal_common_content"></h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!--去接单按钮-->
<div class="hy_jiedan">
    <a href="/count/freightDemand">
        <h4>去接单</h4>
    </a>
</div>
<!--公共弹出模态框end--> 
<script type="text/javascript" src="/resources/js/utils/md5.js" ></script>
<script type="text/javascript" src="/resources/js/count/head/login.js"></script>
<script>

</script>

