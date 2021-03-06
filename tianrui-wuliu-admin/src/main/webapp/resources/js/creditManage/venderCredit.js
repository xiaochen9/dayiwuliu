;(function($,win){
	 creditYearArr = [2016,2017,2018,2019,2020,2021,2022,2023,2024,2025];
	var creditMonthArr = [01,02,03,04,05,06,07,08,09,10,11,12];
	init();
	
	function init(){
		initSearchContent();
		initCreditData(true);
	}
	//初始化搜索内容
	function initSearchContent(){
		for(var i=0;i<creditYearArr.length;i++){
			$('#credityear').append('<option value="'+creditYearArr[i]+'">'+creditYearArr[i]+'</option>');
		}
		for(var i=0;i<creditMonthArr.length;i++){
			$('#creditmonth').append('<option value="'+creditMonthArr[i]+'">'+creditMonthArr[i]+'</option>');
		}
	}
	
	function initCreditData(isNew){
		var params = {};
		if(!isNew){
			params.credityear = $('#credityer').val();
			params.creditmonth = $('#creditmonth').val();
		}
		$.ajax({
			url : CONTEXTPATH + '/creditManage/queryCredit',
			data : params,
			type : 'post',
			success : function(result) {
				if(result.code == '000000'){
					readerHtml(result.data);
				}else{
					alert(result.error);
				}
			}
		});
	}
	
	function readerHtml(list){
		$('#creditBody').empty();
		if(list != null && list.length > 0){
			$('#credityear').val(list[0].credityear);
			$('#creditmonth').val(list[0].creditmonth);
			for(var i=0;i<list.length;i++){
				var obj = list[i];
				var $tr = $('<tr>');
				var csp = obj.creditScoreResp;
				var addnum = csp.addassist+csp.addcontribute+csp.addspecial;
				var subnum = csp.subaccident+csp.subcomplaint+csp.subdisrupt+csp.submanned+csp.suboperation+csp.subturnover;
				$tr.append('<td>'+(i+1)+'</td>')
					.append('<td>'+obj.vendertel+'</td>')
					.append('<td>'+obj.vendername+'</td>')
					.append('<td>'+obj.vehiclesum+'</td>')
					.append('<td>'+obj.billcount+'</td>')
					.append('<td>'+obj.timelystart+'</td>')
					.append('<td>'+obj.timelydelivery+'</td>')
					.append('<td>'+obj.timelyreturn+'</td>')
					.append('<td>'+obj.cardamage+'</td>')
					.append('<td>'+obj.transportaccident+'</td>')
					.append('<td class="text_underline"><a data-toggle="modal" data-target="#adddetail" class="addCredit">'+addnum+'</a></td>')
					.append('<td class="text_underline"><a data-toggle="modal" data-target="#subdetail" class="subCredit">'+subnum+'</a></td>')
					.data(obj).appendTo('#creditBody');
			}
			$('.addCredit').off('click').on('click',function(){
				var obj = $(this).closest('tr').data();
				var csp = obj.creditScoreResp;
				$('#csId').val(csp.id);
				$('#addAssist').val(csp.addassist);
				$('#addSpecial').val(csp.addspecial);
				$('#addContribute').val(csp.addcontribute);
			});
			$('.subCredit').off('click').on('click',function(){
				var obj = $(this).closest('tr').data();
				var csp = obj.creditScoreResp;
				$('#csId').val(csp.id);
				$('#subManned').val(csp.submanned);
				$('#subOperation').val(csp.suboperation);
				$('#subAccident').val(csp.subaccident);
				$('#subComplaint').val(csp.subcomplaint);
				$('#subTurnover').val(csp.subturnover);
				$('#subDisrupt').val(csp.subdisrupt);
			});
		}else{
			//没有数据
			alert("暂无数据!");
		}
	}
	
	$('.addComfirm').off('click').on('click',function(){
		$(this).addClass('disabled');
		var csId = $('#csId').val();
		var addassist = $('#addAssist').val();
		var addspecial = $('#addSpecial').val();
		var addcontribute = $('#addContribute').val();
		$.ajax({
			url : CONTEXTPATH + '/creditManage/updateCreditScore',
			data : {
				id:csId,
				addassist:addassist,
				addspecial:addspecial,
				addcontribute:addcontribute
			},
			type : 'post',
			success : function(result) {
				if(result.code == '000000'){
					alert(result.data);
					win.location.reload();
				}else{
					alert(result.error);
				}
			}
		});
	});
	
	$('.subComfirm').off('click').on('click',function(){
		$(this).addClass('disabled');
		var csId = $('#csId').val();
		var submanned = $('#subManned').val();
		var suboperation = $('#subOperation').val();
		var subaccident = $('#subAccident').val();
		var subcomplaint = $('#subComplaint').val();
		var subturnover = $('#subTurnover').val();
		var subdisrupt = $('#subDisrupt').val();
		$.ajax({
			url : CONTEXTPATH + '/creditManage/updateCreditScore',
			data : {
				id:csId,
				submanned:submanned,
				suboperation:suboperation,
				subaccident:subaccident,
				subcomplaint:subcomplaint,
				subturnover:subturnover,
				subdisrupt:subdisrupt
			},
			type : 'post',
			success : function(result) {
				if(result.code == '000000'){
					alert(result.data);
					win.location.reload();
				}else{
					alert(result.error);
				}
			}
		});
	});
	
	$('.searchCredit').off('click').on('click',function(){
		initCreditData(false);
	});
	
})(jQuery,window);