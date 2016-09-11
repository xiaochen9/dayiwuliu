package com.tianrui.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tianrui.service.bean.Bill;
import com.tianrui.service.bean.BillUpdate;

public interface BillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wuliu_bill
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wuliu_bill
     *
     * @mbggenerated
     */
    int insert(Bill record);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wuliu_bill
     *
     * @mbggenerated
     */
    int insertSelective(Bill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wuliu_bill
     *
     * @mbggenerated
     */
    Bill selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wuliu_bill
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Bill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wuliu_bill
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Bill record);
    
    
    List<Bill> selectByCondition(Bill record);
    /** 批量修改运单*/
    int updateByBillTransfer(BillUpdate record);
    /** 查询可以转运的运单*/
    List<Bill> selectByBillTransfer(Bill record);
    
    long countByCondition(Bill record);
    
    Double querySumWithPlan(Bill record);
    
    List<Bill> selectByPlanId(String billId);
    
	List<Bill> selectBillByCapaId(@Param("capaId")String capaId, @Param("venderid")String venderid);
}