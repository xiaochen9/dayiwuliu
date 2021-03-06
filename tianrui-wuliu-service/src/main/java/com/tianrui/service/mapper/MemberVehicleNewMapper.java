package com.tianrui.service.mapper;

import java.util.List;

import com.tianrui.service.bean.vehiclereg.MemberVehicleNew;

public interface MemberVehicleNewMapper {
    int deleteByPrimaryKey(String id);

    int insert(MemberVehicleNew record);

    int insertSelective(MemberVehicleNew record);

    MemberVehicleNew selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MemberVehicleNew record);

    int updateByPrimaryKey(MemberVehicleNew record);
    
    List<MemberVehicleNew> selectByCondition(MemberVehicleNew record);
}