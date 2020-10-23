package com.founder.entity;

/**
 * 角色管理Entity
 */
public class RoleEntity extends BaseEntity {
    private String roleId;      //角色id
    private String roleName;    //角色名称

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
