<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>房多多-发布房源</title>
		<link rel="stylesheet" href="css/style.css" />
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	<div id="body">
    	<div id="head">
    		<ul class="nav nav-tabs">
    			<li><a href="home">首页</a></li>
    			<li><a href="#">新房</a></li>
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
    			<a href="toLogin">请登录</a> | <a href="toReg">注册</a>
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
	    <div id="regLogin" class="wrap">
			<div class="dialog">
				<dl class="clearfix">
					<dt>新房屋信息发布</dt>
					<dd class="past">填写房屋信息</dd>
				</dl>
				<div class="box">
					<form action="addHouse" method="post" enctype="multipart/form-data">
						<div style="color:red;">${hint}</div>
						<div class="infos">
							<table class="field">
								<tr>
									<td class="field">标 题：</td>
									<td><input type="text" class="text" name="title"></td>
								</tr>
								<tr>
									<td class="field">户 型：</td>
									<td>
										<select  class="text" name="houseType.id">
											<c:forEach items="${houseTypeList}" var="type">
											<option value="${type.id}">${type.name}</option>
											</c:forEach>
										</select>
								   </td>
								</tr>
								<tr>
									<td class="field">面 积：</td>
									<td><input type="number" min="1" class="mtext" name="area"></td>
								</tr>
								<tr>
									<td class="field">楼 层：</td>
									<td>
										<input type="number" name="floor" class="stext" maxlength="3">
										/
										<input type="number" min="1" name="totalFloor" class="stext" maxlength="3">
									</td>
								</tr>
								<tr>
									<td class="field">价 格：</td>
									<td><input type="number" min="1" class="mtext" name="price"></td>
								</tr>
		
		                        <tr>
									<td class="field">省市区：</td>
									<td>	
										<select  id="prov" class="text" name="province.id">
											<option value="0">请选择</option>
											<c:forEach items="${provinceList}" var="prov">
											<option value='${prov.id}'>${prov.name}</option>
											</c:forEach>
										</select>
										<select  id="city" class="text" name="city.id" disabled>
											<option value="0">请选择</option>
										</select>
										<select id="dist" class="text" name="district.id" disabled>
											<option value="0">请选择</option>
										</select>
		                            </td>
								</tr>
								<tr>
									<td class="field">街 道：</td>
									<td>
										<input type="text" name="street" class="text">
									</td>
								</tr>
								<tr>
									<td class="field">联系人：</td>
									<td><input type="text" class="text" name="contacter.name"></td>
								</tr>
		                        <tr>
									<td class="field">联系电话：</td>
									<td><input type="tel" class="text" name="contacter.tel"></td>
								</tr>
								 <tr>
									<td class="field">QQ：</td>
									<td><input type="text" class="text" name="contacter.qq"></td>
								</tr>
								 <tr>
									<td class="field">E-mail：</td>
									<td><input type="email" class="text" name="contacter.email"></td>
								</tr>
								<tr>
									<td class="field">上传图片：</td>
									<td>
										<input id="file" type="file" class="text" name="primaryPhoto">
										<input id="addbutton" type="button" value="+" class="addbutton">
									</td>
								</tr>
								<tr>
									<td class="field">图片预览：</td>
									<td id="prevArea"><img id="housePhoto" src="" alt="" width="160" height="120"></td>
								</tr>
		                        <tr>
									<td class="field">详细信息：</td>
									<td><textarea name="detail"></textarea></td>
								</tr>
							</table>
							<div ><input type="submit" class="buttons" value="立即发布"></div>
						</div>
					</form>
				</div>
			</div>
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