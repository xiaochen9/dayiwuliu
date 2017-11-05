package com.tianrui.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianrui.api.intf.ILEDCountService;
import com.tianrui.api.intf.IMemberVoService;
import com.tianrui.api.req.LED.LEDCountReq;
import com.tianrui.api.resp.LED.LEDCountResp;
import com.tianrui.common.utils.UUIDUtil;
import com.tianrui.common.vo.MemberVo;
import com.tianrui.common.vo.PaginationVO;
import com.tianrui.common.vo.Result;
import com.tianrui.service.bean.LEDCount;
import com.tianrui.service.bean.LEDCountData;
import com.tianrui.service.mapper.LEDCountDataMapper;
import com.tianrui.service.mapper.LEDCountMapper;

@Service
public class LEDCountService implements ILEDCountService{

	@Autowired
	LEDCountMapper lEDCountMapper;
	@Autowired
	LEDCountDataMapper lEDCountDataMapper;
	@Autowired
	IMemberVoService memberVoService;
	
	@Override
	public Result allCountData() {
		// TODO Auto-generated method stub
		Result rs = Result.getSuccessResult();
		LEDCountData query = new LEDCountData();
		query.setLedType("9");
		query.setDataType("1");
		List<LEDCountData> list = lEDCountDataMapper.selectByCondition(query);
		countHend();
		for(LEDCountData del: list){
			lEDCountDataMapper.deleteByPrimaryKey(del.getId());
		}
		return rs;
	}
	
	protected void countHend() {
		LEDCount cou = new LEDCount();
		LEDCountData save = new LEDCountData();
		save.setCreateTime(System.currentTimeMillis());
		//总运费
		Double amount = lEDCountMapper.selectByPayAmount(cou);
		save.setId(UUIDUtil.getId());
		save.setDataType("1");
		save.setLedType("9");
		save.setCountdata(amount);
		save.setRemark("zyf");
		savecountHend(save);
		//运单签收量
		Double dyTrueweight = lEDCountMapper.selectByBillDy(cou);
		Double alTrueweight = lEDCountMapper.selectByBillAl(cou);
		save.setId(UUIDUtil.getId());
		save.setDataType("1");
		save.setLedType("9");
		save.setCountdata(dyTrueweight+alTrueweight);
		save.setRemark("qsl");
		savecountHend(save);
		//车辆总数
		Double vehicle = lEDCountMapper.selectByCountVehicle(cou);
		save.setId(UUIDUtil.getId());
		save.setDataType("1");
		save.setLedType("9");
		save.setCountdata(vehicle);
		save.setRemark("clzs");
		savecountHend(save);
		//运单总数
		Double albill = lEDCountMapper.selectByCountAl(cou);
		Double dybill = lEDCountMapper.selectByCountDy(cou);
		save.setId(UUIDUtil.getId());
		save.setDataType("1");
		save.setLedType("9");
		save.setCountdata(albill+dybill);
		save.setRemark("ydzs");
		savecountHend(save);
		//活跃车辆
		cou.setTimeBegin(indexLong(new Date().getTime()));
		Double vehicleAct = lEDCountMapper.selectByVehcileAct(cou);
		save.setId(UUIDUtil.getId());
		save.setDataType("1");
		save.setLedType("9");
		save.setCountdata(vehicleAct);
		save.setRemark("hycl");
		savecountHend(save);
	}
	
	protected void savecountHend(LEDCountData save) {
		lEDCountDataMapper.insertSelective(save);
	}
	
	public Long indexLong(Long tm){
		Date date=new Date(tm);//取时间
	    Calendar calendar = new GregorianCalendar(); 
	    calendar.setTime(date); 
//	    calendar.add(calendar.YEAR, 1);//把日期往后增加一年.整数往后推,负数往前移动
//	    calendar.add(calendar.DAY_OF_MONTH, 1);//把日期往后增加一个月.整数往后推,负数往前移动
//	    calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动 
//	    calendar.add(calendar.WEEK_OF_MONTH, 1);//把日期往后增加一个月.整数往后推,负数往前移动
	    calendar.add(calendar.MONTH, -1);//获取当前月份
	    date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
		return date.getTime();
	}

