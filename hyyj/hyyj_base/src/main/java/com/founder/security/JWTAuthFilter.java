package com.founder.security;


import com.founder.utils.JWTManagerUtils;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class JWTAuthFilter extends BasicAuthenticationFilter {


    public JWTAuthFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        if("/login/loginIn".equals(request.getRequestURI())){
            return true;
        }
        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入了过滤器:"+request.getRequestURI());
        //从cookie中获取JWT
        Cookie[] cookies=request.getCookies();
        String token="";
        if(cookies!=null){
            for(Cookie cookie:cookies){
                if("token".equals(cookie.getName())){
                    token=cookie.getValue();
                }
            }
        }

        if(JWTManagerUtils.vaild(token,"Founder")){
            Claims claims= JWTManagerUtils.getClaims(token,"Founder");
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken("sss", null, new ArrayList()));
            chain.doFilter(request, response);
        }else {
            if(isAjaxRequest(request,response)){
                ajaxHttpToLogin(request,response,"/login.html");
            }else {
                request.getRequestDispatcher("/login.html").forward(request, response);
            }
        }
    }

    private boolean isAjaxRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            //判断是否为ajax请求。
            String ss=request.getHeader("x-requested-with");
            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void ajaxHttpToLogin(HttpServletRequest request, HttpServletResponse response, String loginUrl) {
        //如果是ajax请求响应头会有x-requested-with,自定义707状态码为ajax登录过期
        try {
            //设置session
            response.setHeader("SESSIONSTATUS", "TIMEOUT");
            response.setHeader("CONTEXTPATH", request.getContextPath() +loginUrl);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);//403 禁止
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
