package com.qq.houseInfo.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 用户注册对象DTO
 * @author 龙保运
 *
 */
public class UserRegistDto {
	
	@Pattern(regexp="[a-zA-Z0-9_]{6,20}")
	private String username;			//用户名
	@Pattern(regexp="[a-zA-Z]\\w{5,17}")
	private String password;			//密码
	@Size(min=5,max=20)
	private String rePassword;		//确认密码
	private String realName;			//真实姓名
	@Pattern(regexp="(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}")
	private String tel;						//联系电话
	@Size(min=4,max=4)
	private String code;					//验证码
	private Boolean admin;			//是否是管理员
	
	public Boolean getIsAdmin() {
		return admin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.admin = isAdmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
