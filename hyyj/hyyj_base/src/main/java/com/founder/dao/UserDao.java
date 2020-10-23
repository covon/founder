package com.founder.dao;


import com.founder.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户管理Dao
 */
@Mapper
public interface UserDao {
    //查询所有用户信息
    List<UserEntity> selectAll();
    //根据用户名密码查询用户对象
    UserEntity selectUserByUP(UserEntity user);
}
