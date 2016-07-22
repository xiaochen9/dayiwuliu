package com.tianrui.service.admin.mapper;

import java.util.List;

import com.tianrui.service.admin.bean.FileCargo;

public interface FileCargoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_cargo
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_cargo
     *
     * @mbggenerated
     */
    int insert(FileCargo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_cargo
     *
     * @mbggenerated
     */
    int insertSelective(FileCargo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_cargo
     *
     * @mbggenerated
     */
    FileCargo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_cargo
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FileCargo record);
    /**
     * 
     * @描述:批量修改
     * @param record
     * @return
     * @返回类型 int
     * @创建人 lsj
     * @创建时间 2016年7月20日下午4:26:02
     */
    int batchUpdateByPrimaryKeySelective(FileCargo record);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_cargo
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FileCargo record);
    
    /**
     * 根据条件进行货物档案信息查询
     * <p>
     * @param record
     * @return
     * <p>
     * @author guyuke
     * @time 2016年5月22日 下午5:55:28
     */
    List<FileCargo> selectCargoByCondition(FileCargo argCondition);
    
    /**
     * 根据条件进行货物档案信息数据总量查询
     * <p>
     * @param record
     * @return
     * <p>
     * @author guyuke
     * @time 2016年5月22日 下午5:55:28
     */
    long selectCountByCondition(FileCargo argCondition);
}