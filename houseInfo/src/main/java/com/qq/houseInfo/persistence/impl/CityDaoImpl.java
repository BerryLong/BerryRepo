package com.qq.houseInfo.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qq.houseInfo.domain.City;
import com.qq.houseInfo.domain.Province;
import com.qq.houseInfo.persistence.BaseDaoadapter;
import com.qq.houseInfo.persistence.CityDao;

/**
 * 城市信息持久层相关操作接口实现类
 * @author 龙保运
 *
 */
@Repository
public class CityDaoImpl 
		extends BaseDaoadapter<City, Integer> 
		implements CityDao {

	@Override
	public List<City> findAllByProvince(Province province) {
		return sessionFactory.getCurrentSession()
				.createQuery("from City as c where c.province=:province",City.class)
				.setParameter("province", province)
				.getResultList();
	}

}
