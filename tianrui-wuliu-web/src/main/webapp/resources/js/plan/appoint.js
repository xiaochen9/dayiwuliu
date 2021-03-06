;(function($,win){
	$('.venderList li').off('click').on('click',function(){
		$(this).siblings().removeClass('active').find('.checkInput').each(function(){
			this.checked = false;
		});
		$(this).addClass('active').find('.checkInput')[0].checked = true;
	});
	$(".checkInput").change(function(){
		$(this).closest('li').siblings().find('.checkInput').each(function(){
			this.checked = false;
		});
	});
	//返回
	$(".backBtn").off('click').on('click',function(){
		var operate = $('#operate').val();
		if(operate == 'add'){
			window.location.href = "/trwuliu/planvender/main";
		}
		if(operate == 'edit'){
			window.location.href = "/trwuliu/planAppoint/main";
		}
	});
	//委派计划
	$('.appointBtn').off('click').on('click',function(){
		var operate = $('#operate').val();
		this.disabled = true;
		if(operate == 'add'){
			addAppointPlan(this);
		}
		if(operate == 'edit'){
			editAppointPlan(this);
		}
	});
	
	var addAppointPlan = function(dom){
		var params = getParams();
		if(!params){
			//解除按钮冻结
			if(dom){
				dom.disabled = false;
			}
			return;
		}
		$.ajax({
			url:'/trwuliu/planAppoint/addAppointPlan',
			data:params,
			dataType:'json',
			type:'POST',
			cache:false,
			async:true,
			success:function(res){
				if(res.code=="000000"){
					window.location.href = CONTEXTPATH + "/trwuliu/planvender/main";
				}else{
					alert(res.error);
				}
				//解除按钮冻结
				if(dom){
					dom.disabled = false;
				}
			}
		});
	};
	
	var editAppointPlan = function(dom){
		var params = getParams();
		if(!params){
			//解除按钮冻结
			if(dom){
				dom.disabled = false;
			}
			return;
		}
		$.ajax({
			url:'/trwuliu/planAppoint/editAppointPlan',
			data:params,
			dataType:'json',
			type:'POST',
			cache:false,
			async:true,
			success:function(res){
				if(res.code=="000000"){
					window.location.href = CONTEXTPATH + "/trwuliu/planAppoint/main";
				}else{
					alert(res.error);
				}
				//解除按钮冻结
				if(dom){
					dom.disabled = false;
				}
			}
		});
	};
	
	function getParams(){
		var planid = $('#planid').val();
		var begintime = $('#begintime').val();
		var endtime = $('#endtime').val();
		var totalplanned = $('#totalplanned').val();
		var venderid = $('ul.venderList li.active').attr('venderid');
		var venderName = $('ul.venderList li.active').attr('venderName');
		var venderTel = $('ul.venderList li.active').attr('venderTel');
		if(!$.trim(planid)){
			alert("请刷新重试");return false;
		}
		if(!$.trim(begintime)){
			alert("开始时间不能为空");return false;
		}
		if(!$.trim(endtime)){
			alert("结束时间不能为空");return false;
		}
		if(!$.trim(totalplanned)){
			alert("运输量不能为空");return false;
		}
		if(!$.isNumeric(totalplanned)){
			alert("运输量必须为数字");return false;
		}
		if(parseFloat(totalplanned) <= 0){
			alert("运输量必须大于零");return false;
		}
		if(!$.trim(venderid)){
			alert("必须选择一个车主");return false;
		}
		if(!$.trim(venderName)){
			alert("必须选择一个车主");return false;
		}
		if(!$.trim(venderTel)){
			alert("必须选择一个车主");return false;
		}
		return {
			planid:planid,
			begintime:begintime,
			endtime:endtime,
			totalplanned:totalplanned,
			venderid:venderid,
			venderName:venderName,
			venderTel:venderTel
		};
	}
	
	
	
	
})(jQuery,window);