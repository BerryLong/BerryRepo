package com.qq.test1706.houseInfo.persistence;

import com.qq.test1706.houseInfo.domain.House;
import com.qq.test1706.houseInfo.util.PageBean;
import com.qq.test1706.houseInfo.util.QueryBean;

/**
 * 售房信息持久化相关操作接口类
 * @author 龙保运
 *
 */
public interface HouseDao extends BaseDao<House, Integer> {
	
	/**
	 * 分页显示所有的售房信息
	 * @param page 当前页
	 * @param size 显示数量
	 * @return 分页器
	 */
	PageBean<House> findAll(int page,int size);
	
	/**
	 * 通过制定的查询语句查询数据
	 * @param ql 查询语句
	 * @param page 当前页
	 * @param size 显示数量
	 * @return 分页器
	 */
	PageBean<House> findByQueryAndPage(QueryBean queryBean,int page,int size);

}
