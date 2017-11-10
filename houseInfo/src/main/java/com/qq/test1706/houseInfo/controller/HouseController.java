package com.qq.test1706.houseInfo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qq.test1706.houseInfo.domain.HouseType;
import com.qq.test1706.houseInfo.domain.User;
import com.qq.test1706.houseInfo.dto.SearchHouseParam;
import com.qq.test1706.houseInfo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qq.test1706.houseInfo.domain.House;
import com.qq.test1706.houseInfo.util.CommonsUtil;
import com.qq.test1706.houseInfo.util.PageBean;

/**
 * 房源信息相关操作控制器类
 * @author 龙保运
 *
 */
@Controller
public class HouseController {

	@Autowired
	private HouseService houseService;

	@GetMapping("/getAllHouseType")
	@ResponseBody
	public List<HouseType> getAllHouseType(){
		return houseService.listAllHouseTypes();
	}
	
	@PostMapping("/searchHouse")
	public String searchHouse(SearchHouseParam param, Model model
			, @RequestParam(defaultValue = "1") int page
			, @RequestParam(defaultValue = "3") int size) {
		PageBean<House> pageBean =houseService.serchHousesByParamAndPage(param, page, size);
		model.addAttribute("houseInfoList",pageBean.getDataModel());
		model.addAttribute("currentPage", pageBean.getCurrentPage());
		model.addAttribute("pageSize", pageBean.getPageSize());
		model.addAttribute("totalPage", pageBean.getTotalPage());
		return "index";
	}
	/**
	 * 发布新房源
	 * @param house 房源对象
	 * @return 主页
	 */
	@PostMapping("/addHouse")
	public String publishHouse(House house,MultipartFile primaryPhoto
			,MultipartFile[] photo,Model model,HttpServletRequest request) throws IOException {
		String viewName = "regist";
		if(!primaryPhoto.isEmpty()) {
			String originalFilename = primaryPhoto.getOriginalFilename();
			String newFilename = CommonsUtil.getRondomFilename() 
					+ CommonsUtil.getFilenameSuffix(originalFilename); 
			String path = request.getServletContext().getRealPath("/img");
			primaryPhoto.transferTo(new File(path +"/"+newFilename));
			house.setMainPhoto(newFilename);
			house.setPubDate(new Date());
			Integer userId = (Integer)(request.getSession().getAttribute("userId"));
			house.setUser(new User(userId));
			if(houseService.publishNewHouseInfo(house)!=null) {
				System.out.println(house.getId());
				viewName = "redirect:home";
			} else {
				model.addAttribute("hint", "发布失败！请检查信息是否正确");
			}
		}else {
			model.addAttribute("hint", "未选择上传的图片");
		}
		
		return viewName;
	}
	
	/**
	 * 分页显示所有房源信息--首页
	 * @return 返回到主页
	 */
	@GetMapping("/home")
	public String findAllHouseInfo(Model model
			,@RequestParam(defaultValue = "1") int page
			,@RequestParam(defaultValue = "3") int size) {
		PageBean<House> pageBean = houseService
				.findAllHouseInfo(page, size);
		model.addAttribute("houseInfoList",pageBean.getDataModel());
		model.addAttribute("currentPage", pageBean.getCurrentPage());
		model.addAttribute("pageSize", pageBean.getPageSize());
		model.addAttribute("totalPage", pageBean.getTotalPage());
		return "index";
	}
	
}
