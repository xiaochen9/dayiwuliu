package com.tianrui.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.tianrui.api.admin.intf.IAnlianService;
import com.tianrui.api.intf.IAnlianBillService;
import com.tianrui.api.intf.ICargoPlanService;
import com.tianrui.api.intf.ICrossVehicleService;
import com.tianrui.api.intf.IMemberVoService;
import com.tianrui.api.req.admin.ZJXLVehicleReq;
import com.tianrui.api.req.admin.anlian.AnlianShipmentReq;
import com.tianrui.api.req.admin.anlian.LinesReq;
import com.tianrui.api.req.admin.anlian.OrdersReq;
import com.tianrui.api.req.front.bill.AnlianBillFindReq;
import com.tianrui.api.req.front.bill.AnlianBillSaveReq;
import com.tianrui.api.req.front.bill.AnlianBillSignerReq;
import com.tianrui.api.req.front.bill.AnlianBillUpdateReq;
import com.tianrui.api.req.front.bill.BillBankReq;
import com.tianrui.api.req.front.cargoplan.PlanConfirmReq;
import com.tianrui.api.req.front.message.SendMsgReq;
import com.tianrui.api.resp.admin.PageResp;
import com.tianrui.api.resp.admin.ZJXLVehicleResp;
import com.tianrui.api.resp.front.bill.AnlianBillResp;
import com.tianrui.api.resp.front.cargoplan.PlanRouteResp;
import com.tianrui.common.constants.Constant;
import com.tianrui.common.enums.MessageCodeEnum;
import com.tianrui.common.utils.UUIDUtil;
import com.tianrui.common.vo.MemberVo;
import com.tianrui.common.vo.PaginationVO;
import com.tianrui.common.vo.Result;
import com.tianrui.service.admin.bean.FileCargo;
import com.tianrui.service.admin.bean.FileOrgCargo;
import com.tianrui.service.admin.bean.FilePositoin;
import com.tianrui.service.admin.bean.FileRoute;
import com.tianrui.service.admin.bean.Merchant;
import com.tianrui.service.admin.mapper.FileCargoMapper;
import com.tianrui.service.admin.mapper.FileOrgCargoMapper;
import com.tianrui.service.admin.mapper.FilePositoinMapper;
import com.tianrui.service.admin.mapper.FileRouteMapper;
import com.tianrui.service.admin.mapper.MerchantMapper;
import com.tianrui.service.bean.AddVehicleBankCard;
import com.tianrui.service.bean.AnlianDict;
import com.tianrui.service.bean.Bill;
import com.tianrui.service.bean.BillAnlianPosition;
import com.tianrui.service.bean.MemberBankCard;
import com.tianrui.service.bean.MemberVehicle;
import com.tianrui.service.bean.Plan;
import com.tianrui.service.bean.SystemMember;
import com.tianrui.service.bean.VehicleDriver;
import com.tianrui.service.bean.VehicleGpsZjxl;
import com.tianrui.service.bean.anlian.AnlianBill;
import com.tianrui.service.mapper.AddVehicleBankCardMapper;
import com.tianrui.service.mapper.AnlianBillMapper;
import com.tianrui.service.mapper.AnlianDictMapper;
import com.tianrui.service.mapper.MemberBankCardMapper;
import com.tianrui.service.mapper.MemberVehicleMapper;
import com.tianrui.service.mapper.PlanMapper;
import com.tianrui.service.mapper.SystemMemberInfoMapper;
import com.tianrui.service.mapper.SystemMemberMapper;
import com.tianrui.service.mapper.VehicleDriverMapper;
import com.tianrui.service.mapper.VehicleTicketMapper;
import com.tianrui.service.mongo.BillAnlianPositionDao;
import com.tianrui.service.mongo.VehicleGpsZjxlDao;
import com.tianrui.service.util.TimeUtils;
@Service
public class AnlianBillService implements IAnlianBillService{

