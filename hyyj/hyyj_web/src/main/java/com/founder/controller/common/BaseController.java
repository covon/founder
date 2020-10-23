package com.founder.controller.common;


import com.founder.entity.UserSessionEntity;
import com.founder.utils.Logger;
import com.founder.utils.PageData;
import com.founder.utils.UserSessionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {

	protected Logger logger = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 6357869213649815390L;
	
	/**
	 * 得到PageData
	 */
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}

	/**
	 * 获取respon
	 * @return
	 */
	public HttpServletResponse getRespon(){
		HttpServletResponse resp = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
		return resp;
	}
	/**
	 * 得到session对象
	 * @return
	 */
	public HttpSession getSession(){
		return getRequest().getSession();
	}
	/**
	 * 将用户信息存入session
	 * @param userSession
	 */
	public void createUserSession(UserSessionEntity userSession){
		UserSessionUtils.buildUserSession(userSession, getSession());
	}
	/**
	 * 获得UserSession
	 * @return
	 */
	public UserSessionEntity getUserSession(){
		return UserSessionUtils.getUserSession(getRequest());
	}
	/**
	 * 获得用户ID
	 * @return
	 */
	public String getUserID(){
		String userId=getUserSession().getUserid();
		return userId;
	}
	public String getUserName(){
		String userName=getUserSession().getName();
		return userName;
	}
	
	
	/**
	 * 删除UserSession
	 */
	public void removeUserSession(){
		UserSessionUtils.removeUserSession(getSession());
	}
	
	/**
	 * 获得完整的访问路径
	 * @return
	 */
	public String getBasePath(){
		HttpServletRequest request =getRequest();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ request.getContextPath(); 
		return basePath;
	}
	
	
	public static void logBefore(Logger logger, String interfaceName){
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}
	
	public static void logAfter(Logger logger){
		logger.info("end");
		logger.info("");
	}

	
}
