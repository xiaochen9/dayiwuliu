package com.tianrui.service.admin.bean;

import java.util.List;

/**
 * @Description 运费结算Bean
 * @author zhanggaohao
 * @version 2017年6月20日 下午3:14:02
 */
public class PayInvoiceDetail {
	
	private String id;
	
	private String albankOwnerName;
	private String albankOwnerPhone;
	private String dybankOwnerName;
	private String dybankOwnerPhone;
	
	private String planId;
	//多条id
	private List<String> ids;
	//查询关键字
	private String searchKey;
	//运价确认状态 1-未确认  2-已确认  3-已合单
	private String billPayStatus;
	//附件图片
	private String appendix;
	
	private String memo;
	
	private Long timeBegin;
	
	private Long timeEnd;
	
	private String driverPhone;
	private String driverName;
	private String venderPhone;
	private String venderName;
	private String shipperMerchant;
	private String shipname;
	
	private String consignee;
	
	
	private Double billweightB;
   
	private Double billpriceB;
	
	private Integer pageNo;
	
	private Integer pageSize;
    //单据编号
    private String code;
    //账单ID
    private String payInvoiceId;
    //司机ID
    private String driverId;
    //司机证件号码
    private String driverIdNo;
    //车主ID
    private String venderId;
    //车主证件号码
    private String venderIdNo;
    //货主ID
    private String ownerId;
    //货主证件号码
    private String ownerIdNo;
    //发票类型CODE
    private String invoiceCode;
    //发票类型NAME
    private String invoiceName;
    //运单ID
    private String billId;
    //运单编码
    private String billCode;
    //运单身份（1：司机运单，2：车主运单）
    private Integer billType;
    //物料编码
    private String materialCode;
    //物料名称
    private String materialName;
    //货物名称
    private String cargoName;
    //运单重量
    private Double billWeight;
    //运单单价
    private Double billPrice;
    //税率
    private Double taxRate;
    //前台运单总价
    private Double receptionBillTotalPrice;
    //后台运单总价
    private Double backstageBillTotalPrice;
    //前台扣重扣杂
    private Double receptionDeductWeightMisc;
    //前台扣款
    private Double receptionDeductMoney;
    //前台其他扣款
    private Double receptionDeductOther;
    //前台油卡扣款
    private Double receptionDeductOilCard;
    //后台扣重扣杂
    private Double backstageDeductWeightMisc;
    //后台扣款
    private Double backstageDeductMoney;
    //后台其他扣款
    private Double backstageDeductOther;
    //后台油卡扣款
    private Double backstageDeductOilCard;
    //是否合单（0：否，1：是）
    private Boolean whetherClose;
    //组织ID
    private String orgid;
    //组织名称
    private String orgname;
    //是否有效（0：无效，1：有效）
    private Boolean state;
    //创建人
    private String creator;
    //创建时间
    private Long createTime;
    //修改人
    private String modifier;
    //修改时间
    private Long modifyTime;
    //说明
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getPayInvoiceId() {
        return payInvoiceId;
    }

