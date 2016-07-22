package com.tianrui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianrui.api.intf.ICargoPlanTemplateService;
import com.tianrui.api.req.front.cargoplan.PlanTemplateReq;
import com.tianrui.api.resp.front.cargoplan.PlanResp;
import com.tianrui.common.constants.ErrorCode;
import com.tianrui.common.vo.MemberVo;
import com.tianrui.common.vo.Result;
import com.tianrui.service.bean.Plan;
import com.tianrui.service.mongo.PlanTemplateDao;
@Service
public class CargoPlanTemplateService implements ICargoPlanTemplateService{

	private static Logger loger =LoggerFactory.getLogger(CargoPlanTemplateService.class);
	@Autowired
	PlanTemplateDao planTemplateDao;
	@Autowired
	MemberVoService memberVoService;

	@Override
	public List<PlanResp> findPlanTemplat(PlanTemplateReq req) {
		List<PlanResp> list =null;
		if( req !=null && StringUtils.isNotBlank(req.getCurruId()) ){
			try {
				list=copyProperties(planTemplateDao.findWithuId(req.getCurruId()));
			} catch (Exception e) {
				loger.error(e.getMessage(),e);
			}
		}
		return list;
	}

	@Override
	public PlanResp findOne(PlanTemplateReq req) {
		PlanResp resp =null;
		if( req !=null && StringUtils.isNotBlank(req.getId())){
			try {
				resp=copyPropertie(planTemplateDao.findOne(req.getId()));
			} catch (Exception e) {
				loger.error(e.getMessage(),e);
			}
		}
		return resp;
	}

	@Override
	public Result delTemplat(PlanTemplateReq req) {
		Result resp =Result.getSuccessResult();
		if( req !=null && StringUtils.isNotBlank(req.getId())){
			try {
				planTemplateDao.remove(req.getId());;
			} catch (Exception e) {
				loger.error(e.getMessage(),e);
			}
		}else{
			resp.setErrorCode(ErrorCode.PARAM_NULL_ERROR);
		}
		return resp;
	}
	private List<PlanResp> copyProperties(List<Plan> list) throws Exception{
		List<PlanResp> la = new ArrayList<PlanResp>();
		for(Plan p : list){
			PlanResp re =copyPropertie(p);
			la.add(re);
		}
		return la;
	}
	
	private PlanResp copyPropertie(Plan plan)throws Exception{
		PlanResp resp =null;
		if( plan !=null ){
			resp = new PlanResp();
			if( StringUtils.isNotBlank(resp.getCreator())  ){
				MemberVo owner =memberVoService.get(resp.getCreator());
				resp.setOwnerName(owner.getRealName());
			}
			PropertyUtils.copyProperties(resp, plan);
		}
		return resp;
	}
	
}