	private static Logger loger =LoggerFactory.getLogger(AnlianBillService.class);
	@Autowired
	PlanMapper planMapper;
	@Autowired
	FileRouteMapper routeMapper;
	@Autowired
	FilePositoinMapper positionMapper;
	@Autowired
	MemberVehicleMapper memberVehicleMapper;
	@Autowired
	VehicleTicketMapper vehicleTicketMapper;
	@Autowired
	SystemMemberMapper systemMemberMapper;
	@Autowired
	SystemMemberInfoMapper systemMemberInfoMapper;
	@Autowired
	AnlianDictMapper anlianDictMapper;
	@Autowired
	FileCargoMapper fileCargoMapper;
	@Autowired
	FileOrgCargoMapper fileOrgCargoMapper;
	@Autowired
	IAnlianService anlianService;
	@Autowired
	VehicleDriverMapper vehicleDriverMapper;
	@Autowired
	AnlianBillMapper anlianBillMapper;
	@Autowired
	BillAnlianPositionDao billAnlianPositionDao;
	@Autowired
	MerchantMapper merchantMapper;
	@Autowired
	protected ICargoPlanService cargoPlanService;
	@Autowired
	IMemberVoService MemberVoService;
	@Autowired
	MessageService messageService;
	@Autowired
	VehicleGpsZjxlDao vehicleGpsZjxlDao;
	@Autowired
	ICrossVehicleService crossVehicleService;
	@Autowired
	MemberBankCardMapper memberBankCardMapper;
	@Autowired
	AddVehicleBankCardMapper addVehicleBankCardMapper;
	
	@Override
	public Result uptBankCard(BillBankReq req) throws Exception {
		// TODO Auto-generated method stub
		Result rs = Result.getSuccessResult();
		AnlianBill bill = anlianBillMapper.selectByPrimaryKey(req.getBillId());
		MemberBankCard bank = memberBankCardMapper.selectByPrimaryKey(req.getBankId());
		if(bill==null||bank==null){
			rs.setCode("1");
			rs.setError("运单id或银行卡id有误");
			return rs;
		}
		if("1".equals(bill.getConfirmPriceA())){
			rs.setCode("1");
			rs.setError("已运价确认运单，不能更换银行卡");
			return rs;
		}
		if(bill.getPayment().equals("2")){
			//支付对象车主
			rs.setCode("1");
			rs.setError("支付对象为车主，不能更换银行卡");
			return rs;
		}
		if(!bill.getDriverid().equals(req.getDriverId())){
			rs.setCode("1");
			rs.setError("非该司机运单，不能更换银行卡");
			return rs;
		}
		String bankType = "1";//1-默认银行卡，2-引用银行卡
		if(req.getBankType().equals("0")){
			//引用银行卡
			bankType = "2";
			AddVehicleBankCard add = new AddVehicleBankCard();
			add.setDriverid(req.getDriverId());
			add.setVehicleownerid(bank.getCreater());
			List<AddVehicleBankCard> adlist = addVehicleBankCardMapper.selectByCondition(add);
			if(adlist.size()!=1){
				rs.setCode("2");
				rs.setError("司机暂未引用该银行卡");
				return rs;
			}
		}else{
			bankType = "1";
			//添加银行卡
			if(!bank.getCreater().equals(req.getDriverId())){
				rs.setCode("3");
				rs.setError("非该司机银行卡");
				return rs;
			}
		}
		AnlianBill upt = new AnlianBill();
		upt.setId(req.getBillId());
		upt.setBankId(bank.getId());
		upt.setBankType(bankType);
		upt.setBankCard(bank.getBankcard());
		upt.setBankOwnerName(bank.getIdname());
		upt.setBankOwnerPhone(bank.getTelphone());
		anlianBillMapper.updateByPrimaryKeySelective(upt);
		return rs;
	}
	
