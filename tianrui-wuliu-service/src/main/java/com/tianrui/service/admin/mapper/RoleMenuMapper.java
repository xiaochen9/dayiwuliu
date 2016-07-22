package com.tianrui.service.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tianrui.service.admin.bean.Mainmenu;
import com.tianrui.service.admin.bean.Role;
import com.tianrui.service.admin.bean.RoleMenu;

public interface RoleMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_Role_Menu
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_Role_Menu
     *
     * @mbggenerated
     */
    int insert(RoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_Role_Menu
     *
     * @mbggenerated
     */
    int insertSelective(RoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_Role_Menu
     *
     * @mbggenerated
     */
    RoleMenu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_Role_Menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trwuliu_Role_Menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RoleMenu record);
    
    //根据菜单I的查找对应的角色
    List<Role> findWithMId(Integer mId);
    //根据角色id查找对应的菜单
    List<Mainmenu> findWithRId(Integer rId);
    List<Mainmenu> findWithRIds(@Param("rIds")List<Integer> rIds);
    
    
    int deleteWithmId(Integer id);
    
    int deleteWithrId(Integer id);
}