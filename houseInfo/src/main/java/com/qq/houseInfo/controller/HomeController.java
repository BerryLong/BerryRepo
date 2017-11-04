package com.qq.houseInfo.controller;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qq.houseInfo.domain.City;
import com.qq.houseInfo.domain.District;
import com.qq.houseInfo.domain.Province;
import com.qq.houseInfo.service.LocationService;
import com.qq.houseInfo.util.CommonsUtil;

/**
 * 页面跳转控制器类
 * @author 龙保运
 *
 */
@Controller
public class HomeController {

	private static final int CODE_IMAGE_HEIGHT = 30;
	private static final int CODE_IMAGE_WIDTH = 80;
	private static final int CODE_LENGTH = 4;
	
	@Autowired
	private LocationService locationService;

	/**
	 * 测试异常页面
	 */
	@RequestMapping("/error")
	public String toException() {
		System.out.println(8/0);
		return "index";
	}
	
	/**
	 * 跳转到登录页
	 */
	@GetMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	/**
	 * 跳转到注册页
	 */
	@GetMapping("/toReg")
	public String toRegist() {
		return "regist";
	}

	/**
	 * 生成验证码
	 */
	@GetMapping(value = "/doCode",produces = "image/png")
	@ResponseBody
	public BufferedImage getCodeImage(HttpSession session) throws Exception {
		String code = CommonsUtil.generateCode(CODE_LENGTH);
		session.setAttribute("code", code);
		return CommonsUtil.generateCodeImage(code, CODE_IMAGE_WIDTH, CODE_IMAGE_HEIGHT);
	}
	
	/**
	 *  跳转到添加房源页面
	 */
	@GetMapping("/toPub")
	public String toPub() {
		
		return "pub";
	}
	
	/**
	 * 根据省份加载城市信息
	 * @param province 省份对象
	 * @return 城市信息容器
	 */
	@GetMapping("/cities")
	@ResponseBody
	public List<City> getCities(Province province){
		return locationService.ListAllCitiesByProvince(province);
	}
	
	/**
	 * 根据城市信息加载地区信息
	 * @param city 城市信息
	 * @return 地区信息的容器
	 */
	@GetMapping("/districts")
	@ResponseBody
	public List<District> getDistricts(City city){
		return locationService.listAllDistrictsByCity(city);
	}
}
