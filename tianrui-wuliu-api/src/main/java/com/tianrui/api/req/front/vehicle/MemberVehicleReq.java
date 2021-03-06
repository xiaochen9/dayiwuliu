package com.tianrui.api.req.front.vehicle;

import com.tianrui.api.req.BaseReq;

/**
 * 我的车辆对应请求类
 * <p>
 * @author guyuke
 * @time 2016年6月2日 上午9:07:42
 */
public class MemberVehicleReq extends BaseReq{

	private static final long serialVersionUID = -7190183760043617974L;
	
	/** 主键 */
	private String id;
	/** 用户主键 */
	private String memberId;
	private String registcode;
	private String registimage;
	private String opercode;
	private String operimage;
	
	private String drivingTime;
	
	private String identitycode;
	private String identieyimage;
	private String agreeimage;
	private String roadtransportcode;
	private String roadtransportimage;
	
	/** 车辆主键*/
	private String vehicleId;
	/** 车牌号前缀 */
	private String vehiclePrefix;
	/** 车牌号 */
	private String vehicleNo;
	/** 车辆类型(1:箱式,2:车板,3:冷藏,4:散装罐车,5:半挂车) */
	private String vehicleType;
	/** 车辆类型名称 */
	private String vehicleTypeName;
	/**车辆所有人电话*/
	private String vehiOwnerTel;
	/**车辆所有人姓名*/
	private String vehiOwnerName;
	/** 车辆长度(米) */
	private String vehiLength;
	/** 车辆宽度(米) */
	private String vehiWidth;
	/** 车辆高度(米) */
	private String vehiHeight;
	/** 车辆重量(吨) */
	private String vehiWeight;
	/** 行驶证照片路径 */
	private String vehiLicenseImgPath;
	/** 车头照片路径 */
	private String vehiHeadImgPath;
	/** 车辆状态(-1:认证失败,0:未认证,1:认证成功,2:认证中) */
	private String status;
	/** 车辆运单状态(2-发货中3-运货中4-卸货中5-空闲中)*/
	private String billstatus;
	/** 认证失败原因 */
	private String memo;
	/** 创建人 */
	private String creator;
	/** 创建时间 */
	private Long createTime;
	/** 修改人 */
	private String modifier;
	/** 修改时间 */
	private Long modifyTime;
	/** 审核时间*/
	private Long audittime;
	/** 临时车辆-1； 认证车辆-2*/
	private String desc2;
	/** 经营许可证有效期*/
	private String desc3;
	
	/**
	 * 获取主键
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置主键
	 * @param newId
	 */
	public void setId(String newId) {
		this.id = newId;
	}

	public String getBillstatus() {
		return billstatus;
	}

	public void setBillstatus(String billstatus) {
		this.billstatus = billstatus;
	}

	/**
	 * 获取用户主键
	 * @return memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	public String getRegistcode() {
		return registcode;
	}

	public void setRegistcode(String registcode) {
		this.registcode = registcode;
	}

	public String getRegistimage() {
		return registimage;
	}

	public String getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

	public void setRegistimage(String registimage) {
		this.registimage = registimage;
	}

	public String getOpercode() {
		return opercode;
	}

	public void setOpercode(String opercode) {
		this.opercode = opercode;
	}

	public String getOperimage() {
		return operimage;
	}

	public void setOperimage(String operimage) {
		this.operimage = operimage;
	}

	public String getIdentitycode() {
		return identitycode;
	}

	public void setIdentitycode(String identitycode) {
		this.identitycode = identitycode;
	}

	public String getIdentieyimage() {
		return identieyimage;
	}

	public void setIdentieyimage(String identieyimage) {
		this.identieyimage = identieyimage;
	}

	public String getAgreeimage() {
		return agreeimage;
	}

	public void setAgreeimage(String agreeimage) {
		this.agreeimage = agreeimage;
	}

	public String getRoadtransportcode() {
		return roadtransportcode;
	}

	public void setRoadtransportcode(String roadtransportcode) {
		this.roadtransportcode = roadtransportcode;
	}

	public String getRoadtransportimage() {
		return roadtransportimage;
	}

	public void setRoadtransportimage(String roadtransportimage) {
		this.roadtransportimage = roadtransportimage;
	}

	/**
	 * 设置用户主键
	 * @param newMemberId
	 */
	public void setMemberId(String newMemberId) {
		this.memberId = newMemberId;
	}
	
	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getAudittime() {
		return audittime;
	}

	public void setAudittime(Long audittime) {
		this.audittime = audittime;
	}

	/**
	 * 获取车辆主键
	 * @return vehicleId
	 */
	public String getVehicleId() {
		return vehicleId;
	}

	/**
	 * 设置车辆主键
	 * @param newVehicleId
	 */
	public void setVehicleId(String newVehicleId) {
		this.vehicleId = newVehicleId;
	}

	/**
	 * 获取车牌号前缀
	 * @return vehiclePrefix
	 */
	public String getVehiclePrefix() {
		return vehiclePrefix;
	}

	/**
	 * 获取车牌号前缀
	 * @return newVehiclePrefix
	 */
	public void setVehiclePrefix(String newVehiclePrefix) {
		this.vehiclePrefix = newVehiclePrefix;
	}

