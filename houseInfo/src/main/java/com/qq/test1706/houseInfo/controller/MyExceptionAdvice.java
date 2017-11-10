package com.qq.test1706.houseInfo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 异常处理
 * @author 龙保运
 *
 */
@ControllerAdvice
public class MyExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String to404Exception() {
		return "error/error";
	} 

}
