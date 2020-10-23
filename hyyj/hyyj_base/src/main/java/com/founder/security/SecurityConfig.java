package com.founder.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 路径拦截相关的配置
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //系统静态资源通过
        web.ignoring().antMatchers("/static/**","/*.html","/**/favicon.ico");
        //swagger静态资源通过
        web.ignoring().antMatchers("/webjars/**","/swagger-ui.html","/swagger-resources/**","/v2/**","/api/token/getClaims");
        //可以仿照上面一句忽略静态资源
    }

    /**
     * 设置安全策略，即那些直接可以访问
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // 对请求进行认证
        http.authorizeRequests().
                mvcMatchers(HttpMethod.POST,"/login/loginIn").permitAll().
                anyRequest().authenticated()
                .and().formLogin().loginPage("/login.html").permitAll().and().logout().permitAll();
        http.addFilterBefore(new JWTAuthFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }


}