	@Override
	public PaginationVO<LEDCountResp> findCount(LEDCountReq req) throws Exception {
		PaginationVO<LEDCountResp> page = new PaginationVO<LEDCountResp>();
		LEDCountData query = new LEDCountData();
		if(req.getPageNO()!=null){
			query.setPageNO(req.getPageNO()*req.getPageSize());
			query.setPageSize(req.getPageSize());
			page.setPageNo(req.getPageNO());
			page.setPageSize(req.getPageSize());
		}
		query.setLedType(req.getLedType());
		query.setDataType(req.getDataType());
		List<LEDCountData> list = lEDCountDataMapper.selectByCondition(query);
		long a = lEDCountDataMapper.selectByCount(query);
		page.setList(copyProperties2(list));
		page.setTotal(a);
		return page;
	}
	
	protected List<LEDCountResp> copyProperties2(List<LEDCountData> req) throws Exception {
		List<LEDCountResp> list = new ArrayList<LEDCountResp>();
		for(LEDCountData sp : req){
			LEDCountResp resp = new LEDCountResp();
			PropertyUtils.copyProperties(resp, sp);
			list.add(resp);
		}
		return list;
	}

	@Override
	public Result payAmountCount(Long begin, Long end, String timeStr) {
		LEDCount query = new LEDCount();
		query.setTimeBegin(begin);
		query.setTimeEnd(end);
		Double amount = lEDCountMapper.selectByPayAmount(query);
		LEDCountData save = new LEDCountData();
		save.setLedType("6");//1-运量
		save.setCountdata(amount);
		save.setDataType("1");//1-正式数据
		save.setRemark(timeStr);
		save.setStimestr(timeStr);
		saveCountData(save);
		return null;
	}
	
	@Override
	public Result billCouAl(Long begin,Long end,String timeStr) {
		LEDCount query = new LEDCount();
		query.setTimeBegin(begin);
		query.setTimeEnd(end);
		Double a = 0.00;
		Double al = lEDCountMapper.selectByBillAl(query);
		Double dy = lEDCountMapper.selectByBillDy(query);
		if(al!=null){
			a = a+al;
		}
		if(dy!=null){
			a = a+dy;
		}
		LEDCountData save = new LEDCountData();
		save.setLedType("1");//1-运量
		save.setCountdata(a);
		save.setDataType("1");//1-正式数据
		save.setRemark(timeStr);
		save.setStimestr(timeStr);
		saveCountData(save);
		return null;
	}
	
	/** 统计数据插入*/
	protected void saveCountData(LEDCountData db) {
		//校验当月数据是否统计
		LEDCountData query = new LEDCountData();
		query.setDataType(db.getDataType());
		query.setLedType(db.getLedType());
		query.setStimestr(db.getStimestr());
		List<LEDCountData> list = lEDCountDataMapper.selectByCondition(query);
		if(list.size()==0){
			db.setId(UUIDUtil.getId());
			db.setCreateTime(System.currentTimeMillis());
			lEDCountDataMapper.insertSelective(db);
		}else{
			db.setId(list.get(0).getId());
			db.setModifyTime(System.currentTimeMillis());
			lEDCountDataMapper.updateByPrimaryKeySelective(db);
		}
	}

