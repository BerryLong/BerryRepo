package com.qq.test1706.houseInfo.service;

import java.util.List;

import com.qq.test1706.houseInfo.domain.House;
import com.qq.test1706.houseInfo.domain.HousePhoto;
import com.qq.test1706.houseInfo.domain.HouseType;
import com.qq.test1706.houseInfo.dto.SearchHouseParam;
import com.qq.test1706.houseInfo.util.PageBean;

/**
 * 房源信息相关操作业务接口
 * @author 龙保运
 *
 */
public interface HouseService {
	
	/**
	 * 通过参数查询房源
	 * @param param 查询参数对象
	 * @param page 当前页
	 * @param size 显示数量
	 * @return 分页器
	 */
	PageBean<House> serchHousesByParamAndPage(SearchHouseParam param,int page,int size);
	
	/**
	 * 保存其他的图片
	 * @param housePhoto
	 * @return
	 */
	boolean saveOthersPhoto(HousePhoto housePhoto);
	/**
	 * 分页显示所有房源信息
	 * @param page 当前页
	 * @param size 每页显示数量
	 * @return 分页器
	 */
	PageBean<House> findAllHouseInfo(int page,int size);
	
	/**
	 * 添加新的房源信息
	 * @param house 房源对象
	 * @return 主键
	 */
	Integer publishNewHouseInfo(House house);

	/**
	 * 列出所有房型
	 */
	List<HouseType> listAllHouseTypes();
	
}
