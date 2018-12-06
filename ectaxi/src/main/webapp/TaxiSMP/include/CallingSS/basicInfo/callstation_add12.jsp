<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加电召站</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

    <style>
        .table {
            width: 100%;
            /*height: 100%;*/
            font-size: 12px;
            text-align: center;
            border-spacing: 10px;
        }
    </style>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<table class="table">
    <tbody>
    <tr>
        <td>电召站编号：&nbsp;&nbsp;<input id="callstationId" class="easyui-textbox"/></td>
        <td>电召站简称：<input id="name" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td>电话号码：&nbsp;&nbsp;&nbsp;<input id="phone" class="easyui-textbox"/></td>
        <td>位置描述：&nbsp;<input id="position" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td>电召站附近路线：<input id="line" class="easyui-textbox"/></td>
        <td>地理位置：&nbsp;<input id="geographical" class="easyui-textbox"/></td>
    </tr>
    </tbody>
</table>

</body>
</html>

<script>

    /*
    ** 判断传来的参数是否为空或null，是则弹出警告框
    */
    function errorAlert(value, msg) {
        if ((value === null) || (value === "")) {
            $.messager.alert('警告', msg, 'error');
            return false;
        }
        return true;
    }

    /*
    ** 判断必填内容不能为空；正常后提交添加
    */
    function completedForm(dialog, grid, p) {

        var callstationId = $('#callstationId').val();
        if (!errorAlert(callstationId, "电召站编号不能为空！！！")) {
            return false
        }

        var name = $('#name').val();
        if (!errorAlert(name, "电召站简称不能为空！！！")) {
            return false
        }

        var phone = $('#phone').val();
        if (!errorAlert(phone, "电话号码不能为空！！！")) {
            return false
        }

        var position = $('#position').val();
        if (!errorAlert(position, "位置描述不能为空！！！")) {
            return false
        }

        var line = $('#line').val();
        if (!errorAlert(line, "电召站附近路线不能为空！！！")) {
            return false
        }

        var geographical = $('#geographical').val();
        if (!errorAlert(geographical, "地理位置不能为空！！！")) {
            return false
        }

        var dataUrl = "callstationId=" + callstationId +
            "&name=" + name +
            "&phone=" + phone +
            "&position=" + position +
            "&line=" + line +
            "&geographical=" + geographical;
        $.ajax({
            url: path + '/callstation/saveorupdateCallstation?' + dataUrl,
            dataType: "json",
            type: "POST",
            success: function (data) {
                dialog.dialog("destroy");
                grid.datagrid('reload');
                p.messager.show({
                    title: '提示',
                    msg: '添加成功!',
                    timeout: 3000,
                    showType: 'slide'
                });
            }
        });
    }	//function completedForm()结束

    function tsts() {
        alert();
    }
</script>