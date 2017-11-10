<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>房多多-首页</title>
		<link rel="stylesheet" href="css/style.css" />
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	<div id="body">
    	<div id="head">
    		<ul class="nav nav-tabs">
    			<li><a href="home">首页</a></li>
    			<li><a href="error">新房</a></li>
    			<li><a href="#">二手房</a></li>
    			<li><a href="#">租房</a></li>
    			<li><a href="#">查房价</a></li>
    			<li><a href="#">装修家居</a></li>
    			<li><a href="#">写字楼</a></li>
    			<li><a href="#">商铺</a></li>
    			<li><a href="#">房产百科</a></li>
    		</ul>
    		<div id="wellcom">
    			<c:if test="${!empty userId }">
    				${userRealName } ,欢迎您 !
    			</c:if>
    		</div>
    		<div id="login">
    		<c:choose>
    			<c:when test="${!empty userId }">
    			<a href="exitLogin">注销登录</a>
    			</c:when>
    			<c:otherwise>
    			欢迎来到房多多！&nbsp;&nbsp;&nbsp;&nbsp;
    			<a href="toLogin">马上登录</a> | <a href="toReg">快速注册</a>
    			</c:otherwise>
    		</c:choose>
    		</div>
    	</div>
    	<div id="search">
    		<input id="tt" autocomplete="off" type="text" placeholder="请输入小区名称..." />
			<input id="ss" type="button" value="搜索" />
			<div id="info">
				<a href="#">大面地价破万 </a>
				<a href="#">热搜大面 </a>
				<a href="#">二手房实战录 </a>
				<a href="#">再造城北 </a>
				<a href="#">天府新区</a>
			</div>
    	</div>
    	<div id="area">
    		<div id="title1" align="center">按区域查询</div>
    		<c:if test="${!empty userId }">
    			<input id="new" type="button" value="免费发布房源" />
    		</c:if>
    		<div id="areas">
    		区域：<a href="#">不限</a>	<a href="#">武侯</a>	<a href="#">青羊</a>	<a href="#">高新区</a>　
    		<a href="#">天府新区</a>　<a href="#">金牛</a>　<a href="#">锦江</a>　<a href="#">成华</a>
    		<a href="#">双流</a>　<a href="#">温江</a>　<a href="#">龙泉</a>　<a href="#">郫都区</a>　<a href="#">新都</a>　
    		<a href="#">都江堰</a>　<a href="#">高新西区</a>　<a href="#">其他</a>　<a href="#">成都周边</a><br /><br />
    		总价：<a href="#">不限</a>	<a href="#">40万以下</a>	<a href="#">40-60万</a>	<a href="#">60-80万</a>	<a href="#">80-100万</a>	
    		<a href="#">100-150万</a>	<a href="#">150-200万</a>	<a href="#">200-300万</a>	<a href="#">300万以上</a>	<br /><br />
    		户型：<a href="#">不限</a>	<a href="#">一居</a>	<a href="#">二居</a>	<a href="#">三居</a>	<a href="#">四居</a>	<a href="#">五居</a>	<a href="#">五居以上</a>	<br /><br />
    		环线：<a href="#">不限</a>	<a href="#">一环以内</a>	<a href="#">一至二环</a>	<a href="#">二至中环</a>	<a href="#">中至三环</a>	<a href="#">三至绕城</a>	<a href="#">绕城以外</a>	
    		</div>
    	</div>
    	<div id="select">
    	更多找房条件：
    		<select>
    			<option>朝向</option>
    			<option>不限</option>
    			<option>南北通透</option>
    			<option>东西向</option>
    			<option>朝东</option>
    			<option>朝南</option>
    			<option>朝西</option>
    			<option>朝北</option>
    		</select>
    		<select>
    			<option>房龄</option>
    			<option>不限</option>
    			<option>2年以下</option>
    			<option>2-5年</option>
    			<option>5-10年</option>
    			<option>10年以上</option>
    		</select>
    		<select>
    			<option>楼层</option>
    			<option>地下</option>
    			<option>6层以下</option>
    			<option>6-12层</option>
    			<option>12层以上</option>
    		</select>
    		<select>
    			<option>建筑类别</option>
    			<option>板楼</option>
    			<option>塔楼</option>
    			<option>平房</option>
    		</select>
    	</div>
    	<c:forEach items="${houseInfoList }" var="house">
    	<div class="info">
	    	<div id="photo">
	    		<img src="img/${house.mainPhoto}"/>
	    		<div class="count">1图</div>
	    	</div>
	    	<div id="detail">
	    	<label style="font-size: 20px;"><a href="#">${house.title}</a></label><br/>
	    	${house.houseType.name } |${house.floor }层(共${house.totalFloor }层) <br/>
	    	${house.street }<br/>
	    	中介人: ${house.contacter.name }
	    	</div>
	    	<div id="harea">
	    	${house.area }㎡<br/>
	    	建筑面积
	    	</div>
	    	<div id="price">
	    	${house.price }万<br/>
	    	</div>
    	</div>
    	</c:forEach>
    	<div class="pager">
				<ul>
					<li class="current"><a href="home">首页</a></li>
					<c:if test="${currentPage > 1}">
					<li><a href="home?page=${currentPage - 1}">上一页</a></li>
					</c:if>
					<c:if test="${currentPage < totalPage}">
					<li><a href="home?page=${currentPage + 1}">下一页</a></li>
					</c:if>
					<li><a href="home?page=${totalPage}">末页</a></li>
					<li><span class="total">${currentPage}/${totalPage}页</span></li>
				</ul>
				
			</div>
    	<div id="foot" align="center">
    	<hr/>
    		关于我们 ‖ 网站合作 ‖ 联系我们 ‖ 我要推广 ‖ 招聘信息 ‖ 各地二手房 ‖	 意见反馈 ‖ 手机房天下‖开放平台‖ 更多链接<br/>
    		Copyright © 2017 www.lby.com
    	</div>
	</div>
 	</body>
 	<script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
	<script src="js/house.js"></script>
</html>