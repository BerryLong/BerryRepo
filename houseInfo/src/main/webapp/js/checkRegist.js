$(function() {
	/**
	 * 用户名格式提示
	 */
	$("#username").on("focus", function() {
		$('#isValid').text("6-16位字符,可包含字母(区分大小写)、数字和下划线").css("color", "green");
	});
	
	/**
	 * 验证用户名是否可以注册
	 */
	$("#username").on("blur", function() {
		var username = $(this).val();   //取得用户名
			if(checkUsername(username)){
				$.ajax({
					url : "doCheck",
					data : {
						"username" : username
					},
					success : function(data) {
						if (data.valid) {
							showErrorHint(data.message);
						} else {
							showCorrectHint(data.message);
						}
					}
				});
			}
	});
	
	/**
	 * 刷新验证码
	 */
	$("#code").on("click", function() {
		$(this).attr("src", "doCode?" + Math.random());
	});
	
	/**
	 * 密码格式提示
	 */
	$("#password").on("focus", function() {
		$("#perror").text("以字母开头，长度在6~20之间，只能包含字母、数字和下划线").css("color", "green");
	});
	/**
	 * 密码格式验证
	 */
	$("#password").on("blur", function() {
		var password = $(this).val();   //取得用户密码
			checkPassword(password);
	});
	
	/**
	 * 电话号码格式提示
	 */
	$("#tel").on("focus", function() {
		$("#terror").text("国内电话:如(152-1234-4321)").css("color", "green");
	});
	/**
	 * 电话号码格式验证
	 */
	$("#tel").on("blur", function() {
		var tel = $(this).val();				//取得电话号码
		checkTel(tel);
	});
	
	/**
	 * 表单验证
	 */
	$('#registForm').on('submit', function(evt) {
		evt.preventDefault();
		var username = $("#username").val();
		var password = $("#password").val();
		var tel = $("#tel").val();
		if(checkUsername(username)&checkPassword(password)&checkTel(tel)){
			evt.target.submit();
		} else{
			$("#hint").text("请正确填写信息").css("color", "red");
		}
	});
});


/**
 * 用户名为空提示
 */
function showNullHint() {
	$("#isValid").text("用户名不能为空").css("color", "red");
	$('#username').val('');
}
/**
 * 用户名已被注册提示
 */
function showErrorHint(msg) {
	$("#isValid").text(msg).css("color", "red");
	$('#username').val('');
}
/**
 * 用户名可以注册提示
 */
function showCorrectHint(msg) {
	$("#isValid").text(msg).css("color", "green");
}
/**
 * 用户名格式验证
 */
function checkUsername(username) {
	var flag = /^[a-zA-Z0-9_]{6,20}$/.test(username);
	flag ? $("#isValid").text("") : $("#isValid").text("用户名格式错误,请尝试更换").css("color", "red");
	return flag;
}
/**
 * 密码格式验证
 */
function checkPassword(password) {
	var flag = /^[a-zA-Z]\w{5,17}$/.test(password);
	flag ? $("#perror").text("") : $("#perror").text("密码格式错误,请尝试更换").css("color", "red");
	return flag;
}
/**
 * 电话号码格式验证
 */
function checkTel(tel) {
	var flag = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test(tel);
	flag ? $("#terror").text("") : $("#terror").text("电话号码格式错误,请尝试更换").css("color", "red");
	return flag;
}
