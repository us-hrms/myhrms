$(function(){
	//启用检查提示框
	$('#no,#password').popover({trigger:'manual'})
	//创建检查输入值方法
	function check(){
		var val = $("#no").val();//获取表单工号
		//如果输入值为空 则进行提醒
		if(val.length==0||val==""){
			//显示提醒框
			$("#no").popover("show")
			.parents(".form-group")
			.addClass("has-error");//设置组合输入框的样式
			return false;
		}
		val = $("#password").val();//获取表单密码
		if(val.length==0||val==""){
			$("#password").popover("show")
			.parents(".form-group")
			.addClass("has-error");//设置组合输入框的样式
			return false;
		}
		return true;
	}
	$("#no,#password").focus(function(){
		//隐藏提醒框
		$(this).popover("hide")
		.parents(".form-group")
		.removeClass("has-error");//移除组合输入框的样式
		//重新设置表单上方的提示内容文本 和 背景边框样式
		$(".login-alert.alert-danger").text("请输入工号和密码进行登录")
		.removeClass("alert-danger").addClass("alert-info");
	});
	$(".login-cancel").click(function(){
		//点击隐藏modal登录方式的按钮时
		$("#no,#password").val('')//清空输入框的内容
		.parents(".form-group").removeClass("has-error");//清除输入框的状态提示
		//重置表单上方的提示信息
		$(".login-alert.alert-danger").text("请填工号和密码")
		.removeClass("alert-danger").addClass("alert-info");
	});
	$(".staff-login-btn").click(function(){
		var form  = $(this).parents("form");//获得表单对象
		//如果检查通过  异步提交
		if(check())
			$.ajax({
				url:"loginAjaxInSa.ajax",
				data:form.serialize(),
				type:"post",
				dataType:"text",
				success:function(data){
					if(data == "true"){
						$("#login").find("button").remove();//移除modal的按钮
						//显示modal 并且显示信息
						$("#login").modal('show').find(".alert").text("登录成功！")
						.removeClass("alert-danger").addClass("alert-success");
						//在表单上方的状态栏显示信息
						$(".login-alert").text("登录成功！").removeClass("alert-info").addClass("alert-success");
						setTimeout(function() {
							window.location.href= $(form).attr("url");
						}, 1500)
					}else{
						//设置表单输入框的状态
						$("#no,#password").parents(".form-group").addClass("has-error");
						//设置表单上方提示框的内容
						$(".login-alert").text("登录失败，工号或密码错误！")
						.removeClass("alert-info").addClass("alert-danger");
					}
				}
			});
		return false;
	});
});