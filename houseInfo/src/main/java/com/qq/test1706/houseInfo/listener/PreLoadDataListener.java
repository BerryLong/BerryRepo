package com.qq.test1706.houseInfo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.qq.test1706.houseInfo.service.HouseService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.qq.test1706.houseInfo.service.LocationService;

/**
 * 数据预加载监听器类
 * @author 龙保运
 *
 */
public class PreLoadDataListener implements ServletContextListener {
	
	/**
	 * 预加载省份信息和房源类型信息
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//servlet的上下文
		ServletContext servletContext = sce.getServletContext();
		//通过WebApplicationContextUtils工具类获取ico容器上下文
		WebApplicationContext wac =
				WebApplicationContextUtils.getWebApplicationContext(servletContext);
		//获取服务类的服务对象
		HouseService houseService = wac.getBean(HouseService.class);
		LocationService locationService = wac.getBean(LocationService.class);
		
		servletContext.setAttribute("houseTypeList", houseService.listAllHouseTypes());
		servletContext.setAttribute("provinceList", locationService.listAllProvince());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		servletContext.removeAttribute("houseTypeList");
		servletContext.removeAttribute("provinceList");
	}
	
	

}
