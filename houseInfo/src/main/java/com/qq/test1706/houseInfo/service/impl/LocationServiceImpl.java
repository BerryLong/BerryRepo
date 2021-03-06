package com.qq.test1706.houseInfo.service.impl;

import java.util.List;

import com.qq.test1706.houseInfo.domain.City;
import com.qq.test1706.houseInfo.domain.District;
import com.qq.test1706.houseInfo.persistence.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qq.test1706.houseInfo.domain.Province;
import com.qq.test1706.houseInfo.persistence.DistrictDao;
import com.qq.test1706.houseInfo.persistence.ProvinceDao;
import com.qq.test1706.houseInfo.service.LocationService;

/**
 * 省市区信息相关操作业务接口实现类
 * @author 龙保运
 *
 */
@Service
@Transactional(readOnly=true)
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private ProvinceDao provinceDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private DistrictDao districtDao;

	@Override
	public List<Province> listAllProvince() {
		return provinceDao.findAll();
	}

	@Override
	public List<City> ListAllCitiesByProvince(Province province) {
		return cityDao.findAllByProvince(province);
	}

	@Override
	public List<District> listAllDistrictsByCity(City city) {
		return districtDao.findAllByCity(city);
	}

}
