package com.qq.houseInfo.service;

import com.qq.houseInfo.domain.User;
import com.qq.houseInfo.dto.UserLoginDto;
import com.qq.houseInfo.dto.UserRegistDto;

/**
 * 用户相关业务类
 * @author 龙保运
 *
 */
public interface UserService {
	
	/**
	 * 登录
	 * @param user
	 * @return 登陆成功返回true,否则返回false
	 */
	boolean regist(UserRegistDto userRegistDto);

	/**
	 * 注册
	 * @param user
	 * @return 注册成功返回true,否则返回false
	 */
	boolean login(UserLoginDto userLoginDto);
	
	/**
	 * 检查用户名是否可以注册
	 * @return 用户对象
	 */
	User CheckUnique(String username);
}
