package com.qq.test1706.houseInfo.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * 持久层相关操作接口
 * @author 龙保运
 *
 */
public interface BaseDao<E,K extends Serializable>  {
	/**
	 * 保存一个实体信息
	 * @param entity 实体对象
	 * @return
	 */
	K save(E entity);
	
	/**
	 * 按id删除一个实体信息
	 * @param id 实体的主键
	 * @return
	 */
	boolean deleteById(K id);
	
	void delete(K entity);
	/**
	 * 修改一个实体信息
	 * @param entity 实体对象
	 * @return
	 */
	boolean update(E entity);
	
	/**
	 * 查找所有实体信息
	 * @return
	 */
	List<E> findAll();
	
	/**
	 * 通过id查找实体信息
	 * @param id
	 * @return
	 */
	E findById(K id);
}
