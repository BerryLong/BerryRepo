package com.qq.houseInfo.persistence.impl;

import org.springframework.stereotype.Repository;

import com.qq.houseInfo.domain.LoginLog;
import com.qq.houseInfo.persistence.BaseDaoadapter;
import com.qq.houseInfo.persistence.LoginLogDao;

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
