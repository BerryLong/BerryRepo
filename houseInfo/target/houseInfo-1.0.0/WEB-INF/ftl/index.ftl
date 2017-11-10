<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>房多多-首页f</title>
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
    			<#if userId != null || cookie.currentUserId != null>
    				${userRealName } ,欢迎您 !
    			</#if>
    		</div>
    		<div id="login">
    			<#if userId != null >
    			<a href="exitLogin">注销登录</a>
    			</#if>
    			<#if userId == null>
    			欢迎来到房多多！&nbsp;&nbsp;&nbsp;&nbsp;
    			<a href="toLogin">马上登录</a> | <a href="toReg">快速注册</a>
    			</#if>
    		</div>
    	</div>
    	<div id="search">
    	<form action="searchHouse" method="post">
    		<input id="tt" autocomplete="off" type="text" name="title" placeholder="请输入标题..." />
    		<input name="area" type="hidden"  value="不限"/>
    		<input name="price" type="hidden" value="不限" />
    		<input name="houseType.id" type="hidden"  value="0" />
			<input id="ss" type="submit" value="搜索" />
		</form>
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
    		<#if userId != null>
    			<input id="new" type="button" value="免费发布房源" />
    		</#if>
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
	    	<form action="searchHouse" method="post">
	    		<input name="title" type="hidden"  />
	    		<select name="price">
	    			<option  value="不限">价格</option>
	    			<option value="不限">不限</option>
	    			<option value="0-50">0-50万元</option>
	    			<option  value="50-70">50-70万元</option>
	    			<option  value="70-90">70-90万元</option>
	    			<option  value="90-120">90-120万元</option>
	    			<option value="120-150">120-150万元</option>
	    			<option  value="150-9999999999">150万元以上</option>
	    		</select>
	    		<select name="area">
	    			<option  value="不限">面积</option>
	    			<option  value="不限">不限</option>
	    			<option  value="0-60">0-60平米</option>
	    			<option  value="60-80">60-80平米</option>
	    			<option  value="80-100">80-100平米</option>
	    			<option  value="100-150">100-150平米</option>
	    			<option  value="150-200">150-200平米</option>
	    			<option  value="200-999999999">200以上</option>
	    		</select>
	    		<select name="houseType.id">
	    			<option  value="0">房型</option>
	    			<option  value="0">不限</option>
	    			<#list houseTypeList as houseType>
	    			<option value="${houseType.id}">${houseType.name}</option>
	    			</#list>
	    		</select>
	    	<input type="submit" value="查询"/>
	    	</form>
    	</div>
    	<#list houseInfoList as house>
    	<div class="info">
	    	<div id="photo">
	    		<img src="img/${house.mainPhoto}"/>
	    		<div class="count">1图</div>
	    	</div>
	    	<div id="detail">
	    	<label style="font-size: 20px;"><a href="#">${house.title}</a></label><br/>
	    	${house.houseType.name } |${house.floor }层(共${house.totalFloor }层) <br/>
	    	${house.street }<br/>
	    	中介人: <a href="#">${house.contacter.name }</a>
	    	</div>
	    	<div id="harea">
	    	<lable id="fontStyle">${house.area }</lable><font size=4>/㎡</font><br/>
	    	建筑面积
	    	</div>
	    	<div id="price">
	    	<lable id="fontStyle">${house.price }</lable>万<br/>
	    	</div>
    	</div>
    	</#list>
    	<div class="pager">
				<ul>
					<li class="current"><a href="home">首页</a></li>
					<#if currentPage gt 1>
					<li><a href="home?page=${currentPage - 1}">上一页</a></li>
					</#if>
					<#if currentPage lt totalPage>
					<li><a href="home?page=${currentPage + 1}">下一页</a></li>
					</#if>
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