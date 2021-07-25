package com.jx.platform.framework.security.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.stereotype.Component;

/**
 * 使用JSON方式取代formLogin登录
 * @param <T>
 * @param <B>
 */
public class JsonLoginConfigurer<T extends JsonLoginConfigurer<T, B>, B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T, B> {

	private JsonUsernamePasswordAuthenticationFilter authFilter;

	public JsonLoginConfigurer(JsonUsernamePasswordAuthenticationFilter authFilter) {
		this.authFilter = authFilter;
	}
	
	@Override
	public void configure(B http) throws Exception {
		authFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
		authFilter.setSessionAuthenticationStrategy(new NullAuthenticatedSessionStrategy());
		JsonUsernamePasswordAuthenticationFilter filter = postProcess(authFilter);
		http.addFilterAfter(filter, LogoutFilter.class);
	}

	/**
	 * 登录成功回调
	 * @param authSuccessHandler
	 * @return
	 */
	public JsonLoginConfigurer<T,B> loginSuccessHandler(AuthenticationSuccessHandler authSuccessHandler){
		authFilter.setAuthenticationSuccessHandler(authSuccessHandler);
		return this;
	}

	/**
	 * 登录失败回调
	 * @param failureHandler
	 * @return
	 */
	public JsonLoginConfigurer<T,B> loginFailureHandler(AuthenticationFailureHandler failureHandler){
		authFilter.setAuthenticationFailureHandler(failureHandler);
		return this;
	}

}
