package com.qq.test1706.houseInfo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.qq.test1706.houseInfo.domain.HousePhoto;
import com.qq.test1706.houseInfo.dto.SearchHouseParam;
import com.qq.test1706.houseInfo.persistence.HouseDao;
import com.qq.test1706.houseInfo.persistence.HousePhotoDao;
import com.qq.test1706.houseInfo.service.HouseService;
import com.qq.test1706.houseInfo.util.HQLQueryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.qq.test1706.houseInfo.domain.House;
import com.qq.test1706.houseInfo.domain.HouseType;
import com.qq.test1706.houseInfo.persistence.HouseTypeDao;
import com.qq.test1706.houseInfo.util.PageBean;
import com.qq.test1706.houseInfo.util.QueryBean;

/**
 * 房源信息相关操作业务接口实现类
 * @author 龙保运
 *
 */
@Service
@Transactional
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseDao houseDao;
	@Autowired
	private HouseTypeDao houseTypeDao;
	@Autowired
	private HousePhotoDao housePhotoDao;
	@Autowired
	private RedisTemplate<String,List<HouseType>> redisTemplate;

	@Override
	public Integer publishNewHouseInfo(House house) {
		return houseDao.save(house);
	}

	@Override
	public List<HouseType> listAllHouseTypes() {
		List<HouseType> houseTypeList =
				redisTemplate.opsForValue().get("houseTypeList");
		if(houseTypeList == null){
			houseTypeList = houseTypeDao.findAll();
			redisTemplate.opsForValue().set("houseTypeList",houseTypeList);
		}
		return houseTypeList;
	}

	@Override
	public PageBean<House> findAllHouseInfo(int page, int size) {
		return houseDao.findAll(page, size);
	}

	@Override
	public boolean saveOthersPhoto(HousePhoto housePhoto) {
		
		return housePhotoDao.save(housePhoto) != null;
	}

	@Override
	public PageBean<House> serchHousesByParamAndPage(SearchHouseParam param, int page, int size) {
		QueryBean queryBean = new HQLQueryBean(House.class)
				.addCondition("title like ?", "%"+param.getTitle()+"%")
				.addCondition(param.getHouseType().getId() != 0 ,"houseType =?", param.getHouseType())
				.addCondition("price<=?", param.getMaxPrice())
				.addCondition("price>=?", param.getMinPrice())
				.addCondition("area>=?", param.getMinArea())
				.addCondition("area<=?", param.getMaxArea())
				.addOrderBy("pubDate", false);
		return houseDao.findByQueryAndPage(queryBean, page, size);
	}

}
