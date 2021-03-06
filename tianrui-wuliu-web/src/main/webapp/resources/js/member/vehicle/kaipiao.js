$(function (){
	$('#myVehiclePage').addClass('selected');
});
$("#vehicle_ticket_add").on("click",function(){
	
	var veh_quality = $("#veh_quality").val();
	if($.trim(veh_quality)==""){
		alert("总质量不能为空");
		return;
	}
/*	var veh_owner = $("#veh_owner").val();
	if($.trim(veh_owner)==""){
		alert("所有人不能为空");
		return;
	}*/
	var veh_idcard = $("#veh_idcard").val();
	if($.trim(veh_idcard)==""){
		alert("身份证号不能为空");
		return;	
	}
	var veh_certificateno = $("#veh_certificateno").val();
	if($.trim(veh_certificateno)==""){
		alert("登记证书编号不能为空");
		return;	
	}
	
	//1900-2099
	var regexp = /^([1][9][0-9][0-9]|[2][0][0-9][0-9])(\-)([0][1-9]|[1][0-2])(\-)([0-2][0-9]|[3][0-1])$/;
	
	var veh_expirydata = $("#veh_expirydata").val();
	if(!regexp.test(veh_expirydata)){
		alert("道路运输证号检验有效期止时间格式有误");
		return;
	}
	var veh_identification = $("#veh_identification").val();
	if($.trim(veh_identification)==""){
		alert("车辆识别码不能为空");
		return;	
	}
	var veh_motor = $("#veh_motor").val();
	if($.trim(veh_motor)==""){
		alert("发动机号不能为空");
		return;	
	}
	$("#veh_motorno").val(veh_motor);
	
	confirm("操作提示","开票认证通过的车辆绑定开票认证通过的司机后无法解绑,是否确认操作?",function(){
		$("#vehicle_ticket_add").attr("disabled",true);
		$.ajax({
			url : '/trwuliu/Member/vehicleticket/add',// 跳转到 action
			data : $('#vehickeTicket').serialize(),
			type : "post",
			success : function(result) {
				if(result.code=="000000"){
					alert("操作成功");
					window.location.href="/trwuliu/Member/myVehicle/myVehiclePage";
				}else{
					alert(result.error);
				}
				$("#vehicle_ticket_add").attr("disabled",false);
			}
		});
	});
});
