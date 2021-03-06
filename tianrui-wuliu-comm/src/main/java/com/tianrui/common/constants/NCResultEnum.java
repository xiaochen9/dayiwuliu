package com.tianrui.common.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum NCResultEnum {
	

	NC_RESULT_ENUM_1("E001","供应商不存在."),
	NC_RESULT_ENUM_2("E002","供应商还未审核."),
	NC_RESULT_ENUM_3("E003","供应商审核未通过."),
	NC_RESULT_ENUM_4("E004","供应商审核进行中."),
	NC_RESULT_ENUM_5("E005","审核通过，但组织未分配."),
	NC_RESULT_ENUM_6("E006","审核通过，且组织已分配."),
	NC_RESULT_ENUM_11("E011","支付成功."),
	NC_RESULT_ENUM_12("E012","支付中…"),
	NC_RESULT_ENUM_13("E013","支付失败.");
	
	private String code;
	private String msg;
	private static Map<String, String> enumMap = new HashMap<String, String>();
	
	static {
		for (NCResultEnum e : NCResultEnum.values()) {
			enumMap.put(e.code, e.msg);
		}
		enumMap = Collections.unmodifiableMap(enumMap);
	}
	
	private NCResultEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static String getMessage(String code) {
		return enumMap.get(code);
	}
	
}