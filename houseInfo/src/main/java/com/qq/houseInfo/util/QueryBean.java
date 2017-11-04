package com.qq.houseInfo.util;

import java.util.List;

/**
 * 查询对象接口（生成查询和查记录数的查询语句）
 * @author 龙保运
 *
 */
public interface QueryBean {
	
	/**
	 * 是否添加查询的条件方法
	 * @param flag 是否标志
	 * @param codition 条件名称
	 * @param value 条件的值
	 */
	QueryBean addCondition(boolean flag,String codition,Object value);
	
	/**
	 * 确定添加查询方法
	 * @param codition 查询条件
	 * @param value 条件值
	 */
	default QueryBean addCondition(String codition,Object value) {
		return addCondition(true, codition, value);
	}
	
	/**
	 * 是否添加排序条件
	 * @param flag flag 是否添加标志
	 * @param keyword 排序的关键字段
	 * @param asc 是否设置默认升序
	 */
	QueryBean addOrderBy(boolean flag,String keyword,boolean asc);
	/**
	 *  确定添加排序条件
	 * @param keyword 排序的关键字段
	 * @param asc 是否设置默认升序
	 */
	default QueryBean addOrderBy(String keyword,boolean asc) {
		return addOrderBy(true, keyword, asc);
	}
	/**
	 * 确定添加升序的排序条件
	 * @keyword keyword 排序的关键字段
	 */
	default QueryBean addOrderBy(String keyword) {
		return addCondition(true, keyword, true);
	}
	
	/**
	 * 获得所有参数
	 * @return
	 */
	List<Object> getParamters();
	/**
	 * 获得查询语句
	 */
	String getQueryString();
	
	/**
	 * 获得总记录数的语句
	 */
	String getCountString();

}
