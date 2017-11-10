package com.qq.test1706.houseInfo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 售房信息类
 * @author 龙保运
 *
 */
@Entity
@Table(name = "tb_house")
public class House implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="houseid")
	private Integer id;                       //售房编号
	private Integer area;                   //售房面积
	@Embedded
	private Contacter contacter;      //联系人
	private String detail;                   //售房详细信息
	private String mainPhoto;          //售房主图
	@OneToMany(mappedBy = "house")
	private List<HousePhoto> otherPhotos; //其他图片
	private double price;                  //售房价格
	private Date pubDate;                //发布日期
	private String street;                   //所在街道
	private String title;                      //售房的标题信息
	private Integer floor;                   //所在楼层
	private Integer totalFloor;          //最高楼层
	@ManyToOne
	@JoinColumn(name = "district_id")
	private District district;              //所属区域
	@OneToOne
	@JoinColumn(name = "house_type_id")
	private HouseType houseType;//售房类型
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;						//售房户主
	
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Contacter getContacter() {
		return contacter;
	}
	public void setContacter(Contacter contacter) {
		this.contacter = contacter;
	}
	public List<HousePhoto> getOtherPhotos() {
		return otherPhotos;
	}
	public void setOtherPhotos(List<HousePhoto> otherPhotos) {
		this.otherPhotos = otherPhotos;
	}
	public Integer getTotalFloor() {
		return totalFloor;
	}
	public void setTotalFloor(Integer totalFloor) {
		this.totalFloor = totalFloor;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public String getMainPhoto() {
		return mainPhoto;
	}
	public void setMainPhoto(String mainPhoto) {
		this.mainPhoto = mainPhoto;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getTotalfloor() {
		return totalFloor;
	}
	public void setTotalfloor(Integer totalfloor) {
		this.totalFloor = totalfloor;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public HouseType getHouseType() {
		return houseType;
	}
	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
