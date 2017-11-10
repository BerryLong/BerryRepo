package com.qq.test1706.houseInfo.dto;

/**
 * 用户名验证返回的DTO对象
 * @author 龙保运
 *
 */
public class CheckResult {
	
	private String username;		//用户名
	private boolean valid;			//是否可用
	private String message;		//提示信息
	private String picture;			//提示图片
	
	public CheckResult() {}
	public CheckResult(String username,boolean valid, String message, String picture) {
		this.valid = valid;
		this.message = message;
		this.picture = picture;
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public boolean isValid() {
		return valid;
	}
	public String getMessage() {
		return message;
	}
	public String getPicture() {
		return picture;
	}

}
