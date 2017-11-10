package com.qq.test1706.houseInfo.persistence.impl;

import com.qq.test1706.houseInfo.persistence.BaseDaoadapter;
import com.qq.test1706.houseInfo.persistence.ProvinceDao;
import org.springframework.stereotype.Repository;

import com.qq.test1706.houseInfo.domain.Province;

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
