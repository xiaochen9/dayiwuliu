package com.tianrui.api.req.admin;

import com.tianrui.api.req.BaseReq;

/**
 * 
 * @类描述：我的车辆
 * @创建人：lsj
 * @创建时间：2016年6月4日上午9:56:17
 *
 * @修改人：lsj
 * @修改时间：2016年6月4日上午9:56:17
 * @修改备注：
 *
 */
public class MyVehicleReq extends BaseReq{

	private String id;
	/**
	 * 车牌号前缀
	 */
	private String vehicleprefix;
	/**
	 * 车牌号
	 */
	private String vehicleno;
	/**
	 * 车主姓名
	 */
	private String userName;
	/**
	 * 车主电话
	 */
	private String telphone;
	/**
	 * 车辆类型 1：箱式	2：车板3：冷藏
	 */
	private String vehicletype;
	/**
	 * 可用长度
	 */
	private Double weight;
	/**
	 * 可用载重（吨）
	 */
	private Double length;
	/**
	 * 1:已认证  0:未认证 
	 */
	private Byte verified;
	/**
	 * 认证时间
	 */
	private Long createtime;
	
	private Integer limit;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getLimit() {
		limit = (pageNo-1)*pageSize;
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getVehicleprefix() {
		return vehicleprefix;
	}
	public void setVehicleprefix(String vehicleprefix) {
		this.vehicleprefix = vehicleprefix;
	}
	public String getVehicleno() {
		return vehicleno;
	}
	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Byte getVerified() {
		return verified;
	}
	public void setVerified(Byte verified) {
		this.verified = verified;
	}
	public Long getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}
}
