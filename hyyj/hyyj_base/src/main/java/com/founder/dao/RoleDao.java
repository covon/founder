package com.founder.dao;


import com.founder.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色管理Dao
 */
@Mapper
public interface RoleDao {
    //查询所有角色信息
    List<RoleEntity> selectAll();
    //插入角色信息
    int insertRole(RoleEntity role);
    //修改角色信息
    int updateRole(RoleEntity role);
    //删除角色信息
    int deleteRoleById(String roleId);
    //角色名称的重复校验
    int selectNameCheck(RoleEntity entity);
}
