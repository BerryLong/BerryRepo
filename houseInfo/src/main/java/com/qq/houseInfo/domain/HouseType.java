package com.qq.houseInfo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 售房类型类
 * @author 龙保运
 *
 */
@Entity
@Table(name="tb_house_type")
public class HouseType implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="typeid")
	private Integer id;				//类型编号
	@Column(name="typename")
	private String name; //类型名称
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String typeName) {
		this.name = typeName;
	}

}
