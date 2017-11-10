<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>房多多-用户注册</title>
		<link rel="stylesheet" href="css/style.css" />
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div id="head">
			<ul class="nav nav-tabs">
				<li>
					<a href="home">首页</a>
				</li>
				<li>
					<a href="#">新房</a>
				</li>
				<li>
					<a href="#">二手房</a>
				</li>
				<li>
					<a href="#">租房</a>
				</li>
				<li>
					<a href="#">查房价</a>
				</li>
				<li>
					<a href="#">装修家居</a>
				</li>
				<li>
					<a href="#">写字楼</a>
				</li>
				<li>
					<a href="#">商铺</a>
				</li>
				<li>
					<a href="#">房产百科</a>
				</li>
			</ul>
			<div id="login">
				<a href="toLogin">马上登录</a> |
				<a href="toReg">快速注册</a>
			</div>
		</div>
		<div id="registinfo">
			<p>用户注册</p>
			<div id="hint"  class="hint">${hint }</div>
			<form id="registForm" action="doRegist" method="post">
				用户名:<br>
				<input type="text" name="username" id="username" required placeholder="请输入用户名" value="${userRegistDto.username }" />
				<div id="isValid"  class="hint">${isValid }</div>
				密码:<br>
				<input type="password" name="password" id="password" required placeholder="请输入密码" value="${userRegistDto.password }"  />
				<div id="perror"  class="hint">${perror }</div>
				真实姓名：<br/>
				<input type="text" name="realName" id="realname" placeholder="请输入真实姓名" value="${userRegistDto.realName }" />
				<div id="nerror"  class="hint">${nerror }</div>
				联系电话：<br/>
				<input type="text" name="tel" id="tel" placeholder="请输入联系电话" value="${userRegistDto.tel }" />
				<div id="terror"  class="hint">${terror }</div>
				验证码: <br> 
				<input type="text" name="code" id="codeStr"	placeholder="请输入图片上的字符" />
				<div id="codephoto">
					<img id="code" src="doCode" width="80" height="30">
				</div>
				<div id="cerror"  class="hint">${cerror }</div>
				<div class="button">
					<input type="submit" class="bt" value="确认注册" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" class="bt" value="重新填写 " onclick="window.location = ''" />
				</div>
				<br/>
			</form>
		</div>

		<div id="foot" align="center">
			<hr/> 关于我们 ‖ 网站合作 ‖ 联系我们 ‖ 我要推广 ‖ 招聘信息 ‖ 各地二手房 ‖ 意见反馈 ‖ 手机房天下‖开放平台‖ 更多链接<br/> Copyright © 2017 www.lby.com
		</div>
	</body>
	<script src="https://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript" src="js/checkRegist.js"></script>
</html>