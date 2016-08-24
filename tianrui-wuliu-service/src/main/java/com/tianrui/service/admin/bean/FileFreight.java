package com.tianrui.service.admin.bean;

import com.tianrui.service.bean.IModel;
/**
 * 
 * @类描述：运价档案
 * @创建人：tank
 * @创建时间：2016年4月22日下午4:44:20
 *
 * @修改人：tank
 * @修改时间：2016年4月22日下午4:44:20
 * @修改备注：
 *
 */
public class FileFreight implements IModel {
    /**
     * id
     */
    private String id;
    /**
     * 审核状态
     */
    private String auditstatus;
    
    /**
     * 审核原因
     */
    private String auditreason;

    /**
     * 所属组织名称 
     */
    private String organizationname;
    /**
     * 被调用次数
     */
    private String count;
    /**
     * 货物状态
     */
    private String cStatus;
    /**
     * 路径状态
     */
    private String rStatus;
    /**
     * 所属组织id
     */
    private String organizationid;

    /**
     * 运价状态（0-可用；1-暂不可用；2-已删除）
     */
    private String status;

    /**
     * 货物id
     */
    private String cargoid;

    /**
     * 主计量单位
     */
    private String measure;

    /**
     * 路径id
     */
    private String routeid;

    /**
     * 计价单位
     */
    private String priceunits;

    /**
     * 单价
     */
    private Double price;

    private Double priceInfo;
    /**
     * 创建者 
     */
    private String creator;

    /**
     * 创建时间
     */
    private Long createtime;

    /**
     * 修改者 
     */
    private String modifier;

    /**
     * 修改时间
     */
    private Long modifytime;

    /**
     * 运价名称
     */
    private String freightName;

    /**
     *	价格类型 0-自由；1-合同
     */
    private String freightType;
    
    private String freightTypeInfo;
    
    /** 税率*/
    private Double tallage;
    
    private Double tallageInfo;
    private String desc1;
    private String desc2;

	/**
     *
     */
    private String desc3;

    /**
     *
     */
    private String desc4;
    /**
     * 第几页
     */
    private Integer limit;
    /**
     * 每页几条数据
     */
    private Integer pageSize;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.ID
     *
     * @return the value of file_freight.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

	public Double getPriceInfo() {
		return priceInfo;
	}

	public void setPriceInfo(Double priceInfo) {
		this.priceInfo = priceInfo;
	}

	public String getFreightTypeInfo() {
		return freightTypeInfo;
	}

	public void setFreightTypeInfo(String freightTypeInfo) {
		this.freightTypeInfo = freightTypeInfo;
	}

	public Double getTallageInfo() {
		return tallageInfo;
	}

	public void setTallageInfo(Double tallageInfo) {
		this.tallageInfo = tallageInfo;
	}

	public Integer getLimit() {
		return limit;
	}

    public String getcStatus() {
		return cStatus;
	}

	public void setcStatus(String cStatus) {
		this.cStatus = cStatus;
	}

	public String getFreightName() {
		return freightName;
	}

	public void setFreightName(String freightName) {
		this.freightName = freightName;
	}

	public String getFreightType() {
		return freightType;
	}

	public void setFreightType(String freightType) {
		this.freightType = freightType;
	}

	public Double getTallage() {
		return tallage;
	}

