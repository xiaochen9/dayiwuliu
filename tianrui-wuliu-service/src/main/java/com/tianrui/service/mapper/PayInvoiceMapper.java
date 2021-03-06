package com.tianrui.service.mapper;

import java.util.List;

import com.tianrui.service.bean.PayInvoice;

public interface PayInvoiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice
     *
     * @mbggenerated
     */
    int insert(PayInvoice record);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice
     *
     * @mbggenerated
     */
    PayInvoice selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PayInvoice record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_invoice
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PayInvoice record);
    
    List<PayInvoice> selectByCondition(PayInvoice record);
    
    long countByCondition(PayInvoice record);
}