	@Override
	public Result billCargo() {
		Result rs = Result.getSuccessResult();
		//校验当月数据是否统计
		LEDCountData que = new LEDCountData();
		que.setDataType("1");//1-正式数据
		que.setLedType("2");//2-货物类别
		List<LEDCountData> list = lEDCountDataMapper.selectByCondition(que);
		
		LEDCount query = new LEDCount();
		query.setPageNo(0);
		query.setPageSize(10);
		List<LEDCount> al = lEDCountMapper.selectByCargoAl(query);
		List<LEDCount> dy = lEDCountMapper.selectByCargoDy(query);
		//运单总数
		Double billcount = lEDCountMapper.selectByCountAl(null)+lEDCountMapper.selectByCountDy(null);
		cargoList(al,dy,billcount);
		for(LEDCountData led : list){
			lEDCountDataMapper.deleteByPrimaryKey(led.getId());
		}
		return rs;
	}
	
	
	/** 计算两组数据最大值前五及其他*/
	protected List<LEDCount> cargoList(List<LEDCount> al,List<LEDCount> dy,Double billcount) {
		List<LEDCount> list = new ArrayList<LEDCount>();
		//循环整合两组数据
		for(LEDCount a : al){
			for (int i = 0; i < dy.size(); i++) {
				if(a.getCountName().equals(dy.get(i).getCountName())){
					//如果数据名称相同  统计数目相加
					a.setCountNum(a.getCountNum()+dy.get(i).getCountNum());
					dy.remove(i);
				}
			}
			list.add(a);
		}
		for(LEDCount b : dy){
			list.add(b);
		}
		//循环整合两组数据END
		int max = 0;
		Double other = billcount;
		//分次去除最大数据
		for (int i = 0; i < 5; i++) {
			Double maxNum = 0.00;
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).getCountNum()>maxNum){
					maxNum = list.get(j).getCountNum();
					max = j;
				}
			}
			LEDCountData save = new LEDCountData();
			save.setId(UUIDUtil.getId());
			save.setDataType("1");
			save.setLedType("2");
			save.setRemark(list.get(max).getCountName());
			save.setCountdata(list.get(max).getCountNum());
			save.setCreateTime(System.currentTimeMillis());
			lEDCountDataMapper.insertSelective(save);
			other = other - list.get(max).getCountNum();
			list.remove(max);
		}
		//计算其它类型
		LEDCountData oth = new LEDCountData();
		oth.setId(UUIDUtil.getId());
		oth.setDataType("1");
		oth.setLedType("2");
		oth.setRemark("其它");
		oth.setCountdata(other);
		oth.setCreateTime(System.currentTimeMillis());
		lEDCountDataMapper.insertSelective(oth);
		return list;
	}

	@Override
	public Result vehicleType() {
		Result rs = Result.getSuccessResult();
		LEDCountData query = new LEDCountData();
		query.setLedType("3");
		query.setDataType("1");
		List<LEDCountData> list = lEDCountDataMapper.selectByCondition(query);
		countVehicleType();
		for(LEDCountData del: list){
			lEDCountDataMapper.deleteByPrimaryKey(del.getId());
		}
		return rs;
	}
	
	protected void countVehicleType() {
		LEDCount query = new LEDCount();
		query.setPageNo(0);
		query.setPageSize(4);
		List<LEDCount> list = lEDCountMapper.selectByVehicleType(query);
		Double a = lEDCountMapper.selectByCountVehicle(null);
		for(LEDCount db : list){
			LEDCountData oth = new LEDCountData();
			oth.setId(UUIDUtil.getId());
			oth.setDataType("1");
			oth.setLedType("3");
			oth.setRemark(db.getCountName());
			oth.setCountdata(db.getCountNum());
			oth.setCreateTime(System.currentTimeMillis());
			lEDCountDataMapper.insertSelective(oth);
			a = a - db.getCountNum();
		}
		LEDCountData oth = new LEDCountData();
		oth.setId(UUIDUtil.getId());
		oth.setDataType("1");
		oth.setLedType("3");
		oth.setRemark("其它");
		oth.setCountdata(a);
		oth.setCreateTime(System.currentTimeMillis());
		lEDCountDataMapper.insertSelective(oth);
	}

	@Override
	public Result vehicleAddress() {
		Result rs = Result.getSuccessResult();
		LEDCountData query = new LEDCountData();
		query.setLedType("4");//4-车辆归属地
		query.setDataType("1");
		List<LEDCountData> list = lEDCountDataMapper.selectByCondition(query);
		countvehicleAddress();
		for(LEDCountData del: list){
			lEDCountDataMapper.deleteByPrimaryKey(del.getId());
		}
		return rs;
	}
	
	protected void countvehicleAddress() {
		LEDCount query = new LEDCount();
		query.setPageNo(0);
		query.setPageSize(4);
		List<LEDCount> list = lEDCountMapper.selectByVehicleAddress(query);
		Double a = lEDCountMapper.selectByCountVehicle(null);
		for(LEDCount db : list){
			LEDCountData oth = new LEDCountData();
			oth.setId(UUIDUtil.getId());
			oth.setDataType("1");
			oth.setLedType("4");
			oth.setRemark(db.getCountName());
			oth.setCountdata(db.getCountNum());
			oth.setCreateTime(System.currentTimeMillis());
			lEDCountDataMapper.insertSelective(oth);
			a = a - db.getCountNum();
		}
		LEDCountData oth = new LEDCountData();
		oth.setId(UUIDUtil.getId());
		oth.setDataType("1");
		oth.setLedType("4");
		oth.setRemark("其它");
		oth.setCountdata(a);
		oth.setCreateTime(System.currentTimeMillis());
		lEDCountDataMapper.insertSelective(oth);
	}

	@Override
	public Result vehicleRate() {
		Result rs = Result.getSuccessResult();
		LEDCountData query = new LEDCountData();
		query.setLedType("5");//5-车辆使用频率
		query.setDataType("1");
		List<LEDCountData> list = lEDCountDataMapper.selectByCondition(query);
		for(LEDCountData del: list){
			lEDCountDataMapper.deleteByPrimaryKey(del.getId());
		}
		countvehicleRate();
		return rs;
	}
	
	protected void countvehicleRate() {
		Double sum = lEDCountMapper.selectByCountVehicle(null);
		LEDCount req = new LEDCount();
		req.setMin(1);
		req.setMax(10);
		sum = sum - saveCountVehicleRate(req,"2-10次");
		req.setMin(10);
		req.setMax(99);
		sum = sum - saveCountVehicleRate(req,"10-100次");
		req.setMin(100);
		req.setMax(200);
		sum = sum - saveCountVehicleRate(req,"100-200次");
		req.setMin(200);
		req.setMax(null);
		sum = sum - saveCountVehicleRate(req,"200次以上");
		LEDCountData oth = new LEDCountData();
		oth.setId(UUIDUtil.getId());
		oth.setDataType("1");
		oth.setLedType("5");
		oth.setRemark("其它");
		oth.setCountdata(sum);
		oth.setCreateTime(System.currentTimeMillis());
		lEDCountDataMapper.insertSelective(oth);
	}
	protected Double saveCountVehicleRate(LEDCount req,String remark){
		List<LEDCount> al = lEDCountMapper.selectByVehicleRateAl(req);
		List<LEDCount> dy = lEDCountMapper.selectByVehicleRateDy(req);
		for(LEDCount alcount : al){
			for (int i = 0; i < dy.size(); i++) {
				if(alcount.getCountName().equals(dy.get(i).getCountName())){
					dy.remove(i);
				}
			}
		}
		LEDCountData oth = new LEDCountData();
		oth.setId(UUIDUtil.getId());
		oth.setDataType("1");
		oth.setLedType("5");
		oth.setRemark(remark);
		oth.setCountdata((double) (al.size()+dy.size()));
		oth.setCreateTime(System.currentTimeMillis());
		lEDCountDataMapper.insertSelective(oth);
		return oth.getCountdata();
	}

	@Override
	public Result venderCount() {
		Result rs = Result.getSuccessResult();
		//7-车主
		LEDCountData query = new LEDCountData();
		query.setLedType("7");
		query.setDataType("1");
		List<LEDCountData> list = lEDCountDataMapper.selectByCondition(query);
		for(LEDCountData del : list){
			lEDCountDataMapper.deleteByPrimaryKey(del.getId());
		}
		saveVenderCount();
		return rs;
	}
	
	protected void saveVenderCount() {
		LEDCount count = new LEDCount();
		count.setPageNo(0);
		count.setPageSize(20);
		List<LEDCount> al = lEDCountMapper.selectByVenderAl(count);
		List<LEDCount> dy = lEDCountMapper.selectByVenderDy(count);
		for(LEDCount acou : al){
			String remark = getMemberVo(acou.getCountName());
			for (int i = 0; i < dy.size(); i++) {
				String dyName = getMemberVo(dy.get(i).getCountName());
				if(remark.equals(dyName)){
					acou.setCountNum(acou.getCountNum()+dy.get(i).getCountNum());
					dy.remove(i);
				}
			}
			LEDCountData save = new LEDCountData();
			save.setId(UUIDUtil.getId());
			save.setDataType("1");
			save.setLedType("7");
			save.setCountdata(acou.getCountNum());
			save.setRemark(remark);
			save.setStimestr(acou.getCountName());
			save.setCreateTime(System.currentTimeMillis());
			lEDCountDataMapper.insertSelective(save);
		}
		
		for(LEDCount acou : dy){
			String remark = getMemberVo(acou.getCountName());
			LEDCountData save = new LEDCountData();
			save.setId(UUIDUtil.getId());
			save.setDataType("1");
			save.setLedType("7");
			save.setCountdata(acou.getCountNum());
			save.setRemark(remark);
			save.setStimestr(acou.getCountName());
			save.setCreateTime(System.currentTimeMillis());
			lEDCountDataMapper.insertSelective(save);
		}
		
	}

	@Override
	public Result ownerCount() {
		// TODO Auto-generated method stub
		Result rs = Result.getSuccessResult();
		//7-车主
		LEDCountData query = new LEDCountData();
		query.setLedType("8");//8-货主
		query.setDataType("1");
		List<LEDCountData> list = lEDCountDataMapper.selectByCondition(query);
		for(LEDCountData del : list){
			lEDCountDataMapper.deleteByPrimaryKey(del.getId());
		}
		saveOwnerCount();
		return rs;
	}
	
	protected void saveOwnerCount() {
		LEDCount count = new LEDCount();
		count.setPageNo(0);
		count.setPageSize(20);
		List<LEDCount> al = lEDCountMapper.selectByOwnerAl(count);
		List<LEDCount> dy = lEDCountMapper.selectByOwnerDy(count);
		List<LEDCount> all = new ArrayList<LEDCount>();
		for(LEDCount acou : al){
			String remark = getMemberVo(acou.getCountName());
			acou.setRemark(remark);
			for (int i = 0; i < dy.size(); i++) {
				String fyName = getMemberVo(dy.get(i).getCountName());
				dy.get(i).setRemark(fyName);
				System.out.println(remark+",,"+fyName);
				if(remark.equals(fyName)){
					System.out.println(remark+"=="+fyName);
					acou.setCountNum(acou.getCountNum()+dy.get(i).getCountNum());
					dy.remove(i);
				}
			}
			all.add(acou);
		}
		for(LEDCount dyou : dy){
			all.add(dyou);
		}
		System.out.println("剩余数据---"+dy.size());
		for(LEDCount dex : all){
			LEDCountData save = new LEDCountData();
			save.setId(UUIDUtil.getId());
			save.setDataType("1");
			save.setLedType("8");
			save.setCountdata(dex.getCountNum());
			save.setRemark(dex.getRemark());
			save.setStimestr(dex.getCountName());
			save.setCreateTime(System.currentTimeMillis());
			lEDCountDataMapper.insertSelective(save);
		}
	}
	
	protected String  getMemberVo(String id) {
		MemberVo vo = memberVoService.get(id);
		String remark = "";
		if(vo!=null){
			if(StringUtils.isNotBlank(vo.getUserName())){
				remark = vo.getUserName();
			}else if(StringUtils.isNotBlank(vo.getCompanyName())){
				remark = vo.getCompanyName();
			}
		}
		return remark;
	}
}