    public void setPayInvoiceId(String payInvoiceId) {
        this.payInvoiceId = payInvoiceId == null ? null : payInvoiceId.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getDriverIdNo() {
        return driverIdNo;
    }

    public void setDriverIdNo(String driverIdNo) {
        this.driverIdNo = driverIdNo == null ? null : driverIdNo.trim();
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId == null ? null : venderId.trim();
    }

    public String getVenderIdNo() {
        return venderIdNo;
    }

    public void setVenderIdNo(String venderIdNo) {
        this.venderIdNo = venderIdNo == null ? null : venderIdNo.trim();
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public String getOwnerIdNo() {
        return ownerIdNo;
    }

    public void setOwnerIdNo(String ownerIdNo) {
        this.ownerIdNo = ownerIdNo == null ? null : ownerIdNo.trim();
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName == null ? null : invoiceName.trim();
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode == null ? null : billCode.trim();
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode == null ? null : materialCode.trim();
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName == null ? null : materialName.trim();
	}

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName == null ? null : cargoName.trim();
    }

    public Double getBillWeight() {
        return billWeight;
    }

    public void setBillWeight(Double billWeight) {
        this.billWeight = billWeight;
    }

    public Double getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(Double billPrice) {
        this.billPrice = billPrice;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getReceptionBillTotalPrice() {
        return receptionBillTotalPrice;
    }

    public void setReceptionBillTotalPrice(Double receptionBillTotalPrice) {
        this.receptionBillTotalPrice = receptionBillTotalPrice;
    }

    public Double getBackstageBillTotalPrice() {
        return backstageBillTotalPrice;
    }

    public void setBackstageBillTotalPrice(Double backstageBillTotalPrice) {
        this.backstageBillTotalPrice = backstageBillTotalPrice;
    }

    public Double getReceptionDeductWeightMisc() {
        return receptionDeductWeightMisc;
    }

    public void setReceptionDeductWeightMisc(Double receptionDeductWeightMisc) {
        this.receptionDeductWeightMisc = receptionDeductWeightMisc;
    }

    public Double getReceptionDeductMoney() {
        return receptionDeductMoney;
    }

    public void setReceptionDeductMoney(Double receptionDeductMoney) {
        this.receptionDeductMoney = receptionDeductMoney;
    }

    public Double getReceptionDeductOther() {
        return receptionDeductOther;
    }

    public void setReceptionDeductOther(Double receptionDeductOther) {
        this.receptionDeductOther = receptionDeductOther;
    }

    public Double getReceptionDeductOilCard() {
        return receptionDeductOilCard;
    }

    public void setReceptionDeductOilCard(Double receptionDeductOilCard) {
        this.receptionDeductOilCard = receptionDeductOilCard;
    }

    public Double getBackstageDeductWeightMisc() {
        return backstageDeductWeightMisc;
    }

    public void setBackstageDeductWeightMisc(Double backstageDeductWeightMisc) {
        this.backstageDeductWeightMisc = backstageDeductWeightMisc;
    }

    public Double getBackstageDeductMoney() {
        return backstageDeductMoney;
    }

    public void setBackstageDeductMoney(Double backstageDeductMoney) {
        this.backstageDeductMoney = backstageDeductMoney;
    }

    public Double getBackstageDeductOther() {
        return backstageDeductOther;
    }

    public void setBackstageDeductOther(Double backstageDeductOther) {
        this.backstageDeductOther = backstageDeductOther;
    }

    public Double getBackstageDeductOilCard() {
        return backstageDeductOilCard;
    }

    public void setBackstageDeductOilCard(Double backstageDeductOilCard) {
        this.backstageDeductOilCard = backstageDeductOilCard;
    }

    public Boolean getWhetherClose() {
        return whetherClose;
    }

    public void setWhetherClose(Boolean whetherClose) {
        this.whetherClose = whetherClose;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid == null ? null : orgid.trim();
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public String getBillPayStatus() {
		return billPayStatus;
	}

	public void setBillPayStatus(String billPayStatus) {
		this.billPayStatus = billPayStatus;
	}

	public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getAppendix() {
		return appendix;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}

	public Double getBillweightB() {
		return billweightB;
	}

	public void setBillweightB(Double billweightB) {
		this.billweightB = billweightB;
	}

	public Double getBillpriceB() {
		return billpriceB;
	}

	public String getAlbankOwnerName() {
		return albankOwnerName;
	}

	public void setAlbankOwnerName(String albankOwnerName) {
		this.albankOwnerName = albankOwnerName;
	}

	public String getAlbankOwnerPhone() {
		return albankOwnerPhone;
	}

	public void setAlbankOwnerPhone(String albankOwnerPhone) {
		this.albankOwnerPhone = albankOwnerPhone;
	}

	public String getDybankOwnerName() {
		return dybankOwnerName;
	}

	public void setDybankOwnerName(String dybankOwnerName) {
		this.dybankOwnerName = dybankOwnerName;
	}

	public String getDybankOwnerPhone() {
		return dybankOwnerPhone;
	}

	public void setDybankOwnerPhone(String dybankOwnerPhone) {
		this.dybankOwnerPhone = dybankOwnerPhone;
	}

	public void setBillpriceB(Double billpriceB) {
		this.billpriceB = billpriceB;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getVenderPhone() {
		return venderPhone;
	}

	public void setVenderPhone(String venderPhone) {
		this.venderPhone = venderPhone;
	}

	public String getVenderName() {
		return venderName;
	}

	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}

	public String getShipperMerchant() {
		return shipperMerchant;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public void setShipperMerchant(String shipperMerchant) {
		this.shipperMerchant = shipperMerchant;
	}

	public String getShipname() {
		return shipname;
	}

	public void setShipname(String shipname) {
		this.shipname = shipname;
	}

	public Long getTimeBegin() {
		return timeBegin;
	}

	public void setTimeBegin(Long timeBegin) {
		this.timeBegin = timeBegin;
	}

	public Long getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Long timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public PayInvoiceDetail() {
		super();
	}

	public PayInvoiceDetail(String id, String code, String payInvoiceId, String driverId, String driverIdNo,
			String venderId, String venderIdNo, String ownerId, String ownerIdNo, String invoiceCode,
			String invoiceName, String billId, String billCode, Integer billType, String materialCode,
			String materialName, String cargoName, Double billWeight, Double billPrice, Double taxRate,
			Double receptionBillTotalPrice, Double backstageBillTotalPrice, Double receptionDeductWeightMisc,
			Double receptionDeductMoney, Double receptionDeductOther, Double receptionDeductOilCard,
			Double backstageDeductWeightMisc, Double backstageDeductMoney, Double backstageDeductOther,
			Double backstageDeductOilCard, Boolean whetherClose, String orgid, String orgname, Boolean state,
			String creator, Long createTime, String modifier, Long modifyTime, String remark) {
		super();
		this.id = id;
		this.code = code;
		this.payInvoiceId = payInvoiceId;
		this.driverId = driverId;
		this.driverIdNo = driverIdNo;
		this.venderId = venderId;
		this.venderIdNo = venderIdNo;
		this.ownerId = ownerId;
		this.ownerIdNo = ownerIdNo;
		this.invoiceCode = invoiceCode;
		this.invoiceName = invoiceName;
		this.billId = billId;
		this.billCode = billCode;
		this.billType = billType;
		this.materialCode = materialCode;
		this.materialName = materialName;
		this.cargoName = cargoName;
		this.billWeight = billWeight;
		this.billPrice = billPrice;
		this.taxRate = taxRate;
		this.receptionBillTotalPrice = receptionBillTotalPrice;
		this.backstageBillTotalPrice = backstageBillTotalPrice;
		this.receptionDeductWeightMisc = receptionDeductWeightMisc;
		this.receptionDeductMoney = receptionDeductMoney;
		this.receptionDeductOther = receptionDeductOther;
		this.receptionDeductOilCard = receptionDeductOilCard;
		this.backstageDeductWeightMisc = backstageDeductWeightMisc;
		this.backstageDeductMoney = backstageDeductMoney;
		this.backstageDeductOther = backstageDeductOther;
		this.backstageDeductOilCard = backstageDeductOilCard;
		this.whetherClose = whetherClose;
		this.orgid = orgid;
		this.orgname = orgname;
		this.state = state;
		this.creator = creator;
		this.createTime = createTime;
		this.modifier = modifier;
		this.modifyTime = modifyTime;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "PayInvoiceDetail [id=" + id + ", code=" + code + ", payInvoiceId=" + payInvoiceId + ", driverId="
				+ driverId + ", driverIdNo=" + driverIdNo + ", venderId=" + venderId + ", venderIdNo=" + venderIdNo
				+ ", ownerId=" + ownerId + ", ownerIdNo=" + ownerIdNo + ", invoiceCode=" + invoiceCode
				+ ", invoiceName=" + invoiceName + ", billId=" + billId + ", billCode=" + billCode + ", billType="
				+ billType + ", materialCode=" + materialCode + ", materialName=" + materialName + ", cargoName="
				+ cargoName + ", billWeight=" + billWeight + ", billPrice=" + billPrice + ", taxRate=" + taxRate
				+ ", receptionBillTotalPrice=" + receptionBillTotalPrice + ", backstageBillTotalPrice="
				+ backstageBillTotalPrice + ", receptionDeductWeightMisc=" + receptionDeductWeightMisc
				+ ", receptionDeductMoney=" + receptionDeductMoney + ", receptionDeductOther=" + receptionDeductOther
				+ ", receptionDeductOilCard=" + receptionDeductOilCard + ", backstageDeductWeightMisc="
				+ backstageDeductWeightMisc + ", backstageDeductMoney=" + backstageDeductMoney
				+ ", backstageDeductOther=" + backstageDeductOther + ", backstageDeductOilCard="
				+ backstageDeductOilCard + ", whetherClose=" + whetherClose + ", orgid=" + orgid + ", orgname="
				+ orgname + ", state=" + state + ", creator=" + creator + ", createTime=" + createTime + ", modifier="
				+ modifier + ", modifyTime=" + modifyTime + ", remark=" + remark + "]";
	}
    
}