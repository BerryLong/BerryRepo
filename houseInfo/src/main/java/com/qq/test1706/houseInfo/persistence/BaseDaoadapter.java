package com.qq.test1706.houseInfo.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 持久层适配器实现类
 * @author 龙保运
 *
 * @param <E> 需要持久化的对象
 * @param <K> 持久化对象的主键
 */
public abstract class BaseDaoadapter <E,K extends Serializable> implements BaseDao<E, K>{

	@Autowired
	protected SessionFactory sessionFactory;
	private Class<E> entityType;
	private String entityName;
	
	/**
	 *entityType   获取持久化对象的所属类型
	 *entityName 对象的名称
	 */
	protected BaseDaoadapter() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityType = (Class<E>) pt.getActualTypeArguments()[0];
		entityName = entityType.getSimpleName();
	}
	
	@Override
	public K save(E entity) {
		return (K) sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public boolean deleteById(K id) {
		return sessionFactory.getCurrentSession()
				.createQuery("delete from "+ entityName +" as o where o.id=:id")
				.setParameter("id", id)
				.executeUpdate() == 1;
	}

	@Override
	public void delete(K entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}
	@Override
	public boolean update(E entity) {
		sessionFactory.getCurrentSession().merge(entity);
		return true;
	}

	@Override
	public List<E> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from "+entityName,entityType).getResultList();
	}

	@Override
	public E findById(K id) {
		return sessionFactory.getCurrentSession().get(entityType, id);
	}

	
	
}
