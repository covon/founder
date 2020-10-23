package com.founder.dao;


import com.founder.entity.MenuRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单权限Dao
 */
@Mapper
public interface MenuRoleDao {
    //根据角色id查询菜单id
    List<MenuRoleEntity> selectMenuIdByRoleId(String roleId);
    //插入菜单角色id
    void insertMenuRole(MenuRoleEntity menuRole);
    //根据角色id删除菜单权限
    int deleteByRoleId(String roleId);
}
