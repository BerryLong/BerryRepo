package com.qq.houseInfo.persistence;

import java.util.List;

import com.qq.houseInfo.domain.City;
import com.qq.houseInfo.domain.District;

/**
 * 区域信息持久层相关操作接口
 * @author 龙保运
 *
 */
public interface DistrictDao extends BaseDao<District, Integer> {
	
	/**
	 * 根据城市信息加载所有对应的地区信息
	 * @param city 城市对象
	 * @return 地区信息容器
	 */
	List<District> findAllByCity(City city);

}
