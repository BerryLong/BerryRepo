package com.qq.test1706.houseInfo.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 用户登录对象DTO
 * @author 龙保运
 *
 */
public class UserLoginDto {

	private Integer id;						//用户编号
	@Pattern(regexp = "\\w{5,20}")
	private String username;			//用户名
	@Size(min = 5, max = 20)
	private String password;			//密码
	@Size(min = 4, max = 4)
	private String code;					//验证码
	private String realName;			//真实姓名
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	private String ipAddress;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
