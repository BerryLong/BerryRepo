package com.qq.test1706.houseInfo.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC拦截器
 * @author 龙保运
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	/**
	 * 拦截未登录的操作
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		if(userId != null) {
			return true;
		} else {
			String URL = request.getRequestURL().toString();
			String beforeURL = URL.substring(URL.lastIndexOf("/")+1);
			request.getSession().setAttribute("beforeURL", beforeURL);
			
			String hint = URLEncoder.encode("请先登录","utf-8");
			response.sendRedirect("toLogin?hint="+hint);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
