package com.founder.service.impl;

import com.founder.dao.MenuDao;
import com.founder.entity.MenuEntity;
import com.founder.entity.MenuNodeEntity;
import com.founder.service.infs.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理Service.
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuDao menuDao;

    public List<MenuEntity> searchMenu() {
        List<MenuEntity> oneLevels = menuDao.selectMenuByLevel("1");    //获取所有的一级菜单集合
        List<MenuEntity> twoLevels = menuDao.selectMenuByLevel("2");    //获取所有的二级菜单集合
        for(MenuEntity oneLevel : oneLevels){
            for(MenuEntity twoLevel : twoLevels){
                String menuId = oneLevel.getMenuId();                   //获取一级菜单的id
                String parentMenuId = twoLevel.getParentMenuId();       //获取二级菜单的父id
                if(menuId.equals(parentMenuId)){                        //若id一致，则将二级菜单添加到一级菜单集合中
                    oneLevel.getMenus().add(twoLevel);
                }
            }
        }
        return oneLevels;
    }

    public List<MenuNodeEntity> searchMenuRoleByRoleId(String roleId) {
        List<MenuNodeEntity> menuList= menuDao.selectOneLevelMenuRole(roleId);
        for(MenuNodeEntity mn:menuList){
            Map <String,String> menumap=new HashMap<String,String>();
            menumap.put("roleid",roleId);
            menumap.put("menuid",mn.getMenuid());
            List<MenuNodeEntity> cmenuList=menuDao.selectTwoLevelMenuRole(menumap);
            if(cmenuList!=null&&cmenuList.size()>0){
                mn.setCNodes(cmenuList);
                mn.setHasChild(true);
            }else{
                mn.setHasChild(false);
            }
        }
        return menuList;
    }


}
