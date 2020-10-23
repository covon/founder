package com.founder.service.impl;

import com.founder.dao.UserDao;
import com.founder.entity.UserEntity;
import com.founder.service.infs.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理Service
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    public List<UserEntity> searchUserList() {
        return userDao.selectAll();
    }

    public UserEntity searchUserByUP(UserEntity user) {
        return userDao.selectUserByUP(user);
    }

}
