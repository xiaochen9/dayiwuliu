package com.tianrui.api.money.intf;

import java.lang.reflect.InvocationTargetException;

import com.tianrui.api.req.money.SaveWithdrawReq;
import com.tianrui.api.req.money.updateWithdrawReq;
import com.tianrui.common.vo.Result;

public interface IWithdrawRecordService {
	/**
	 * 保存提现申请
	 * @param req
	 * @return
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	Result save(SaveWithdrawReq req) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
	
	/**
	 * 提现结果反馈
	 * @param req
	 * @return
	 */
	Result update(updateWithdrawReq req);

}