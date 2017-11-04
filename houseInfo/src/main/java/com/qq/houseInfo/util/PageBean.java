package com.qq.houseInfo.util;

import java.util.List;

/**
 * 分页器
 * @author 龙保运
 *
 * @param <T> 需要分页的数据类型
 */
public class PageBean<T> {

	private List<T> dataModel;	//存储数据的容器
	private int totalPage;			//总页数
	private int currentPage;		//当前页
	private int pageSize;				//每页显示的数量
	
	public PageBean() {}
	public PageBean(List<T> dataModel, int totalPage, int currentPage, int pageSize) {
		super();
		this.dataModel = dataModel;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	
	public List<T> getDataModel() {
		return dataModel;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	
	
	
}
