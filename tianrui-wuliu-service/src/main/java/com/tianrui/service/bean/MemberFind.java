package com.tianrui.service.bean;

/**
 * 
 * @类描述：会员条件查询类
 * @创建人：lsj
 * @创建时间：2016年5月18日上午11:05:36
 *
 * @修改人：lsj
 * @修改时间：2016年5月18日上午11:05:36
 * @修改备注：
 *
 */
public class MemberFind implements IModel{

	/**
	 * 会员名
	 */
	private String userName;
	/**
	 * 公司名称
	 */
	private String companyName;
	/** 运力类型*/
	private String capaType;
	
	/**
	 * 会员状态
	 */
	private String status;
	/**
	 * 电话
	 */
	private String cellPhone;
	/**
	 * 个人认证
	 */
	private Short userpercheck;
	/**
	 * 司机认证
	 */
	private Short driverpercheck;
	/**
	 * 企业认证
	 */
	private Short companypercheck;
	/**
	 * 用户来源
	 */
	private String sourcetype;
	/**
	 * 注册时间始
	 */
	private Long registtimeFor;
	/**
	 * 注册时间末
	 */
	private Long registtimeEnd;
	/**
	 * 认证时间始
	 */
	private Long submitdateFor;
	/**
	 * 认证时间末
	 */
	private Long submitdateEnd;
	/**
	 * 2-个人账户， 1-企业账户
	 */
	private String  personalType;
	/**
	 * 第几页
	 */
	private int pageNo;
	/**
	 * 每页几条
	 */
	private int pageSize;
	/**
	 * 0-查询普通用户, 1-查询司机用户
	 */
	private String userType;
	
	private Integer limit;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		
		return pageSize;
	}
	public String getPersonalType() {
		return personalType;
	}
	public void setPersonalType(String personalType) {
		this.personalType = personalType;
	}
	public String getCapaType() {
		return capaType;
	}
	public void setCapaType(String capaType) {
		this.capaType = capaType;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Short getUserpercheck() {
		return userpercheck;
	}
	public void setUserpercheck(Short userpercheck) {
		this.userpercheck = userpercheck;
	}
	public Short getDriverpercheck() {
		return driverpercheck;
	}
	public void setDriverpercheck(Short driverpercheck) {
		this.driverpercheck = driverpercheck;
	}
	public Short getCompanypercheck() {
		return companypercheck;
	}
	public void setCompanypercheck(Short companypercheck) {
		this.companypercheck = companypercheck;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getStatus() {
		return status;
	}
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Integer getLimit() {
		return limit;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getSourcetype() {
		return sourcetype;
	}
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	public Long getRegisttimeFor() {
		return registtimeFor;
	}
	public void setRegisttimeFor(Long registtimeFor) {
		this.registtimeFor = registtimeFor;
	}
	public Long getRegisttimeEnd() {
		return registtimeEnd;
	}
	public void setRegisttimeEnd(Long registtimeEnd) {
		this.registtimeEnd = registtimeEnd;
	}
	public Long getSubmitdateFor() {
		return submitdateFor;
	}
	public void setSubmitdateFor(Long submitdateFor) {
		this.submitdateFor = submitdateFor;
	}
	public Long getSubmitdateEnd() {
		return submitdateEnd;
	}
	public void setSubmitdateEnd(Long submitdateEnd) {
		this.submitdateEnd = submitdateEnd;
	}
	
}
