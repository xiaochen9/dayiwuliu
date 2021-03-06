package com.tianrui.api.resp.report;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class ReportBillAllResp {
    private String id;

    private String billType;

    private String businessTime;
    
    private String businessTimeStr;

    private String planNo;

    private String billNo;

    private String sendMan;

    private String sendPersion;

    private String receiptMan;

    private String receiptPersion;

    private String vehicleNo;

    private String cargoName;

    private String routeName;

    private String distinct;

    private String venderWeight;

    private String pickupWeight;

    private String unloadWeight;

    private String trueWeight;

    private String billStatus;

    private String driverName;

    private String payMent;

    private Long billCreaterTime;

    private Long acceptTime;

    private Long pickupTime;

    private Long unloadTime;

    private Long signTime;
    
    private String ownerName;
    
    private String billCreaterTimeStr;
    private String acceptTimeStr;
    private String pickupTimeStr;
    private String unloadTimeStr;
    private String signTimeStr;
    
    private String desc1;

    private String desc2;

    private String desc3;

    private String desc4;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType == null ? null : billType.trim();
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime == null ? null : businessTime.trim();
    }

    public String getPlanNo() {
        return planNo;
    }

    public void setPlanNo(String planNo) {
        this.planNo = planNo == null ? null : planNo.trim();
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getSendMan() {
        return sendMan;
    }

    public void setSendMan(String sendMan) {
        this.sendMan = sendMan == null ? null : sendMan.trim();
    }

    public String getSendPersion() {
        return sendPersion;
    }

    public void setSendPersion(String sendPersion) {
        this.sendPersion = sendPersion == null ? null : sendPersion.trim();
    }

    public String getReceiptMan() {
        return receiptMan;
    }

    public void setReceiptMan(String receiptMan) {
        this.receiptMan = receiptMan == null ? null : receiptMan.trim();
    }

    public String getReceiptPersion() {
        return receiptPersion;
    }

    public void setReceiptPersion(String receiptPersion) {
        this.receiptPersion = receiptPersion == null ? null : receiptPersion.trim();
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo == null ? null : vehicleNo.trim();
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName == null ? null : cargoName.trim();
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName == null ? null : routeName.trim();
    }

    public String getDistinct() {
        return distinct;
    }

    public void setDistinct(String distinct) {
        this.distinct = distinct == null ? null : distinct.trim();
    }

    public String getVenderWeight() {
        return venderWeight;
    }

    public void setVenderWeight(String venderWeight) {
        this.venderWeight = venderWeight == null ? null : venderWeight.trim();
    }

    public String getPickupWeight() {
        return pickupWeight;
    }

    public void setPickupWeight(String pickupWeight) {
        this.pickupWeight = pickupWeight == null ? null : pickupWeight.trim();
    }

    public String getUnloadWeight() {
        return unloadWeight;
    }

    public void setUnloadWeight(String unloadWeight) {
        this.unloadWeight = unloadWeight == null ? null : unloadWeight.trim();
    }

    public String getTrueWeight() {
        return trueWeight;
    }

    public void setTrueWeight(String trueWeight) {
        this.trueWeight = trueWeight == null ? null : trueWeight.trim();
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus == null ? null : billStatus.trim();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    public String getPayMent() {
        return payMent;
    }

    public void setPayMent(String payMent) {
        this.payMent = payMent == null ? null : payMent.trim();
    }

    public Long getBillCreaterTime() {
        return billCreaterTime;
    }

    public void setBillCreaterTime(Long billCreaterTime) {
        this.billCreaterTime = billCreaterTime;
    }

    public Long getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Long acceptTime) {
        this.acceptTime = acceptTime;
    }

    public Long getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Long pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Long getUnloadTime() {
        return unloadTime;
    }

    public void setUnloadTime(Long unloadTime) {
        this.unloadTime = unloadTime;
    }

    public Long getSignTime() {
        return signTime;
    }

    public void setSignTime(Long signTime) {
        this.signTime = signTime;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1 == null ? null : desc1.trim();
    }

    public String getDesc2() {
        return desc2;
    }

    public void setDesc2(String desc2) {
        this.desc2 = desc2 == null ? null : desc2.trim();
    }

    public String getDesc3() {
        return desc3;
    }

    public void setDesc3(String desc3) {
        this.desc3 = desc3 == null ? null : desc3.trim();
    }

    public String getDesc4() {
        return desc4;
    }

    public void setDesc4(String desc4) {
        this.desc4 = desc4 == null ? null : desc4.trim();
    }

    
	public String getBillCreaterTimeStr() {
		if(billCreaterTime!= null){
			billCreaterTimeStr =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(billCreaterTime));
		}
		return billCreaterTimeStr;
	}

	public String getAcceptTimeStr() {
		if(acceptTime!= null){
			acceptTimeStr =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(acceptTime));
		}
		return acceptTimeStr;
	}

	public String getPickupTimeStr() {
		if(pickupTime!= null){
			pickupTimeStr =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(pickupTime));
		}
		return pickupTimeStr;
	}

	public String getUnloadTimeStr() {
		if(unloadTime!= null){
			unloadTimeStr =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(unloadTime));
		}
		return unloadTimeStr;
	}

	public String getSignTimeStr() {
		if(signTime!= null){
			signTimeStr =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(signTime));
		}
		return signTimeStr;
	}

	public String getBusinessTimeStr() {
		if(StringUtils.isNotBlank(businessTime)){
			businessTimeStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(businessTime)));
		}
		return businessTimeStr;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
    
    
    
}