	@Override
	public Result alBillSave(AnlianBillSaveReq req) throws Exception {
		Result rs = Result.getSuccessResult();
		Plan plan = planMapper.selectByPrimaryKey(req.getPlanid());
		FileRoute route = routeMapper.selectByPrimaryKey(plan.getRouteid());
		//始发地id FilePositoin 取 oc
		FilePositoin sfd = positionMapper.selectByPrimaryKey(route.getOpositionid());
		//目的地id FilePositoin 取 oc
		FilePositoin mdd = positionMapper.selectByPrimaryKey(route.getDpositionid());
//		//车辆司机关系表
//		VehicleDriver vd = vehicleDriverMapper.selectByPrimaryKey(req.getVehicleDrvierid());
		//车辆信息
		MemberVehicle vehicle = memberVehicleMapper.selectByPrimaryKey(req.getVehicleid());
		//司机信息
		SystemMember member = systemMemberMapper.selectByPrimaryKey(req.getDriverid());
		
		//++++++++++++++++++++++++++++++
		//拼装安联所需数据
		AnlianShipmentReq shipment = new AnlianShipmentReq();
		//车牌号
		shipment.setCph(vehicle.getVehicleprefix()+vehicle.getVehicleno());
		//安联司机会员号
		shipment.setSj(member.getAldriverid());
		//运单总质量
		shipment.setZzl(req.getWeight());
		//总体积
		shipment.setZtj(req.getVolume());
		//总数量
		shipment.setZsl(req.getSize());
		
		Double siz = Double.valueOf(req.getSize());
		Double pric = Double.valueOf(req.getPrice());
		Double yf = siz*pric;
		//运费
		shipment.setYf(String.valueOf(yf));
		//计费方式 10-重量 20-体积 默认按重量计算
		if(StringUtils.equals("吨", req.getDesc1())){
			shipment.setJffs("10");
		}else if(StringUtils.equals("立方米", req.getDesc1())){
			shipment.setJffs("20");
		}
		//始发地
		shipment.setQycs(sfd.getOc());
		//目的城市
		shipment.setMdcs(mdd.getOc());
		//距离
		shipment.setLc(route.getDistance().toString());
		//要求提货日期
		shipment.setYqthrq(req.getBillStartTime());
		//要求到货日期
		shipment.setYqdhrq(req.getBillEndTime());
		String uu = UUIDUtil.getId();
		shipment.setPzdh(uu.substring(0, 6));
		
		Merchant mchant = merchantMapper.selectByPrimaryKey(plan.getShipperMerchant());
		
		OrdersReq order = new OrdersReq();
		// 客户代码
		if(mchant!=null){
			order.setKhdm(mchant.getCode());
		}
		//提货地址
		order.setThdz(plan.getStartcity());
		//收货地址
		order.setShdz(plan.getEndcity());
		//收货人
		order.setShr(plan.getReceiveperson());
		//联系手机
		order.setLxsj(plan.getReceivepersonphone());
		//加急 Y- 加急 N-不加急
		order.setJj("Y");
		
		order.setDdh(uu.substring(5,12));
		LinesReq lines = new LinesReq();
		//货品名称
		lines.setHpmc(plan.getCargoname());
		//数量
		lines.setSl(req.getWeight());
		//单位
		lines.setDw(req.getDesc1());
		
		FileOrgCargo orgcargo = fileOrgCargoMapper.selectByPrimaryKey(plan.getCargoid());
		FileCargo cargo = fileCargoMapper.selectByPrimaryKey(orgcargo.getCargoid());
		AnlianDict record = new AnlianDict();
		record.setType("cargo");
		record.setWlname(cargo.getCargotype());
		List<AnlianDict> list = anlianDictMapper.selectByCondition(record);
		if(list.size()==1){
			//货品属性
			lines.setHpsx(list.get(0).getAlcode());
		}
		List<OrdersReq> ol = new ArrayList<OrdersReq>();
		ol.add(order);
		List<LinesReq> ll = new ArrayList<LinesReq>();
		ll.add(lines);
		
		order.setLines(ll);
		shipment.setOrders(ol);
		rs = anlianService.shipment(shipment);
		if(rs.getCode().equals("000000")){
			anlianBillInsert(shipment,rs.getData().toString(),req);
		}
//		anlianBillInsert(shipment,"CS0000000",req);
		return rs;
	}
	/** 运单本地保存
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException */
	public void anlianBillInsert(AnlianShipmentReq shipment,String billNo,AnlianBillSaveReq req) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		AnlianBill bill = new AnlianBill();
		bill.setId(UUIDUtil.getId());
		bill.setBillno(billNo);
		bill.setDriverid(req.getDriverid());
		bill.setOwnerid(req.getOwnerid());
		bill.setVenderid(req.getVenderid());
		bill.setDesc1(req.getPlanid());
		bill.setPayment(req.getPayment());
		bill.setReceive_memberid(req.getReceive_memberid());
		PropertyUtils.copyProperties(bill, shipment);
		List<OrdersReq> lo = shipment.getOrders();
		for(OrdersReq r : lo){
			PropertyUtils.copyProperties(bill, r);
			List<LinesReq> l = r.getLines();
			for(LinesReq v : l){
				PropertyUtils.copyProperties(bill, v);
			}
		}
		bill.setBankCard(req.getBankCard());
		bill.setBankId(req.getBankId());
		bill.setBankOwnerName(req.getBankOwnerName());
		bill.setBankOwnerPhone(req.getBankOwnerPhone());
		bill.setBankType(req.getBankType());
		bill.setCreatetime(System.currentTimeMillis());
		anlianBillMapper.insert(bill);
	}
	@Override
	public PaginationVO<AnlianBillResp> find(AnlianBillFindReq req) throws Exception {
		PaginationVO<AnlianBillResp> pv = new PaginationVO<AnlianBillResp>();
		AnlianBill bill = new AnlianBill();
		PropertyUtils.copyProperties(bill, req);
		bill.setShhr(req.getShr());
		if(req.getPageNo()!=null){
			bill.setStart(req.getPageNo()*req.getPageSize());
			bill.setLimit(req.getPageSize());
			pv.setPageNo(req.getPageNo());
			pv.setPageSize(req.getPageSize());
		}
		List<AnlianBill> list = anlianBillMapper.selectByCondition(bill);
		long a = anlianBillMapper.selectByCount(bill);
		List<AnlianBillResp> rs =copy(list);
		//道路名称
		setRouteNames(rs);
		pv.setList(rs);
		pv.setTotal(a);
		return pv;
	}
	@Override
	public List<AnlianBillResp> findAll(AnlianBillFindReq req) throws Exception {
		AnlianBill bill = new AnlianBill();
		PropertyUtils.copyProperties(bill, req);
		List<AnlianBill> list = anlianBillMapper.selectByCondition(bill);
		return copy(list);
	}

	@Override
	public Result findByid(AnlianBillFindReq req) throws Exception {
		Result rs = Result.getSuccessResult();
		AnlianBill bill = anlianBillMapper.selectByPrimaryKey(req.getId());
		//判断银行卡号是否为空
		if(bill!=null&&StringUtils.isEmpty(bill.getBankCard())){
			String creater = "";
			//1:司机  2:车主
			if(bill.getPayment().equals("1")){
				creater=bill.getDriverid();
			}else{
				creater=bill.getVenderid();
			}
			//获取默认的银行卡
			MemberBankCard bankCard = getBankCard(creater);
			if(bankCard!=null && StringUtils.isNotBlank(bankCard.getBankcard())){
				bill.setBankCard(bankCard.getBankcard());
				bill.setBankId(bankCard.getId());
				bill.setBankType("1");
				bill.setBankOwnerName(bankCard.getIdname() == null ? "":bankCard.getIdname());
				bill.setBankOwnerPhone(bankCard.getTelphone());
			}else{
				//设置空字符串
				bill.setBankCard("");
				bill.setBankOwnerName("");
			}
		}
		//车主
		SystemMember vender = systemMemberMapper.selectByPrimaryKey(bill.getVenderid());
		//司机
		SystemMember driver = systemMemberMapper.selectByPrimaryKey(bill.getDriverid());
		//货主
		SystemMember owner = systemMemberMapper.selectByPrimaryKey(bill.getOwnerid());
		//计划
		Plan plan = planMapper.selectByPrimaryKey(bill.getDesc1());
		
		AnlianBillResp resp = new AnlianBillResp();
		PropertyUtils.copyProperties(resp, bill);
		if(plan != null){
			resp.setPlanCode(plan.getPlancode());
		}
		resp.setOwnername(owner.getRemarkname());
		resp.setOwnertel(owner.getCellphone());
		
		resp.setVendername(vender.getRemarkname());
		resp.setVendertel(vender.getCellphone());
		
		resp.setDrivername(driver.getRemarkname());
		resp.setDrivertel(driver.getCellphone());
		resp.setAldriverid(driver.getAldriverid());
		
		resp.setStatus(bill.getDesc4());
		rs.setData(resp);
		return rs;
	}
	
	public List<AnlianBillResp> copy(List<AnlianBill> list) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		List<AnlianBillResp> r = new ArrayList<AnlianBillResp>();
		for(AnlianBill b :list){
			AnlianBillResp s = new AnlianBillResp();
			PropertyUtils.copyProperties(s, b);
			r.add(s);
		}
		return r;
	}
	
	@Override
	public Result findPositionOld(AnlianBillFindReq req) throws Exception {
		Result rs = Result.getSuccessResult();
		AnlianBill bill = anlianBillMapper.selectByPrimaryKey(req.getId());
		if(bill != null){
			//TODO
			//查询车辆是否有中交兴路地址
			ZJXLVehicleReq zjreq = new ZJXLVehicleReq();
			zjreq.setVehicleno(bill.getCph());
			zjreq.setVehiclelogo("1");
			zjreq.setCrossloge("1");
			PageResp<ZJXLVehicleResp> page = crossVehicleService.find(zjreq);
			List<ZJXLVehicleResp> zjlist = page.getList();
			List<BillAnlianPosition> resp = new ArrayList<BillAnlianPosition>();
			if(zjlist.size()==1){
				List<VehicleGpsZjxl> list = vehicleGpsZjxlDao.getVehicleTrack(bill.getCph(), bill.getPtBegintime(), bill.getPtEndtime());
				for(VehicleGpsZjxl zjxl : list){
					BillAnlianPosition post = new BillAnlianPosition();
					post.setCreatetime(zjxl.getUtc());
					post.setLat(zjxl.getLat().toString());
					post.setLng(zjxl.getLon().toString());
					post.setShipmentno(bill.getBillno());
					resp.add(post);
				}
			}else{
				resp = billAnlianPositionDao.findPosition(bill.getBillno());
			}
			rs.setData(resp);
		}else{
			rs.setCode("1");
			rs.setError("请输入正确id");
		}
		return rs;
	}
	
	@Override
	public Result zjfindPosition (AnlianBillFindReq req) throws Exception {
		Result rs = Result.getSuccessResult();
		AnlianBill bill = anlianBillMapper.selectByPrimaryKey(req.getId());
		if(bill != null && null != bill.getCph() ){
			long beginTime = bill.getCreatetime();
			long endTime = 0;
			if(null !=bill.getPtBegintime()){
				beginTime = bill.getPtBegintime();
			} 
			if ( null != bill.getPtEndtime()) {
				endTime = bill.getPtEndtime();
			}else {
				endTime = TimeUtils.getSpecifiedDay(beginTime, 2);
			}
				
			//查询车辆是否有中交兴路地址
			ZJXLVehicleReq zjreq = new ZJXLVehicleReq();
			zjreq.setVehicleno(bill.getCph());
//			zjreq.setVehiclelogo("1");
			zjreq.setCrossloge("1");
			PageResp<ZJXLVehicleResp> page = crossVehicleService.find(zjreq);
			List<ZJXLVehicleResp> zjlist = page.getList();
			List<BillAnlianPosition> resp = new ArrayList<BillAnlianPosition>();
			if(zjlist.size()==1){
				List<VehicleGpsZjxl> list = null;
				try {
					list = vehicleGpsZjxlDao.getVehicleTrack(bill.getCph(), beginTime, endTime);
				} catch (Exception e) {
					e.printStackTrace();
					loger.error(e.getMessage());
				}
				if(null != list && list.size() > 0){
					for(VehicleGpsZjxl zjxl : list){
						BillAnlianPosition post = new BillAnlianPosition();
						post.setCreatetime(zjxl.getUtc());
						post.setLat(zjxl.getLat().toString());
						post.setLng(zjxl.getLon().toString());
						post.setShipmentno(bill.getBillno());
						resp.add(post);
					}
				}
			}
			rs.setData(resp);
		}else{
			rs.setCode("1");
			rs.setError("数据路径异常或者车牌号不存在");
		}
		return rs;
	}
	@Override
	public Result dyfindPosition(AnlianBillFindReq req) throws Exception {
		Result rs = Result.getSuccessResult();
		AnlianBill bill = anlianBillMapper.selectByPrimaryKey(req.getId());
		if(bill != null){
			List<BillAnlianPosition> resp = new ArrayList<BillAnlianPosition>();
			resp = billAnlianPositionDao.findPosition(bill.getBillno());
			rs.setData(resp);
		}else{
			rs.setCode("1");
			rs.setError("请输入正确id");
		}
		return rs;
	}
	
	//开票运单增加路线名称
	private void setRouteNames(List<AnlianBillResp> list){
		if( CollectionUtils.isNotEmpty(list) ){
			List<String> planIds = new ArrayList<String>();
			//拼装计划id
			for(AnlianBillResp item :list ){
				if( StringUtils.isNotBlank(item.getDesc1()) ){
					planIds.add(item.getDesc1());
				}
			}
			//根据计划id查询路线信息
			if( CollectionUtils.isNotEmpty(planIds) ){
				List<PlanRouteResp> db =routeMapper.selectByPlanIds(planIds);
				if(CollectionUtils.isNotEmpty(db)  ){
					for(PlanRouteResp item  :db){
						for(AnlianBillResp item2:list ){
							if( StringUtils.isNotBlank(item2.getDesc1()) && StringUtils.equals(item2.getDesc1(), item.getPlanId()) ){
								item2.setRouteName(item.getRouteName());
							}
						}
					}
				}
			}
		}
	}
	@Override
	public Result update(AnlianBillUpdateReq req) throws Exception {
		Result rs = Result.getSuccessResult();
		AnlianBill record = new AnlianBill();
		record.setId(req.getId());
		record.setDesc3(req.getDesc3());
		record.setDesc4(req.getDesc4());
		if(req.getPtBegintime()!=null){
			record.setPtBegintime(req.getPtBegintime());
		}
		if(req.getPtEndtime()!=null){
			record.setPtEndtime(req.getPtEndtime());
		}
		anlianBillMapper.updateByPrimaryKeySelective(record);
		return rs;
	}
	@Override
	public Result billSigner(AnlianBillSignerReq req) throws Exception {
		Result rs = Result.getSuccessResult();
		AnlianBill bill = anlianBillMapper.selectByPrimaryKey(req.getId());
		if(bill.getTrueweight()!=null){
			rs.setCode("1");
			rs.setError("运单已被签收");
			return rs;
		}
		AnlianBill record = new AnlianBill();
		record.setId(req.getId());
		if(StringUtils.isNotBlank(req.getSignimgurl())){
			record.setSignimgurl(req.getSignimgurl());
		}
		if(StringUtils.isNotBlank(req.getPickupimgurl())){
			record.setPickupimgurl(req.getPickupimgurl());
		}
		record.setSignweight(req.getSignweight());
		record.setPickupweight(req.getPickupweight());
		record.setTrueweight(req.getTrueweight());
		record.setSigntime(System.currentTimeMillis());
		record.setConfirmPriceA("0");//前台未运价确认
		anlianBillMapper.updateByPrimaryKeySelective(record);
		
		Plan plan =planMapper.selectByPrimaryKey(bill.getDesc1());//desc1计划id
		Plan rootPlan = planMapper.selectRootPlanByPlanId(plan.getId());
		Plan planUpdate =new Plan();
		if(StringUtils.equals(plan.getIsAppoint(), "1")){
			planUpdate.setId(rootPlan.getId());
			if( rootPlan.getCompleted() !=null ){
				planUpdate.setCompleted(rootPlan.getCompleted()+Double.valueOf(req.getTrueweight()));
			}else{
				planUpdate.setCompleted(Double.valueOf(req.getTrueweight()));
			}
			//判断总计签收量 是否大于计划总量
			if(planUpdate.getCompleted() != null){
				if(planUpdate.getCompleted() >= rootPlan.getTotalplanned()){
					PlanConfirmReq planReq = new PlanConfirmReq();
					planReq.setId(rootPlan.getId());
					cargoPlanService.completePlan(planReq);
				}
			}
		}else{
			planUpdate.setId(plan.getId());
			if( plan.getCompleted() !=null ){
				planUpdate.setCompleted(plan.getCompleted()+Double.valueOf(req.getTrueweight()));
			}else{
				planUpdate.setCompleted(Double.valueOf(req.getTrueweight()));
			}
			//判断总计签收量 是否大于计划总量
			if(planUpdate.getCompleted() != null){
				if(planUpdate.getCompleted() >= plan.getTotalplanned()){
					PlanConfirmReq planReq = new PlanConfirmReq();
					planReq.setId(plan.getId());
					cargoPlanService.completePlan(planReq);
				}
			}
		}
		planMapper.updateByPrimaryKeySelective(planUpdate);
		//为车主发送站内信
//		MemberVo currUser =getMember(req.getCreater());
//		MemberVo receive =getMember(bill.getVenderid());
//		sendMsgInside(Arrays.asList(new String[]{bill.getBillno(),currUser.getCellphone()}), bill.getId(), currUser, receive, MessageCodeEnum.BILL_2VENDER_ALSIGN, "vender");
		return rs;
	}
	
	private void sendMsgInside(List<String> params,String kId,MemberVo sendUser,MemberVo receiveUser,MessageCodeEnum codeEnum,String type ){
		SendMsgReq req =new SendMsgReq();
		if( sendUser !=null && receiveUser !=null && codeEnum !=null ){
			req.setParams(params);
			req.setKeyid(kId);
			//发送人
			req.setSendid(sendUser.getId());
			req.setSendname(sendUser.getRealName());
			//接受人
			req.setRecid(receiveUser.getId());
			req.setRecname(receiveUser.getRealName());
			req.setCodeEnum(codeEnum);
			req.setRecType(codeEnum.getType());
			//消息类别  系统 还是会员
			req.setType("2");
			//详情URI
			String uri ="";
			switch (type) {
				case "driver":
					uri ="/trwuliu/billdriver/detail?id="+kId;
					break;
				case "owner":
					uri ="/trwuliu/billowner/detail?id="+kId;
					break;
				case "vender":
					uri ="/trwuliu/billvender/detail?id="+kId;
					break;
			}
			req.setURI(uri);
			try {
				messageService.sendMessageInside(req);
			} catch (Exception e) {
				loger.warn("站内信发送失败,发送信息:{}",JSON.toJSON(req),e);
			}
		}
	}
	
	private MemberVo getMember(String id){
		MemberVo member =MemberVoService.get(id);
		return member;
	}
	
	/** 获取用户默认银行卡*/
	protected MemberBankCard getBankCard(String creater) {
		MemberBankCard card = null;
		MemberBankCard bank = new MemberBankCard();
		bank.setCreater(creater);
		bank.setBankstatus("1");
		bank.setBankautid("1");
		List<MemberBankCard> bankList = memberBankCardMapper.selectByCondition(bank);
		if(bankList.size()==1){
			card = new MemberBankCard();
			card = bankList.get(0);
		}
		return card;
	}
}
