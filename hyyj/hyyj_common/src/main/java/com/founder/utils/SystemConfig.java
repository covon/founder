package com.founder.utils;

public class SystemConfig {
	/*------------------------系统常量配置------------------------------*/
	/*
	 * 管理员权限定义
	 */
	public static final int EC_MANAGER=1;//系统管理员
	public static final int EC_USER=0;//普通用户
	
	/*
	 *五大要素定义 
	 */
	public static final int HUMAN=1;//人
	public static final int LAND=2;//地
	public static final int AFFAIRS=3;//事
	public static final int THINGS=4;//物
	public static final int ORGANIZATIONS=5;//组织
	/*
	 * 是否标准模型
	 */
	public static final int STANDARD=0;//标准
	public static final int NOTSTANDARD=1;//非标准
	/*
	 * 模型使用标识
	 */
	public static final int NOTCANCEL=0;//未注销
	public static final int CANCEL=1;//注销

	/*
	 * 审核状态定义
	 */
	public static final String NOTVIEW="0";//未查看
	public static final String PASS="1";//通过
	public static final String FAILED="2";//未通过	
	
	
	public static final int page=8;
}
