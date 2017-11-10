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
	    <div align="center">
			<pre>
		
         .----.
      _.'__    `. 
  .--(#)(##)---/#\
.' @          /###\
:         ,   #####
 `-..__.-' _.-\###/  
       `;_:    `"'
     .'"""""`. 
    /,  JOE  ,\
   //  COOL!  \\
   `-._______.-'
   ___`. | .'___ 
  (______|______)
			</pre>
			<h3>哦豁...页面走丢了.......</h3>
			<a href="home">返回首页</a>
		</div>
    	<div id="foot" align="center">
    	<hr/>
    		关于我们 ‖ 网站合作 ‖ 联系我们 ‖ 我要推广 ‖ 招聘信息 ‖ 各地二手房 ‖	 意见反馈 ‖ 手机房天下‖开放平台‖ 更多链接<br/>
    		Copyright © 2017 www.lby.com
    	</div>
	</div>
 	</body>
</html>