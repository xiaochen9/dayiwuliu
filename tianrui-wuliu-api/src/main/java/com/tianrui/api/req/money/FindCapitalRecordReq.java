package com.tianrui.api.req.money;

public class FindCapitalRecordReq {

	private Integer pageNo;
	    
    private Integer pageSize;

    private String cellphone;//登录账号

    private String username;//用户姓名

    private String useryhno;//银行（NC）唯一编号，身份证号
    
    private Long transactiontype;//交易类型11-收入运费，19-资金回流；  21-提现申请，22-提现成功

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseryhno() {
		return useryhno;
	}

	public void setUseryhno(String useryhno) {
		this.useryhno = useryhno;
	}

	public Long getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(Long transactiontype) {
		this.transactiontype = transactiontype;
	}
}