	public void setTallage(Double tallage) {
		this.tallage = tallage;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.ID
     *
     * @param id the value for file_freight.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.organizationname
     *
     * @return the value of file_freight.organizationname
     *
     * @mbggenerated
     */
    public String getOrganizationname() {
        return organizationname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.organizationname
     *
     * @param organizationname the value for file_freight.organizationname
     *
     * @mbggenerated
     */
    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname == null ? null : organizationname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.organizationid
     *
     * @return the value of file_freight.organizationid
     *
     * @mbggenerated
     */
    public String getOrganizationid() {
        return organizationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.organizationid
     *
     * @param organizationid the value for file_freight.organizationid
     *
     * @mbggenerated
     */
    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid == null ? null : organizationid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.status
     *
     * @return the value of file_freight.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.status
     *
     * @param status the value for file_freight.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }


    public String getCargoid() {
		return cargoid;
	}

	public void setCargoid(String cargoid) {
		this.cargoid = cargoid;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.measure
     *
     * @return the value of file_freight.measure
     *
     * @mbggenerated
     */
    public String getMeasure() {
        return measure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.measure
     *
     * @param measure the value for file_freight.measure
     *
     * @mbggenerated
     */
    public void setMeasure(String measure) {
        this.measure = measure == null ? null : measure.trim();
    }

    public String getAuditstatus() {
		return auditstatus;
	}

	public void setAuditstatus(String auditstatus) {
		this.auditstatus = auditstatus;
	}

	public String getAuditreason() {
		return auditreason;
	}

	public void setAuditreason(String auditreason) {
		this.auditreason = auditreason;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.routeid
     *
     * @return the value of file_freight.routeid
     *
     * @mbggenerated
     */
    public String getRouteid() {
        return routeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.routeid
     *
     * @param routeid the value for file_freight.routeid
     *
     * @mbggenerated
     */
    public void setRouteid(String routeid) {
        this.routeid = routeid == null ? null : routeid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.priceUnits
     *
     * @return the value of file_freight.priceUnits
     *
     * @mbggenerated
     */
    public String getPriceunits() {
        return priceunits;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.priceUnits
     *
     * @param priceunits the value for file_freight.priceUnits
     *
     * @mbggenerated
     */
    public void setPriceunits(String priceunits) {
        this.priceunits = priceunits == null ? null : priceunits.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.price
     *
     * @return the value of file_freight.price
     *
     * @mbggenerated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.price
     *
     * @param price the value for file_freight.price
     *
     * @mbggenerated
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.creator
     *
     * @return the value of file_freight.creator
     *
     * @mbggenerated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.creator
     *
     * @param creator the value for file_freight.creator
     *
     * @mbggenerated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.createtime
     *
     * @return the value of file_freight.createtime
     *
     * @mbggenerated
     */
    public Long getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.createtime
     *
     * @param createtime the value for file_freight.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.modifier
     *
     * @return the value of file_freight.modifier
     *
     * @mbggenerated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.modifier
     *
     * @param modifier the value for file_freight.modifier
     *
     * @mbggenerated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.modifytime
     *
     * @return the value of file_freight.modifytime
     *
     * @mbggenerated
     */
    public Long getModifytime() {
        return modifytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.modifytime
     *
     * @param modifytime the value for file_freight.modifytime
     *
     * @mbggenerated
     */
    public void setModifytime(Long modifytime) {
        this.modifytime = modifytime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.DESC1
     *
     * @return the value of file_freight.DESC1
     *
     * @mbggenerated
     */
    public String getDesc1() {
        return desc1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.DESC1
     *
     * @param desc1 the value for file_freight.DESC1
     *
     * @mbggenerated
     */
    public void setDesc1(String desc1) {
        this.desc1 = desc1 == null ? null : desc1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.DESC2
     *
     * @return the value of file_freight.DESC2
     *
     * @mbggenerated
     */
    public String getDesc2() {
        return desc2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.DESC2
     *
     * @param desc2 the value for file_freight.DESC2
     *
     * @mbggenerated
     */
    public void setDesc2(String desc2) {
        this.desc2 = desc2 == null ? null : desc2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.DESC3
     *
     * @return the value of file_freight.DESC3
     *
     * @mbggenerated
     */
    public String getDesc3() {
        return desc3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.DESC3
     *
     * @param desc3 the value for file_freight.DESC3
     *
     * @mbggenerated
     */
    public void setDesc3(String desc3) {
        this.desc3 = desc3 == null ? null : desc3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column file_freight.DESC4
     *
     * @return the value of file_freight.DESC4
     *
     * @mbggenerated
     */
    public String getDesc4() {
        return desc4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column file_freight.DESC4
     *
     * @param desc4 the value for file_freight.DESC4
     *
     * @mbggenerated
     */
    public void setDesc4(String desc4) {
        this.desc4 = desc4 == null ? null : desc4.trim();
    }
}