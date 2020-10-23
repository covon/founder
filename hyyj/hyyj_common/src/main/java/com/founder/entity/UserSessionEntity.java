package com.founder.entity;

import java.io.Serializable;

/**
 * 用户登录信息实体类
 * 
 * @ClassName UserSessionEntity
 * @Description TODO
 * @author WangBo 
 * @date 2016年8月31日
 */
public class UserSessionEntity implements Serializable{

	private static final long serialVersionUID = 9151007869979456601L;
	
	private String userid;  //用户登录名
	private String name;    //用户名称
	private String password; //登录密码
	private String role;    //用户角色

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
