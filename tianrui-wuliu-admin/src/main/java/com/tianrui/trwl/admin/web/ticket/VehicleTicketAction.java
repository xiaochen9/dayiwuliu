package com.tianrui.trwl.admin.web.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.api.intf.IVehicleTicketService;
import com.tianrui.api.req.front.vehicle.TicketFindReq;
import com.tianrui.api.req.front.vehicle.VehicleTicketReq;
import com.tianrui.api.resp.front.vehicle.VehicleTicketResp;
import com.tianrui.common.vo.PaginationVO;
import com.tianrui.common.vo.Result;

@Controller
@RequestMapping("/admin/ticket")
public class VehicleTicketAction {

	@Autowired
	IVehicleTicketService vehicleTicketService;
	
	@RequestMapping("vehicleticket")
	public ModelAndView vehicleticket(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/adminMember/vehicle/ticket");
		return view;
	}
	
	/** 车辆开票认证列表查询
	 * @throws Exception */
	@RequestMapping(value="page",method=RequestMethod.POST)
	@ResponseBody
	public Result page(TicketFindReq req) throws Exception{
		Result rs = Result.getSuccessResult();
		PaginationVO<VehicleTicketResp> page = vehicleTicketService.page(req);
		rs.setData(page);
		return rs;
	}
	/*** 后台完善车辆开票信息
	 * @throws Exception */
	@RequestMapping(value="save",method=RequestMethod.POST)
	@ResponseBody
	public Result save(VehicleTicketReq req) throws Exception{
		Result rs = Result.getSuccessResult();
		rs = vehicleTicketService.save(req);
		return rs;
	}
	/** 查询开票车辆信息*/
	@RequestMapping(value="findVehicleId",method=RequestMethod.POST)
	@ResponseBody
	public Result findVehicleId(TicketFindReq req) throws Exception{
		Result rs = Result.getSuccessResult();
		rs = vehicleTicketService.findByVehicleId(req);
		return rs;
	}
	
	/***开票车辆审核
	 * @throws Exception 
	 */
	@RequestMapping(value="shenhe",method=RequestMethod.POST)
	@ResponseBody
	public Result shenhe(VehicleTicketReq req) throws Exception {
		Result rs = Result.getSuccessResult();
		rs = vehicleTicketService.shenhe(req);
		return rs;
	}
	/**
	 * 车辆开票认证强制通过
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="ticketSuccess",method=RequestMethod.POST)
	@ResponseBody
	public Result ticketSuccess(String id) throws Exception{
		Result rs = Result.getSuccessResult();
		rs = vehicleTicketService.ticketSuccess(id);
		return rs;
	}
}
