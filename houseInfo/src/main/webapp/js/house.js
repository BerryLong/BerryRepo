$(function() {
	/**
	 * 跳转到注册页面
	 */
	$("#toRegist").on("click",function(){
		location.href="toReg";
	});
	
	/**
	 * 验证登录用户名
	 */
	$("#username").on("blur",function(){
		checkUsername($(this).val());
	});
	/**
	 * 验证登录密码
	 */
	$("#password").on("blur",function(){
		checkPassword($(this).val());
	});
	
	/**
	 * 刷新验证码
	 */
	$("#code").on("click",function(){
		$(this).attr("src","doCode?"+Math.random());
	});

	/**
	 * 表单验证
	 */
	$('#loginForm').on('submit', function(evt) {
		evt.preventDefault();
		var username = $("#username").val();
		var password = $("#password").val();
		if(checkUsername(username)&checkPassword(password)){
			evt.target.submit();
		} else{
			$("#hint").text("请正确填写信息").css("color", "red");
		}
	});
	
	$("#new").on("click",function(){
		location.href="toPub";
	});
	
	$('#prov').on('change', function() {
		$('#city option:gt(0)').remove();
		$('#dist option:gt(0)').remove();
		$('#city').attr('disabled', 'disabled');
		$('#dist').attr('disabled', 'disabled');
		var provId = $(this).val();
		if (provId != 0) {
			$.getJSON('cities', {'id': provId}, function(data) {
				var citySelect = $('#city').removeAttr('disabled');
				$('#city option:gt(0)').remove();
				for (var i = 0, len = data.length; i < len; ++i) {
					var city = data[i];
					citySelect.append($('<option>').val(city.id).text(city.name));
				}
				citySelect.on('change', function() {
					var cityId = $(this).val();
					if (cityId != 0) {
						$.getJSON('districts', {'id':cityId}, function(data) {
							var distSelect = $('#dist').removeAttr('disabled');
							$('#dist option:gt(0)').remove();
							for (var i = 0, len = data.length; i < len; ++i) {
								var district = data[i];
								distSelect.append($('<option>').val(district.id).text(district.name));
							}
						});
					}
				})
			});
		}
	});
	$('#addbutton').on('click', function() {
		var tr = $(this).parent().parent();
		var img = $('<img>').attr('width', 160).attr('height', 120);
		$('#prevArea').append(img);
		var newTr = $('<tr>');
		var newTd1 = $('<td class="field"></td>');
		var newTd2 = $('<td>');
		var fileInput = $('<input type="file" name="photo" class="text"/>');
		fileInput.on('change', function() {
			doPreview(this, img);
		});
		var minusButton = $('<input type="button" value="-" class="minusbutton"/>');
		minusButton.on('click', function() {
			newTr.remove();
			img.remove();
		});
		newTd2.append(fileInput);
		newTd2.append(minusButton);
		newTr.append(newTd1);
		newTr.append(newTd2);
		tr.after(newTr);
	});
	
	$('#file').on('change', function() {
		doPreview(this, $('#housePhoto'));
	});
	
	function doPreview(source, target) {
		var file = source.files[0];	// 从文件选择器获取选中的文件
		if(/image\/\w+/.test(file.type)) {
			if(window.FileReader) {	// 判断是否支持FileReader
				var fr = new FileReader();	// 创建FileReader对象
				fr.onloadend = function() {	// 绑定回调函数（文件读取完毕时回调）
					target.attr('src', this.result);	// 修改img标签的src属性将图片预览出来
				};
				fr.readAsDataURL(file);	// 根据URL读取文件
			}
		} else {
			alert("只能选择图片文件");
			source.value = "";	// 清除文件选择中的内容
			target.attr('src', '');	// 清除图片预览
		}
	}
	
	$('#saveUser').on('click', function() {
		alert($(this).val());
         if ($('#saveUser').prop("checked")) {
        	 $('#saveUser').attr("value","true");
        	 $("#username").val('sbdasdasd');
        	 alert($(this).val());
         } else {
        	 $('#saveUser').attr("value","false");
        	 alert($(this).val());
         }
	});
});

function checkUsername(username) {
	var flag = /^\w{5,20}$/.test(username);
	flag ? $("#uerror").text("") : $("#uerror").text("请输入正确的用户名");
	return flag;
}
function checkPassword(password){
	var flag = /^\w{5,20}$/.test(password);
	flag ? $("#perror").text("") : $("#perror").text("请输入正确的密码");
	return flag;
}