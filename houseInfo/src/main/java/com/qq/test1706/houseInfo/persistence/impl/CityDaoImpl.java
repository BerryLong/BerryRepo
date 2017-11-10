package com.qq.test1706.houseInfo.persistence.impl;

import java.util.List;

import com.qq.test1706.houseInfo.domain.City;
import com.qq.test1706.houseInfo.domain.Province;
import com.qq.test1706.houseInfo.persistence.BaseDaoadapter;
import com.qq.test1706.houseInfo.persistence.CityDao;
import org.springframework.stereotype.Repository;

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
