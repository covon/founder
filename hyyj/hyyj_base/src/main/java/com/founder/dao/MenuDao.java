package com.founder.dao;


import com.founder.entity.MenuEntity;
import com.founder.entity.MenuNodeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理Dao.
 */
@Mapper
public interface MenuDao {
    //根据层级查询菜单信息
    List<MenuEntity> selectMenuByLevel(String level);
    //根据角色id查询一级菜单信息
    List<MenuNodeEntity> selectOneLevelMenuRole(String roleId);
    //根据角色id查询二级菜单信息
    List<MenuNodeEntity> selectTwoLevelMenuRole(Map<String, String> menumap);
}
