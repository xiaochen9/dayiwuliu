package com.tianrui.api.req.count;

public class CountAddReq {
	private String id;

    private String type;

    private String remark;

    private Double adddate;

    private Long showtime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getAdddate() {
		return adddate;
	}

	public void setAdddate(Double adddate) {
		this.adddate = adddate;
	}

	public Long getShowtime() {
		return showtime;
	}

	public void setShowtime(Long showtime) {
		this.showtime = showtime;
	}

    
}
