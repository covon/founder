package com.founder.service.infs;



import com.founder.entity.UserEntity;

import java.util.List;

public interface IUserService {
    //查询所有用户信息
    List<UserEntity> searchUserList();
    //根据用户名密码查询用户对象
    UserEntity searchUserByUP(UserEntity user);
}
