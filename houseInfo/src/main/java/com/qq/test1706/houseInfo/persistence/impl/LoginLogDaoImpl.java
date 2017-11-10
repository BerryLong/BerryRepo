package com.qq.test1706.houseInfo.persistence.impl;

import com.qq.test1706.houseInfo.persistence.BaseDaoadapter;
import com.qq.test1706.houseInfo.persistence.LoginLogDao;
import org.springframework.stereotype.Repository;

import com.qq.test1706.houseInfo.domain.LoginLog;

/**
 * 登录日志持久层相关操作实现类
 * @author 龙保运
 *
 */
@Repository
public class LoginLogDaoImpl 
		extends BaseDaoadapter<LoginLog, Integer>
		implements LoginLogDao {

}
