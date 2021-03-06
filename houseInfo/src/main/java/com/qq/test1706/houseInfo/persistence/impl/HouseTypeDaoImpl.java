package com.qq.test1706.houseInfo.persistence.impl;

import org.springframework.stereotype.Repository;

import com.qq.test1706.houseInfo.domain.HouseType;
import com.qq.test1706.houseInfo.persistence.BaseDaoadapter;
import com.qq.test1706.houseInfo.persistence.HouseTypeDao;

/**
 * 房源类型持久层相关操作接口实现类
 * @author 龙保运
 *
 */
@Repository
public class HouseTypeDaoImpl 
		extends BaseDaoadapter<HouseType, Integer> 
		implements HouseTypeDao {

}
