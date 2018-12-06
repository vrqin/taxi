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
        <td>客户姓名：<input id="name" class="easyui-textbox"/></td>
        <td>联系电话：<input id="phone" class="easyui-textbox"/></td>
        <input type="hidden" id="id" name="id">
    </tr>
    <tr>
        <td>失物分类：
            <select class="easyui-combobox" id="classify" data-options="width:168,panelHeight:'auto',editable:false">
                <option value="1">钥匙</option>
                <option value="2">手机</option>
                <option value="3">电脑</option>
                <option value="4">钱包</option>
                <option value="5">背包</option>
                <option value="6">其它</option>
            </select>
        </td>
        <td>来电时间：<input id="calltime" class="easyui-datetimebox" data-options="editable:false"/></td>
    </tr>
    <tr>
        <td>上车时间：<input id="geton" class="easyui-datetimebox" data-options="editable:false"/></td>
        <td>下车时间：<input id="getoff" class="easyui-datetimebox" data-options="editable:false"/></td>
    </tr>
    <tr>
        <td>查找结果：
            <select class="easyui-combobox" id="state" data-options="width:168,panelHeight:'auto',editable:false">
                <option value="0">未处理</option>
                <option value="1" selected>已退回客户</option>
            </select>
        </td>
        <td>所在车辆：<input id="kabnum" class="easyui-combobox"/></td>
    </tr>
    </tbody>
</table>

</body>
</html>

<script>
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        /*
        ** 判断当前状态是否为修改内容
        */
        if ('${param.id}' > 0) {
            loadvalue();
        }

        $("#kabnum").combobox({
            url: path + '/carinfo/findcarinfotree?clientid=' + globab_clientId,
            method: 'GET',
            valueField: 'id',
            textField: 'text',
            onLoadSuccess: function (data) {
//						console.info(data);
            }
        });

        /*
        ** 获取选中项的信息，并显示在输入框
        */
        function loadvalue() {
            $.ajax({
                url: path + '/lostlibrary/findNameByid?id=' +${param.id},
                dataType: "json",
                type: "GET",
                success: function (data) {
                    ////console.info(data);
                    $('#id').val(data.id);
                    $('#name').textbox("setValue", data.name);
                    $('#phone').textbox("setValue", data.phone);
                    $('#classify').combobox("setValue", data.classify);
                    $('#calltime').datetimebox("setValue", formattime(data.createtime.time));
                    $('#geton').datetimebox("setValue", formattime(data.geton.time));
                    $('#getoff').datetimebox("setValue", formattime(data.getoff.time));
                    $('#state').combobox("setValue", data.state);
                    $('#kabnum').combobox("setValue", data.kabnum);
                }
            });
        }

    });

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

        var id = $("#id").val();

        var name = $('#name').textbox("getValue");
        if (!errorAlert(name, "客户姓名不能为空！！！")) {
            return false
        }

        var phone = $('#phone').textbox("getValue");
        if (!errorAlert(phone, "手机号码不能为空！！！")) {
            return false
        }

        var classify = $('#classify').combobox("getValue");
        if (!errorAlert(classify, "失物分类不能为空！！！")) {
            return false
        }

        var calltime = $('#calltime').datetimebox("getValue");
        if (!errorAlert(calltime, "来电时间不能为空！！！")) {
            return false
        }

        var geton = $('#geton').datetimebox("getValue");
        if (!errorAlert(geton, "上车时间不能为空！！！")) {
            return false
        }

        var getoff = $('#getoff').datetimebox("getValue");
        if (!errorAlert(getoff, "下车时间不能为空！！！")) {
            return false
        }

        var kabnum = $('#kabnum').combobox("getText");

        var state = $('#state').combobox("getValue");

        var dataUrl = "id=" + id +
            "&name=" + name +
            "&phone=" + phone +
            "&classify=" + classify +
            "&calltime=" + calltime +
            "&geton=" + geton +
            "&getoff=" + getoff +
            "&kabnum=" + kabnum +
            "&clientid=" + globab_clientId +
            "&token=" + token +
            "&state=" + state;
        $.ajax({
            url: path + '/lostlibrary/saveorupdateLostLibrary?' + dataUrl,
            dataType: "json",
            type: "POST",
            success: function (data) {

                grid.datagrid('reload');
                window.parent.$.messager.show({
                    title: '提示',
                    msg: data.desc,
                    timeout: 3000,
                    showType: 'slide'
                });
                dialog.dialog("destroy");
            }
        });
    }	//function completedForm()结束
</script>