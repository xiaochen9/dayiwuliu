package com.tianrui.api.resp.report;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportPlanAllResp {
    private String id;

    private Long planCreateTime;
    
    private String  planCreateTimeStr;
    private String planCode;

    private Long planBeginTime;
    private String  planBeginTimeStr;
    private Long planEndTime;
    private String  planEndTimeStr;
    private String planWeight;

    private String complitWeight;

    private String tempo;

    private String planStatus;

    private String cargoName;

    private String routeName;

    private String sendMan;

    private String sendPersion;

    private String venderName;

    private String receiptMan;

    private String receiptPersion;

    private String distant;

    private String price;

    private String tax;

    private String payMent;

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

    public Long getPlanCreateTime() {
        return planCreateTime;
    }

    public void setPlanCreateTime(Long planCreateTime) {
        this.planCreateTime = planCreateTime;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode == null ? null : planCode.trim();
    }

    public Long getPlanBeginTime() {
        return planBeginTime;
    }

    public void setPlanBeginTime(Long planBeginTime) {
        this.planBeginTime = planBeginTime;
    }

    public Long getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Long planEndTime) {
        this.planEndTime = planEndTime;
    }

    public String getPlanWeight() {
        return planWeight;
    }

    public void setPlanWeight(String planWeight) {
        this.planWeight = planWeight == null ? null : planWeight.trim();
    }

    public String getComplitWeight() {
        return complitWeight;
    }

    public void setComplitWeight(String complitWeight) {
        this.complitWeight = complitWeight == null ? null : complitWeight.trim();
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo == null ? null : tempo.trim();
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus == null ? null : planStatus.trim();
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

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName == null ? null : venderName.trim();
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

    public String getDistant() {
        return distant;
    }

    public void setDistant(String distant) {
        this.distant = distant == null ? null : distant.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax == null ? null : tax.trim();
    }

    public String getPayMent() {
        return payMent;
    }

    public void setPayMent(String payMent) {
        this.payMent = payMent == null ? null : payMent.trim();
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

    
	public String getPlanCreateTimeStr() {
		if(planCreateTime != null){
			planCreateTimeStr =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(planCreateTime));
		}
		return planCreateTimeStr;
	}
	public String getPlanBeginTimeStr() {
		if(planBeginTime != null){
			planBeginTimeStr =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(planBeginTime));
		}
		return planBeginTimeStr;
	}
	public String getPlanEndTimeStr() {
		if(planEndTime != null){
			planEndTimeStr =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(planEndTime));
		}
		return planEndTimeStr;
	}

    
    
    
    
    
}