package com.qq.test1706.houseInfo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 市级信息类
 * @author 龙保运
 *
 */
@Entity
@Table(name = "tb_city")
public class City implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cityid")
	private Integer id;  				//市级编号
	@Column(name="cityname")
	private String name;				//市级名称
	@ManyToOne
	@JoinColumn(name = "prov_id")
	private Province province;	//改城市所属省级
	
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
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}

}