	/**
	 * 获取车牌号
	 * @return vehicleNo
	 */
	public String getVehicleNo() {
		return vehicleNo;
	}

	/**
	 * 获取车牌号
	 * @return newVehicleNo
	 */
	public void setVehicleNo(String newVehicleNo) {
		this.vehicleNo = newVehicleNo;
	}

	public String getVehiOwnerTel() {
		return vehiOwnerTel;
	}

	public void setVehiOwnerTel(String vehiOwnerTel) {
		this.vehiOwnerTel = vehiOwnerTel;
	}

	public String getVehiOwnerName() {
		return vehiOwnerName;
	}

	public void setVehiOwnerName(String vehiOwnerName) {
		this.vehiOwnerName = vehiOwnerName;
	}

	/**
	 * 获取车辆类型(1:箱式,2:车板,3:冷藏,4:散装罐车,5:半挂车)
	 * @return vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * 获取车辆类型(1:箱式,2:车板,3:冷藏,4:散装罐车,5:半挂车)
	 * @return newVehicleType
	 */
	public void setVehicleType(String newVehicleType) {
		this.vehicleType = newVehicleType;
	}

	/**
	 * 获取车辆类型名称
	 * @return vehicleTypeName
	 */
	public String getVehicleTypeName() {
		return vehicleTypeName;
	}

	/**
	 * 获取车辆类型名称
	 * @return newVehicleTypeName
	 */
	public void setVehicleTypeName(String newVehicleTypeName) {
		this.vehicleTypeName = newVehicleTypeName;
	}

	/**
	 * 获取车辆长度(米)
	 * @return vehiLength
	 */
	public String getVehiLength() {
		return vehiLength;
	}

	/**
	 * 获取车辆长度(米)
	 * @return newVehiLength
	 */
	public void setVehiLength(String newVehiLength) {
		this.vehiLength = newVehiLength;
	}

	/**
	 * 获取车辆宽度(米)
	 * @return vehiWidth
	 */
	public String getVehiWidth() {
		return vehiWidth;
	}

	/**
	 * 获取车辆宽度(米)
	 * @return newVehiWidth
	 */
	public void setVehiWidth(String newVehiWidth) {
		this.vehiWidth = newVehiWidth;
	}

	/**
	 * 获取车辆高度(米) 
	 * @return vehiHeight
	 */
	public String getVehiHeight() {
		return vehiHeight;
	}

	/**
	 * 获取车辆高度(米) 
	 * @return newVehiHeight
	 */
	public void setVehiHeight(String newVehiHeight) {
		this.vehiHeight = newVehiHeight;
	}

	/**
	 * 获取车辆重量(吨)
	 * @return vehiWeight
	 */
	public String getVehiWeight() {
		return vehiWeight;
	}

	/**
	 * 获取车辆重量(吨)
	 * @return newVehiWeight
	 */
	public void setVehiWeight(String newVehiWeight) {
		this.vehiWeight = newVehiWeight;
	}

	/**
	 * 获取行驶证照片路径
	 * @return vehiLicenseImgPath
	 */
	public String getVehiLicenseImgPath() {
		return vehiLicenseImgPath;
	}

	/**
	 * 获取行驶证照片路径
	 * @return newVehiLicenseImgPath
	 */
	public void setVehiLicenseImgPath(String newVehiLicenseImgPath) {
		this.vehiLicenseImgPath = newVehiLicenseImgPath;
	}

	/**
	 * 获取车头照片路径
	 * @return vehiHeadImgPath
	 */
	public String getVehiHeadImgPath() {
		return vehiHeadImgPath;
	}

	/**
	 * 获取车头照片路径
	 * @return newVehiHeadImgPath
	 */
	public void setVehiHeadImgPath(String newVehiHeadImgPath) {
		this.vehiHeadImgPath = newVehiHeadImgPath;
	}
	
	/**
	 * 获取车辆状态(-1:认证失败,0:未认证,1:认证成功,2:认证中) 

	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 获取车辆状态(-1:认证失败,0:未认证,1:认证成功,2:认证中) 

	 * @return newStatus
	 */
	public void setStatus(String newStatus) {
		this.status = newStatus;
	}
	
	/**
	 * 获取认证失败原因
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * 获取认证失败原因
	 * @return newMemo
	 */
	public void setMemo(String newMemo) {
		this.memo = newMemo;
	}

	/**
	 * 获取创建人
	 * @return creator
	 */
	public String getCreator() {
		return creator;
	}
	
	/**
	 * 设置创建人
	 * @param newCreator
	 */
	public void setCreator(String newCreator) {
		this.creator = newCreator;
	}

	/**
	 * 获取修改人
	 * @return modifier
	 */
	public String getModifier() {
		return modifier;
	}
	
	/**
	 * 设置修改人
	 * @param newModifier
	 */
	public void setModifier(String newModifier) {
		this.modifier = newModifier;
	}

	public String getDesc3() {
		return desc3;
	}

	public void setDesc3(String desc3) {
		this.desc3 = desc3;
	}

	public String getDrivingTime() {
		return drivingTime;
	}

	public void setDrivingTime(String drivingTime) {
		this.drivingTime = drivingTime;
	}

}
