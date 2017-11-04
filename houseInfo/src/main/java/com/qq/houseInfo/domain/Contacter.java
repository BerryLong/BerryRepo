package com.qq.houseInfo.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 联系人信息类
 * @author 龙保运
 *
 */
@Embeddable
public class Contacter {

	@Column(name="contacterName")
	public String name;		//联系人姓名
	@Column(name="contacterTel")
	public String tel;			//联系人电话
	@Column(name="contacterQQ")
	public String qq;			//联系人QQ
	@Column(name="contacterEmail")
	public String email;		//联系人邮箱
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}