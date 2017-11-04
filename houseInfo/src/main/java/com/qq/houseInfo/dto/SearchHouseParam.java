package com.qq.houseInfo.dto;

import com.qq.houseInfo.domain.HouseType;

/**
 * 查询数据DTO类
 * @author 龙保运
 *
 */
public class SearchHouseParam {
	
	private String title;							//房源标题
	private String price;							//房源价格
	private HouseType houseType;		//房源类型
	private String area;							//房源面积
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getMinPrice() {
		return this.price.equals("不限") ? 0.0 : Double.parseDouble(this.price.split("-")[0]);
	}
	public double getMaxPrice() {
		return this.price.equals("不限") ? Double.MAX_VALUE : Double.parseDouble(this.price.split("-")[1]);
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public HouseType getHouseType() {
		return houseType;
	}
	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}
	public Integer getMinArea() {
		return this.area.equals("不限") ? 0 : Integer.parseInt(this.area.split("-")[0]);
	}
	public Integer getMaxArea() {
		return this.area.equals("不限") ? Integer.MAX_VALUE : Integer.parseInt(this.area.split("-")[1]);
	}
	public void setArea(String area) {
		this.area = area;
	}

}
