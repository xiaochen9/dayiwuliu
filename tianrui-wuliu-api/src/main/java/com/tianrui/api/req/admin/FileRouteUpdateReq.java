package com.tianrui.api.req.admin;

import com.tianrui.api.req.BaseReq;

public class FileRouteUpdateReq extends BaseReq{


	private static final long serialVersionUID = -7190183760043617974L;
	
	private String id;
	private String routename;

	private String opositionid;
	private String oaddr;
	private String dpositionid;
	private String daddr;
	
	private String receiveid;

	private String sendpersion;
	private String sendpersionphone;
	private String receivepersion;
	private String receivepersionphone;

	private String distanceStr;

	// 当前登录用户组织id
	private String currOrgId;
	// 当前登录用户
	private String currUser;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoutename() {
		return routename;
	}
	public void setRoutename(String routename) {
		this.routename = routename;
	}
	public String getOpositionid() {
		return opositionid;
	}
	public String getReceiveid() {
		return receiveid;
	}
	public void setReceiveid(String receiveid) {
		this.receiveid = receiveid;
	}
	public void setOpositionid(String opositionid) {
		this.opositionid = opositionid;
	}
	public String getOaddr() {
		return oaddr;
	}
	public void setOaddr(String oaddr) {
		this.oaddr = oaddr;
	}
	public String getDpositionid() {
		return dpositionid;
	}
	public void setDpositionid(String dpositionid) {
		this.dpositionid = dpositionid;
	}
	public String getDaddr() {
		return daddr;
	}
	public void setDaddr(String daddr) {
		this.daddr = daddr;
	}
	public String getSendpersion() {
		return sendpersion;
	}
	public void setSendpersion(String sendpersion) {
		this.sendpersion = sendpersion;
	}
	public String getSendpersionphone() {
		return sendpersionphone;
	}
	public void setSendpersionphone(String sendpersionphone) {
		this.sendpersionphone = sendpersionphone;
	}
	public String getReceivepersion() {
		return receivepersion;
	}
	public void setReceivepersion(String receivepersion) {
		this.receivepersion = receivepersion;
	}
	public String getReceivepersionphone() {
		return receivepersionphone;
	}
	public void setReceivepersionphone(String receivepersionphone) {
		this.receivepersionphone = receivepersionphone;
	}

	public String getDistanceStr() {
		return distanceStr;
	}
	public void setDistanceStr(String distanceStr) {
		this.distanceStr = distanceStr;
	}
	public String getCurrOrgId() {
		return currOrgId;
	}
	public void setCurrOrgId(String currOrgId) {
		this.currOrgId = currOrgId;
	}
	public String getCurrUser() {
		return currUser;
	}
	public void setCurrUser(String currUser) {
		this.currUser = currUser;
	}
	
	
	

    
}
