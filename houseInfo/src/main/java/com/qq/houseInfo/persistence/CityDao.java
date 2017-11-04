package com.qq.houseInfo.persistence;

import java.util.List;

import com.qq.houseInfo.domain.City;
import com.qq.houseInfo.domain.Province;

/**
 * 城市信息持久层相关操作接口
 * @author 龙保运
 *
 */
public interface CityDao extends BaseDao<City, Integer> {
	
	/**
	 * 根据省份信息加载所有对应的城市信息
	 * @param province 省份对象
	 * @return 城市信息容器
	 */
	List<City> findAllByProvince(Province province);

}
