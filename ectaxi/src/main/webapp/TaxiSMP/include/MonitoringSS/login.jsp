<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>监控调度系统</title>

    <!-- 注：HTML、CSS以1200px为最小尺寸 -->

    <!--[if lt IE 10]>
    <script type="text/javascript">
        document.createElement("header");
        document.createElement("article");
        document.createElement("footer");
    </script>

    <link rel="stylesheet" href="../../public/css/tips.css">
    <script type="text/javascript" src="../../public/js/tips.js"></script>
    <![endif]-->

    <!-- favicon -->
    <link rel="shortcut icon" href="favicon.png">

    <!-- common.css -->
    <link rel="stylesheet" href="../../public/css/common.css">

    <!-- loginCommon.css -->
    <link rel="stylesheet" href="../../public/css/loginCommon.css">

    <!-- login.css -->
    <link rel="stylesheet" href="public/css/login.css">

    <!-- jquery.js -->
    <script src="../../public/js/jquery-2.2.4.min.js"></script>

    <!-- path.js -->
    <script src="../../public/js/path.js"></script>

</head>

<body>

<!-- 头部 -->
<header>
    <div class="container"></div>
</header>

<!-- 登录框 -->
<article>
    <p><span class="icon icon-position"></span>登录</p>
    <em></em>
    <div>
        <form id="form">
            <p>用户名</p>
            <input type="text" name="username" placeholder="请输入您的用户名" class="text">
            <p>密码</p>
            <input type="password" name="password" placeholder="请输入您的密码" class="text">
            <input type="hidden" name="cgflag" value="3"/>
            <p id="errorTips"></p>
            <input type="button" id="submit" value="登录">
        </form>
        <ul id="pic">
            <li></li>
        </ul>
    </div>
</article>

<!-- 版权 -->
<footer>版权所有 翻版必究</footer>
</body>
</html>

<script>

    /*
     * 声明
     */
    var $id_errorTips = $("#errorTips");
    var $name_username = $("input[name='username']");
    var $name_password = $("input[name='password']");
    var username = $name_username.val();
    var password = $name_password.val();
    var cgflag = $("input[name='cgflag']").val();

    $(function () {



        /*
         * 当输入框输入文字时，判断是否合法
         */
        $name_username.on("input", function () {
            username = $name_username.val();
            var rx = new RegExp(/^[a-zA-Z0-9]+$/);
            if (!rx.test(username)) {
                $id_errorTips.html("错误提示：用户名只能为英文字母和数字！");
                $name_username[0].style.border = "1px solid red";
            } else {
                $id_errorTips.html("");
                $name_username[0].style.border = "none";
            }
        });

        $name_password.on("input", function () {
            password = $name_password.val();
            var rx = new RegExp(/^[a-zA-Z0-9]+$/);
            if (!rx.test(password)) {
                $id_errorTips.html("错误提示：用户名只能为英文字母和数字！");
                $name_password[0].style.border = "1px solid red";
            } else {
                $id_errorTips.html("");
                $name_password[0].style.border = "none";
            }
        });

        /*
         * 点击登录按钮
         */
        $("#submit").on("click", function () {
            onsumbit();
        });
    });

    function onsumbit() {
        //判断用户名或密码是否为空或错误
        if (username === '') {
            $id_errorTips.html("错误提示：用户名不能为空！");
            $name_username.focus();
            return false;
        } else if (password === '') {
            $id_errorTips.html("错误提示：密码不能为空！");
            $name_password.focus();
            return false;
        } else if (!/^[a-zA-Z0-9]+$/.test(username)) {
            $id_errorTips.html("错误提示：用户名只能为英文字母和数字！");
            $name_username.focus();
            return false;
        } else if (!/^[a-zA-Z0-9]+$/.test(password)) {
            $id_errorTips.html("错误提示：用户名只能为英文字母和数字！");
            $name_password.focus();
            return false;
        }

        var data = {
            "accountName": username,
            "passwd": password,
            "cgFlag": cgflag
        };


        var requestURL = path + "/userinfo/userloginObject";
        $.ajax({
            type: "POST",
            crossDomain: true,
            url: requestURL,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {

                ////console.info(data);
                if (data.desc === "success") {
                    //本地存储
                    sessionStorage.token = data.token;
                    sessionStorage.account = username;
                    sessionStorage.sys = cgflag;

                    window.location.href = "index.jsp";
                } else if (data.code === 1) {
                    alert(data.desc);
                }
            }
        });


    }

    function doKeyDown(input_key) {
//            alert(111);
        switch (event.keyCode) {
            case 13: //回车
                if (input_key == 1) {
                    if ($("password").val() == '') {
                        $("#password").focus();
                    } else
                        onsumbit();
                } else
                    onsumbit();
                break;
            case 32: //空格
            //....
        }
    }


    document.onkeydown = doKeyDown;
</script>