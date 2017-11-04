package com.qq.houseInfo.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qq.houseInfo.domain.User;
import com.qq.houseInfo.persistence.BaseDaoadapter;
import com.qq.houseInfo.persistence.UserDao;

/**
 * 用户持久层相关操作接口实现类
 * 
 * @author 龙保运
 *
 */
@Repository
public class UserDaoImpl 
		extends BaseDaoadapter<User, Integer>
		implements UserDao {

	@Override
	public User findByUsername(String username) {
		List<User> userList = sessionFactory.getCurrentSession()
				.createQuery("from User as u where u.username=:username", User.class)
				.setParameter("username", username)
				.getResultList();
		return userList.size() == 1 ? userList.get(0) : null;
	}
}
