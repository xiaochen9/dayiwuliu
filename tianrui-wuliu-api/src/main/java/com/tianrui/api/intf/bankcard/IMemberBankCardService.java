package com.tianrui.api.intf.bankcard;

import java.util.List;

import com.tianrui.api.req.bankcard.MemberBankCardReq;
import com.tianrui.api.resp.bankcard.MemberBankCardResp;
import com.tianrui.common.vo.PaginationVO;
import com.tianrui.common.vo.Result;

/** 我的银行卡*/
public interface IMemberBankCardService {
	
	//根据司机id查询车主列表
	List<MemberBankCardResp> findOwnerById(String id)throws Exception;
	/** 添加银行卡*/
	public Result insertBankCard(MemberBankCardReq req)throws Exception;
	/** 审核银行卡*/
	public Result autidBankCard(MemberBankCardReq req)throws Exception;
	/** 设置默认银行卡*/
	public Result defaulBankCard(MemberBankCardReq req)throws Exception;
	/** 重新认证*/
	public Result update(MemberBankCardReq req)throws Exception;
	/** 删除银行卡*/
	public Result deltBankCard(String id)throws Exception;
	/** 查询银行卡*/
	public PaginationVO<MemberBankCardResp> selectBankCard(MemberBankCardReq req)throws Exception;
	/** 查询银行卡详情*/
	public Result findBankCardById(String id)throws Exception;
	/** 查询银行卡支行详情*/
	public Result findBankSubbranch(String bankTypeId)throws Exception;
	/** 查询银行卡类别*/
	public Result findBankType()throws Exception;
	/** 查询银行卡联行号*/
	public Result findBankNum(String id)throws Exception;
	/** 查询银行卡唯一*/
	public Result findBankOnly(String memberid,String code)throws Exception;
	/** 根据银行名称查询银行 */
	Result selectBankTypeByName(String name);
	/** 定时查询未推送的银行卡并进行推送 */
	void pushBankCardAndCallBackPushStatus();
	/** 根据名称LIKE模糊查询银行支行信息 */
	public Result findBankSubbranchLike(String desc1);
	/**
	 * @annotation 查询审核通过的所有银行卡
	 * @param req
	 * @return
	 */
	public Result findAuditBankCard(MemberBankCardReq req);
	
//	public Result insertBankAddress(JSONArray array)throws Exception;
//	
//	public Result insertBankType(JSONArray array)throws Exception;
}
