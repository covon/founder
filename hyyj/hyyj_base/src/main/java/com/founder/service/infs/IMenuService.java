package com.founder.service.infs;


import com.founder.entity.MenuEntity;
import com.founder.entity.MenuNodeEntity;

import java.util.List;

public interface IMenuService {
    //根据层级查询菜单信息
    List<MenuEntity> searchMenu();
    //根据角色id查询菜单信息
    List<MenuNodeEntity> searchMenuRoleByRoleId(String roleId);

}
