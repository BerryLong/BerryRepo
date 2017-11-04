package com.qq.houseInfo.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qq.houseInfo.domain.LoginLog;
import com.qq.houseInfo.domain.User;
import com.qq.houseInfo.dto.UserLoginDto;
import com.qq.houseInfo.dto.UserRegistDto;
import com.qq.houseInfo.persistence.LoginLogDao;
import com.qq.houseInfo.persistence.UserDao;
import com.qq.houseInfo.service.UserService;

/**
 * 用户相关业务类实现类
 * @author 龙保运
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;

	@Override
	public boolean regist(UserRegistDto userRegistDto) {
		boolean flag = false;
		User temp = userDao.findByUsername(userRegistDto.getUsername());
		if(temp == null) {
			User user = new User();
			String md5 = DigestUtils.md5Hex(userRegistDto.getPassword());
			user.setUsername(userRegistDto.getUsername());
			user.setPassword(md5);
			user.setTel(userRegistDto.getTel());
			user.setRealName(userRegistDto.getRealName());
			user.setAdmin(false);
			flag = userDao.save(user) != null;
		}
		return flag;
	}

	@Override
	public boolean login(UserLoginDto userLoginDto) {
		boolean flag = false;
		User temp = userDao.findByUsername(userLoginDto.getUsername());
		if(temp!=null) {
			String md5 = DigestUtils.md5Hex(userLoginDto.getPassword());
			flag = temp.getPassword().equals(md5);
			if(flag) {
				userLoginDto.setRealName(temp.getRealName());
				userLoginDto.setId(temp.getId());
				LoginLog loginLog = new LoginLog();
				loginLog.setLogDate(new Date());
				loginLog.setUser(temp);
				loginLog.setIpAddr(userLoginDto.getIpAddress());
				loginLogDao.save(loginLog);
			}
		}
		return flag;
	}

	@Override
	public User CheckUnique(String username) {
		return userDao.findByUsername(username);
	}

}
