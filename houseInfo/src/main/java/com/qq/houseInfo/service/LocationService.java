package com.qq.houseInfo.service;

import java.util.List;

import com.qq.houseInfo.domain.City;
import com.qq.houseInfo.domain.District;
import com.qq.houseInfo.domain.Province;

/**
 * 省市区信息相关操作业务接口
 * @author 龙保运
 *
 */
public interface LocationService {
	
	/**
	 * 查询所有省份信息
	 * @return 省份信息容器
	 */
	List<Province> listAllProvince();
	
	/**
	 * 根据省份信息加载对应的城市信息
	 * @param province 省份对象
	 * @return 城市信息容器
	 */
	List<City> ListAllCitiesByProvince(Province province);
	
	/**
	 * 根据城市信息加载对应的地区信息
	 * @param city 城市对象
	 * @return 地区信息的容器
	 */
	List<District> listAllDistrictsByCity(City city);


}
