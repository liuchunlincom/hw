<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <meta name="keywords" content="登录" />
    <meta name="description" content="登录" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <link rel ="stylesheet" href ="/css/bootstrap/css/bootstrap.css">
    <link rel ="stylesheet" href ="/css/Font-Awesome/css/font-awesome.css">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap/js/bootstrap.js"></script>
    <style type="text/css">
        body{
            text-align: center;
            background: #F7FAFC;
            overflow: hidden;
            background: #fff;
        }
    </style>

</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="Mycanvas"></canvas>
        </div>
        <div style="position:fixed;height:90px;width:100%;left:0;top:-15px;z-index:9999;tex-align:center">
            <div class="index-header">
                <h1 class="logo hide-text"><li class="icon-cloud-download">你好！</li></h1>
                <h2 class="subtitle">每天遇见新的自己</h2>
            </div>
            <div class="index-tab-navs">
                <input class="form-control" type="text">
                <div class="navs-slider" data-active-index="1">
                    <a href="#signup" class="">注册</a>
                    <a href="#signin" class="active">登录</a>
                    <span class="navs-slider-bar"></span>
                </div>
            </div>
            <div class="login form">
                <div class="group">
                    <div class="group-ipt email">
                        <input type="text" name="email" id="email" class="ipt" placeholder="邮箱地址" required>
                    </div>
                    <div class="group-ipt password">
                        <input type="password" name="password" id="password" class="ipt" placeholder="输入您的登录密码" required>
                    </div>
                </div>
            </div>

            <div class="button">
                <button type="submit" class="login-btn register-btn" id="button">登录</button>
            </div>

            <div class="remember clearfix">
                <label class="remember-me"><span class="icon"><span class="zt"></span></span><input type="checkbox" name="remember-me" id="remember-me" class="remember-mecheck" checked>记住我</label>
                <label class="forgot-password">
                    <a href="#">忘记密码？</a>
                </label>
            </div>
        </div>
    </div>
</div>


</body>
<script>
    //定义画布宽高和生成点的个数
    var WIDTH = window.innerWidth, HEIGHT = window.innerHeight, POINT = 35;

    var canvas = document.getElementById('Mycanvas');
    canvas.width = WIDTH,
            canvas.height = HEIGHT;
    var context = canvas.getContext('2d');
    context.strokeStyle = 'rgba(0,0,0,0.2)',
            context.strokeWidth = 1,
            context.fillStyle = 'rgba(0,0,0,0.1)';
    var circleArr = [];

    //线条：开始xy坐标，结束xy坐标，线条透明度
    function Line (x, y, _x, _y, o) {
        this.beginX = x,
                this.beginY = y,
                this.closeX = _x,
                this.closeY = _y,
                this.o = o;
    }
    //点：圆心xy坐标，半径，每帧移动xy的距离
    function Circle (x, y, r, moveX, moveY) {
        this.x = x,
                this.y = y,
                this.r = r,
                this.moveX = moveX,
                this.moveY = moveY;
    }
    //生成max和min之间的随机数
    function num (max, _min) {
        var min = arguments[1] || 0;
        return Math.floor(Math.random()*(max-min+1)+min);
    }
    // 绘制原点
    function drawCricle (cxt, x, y, r, moveX, moveY) {
        var circle = new Circle(x, y, r, moveX, moveY)
        cxt.beginPath()
        cxt.arc(circle.x, circle.y, circle.r, 0, 2*Math.PI)
        cxt.closePath()
        cxt.fill();
        return circle;
    }
    //绘制线条
    function drawLine (cxt, x, y, _x, _y, o) {
        var line = new Line(x, y, _x, _y, o)
        cxt.beginPath()
        cxt.strokeStyle = 'rgba(0,0,0,'+ o +')'
        cxt.moveTo(line.beginX, line.beginY)
        cxt.lineTo(line.closeX, line.closeY)
        cxt.closePath()
        cxt.stroke();

    }
    //初始化生成原点
    function init () {
        circleArr = [];
        for (var i = 0; i < POINT; i++) {
            circleArr.push(drawCricle(context, num(WIDTH), num(HEIGHT), num(15, 2), num(10, -10)/40, num(10, -10)/40));
        }
        draw();
    }

    //每帧绘制
    function draw () {
        context.clearRect(0,0,canvas.width, canvas.height);
        for (var i = 0; i < POINT; i++) {
            drawCricle(context, circleArr[i].x, circleArr[i].y, circleArr[i].r);
        }
        for (var i = 0; i < POINT; i++) {
            for (var j = 0; j < POINT; j++) {
                if (i + j < POINT) {
                    var A = Math.abs(circleArr[i+j].x - circleArr[i].x),
                            B = Math.abs(circleArr[i+j].y - circleArr[i].y);
                    var lineLength = Math.sqrt(A*A + B*B);
                    var C = 1/lineLength*7-0.009;
                    var lineOpacity = C > 0.03 ? 0.03 : C;
                    if (lineOpacity > 0) {
                        drawLine(context, circleArr[i].x, circleArr[i].y, circleArr[i+j].x, circleArr[i+j].y, lineOpacity);
                    }
                }
            }
        }
    }

    //调用执行
    window.onload = function () {
         $("#button").click(function(){
             alert();
         });
        init();
        setInterval(function () {
            for (var i = 0; i < POINT; i++) {
                var cir = circleArr[i];
                cir.x += cir.moveX;
                cir.y += cir.moveY;
                if (cir.x > WIDTH) cir.x = 0;
                else if (cir.x < 0) cir.x = WIDTH;
                if (cir.y > HEIGHT) cir.y = 0;
                else if (cir.y < 0) cir.y = HEIGHT;

            }
            draw();
        }, 16);
    }

</script>
</html>