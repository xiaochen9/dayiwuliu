package com.tianrui.service.mapper;

import com.tianrui.service.bean.SystemMemberInfo;

public interface SystemMemberInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_info
     *
     * @mbggenerated
     */
    int insert(SystemMemberInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_info
     *
     * @mbggenerated
     */
    int insertSelective(SystemMemberInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_info
     *
     * @mbggenerated
     */
    SystemMemberInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SystemMemberInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SystemMemberInfo record);
}