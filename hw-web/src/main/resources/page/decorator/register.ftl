<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>注册 - 知乎 - Thousands Find</title>
	<meta author="zrong.me 曾荣">
	<link rel="stylesheet" type="text/css" href="/css/register-login.css">
</head>
<body>
<div id="box"></div>
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title hide">知乎</h1>
		<h2 class="sub-title">生活热爱分享 - Thousands Find</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="/login/toLogin">登录</a>
				<a href="/login/toRegister" class="active">注册</a>
				<div class="slide-bar slide-bar1"></div>				
			</div>
		</div>

		<div class="login form">
			<div class="group">
				<div class="group-ipt email">
					<input type="email" name="email" id="logincode" class="ipt" placeholder="邮箱地址" required onchange="checkLogincode()">
				</div>
				<div class="group-ipt user">
					<input type="text" name="user" id="user" class="ipt" placeholder="选择一个用户名" required>
				</div>
				<div class="group-ipt password">
					<input type="password" name="password" id="password" class="ipt" placeholder="设置登录密码" required onchange="checkPassword()">
				</div>
				<div class="group-ipt password1">
					<input type="password" name="password1" id="password1" class="ipt" placeholder="重复密码" required onchange="checkPassword1()">
				</div>
				<div class="group-ipt verify">
					<input type="text" name="verify" id="verify" class="ipt" placeholder="输入验证码" required>
					<img src="/validateCode/getValidateCode?id=" class="imgcode">
				</div>
			</div>
		</div>

		<div class="button">
			<button type="submit" class="login-btn register-btn" id="register">注册</button>
		</div>
	</div>
</div>

<div class="footer">
	<p>知乎 - Thousands Find</p>
	<p>Designed By ZengRong & <a href="zrong.me">mycodes.net</a> 2016</p>
</div>

<script type="text/javascript" src='/js/particles.js'></script>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src='/js/layer/layer.js'></script>

<script>
	var checkFlag = true;
	$('.imgcode').hover(function(){
		layer.tips("看不清？点击更换", '.verify', {
        		time: 6000,
        		tips: [2, "#3c3c3c"]
    		})
	},function(){
		layer.closeAll('tips');
	}).click(function(){
		$(this).attr('src','/validateCode/getValidateCode?id=' + Math.random());
	})

	$(".login-btn").click(function(){
		var email = $("#email").val();
		var password = $("#password").val();
		var verify = $("#verify").val();
	})
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	});
	$("#register").click(function(){
		var logincode = $("#logincode").val().trim();
		var password = $("#password").val();
		var validataCode = $("#").val().trim();
	});

    /**
     * 登录名重复性校验
     * /
     function checkLogincode(){
		if(true){
            checkInfo('logincode','用户已存在！','#3c3c3c',2000,2);
		}
	}

	/**
	 * 密码校验
	 */
    function checkPassword(){
        if($("#password1").val() ！= "" && $("#password").val() != $("#password1").val()){
            checkInfo('password','密码已修改，请重新确认密码！','#3c3c3c',2000,2);
        }
    }

	/**
	 * 确认密码校验
	 */
    function checkPassword1(){
        if($("#password").val() != $("#password1").val()){
            checkInfo('password1','密码不一致！','#3c3c3c',2000,2);
        }
    }
	/**
	 *
	 * @param id
	 * @param msg
	 * @param color
	 * @param time
	 * @param style
	 */
	function checkInfo(id,msg,color,time,style){
        layer.tips(msg, '#'+ id, {
            time: time,
            tips: [style, color]
        })
	}

</script>
</body>
</html>