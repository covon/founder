package com.founder.entity;

/**
 * Created by 22850 on 2018/2/26.
 */
public class BaseEntity {
    protected String remark;	// 备注
    protected String createUser;	// 创建者
    protected String createTime;	// 创建日期
    protected String updateUser;	// 更新者
    protected String updateTime;	// 更新日期

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
