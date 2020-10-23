package com.founder.entity;

import java.util.List;

/**
 * 菜单权限Entity
 */
public class MenuRoleEntity extends BaseEntity {
    private String menuId;      //菜单id
    private String roleId;      //角色id
    private List<String> menuIds; //菜单id集合

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }
}
