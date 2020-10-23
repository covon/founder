package com.founder.utils;

import com.founder.entity.UserSessionEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserInfoUtils{
	
	/**
	 * 通过RequestContextHolder获得当前s
	 * @return
	 */
	public static HttpServletRequest getReqeust(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		return request;	
	}
	
	
	private static UserSessionEntity UserSessionEntity(){
		UserSessionEntity userSessionEntity=UserSessionUtils.getUserSession(getReqeust());
		return userSessionEntity;
	}
	
	/**
	 * 获得用户ID
	 * @return
	 */
	public static String getUserId(){
		if(UserSessionEntity()==null){
			return "";
		}
		return UserSessionEntity().getUserid();
	}
	/**
	 * 获得用户名称
	 * @return
	 */
	public static String getUserName(){
		return UserSessionEntity().getName();
	}

	/**
	 * 获得用户角色
	 * @return
	 */
	public static String getUserRole(){
		return UserSessionEntity().getRole();
	}
	

	
}
