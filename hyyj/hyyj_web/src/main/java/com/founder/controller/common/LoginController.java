package com.founder.controller.common;


import com.founder.entity.UserEntity;
import com.founder.entity.UserSessionEntity;
import com.founder.service.infs.IUserService;
import com.founder.utils.JWTManagerUtils;
import com.founder.utils.UserSessionUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {
	@Autowired
    IUserService userService;

	@PostMapping("/loginIn")
	public Map<String,Object> loginIn(UserEntity user) {
		HttpServletRequest request =getRequest();
		HttpServletResponse respon=getRespon();
		HttpSession session = request.getSession();

		UserEntity userEntity=userService.searchUserByUP(user);
		UserSessionEntity userSessionEntity=new UserSessionEntity();
		Map<String,Object> map =new HashMap<String,Object>();
		if(userEntity!=null){
			Claims cliams= Jwts.claims();
			cliams.put("user",userEntity);
			String token= JWTManagerUtils.createToken(cliams,"Founder");
//			Cookie cookie=new Cookie("token", token);
//			cookie.setMaxAge(60*60);
//			respon.addCookie(cookie);
			userSessionEntity.setName(userEntity.getUsername());
			userSessionEntity.setRole(userEntity.getRoleId());
			UserSessionUtils.buildUserSession(userSessionEntity, session);
			map.put("success",1);
			map.put("date", "登陆成功");
			map.put("token",token);
		}else{
			map.put("success",0);
			map.put("date", "用户名或密码不正确");

		}
		return map;

	}
	
	/**
	 * 退出登录
	 * @param response
	 */
	@RequestMapping("/loginOut")
	public void loginOut(HttpServletResponse response) {
		//销毁UserSession
		removeUserSession();
		try {
			//重新访问本工程
			response.sendRedirect(getBasePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
