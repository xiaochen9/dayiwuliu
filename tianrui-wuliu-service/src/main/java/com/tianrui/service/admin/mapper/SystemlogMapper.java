package com.tianrui.service.admin.mapper;

import com.tianrui.service.admin.bean.Systemlog;

public interface SystemlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_systemlog
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_systemlog
     *
     * @mbggenerated
     */
    int insert(Systemlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_systemlog
     *
     * @mbggenerated
     */
    int insertSelective(Systemlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_systemlog
     *
     * @mbggenerated
     */
    Systemlog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_systemlog
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Systemlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_systemlog
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Systemlog record);
}