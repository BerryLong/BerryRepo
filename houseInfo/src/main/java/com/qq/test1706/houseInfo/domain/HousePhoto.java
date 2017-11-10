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
 * 售房的主图类
 * @author 龙保运
 *
 */
@Entity
@Table(name="tb_house_photo")
public class HousePhoto implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="photoid") 
	private Integer id;				 //主图编号
	@Column(name="photoname")
	private String name;			//主图名称
	@ManyToOne
	@JoinColumn(name = "house_id")
	private House house;		//所属的售房
	
	public HousePhoto() {}
	public HousePhoto(String name) {
		this.name = name;
	}
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
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}

}
