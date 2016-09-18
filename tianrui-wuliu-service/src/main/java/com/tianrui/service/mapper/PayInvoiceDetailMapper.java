package com.tianrui.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tianrui.service.bean.PayInvoiceDetail;

public interface PayInvoiceDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice_detail
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice_detail
     *
     * @mbggenerated
     */
    int insert(PayInvoiceDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice_detail
     *
     * @mbggenerated
     */
    int insertSelective(PayInvoiceDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice_detail
     *
     * @mbggenerated
     */
    PayInvoiceDetail selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PayInvoiceDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice_detail
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PayInvoiceDetail record);
    
    List<PayInvoiceDetail> selectByCondition(PayInvoiceDetail record);
    
    long countByCondition(PayInvoiceDetail record);
    
    void updateStatusByIds(@Param("ids")List<String> ids,@Param("payId ") String  payId);
    
}