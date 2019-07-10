package org.ithang.tools.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HttpFilter extends HandlerInterceptorAdapter{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("前置拦截器1 preHandle： 请求的uri为："+request.getRequestURI());
		return super.preHandle(request, response, handler);
	}
	
}
