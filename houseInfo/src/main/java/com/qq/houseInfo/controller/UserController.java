package com.qq.houseInfo.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qq.houseInfo.domain.User;
import com.qq.houseInfo.dto.CheckResult;
import com.qq.houseInfo.dto.UserLoginDto;
import com.qq.houseInfo.dto.UserRegistDto;
import com.qq.houseInfo.service.UserService;

/**
 * 用户控制层相关业务类
 * 
 * @author 龙保运
 *
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;

	/**
	 * 用户登录
	 */
	@PostMapping("/doLogin")
	public String doLogin(String code, @Valid UserLoginDto userLoginDto, Errors errors, Model model,
			HttpServletRequest request,String saveUser) {
		String viewName = "login";
		String codeStr = (String) request.getSession().getAttribute("code");
		if (codeStr.equalsIgnoreCase(code)) {
			userLoginDto.setIpAddress(request.getRemoteAddr());
			if (!errors.hasErrors()) {
				if (userService.login(userLoginDto)) {
					request.getSession().setAttribute("userId", userLoginDto.getId());
					request.getSession().setAttribute("userRealName", userLoginDto.getRealName());
					String beforeURL = (String) request.getSession().getAttribute("beforeURL");
					if(beforeURL==null) {
						viewName = "redirect:home";
					} else {
						viewName = "redirect:" +beforeURL;
					}
				} else {
					model.addAttribute("hint", "用户名或密码错误!");
				}
			} else {
				model.addAttribute("hint", "违法操作，请勿侵权！");
			}
		} else {
			model.addAttribute("cerror", "验证码输入错误");
		}
		return viewName;
	}

	/**
	 * 用户登出
	 */
	@GetMapping("/exitLogin")
	public String doLogin(HttpSession session) {
		if (session.getAttribute("userId") != null) {
			session.removeAttribute("userId");
			session.removeAttribute("userRealName");
		}
		return "redirect:home";
	}

	/**
	 * 用户注册
	 */
	@PostMapping("/doRegist")
	public String doRegist(@Valid UserRegistDto userRegistDto, Errors errors
			, Model model,String code,HttpServletRequest request) {
		String viewName = "regist";
		String codeStr = (String) request.getSession().getAttribute("code");
		if(code.equalsIgnoreCase(codeStr)) {
			if(!errors.hasErrors()) {
				if (userService.regist(userRegistDto)) {
					viewName = "redirect:toLogin";
				} else {
					model.addAttribute("hint", "请正确输入注册信息");
				}
			} else {
				model.addAttribute("hint", "违法操作，请勿侵权！");
			}
		} else {
			model.addAttribute("cerror","验证码输入错误");
		}
		return viewName;
	}

	/**
	 * 检验用户名是否可以注册
	 * 
	 * @param username   用户名
	 */
	@GetMapping("/doCheck")
	@ResponseBody
	public CheckResult doCheck(String username) {
			boolean valid = userService.CheckUnique(username) != null;;
			return new CheckResult(username,valid,
							valid ? "小主的用户名已被注册":"小主的用户名可以注册", 
							valid ? "no.png":"ok.png");
	}
	
	@GetMapping("/doSaveUser")
	@ResponseBody
	public Cookie doSaveUser(User user,HttpServletResponse response) {
		Cookie currentUserId = new Cookie("currentUserId", user.getId()+"");
		response.addCookie(currentUserId);
		return currentUserId;
	}
}
