package com.qq.test1706.houseInfo.persistence.impl;

import java.util.List;

import com.qq.test1706.houseInfo.domain.City;
import org.springframework.stereotype.Repository;

import com.qq.test1706.houseInfo.domain.District;
import com.qq.test1706.houseInfo.persistence.BaseDaoadapter;
import com.qq.test1706.houseInfo.persistence.DistrictDao;

/**
 * 区域信息持久层相关操作接口实现类
 * @author 龙保运
 *
 */
@Repository
public class DistrictDaoImpl 
		extends BaseDaoadapter<District, Integer> 
		implements DistrictDao {

	@Override
	public List<District> findAllByCity(City city) {
		return sessionFactory.getCurrentSession()
				.createQuery("from District as d where d.city=:city",District.class)
				.setParameter("city", city)
				.getResultList();
	}

}
