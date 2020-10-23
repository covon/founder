package com.founder.utils;

import com.founder.entity.MenuNodeEntity;
import com.founder.entity.UserSessionEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * UserSession的操作工具
 * @ClassName UserSessionUtils
 * @Description TODO
 * @author WangBo
 * @date 2016年8月31日
 */
public class UserSessionUtils {

	/**
	 * 将UserSession对象保存在session中的usersession键
	 */
	public static final String userSessionKey = "usersession";
	public static final String nodeSessionKey = "nodesession";
	private UserSessionUtils() {
		super();
	}
	
	/**
	 * 获取userSession对象
	* @Title: getUserSession 
	* @Description: TODO
	* @author WangBo
	* @param session    
	* @return UserSessionEntity    
	* @throws
	 */
	public static UserSessionEntity getUserSession(HttpSession session) {
		UserSessionEntity us = (UserSessionEntity)session.getAttribute(userSessionKey);
		return us;
	}
	public static UserSessionEntity getUserSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserSessionEntity us = (UserSessionEntity)session.getAttribute(userSessionKey);
		return us;
	}
	
	/**
	 * 保持UserSession对象到session中
	* @Title: setUserSession 
	* @Description: TODO
	* @param  us
	* @param  session     
	* @return void    
	* @throws
	 */
	public static void setUserSession(UserSessionEntity us, HttpSession session){
		session.setAttribute(userSessionKey,us);
	}
	
	/**
	 * 从session中删除usersession
	* @Title: removeUserSession 
	* @Description: TODO
	* @param session     
	* @return void    
	* @throws
	 */
	public static void removeUserSession(HttpSession session){
		session.removeAttribute(userSessionKey);
	}
	
	/**
	 * 构建userSession
	* @Title: buildUserSession 
	* @Description: TODO
	* @param us
	* @param session     
	* @return UserSessionEntity    
	* @throws
	 */
	public static UserSessionEntity buildUserSession(UserSessionEntity us, HttpSession session){
		setUserSession(us,session);
		return us;
	}
	
	/**
	 * 在session中得到 MenuNodeEntity
	* @Title: getNodeSession 
	* @Description: TODO
	* @param session
	* @param @return     
	* @return MenuNodeEntity    
	* @throws
	 */
	public static MenuNodeEntity getNodeSession(HttpSession session) {
		MenuNodeEntity node = (MenuNodeEntity)session.getAttribute(nodeSessionKey);
		return node;
	}
	
	/**
	 * 保持NodeSession对象到session中
	* @Title: setNodeSession 
	* @Description: TODO
	* @param us
	* @param @param session     
	* @return void    
	* @throws
	 */
	public static void setNodeSession(MenuNodeEntity node, HttpSession session){
		session.setAttribute(nodeSessionKey,node);
	}
	
	/**
	 * 从session中删除nodesession
	* @Title: removeNodeSession 
	* @Description: TODO
	* @param session     
	* @return void    
	* @throws
	 */
	public static void removeNodeSession(HttpSession session){
		session.removeAttribute(nodeSessionKey);
	}
	/**
	 * 
	* @Title: buildNodeSession 
	* @Description: TODO
	* @param  node
	* @param  session
	* @param @return     
	* @return MenuNodeEntity    
	* @throws
	 */
	public static MenuNodeEntity buildNodeSession(MenuNodeEntity node, HttpSession session){
		setNodeSession(node,session);
		return node;
	}
}
