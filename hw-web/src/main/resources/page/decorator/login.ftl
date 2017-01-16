<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta author="Rain">
	<title>登录 - 知乎 - </title>
	<link rel="stylesheet" type="text/css" href="/css/register-login.css">
</head>
<body>
<div id="box"></div>
<div class="cent-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">知乎</h1>
		<h2 class="sub-title">生活热爱分享 - Thousands Find</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="/login/toLogin" class="active">登录</a>
				<a href="/login/toRegister">注册</a>
				<div class="slide-bar"></div>				
			</div>
		</div>

		<div class="login form">
			<div class="group">
				<div class="group-ipt email">
					<li class="icon-user-md"></li>
					<input type="text" name="email" id="loginCode" class="ipt" placeholder="邮箱地址/手机号码/工号" required>
				</div>
				<div class="group-ipt password">
					<input type="password" name="password" id="password" class="ipt" placeholder="输入您的登录密码" required>
				</div>
				<div class="group-ipt verify">
					<input type="text" name="verify" id="verifyCode" class="ipt" placeholder="输入验证码" required>
					<img src="/validateCode/getValidateCode?id=" class="imgcode">
				</div>
			</div>
		</div>

		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">登录</button>
		</div>

		<#--<div class="remember clearfix">
			<label class="remember-me"><span class="icon"><span class="zt"></span></span><input type="checkbox" name="remember-me" id="remember-me" class="remember-mecheck" checked>记住我</label>
			<label class="forgot-password">
				<a href="#">忘记密码？</a>
			</label>
		</div>-->
	</div>
</div>

<div class="footer">
	<p>知乎 - Thousands Find</p>
	<p>Designed By Rain <a href="www.baidu.com">www.rain.com</a> 2016</p>
</div>

<script src='/js/particles.js' type="text/javascript"></script>
<script src='/js/login/background.js' type="text/javascript"></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script src='/js/layer/layer.js' type="text/javascript"></script>
/
<script>
	$('.imgcode').hover(function(){
		layer.tips("看不清？点击更换", '.verify', {
        		time: 6000,
        		tips: [2, "#3c3c3c"]
    		})
	},function(){
		layer.closeAll('tips');
	}).click(function(){
		$(this).attr('src',"/validateCode/getValidateCode?id="+Math.random());//http://zrong.me/home/index/imgcode?id=
	});
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	});
	$("#button").click(function(){
		var loginCode = $("#loginCode").val().trim();
		var password = $("#password").val().trim();
		var validateCode = $("#verifyCode").val().trim();

		$.ajax({
			url:"/user/login",
			data:{"loginid":loginCode,"password":password,"validateCode":validateCode},
			async:true,
			dataType:"json",
			success:function(data){

			},
			error:function(e){

			}
		});
	});
</script>
</body>
</html>