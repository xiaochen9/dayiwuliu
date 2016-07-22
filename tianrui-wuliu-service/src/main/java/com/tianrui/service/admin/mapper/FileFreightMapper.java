package com.tianrui.service.admin.mapper;

import java.util.List;

import com.tianrui.service.admin.bean.FileFreight;
import com.tianrui.service.admin.bean.Freight;

public interface FileFreightMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_freight
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_freight
     *
     * @mbggenerated
     */
    int insert(FileFreight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_freight
     *
     * @mbggenerated
     */
    int insertSelective(FileFreight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_freight
     *
     * @mbggenerated
     */
    FileFreight selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_freight
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FileFreight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_freight
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FileFreight record);
    /**
     * 
     * @描述:批量修改
     * @param record
     * @return
     * @返回类型 int
     * @创建人 lsj
     * @创建时间 2016年7月20日上午9:39:54
     */
    int batchUpdateByPrimaryKeySelective(FileFreight record);
    
    /**
     * 
     * @描述:查询
     * @param record
     * @return
     * @返回类型 List<FileFreight>
     * @创建人 lsj
     * @创建时间 2016年5月23日下午5:10:40
     */
    List<FileFreight> findByEntity(FileFreight record);
   
    /**
     * 
     * @描述:查询
     * 		route cargo 均为可用状态
     * @param record
     * @return
     * @返回类型 List<FileFreight>
     * @创建人 lsj
     * @创建时间 2016年5月23日下午5:10:40
     */
    List<FileFreight> selectByStatus(FileFreight record);
    /**
     * 
     * @描述:多表查询
     * @param record
     * @return
     * @返回类型 List<FileFreight>
     * @创建人 lsj
     * @创建时间 2016年5月27日上午9:39:10
     */
    List<FileFreight> findByToName(FileFreight record);
    /**
     * 
     * @描述:多表查询/查询条数
     * @param record
     * @return
     * @返回类型 List<FileFreight>
     * @创建人 lsj
     * @创建时间 2016年5月27日上午9:39:10
     */
    long findByToNameCount(FileFreight record);
    /**
     * 
     * @描述:多表查询
     * @param id
     * @return
     * @返回类型 Freight
     * @创建人 lsj
     * @创建时间 2016年5月30日下午6:08:15
     */
    Freight selectByKey(String id);
    /**
     * 
     * @描述:根据策略名称查询策略，精确查询
     * @param freight
     * @return
     * @返回类型 List<FileFreight>
     * @创建人 tank
     * @创建时间 2016年6月26日下午3:26:11
     */
	List<FileFreight> findByName(FileFreight freight);
    
    
}