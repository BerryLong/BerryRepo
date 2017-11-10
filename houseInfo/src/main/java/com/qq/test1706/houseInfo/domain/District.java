package com.qq.test1706.houseInfo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 区域信息类
 * @author 龙保运
 *
 */
@Entity
@Table(name="tb_district")
public class District implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="distid")
	private Integer id;			//区域编号
	@Column(name="distname") 
	private String name;		//区域名称
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City	 city;			//该区域所属市级城市
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
}
