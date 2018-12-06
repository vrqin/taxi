<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>修改密码</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

    <style type="text/css">
        .accountinfo {
            padding: 0;
            font-size: 14px;
        }

        .accountinfo li {
            list-style: none;
            margin: 10px;

        }
    </style>


</head>
<body class="easyui-layout" data-options="border:true ,fit:true" style="margin:10px;">
<div style="margin: 10px;padding: 10px;border: 1px solid #c8c8c8;">

    <ul class="accountinfo">
        <li><label>帐号:&nbsp;&nbsp;</label>
            <input id="username" class="easyui-textbox" style="width:160px;">
        </li>
        <li><label>旧密码:&nbsp;</label>
            <input id="password" class="easyui-textbox" style="width:160px;">
        </li>
        <li><label>新密码:&nbsp;</label>
            <input id="newpassword" class="easyui-textbox" style="width:160px;">
        </li>
        <li><label>确认密码:</label>
            <input id="confirmpassword" class="easyui-textbox" style="width:160px;">
        </li>
    </ul>
    <div>
        <button id="save" type="button" class="easyui-linkbutton" iconCls="icon-save" style="width:80px">保存</button>
        <button id="reset" type="button" class="easyui-linkbutton" iconCls="icon-redo" style="width:80px">重置</button>
    </div>
</div>
</body>
</html>


<script>
    var grid;

    $(function () {

        $("#save").click(function () {
            var username = $("#username").val();
            var password = $("#password").val();
            if (username == null || username == "") {
                $.messager.alert('警告', "用户名称不能为空！！！", 'error');
                return;
            }
            if (password == null || password == "") {
                $.messager.alert('警告', "密码不能为空！！！", 'error');
                return;
            }
            var newpassword = $("#newpassword").val();
            if (newpassword == null || newpassword == "") {
                $.messager.alert('警告', "密码不能为空！！！", 'error');
                return;
            }
            var confirmpassword = $("#confirmpassword").val();
            if (confirmpassword == null || confirmpassword == "") {
                $.messager.alert('警告', "密码不能为空！！！", 'error');
                return;
            }
            if (newpassword != confirmpassword) {
                $.messager.alert('警告', "新密码与确认密码不一致！！！", 'error');
                return;
            }

            usersetpassword(username, password, newpassword);

        });

        $("#reset").click(function () {
            reset();
        })

    });

    function usersetpassword(username, password, newpassword) {
        var dataUrl = "username=" + username + "&password=" + password + "&newpassword=" + newpassword;
        $.ajax({
            url: path + '/userinfo/usersetpassword?' + dataUrl,
            dataType: 'json',
            type: "GET",
            async: false,
            success: function (data) {
                if (data.desc.indexOf("成功") > -1) {
                    $.messager.show({
                        title: '提示',
                        msg: "修改成功",
                        timeout: 3000,
                        showType: 'slide'
                    });
                    reset();
                } else {
                    $.messager.alert("错误", "修改错误", "error");
                }

            }
        });
    }

    function reset() {
        $("#username").textbox('setValue', "");
        $("#password").textbox('setValue', "");
        $("#newpassword").textbox('setValue', "");
        $("#confirmpassword").textbox('setValue', "");
    }


</script>