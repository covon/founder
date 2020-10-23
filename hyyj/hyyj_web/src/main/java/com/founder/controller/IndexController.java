package com.founder.controller;

import com.founder.controller.common.BaseController;
import com.founder.entity.JsonResult;
import com.founder.entity.MenuNodeEntity;
import com.founder.entity.UserSessionEntity;
import com.founder.service.infs.IMenuService;
import com.founder.utils.UserSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController extends BaseController {
	@Autowired
    IMenuService menuService;
	/**
	 * 请求页面初始化类
	 * @return
	 */
	@RequestMapping("/init")
	public ModelAndView init(){
		ModelAndView mv=new ModelAndView("index");
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		UserSessionEntity user = UserSessionUtils.getUserSession(session);

		JsonResult result = new JsonResult();
		List<MenuNodeEntity> menuList= menuService.searchMenuRoleByRoleId(user.getRole());
		mv.addObject("menuList", menuList);
		mv.addObject("userSession", getUserSession());
		return mv;
	}
	/**
	 * 请求页面初始化
	 * @return
	 */
	@PostMapping("/genMenuList")
	public List<MenuNodeEntity> genMenuList(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		UserSessionEntity user = UserSessionUtils.getUserSession(session);

		JsonResult result = new JsonResult();
		List<MenuNodeEntity> menuList= menuService.searchMenuRoleByRoleId(user.getRole());
		return menuList;
	}
	/**
	 * 请求页面初始化
	 * @return
	 */
	@GetMapping("/getValue")
	public String getValue(){
		String ss="hellow word";
		return ss;
	}
}
