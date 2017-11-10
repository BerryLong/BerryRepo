package com.qq.test1706.houseInfo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用Hibernate查询接口实现类
 * @author 龙保运
 *
 */
public class HQLQueryBean implements QueryBean {
	
	private String fromClouse;			//from子句
	private String whereClouse;			//where子句
	private String ordebyClouse;		//order by子句 
	
	private List<Object> prameValues = new ArrayList<>();
	
	public HQLQueryBean(Class<?> entyType) {
		fromClouse = "from "+ entyType.getSimpleName() +" as o";
	}

	@Override
	public QueryBean addCondition(boolean flag, String codition, Object value) {
		if (flag) {
			if (whereClouse == null) {
				whereClouse = " where o." + codition;
			} else {
				whereClouse += " and o." + codition;
			}
			prameValues.add(value);
		}
		return this;
	}

	@Override
	public QueryBean addOrderBy(boolean flag, String keyword, boolean asc) {
		if(flag) {
			if(ordebyClouse == null) {
				ordebyClouse = " order by o."+keyword+(asc?" asc ":" desc ");
			}else {
				ordebyClouse += ",o."+keyword+(asc?" asc ":" desc ");
			}
		}
		return this;
	}

	@Override
	public List<Object> getParamters() {
		return prameValues;
	}

	@Override
	public String getQueryString() {
		return fromClouse +" "+whereClouse +" "+ordebyClouse;
	}

	@Override
	public String getCountString() {
		return "select count(o)" + fromClouse +" "+whereClouse;
	}

}
