package com.qq.houseInfo.persistence.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qq.houseInfo.domain.House;
import com.qq.houseInfo.persistence.BaseDaoadapter;
import com.qq.houseInfo.persistence.HouseDao;
import com.qq.houseInfo.util.PageBean;
import com.qq.houseInfo.util.QueryBean;

/**
 * 售房信息持久化相关操作接口实现类
 * @author 龙保运
 *
 */
@Repository
public class HouseDaoImpl 
			extends BaseDaoadapter<House, Integer>
			implements HouseDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public PageBean<House> findAll(int page, int size) {
		//此处SQL语句避免了1+N查询问题
		List<House> houseList = sessionFactory.getCurrentSession()
				.createQuery("from House as h left join fetch h.houseType "
						+ " left join fetch h.district "
						+ " order by h.pubDate desc",House.class)
				.setFirstResult((page - 1) * size)
				.setMaxResults(size)
				.getResultList();
		int count = sessionFactory.getCurrentSession()
				.createQuery("select count(h) from House as h",Long.class)
				.getSingleResult().intValue();
		int totalPage = (count - 1) / size + 1;
		return new PageBean<>(houseList, totalPage, page, size);
	}

	@Override
	public PageBean<House> findByQueryAndPage(QueryBean queryBean, int page, int size) {
		String sql = queryBean.getQueryString();
		Query query = sessionFactory.getCurrentSession().createQuery(sql,House.class);
		for (int i = 0; i < queryBean.getParamters().size(); i++) {
			query.setParameter(i, queryBean.getParamters().get(i));
		}
		List<House> dataModel = query.setFirstResult((page - 1)*size)
				.setMaxResults(size).getResultList();
		query = sessionFactory.getCurrentSession()
				.createQuery(queryBean.getCountString());
		for (int i = 0; i < queryBean.getParamters().size(); i++) {
			query.setParameter(i, queryBean.getParamters().get(i));
		}
		int total = ((Long)query.getSingleResult()).intValue();
		int totalPage = (total - 1)/size + 1;
		return new PageBean<>(dataModel, totalPage, page, size);
	}
	
}
