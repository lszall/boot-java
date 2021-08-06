package com.jx.platform.framework.security;

import com.jx.platform.framework.config.aop.LogFilter;
import com.jx.platform.framework.security.jwt.JwtAuthenticationFilter;
import com.jx.platform.framework.security.login.JsonAuthenticationFailureHandler;
import com.jx.platform.framework.security.login.JsonAuthenticationSuccessHandler;
import com.jx.platform.framework.security.login.JsonLoginConfigurer;
import com.jx.platform.framework.security.login.JsonUsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableGlobalMethodSecurity(prePostEnabled = true)// 开启方法注解使用 @PreAuthorize()
@EnableWebSecurity
public class SercurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PlatfromUserDetailService platfromUserDetailService;


    /**
     * 自定义密码加密类
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        auth.authenticationProvider(daoAuthenticationProvider);
        //区分用户名和密码错误
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(platfromUserDetailService);
        // auth.userDetailsService(platfromUserDetailService);
    }

    /**
     * token 认证过滤器
     */
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private JsonAuthenticationFailureHandler jsonAuthenticationFailureHandler;
    @Autowired
    private JsonAuthenticationSuccessHandler jsonAuthenticationSuccessHandler;

    @Autowired
    private JsonUsernamePasswordAuthenticationFilter authFilter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 开启跨域
        http.cors().and().csrf().disable()
                .formLogin().disable()
                .authorizeRequests()
                .antMatchers("/home/logout").permitAll()
                .antMatchers("/anon/**").permitAll()
                .antMatchers("/authenticated/b").hasAnyRole("admin")
                .antMatchers("/authenticated/c").hasAnyRole("dmind")
                .anyRequest().authenticated()
                .and()
                .apply(new JsonLoginConfigurer<>(authFilter)).loginSuccessHandler(jsonAuthenticationSuccessHandler).loginFailureHandler(jsonAuthenticationFailureHandler)
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new LogFilter(), UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().disable()
        ;
    }


}
