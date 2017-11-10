package com.qq.test1706.houseInfo.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 登录日志类
 * @author 龙保运
 *
 */
@Entity
@Table(name = "tb_login_log")
public class LoginLog implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loginid")   
	private Integer id;								//日志编号
	@ManyToOne(
			cascade = { CascadeType.PERSIST, CascadeType.REMOVE}
	)
	@JoinColumn(name = "user_id")
	private User user;								//登录用户
	@Column(name = "ipaddr")
	private String ipAddr;						//IP地址
	@Column(name = "logdate")
	private Date logDate;						//登录日期

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

}
