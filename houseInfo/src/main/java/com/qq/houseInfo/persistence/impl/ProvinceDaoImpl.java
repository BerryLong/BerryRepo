package com.qq.houseInfo.persistence.impl;

import org.springframework.stereotype.Repository;

import com.qq.houseInfo.domain.Province;
import com.qq.houseInfo.persistence.BaseDaoadapter;
import com.qq.houseInfo.persistence.ProvinceDao;

/**
 * 省份信息持久层相关操作接口实现类
 * @author 龙保运
 *
 */
@Repository
public class ProvinceDaoImpl 
		extends BaseDaoadapter<Province, Integer> 
		implements ProvinceDao {

}
