<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加报警提醒</title>

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

        #extypes, #type, #enable {
            width: 166px;
        }
    </style>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<table class="table">
    <tbody>
    <tr>
        <td>报警公司：<input id="company" class="easyui-textbox"/></td>
        <td>异常类型：
            <select id="extypes" class="easyui-combobox" data-options="editable:false">
                <option value="1">超速</option>
                <option value="2">驶出限区</option>
                <option value="3">区域超速</option>
                <option value="4">疲劳驾驶</option>
                <option value="5">紧急报警</option>
                <option value="6">驶入限区</option>
                <option value="7">防劫预警</option>
                <option value="8">终端超速报警</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>提醒人员：<input id="remind" class="easyui-textbox"/></td>
        <td>通知方式：
            <select id="type" class="easyui-combobox" data-options="editable:false">
                <option value="0">短信通知</option>
                <option value="1">邮件通知</option>
            </select>
        </td>
    </tr>
    <tr>
        <td>是否启用：
            <select id="enable" class="easyui-combobox" data-options="editable:false">
                <option value="0">启用</option>
                <option value="1">未启用</option>
            </select>
        </td>
    </tr>
    </tbody>
</table>

</body>
</html>

<script>
    var clientid = sessionStorage.clientid;

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

        var company = $('#company').val();
        if (!errorAlert(company, "报警公司不能为空！！！")) {
            return false
        }

        var extypes = $("#extypes").combobox("getValue");

        var remind = $('#remind').val();
        if (!errorAlert(remind, "提醒人员不能为空！！！")) {
            return false
        }

        var type = $("#type").combobox("getValue");

        var enable = $("#enable").combobox("getValue");

        var dataUrl = "company=" + company +
            "&enable=" + enable +
            "&extypes=" + extypes +
            "&remind=" + remind +
            "&clientid=" + clientid +
            "&type=" + type;

        $.ajax({
            url: path + '/remindset/saveorupdateRemindSet?' + dataUrl,
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
</script>