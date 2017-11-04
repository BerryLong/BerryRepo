package com.qq.houseInfo.persistence;

import com.qq.houseInfo.domain.User;
/**
 * 用户持久层相关操作接口类
 * @author 龙保运
 *
 */
public interface UserDao extends BaseDao<User, Integer> {
	
	/**
	 * 通过用户名查找用户 
	 * @param username 用户名
	 * @return 用户对象
	 */
	User findByUsername(String username);
}
