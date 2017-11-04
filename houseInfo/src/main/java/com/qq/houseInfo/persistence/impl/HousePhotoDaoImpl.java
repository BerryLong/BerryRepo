package com.qq.houseInfo.persistence.impl;

import org.springframework.stereotype.Repository;

import com.qq.houseInfo.domain.HousePhoto;
import com.qq.houseInfo.persistence.BaseDaoadapter;
import com.qq.houseInfo.persistence.HousePhotoDao;

/**
 * 售房信息持久化相关操作接口实现类
 * @author 龙保运
 *
 */
@Repository
public class HousePhotoDaoImpl 
			extends BaseDaoadapter<HousePhoto, Integer>
			implements HousePhotoDao{

	
}
