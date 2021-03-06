package com.tianrui.trwl.admin.web.member;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tianrui.api.intf.memberMerger.IMemberMergerService;
import com.tianrui.api.req.memberMerger.MergerCellphoneReq;
import com.tianrui.api.req.memberMerger.MergerQueryReq;
import com.tianrui.api.resp.admin.PageResp;
import com.tianrui.api.resp.front.member.MemberResp;
import com.tianrui.common.constants.Constant;
import com.tianrui.common.vo.Result;

/**
 * 会员合并
 * @author xcy
 *
 */
@Controller
@RequestMapping("memberUser")
public class MemberUserAction {
	
	@Autowired
	private IMemberMergerService memberMergeService;

	/**
	 * 跳转到会员合并的主页面
	 * @author xcy
	 * @return
	 */
	@RequestMapping("merger")
	public ModelAndView page(){
		ModelAndView view = new ModelAndView();
		view.setViewName("/system/memberMerge");
		return view;
	}
	/**
	 * 根据身份证号查询用户信息
	 * @author xcy
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("findMemberInfo")
	@ResponseBody
	public Result findIdcard(MergerQueryReq req) throws Exception{
		Result rsult = Result.getSuccessResult();
		PageResp<MemberResp> resp = memberMergeService.selectMergerCellhpone(req);
		rsult.setData(resp);		
		return rsult;
	}
	
	/**
	 * 设置主账号合并会员
	 * @author xcy
	 * @param req
	 * @return
	 */
	@RequestMapping("setMergerMember")
	@ResponseBody
	public Result setMergerMember(MergerCellphoneReq req){
		Result result = memberMergeService.mergerCellphone(req);
		return result;
	}
	
	/**
	 * 用户合并详情 1: 注册用户的类 2:司机管理类
	 * @author xcy
	 * @param req
	 * @param cellPhone
	 * @param type
	 * @return
	 */
	@RequestMapping("detailPage")
	public ModelAndView detailPage(HttpServletRequest req,String cellPhone,String type){
		ModelAndView view = new ModelAndView();
		view.addObject("cellPhone", cellPhone);
		if(type.equals(Constant.ONE_STR)){
			view.setViewName("/system/personDetail");
		}else{
			view.setViewName("/system/driverDetail");
		}
		return view;
	}
}
