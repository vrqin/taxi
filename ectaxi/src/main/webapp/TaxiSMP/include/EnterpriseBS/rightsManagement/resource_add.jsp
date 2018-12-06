<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加Resource</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>

    <style>
        .table {
            width: 100%;
            /*height: 100%;*/
            border-spacing: 10px;
            font-size: 12px;
            text-align: center;
        }

        .table tbody tr td {
            position: relative;
        }

        #defaultPhoto {
            width: 136px;
            border: 1px solid #DDDDDD;
            display: block;
            position: absolute;
            top: 0;
            left: 128px;
        }

        #sex {
            width: 164px;
        }

        #fileTd {
            text-align: left;
            padding-left: 34px;
        }

        .required {
            color: red;
        }
    </style>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<table class="table">
    <tbody>
    <tr>
        <input type="hidden" id="id" name="id" value="">
        <td><span class="required">*</span>所属系统：<input id="ppid" name="ppid" class="easyui-combobox"/></td>
        <td><span class="required">*</span>菜单：<input id="pid" name="pid" class="easyui-combobox"/></td>
    </tr>

    <tr>
        <td><span class="required">*</span>页面类型：<input id="type" name="type" class="easyui-combobox"/></td>
        <td><span class="required">*</span>标题名称：<input id="powerName" name="powerName" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>地址：<input id="powerUrl" name="powerUrl" class="easyui-textbox"/></td>
        <td><span class="required">*</span>图标：<input id="iconCls" name="iconCls" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td>备注：<input id="powerRemark" name="powerRemark" class="easyui-textbox"/></td>
        <td>创建时间：<input id="registerTime" name="registerTime" class="easyui-textbox"/></td>
    </tr>


    </tbody>
</table>

</body>
</html>

<script>
    /*
     ** 全局变量声明
     */
    var oldname = "";

    var oldphone = "";
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    var flag = true;
    $(function () {

        ////console.info(globab_clientId);

        $("#ppid").combobox({
            url: path + '/privilege/findprivilegetree',
            method: 'GET',
            valueField: 'id',
            textField: 'text',
            onLoadSuccess: function (data) {
                ////console.info(data);

            },
            onChange: function (newValue, oldValue) {

                $("#pid").combobox({
                    url: path + '/resource/findresourcegetree?ppid=' + newValue,
                    method: 'GET',
                    valueField: 'id',
                    textField: 'text',
                    onLoadSuccess: function (data) {
                        ////console.info(data);
                        $("#pid").combobox("setText", "");
                    }
                });
            }
        });

        $("#type").combobox({
            data: restype,
            valueField: 'id',
            textField: 'text'
        });

        /*
         ** 判断当前状态是否为修改内容
         */
        if ("${param.id}" > 0) {
            loadvalue();
        }

        /*
         ** 离开执行判断电话号码是否已存在
         */
        $("#accountName").next("span").children("input").eq(0).blur(function () {
            var accountName = $('#accountName').val();

            checkUserAccount(accountName);
        });

    });

    /*
     ** 判断登录帐号是否已存在
     */
    function checkUserAccount(account) {
        if (account == null || account == "") {
            $.messager.alert('警告', "不能为空！", 'error');
            return;
        }
        if (oldname != account) {
            $.ajax({
                url: path + "/resource/checkResourceName?account=" + account,
                dataType: 'json',
                type: 'POST',
                async: false,
                success: function (data) {
                    if (data.code !== 0) {
                        $.messager.alert('警告', "用户已存在！", 'error');
//								$('#accountName').textbox("setValue","");
                    }
                }
            });
        }

    }

    /*
     ** 获取选中项的信息，并显示在输入框
     */
    function loadvalue() {

        $.ajax({
            url: path + '/resource/findResourceByid?id=' +${param.id},
            dataType: "json",
            type: "POST",
            success: function (data) {
                ////console.info(data);

                $('#id').val(data.id);
                $('#iconCls').textbox("setValue", data.iconCls);
                $('#pid').combobox("setValue", data.pid);
                $('#powerName').textbox("setValue", data.powerName);
                $('#powerRemark').textbox("setValue", data.powerRemark);
                $('#powerUrl').textbox("setValue", data.powerUrl);
                $('#ppid').combobox("setValue", data.ppid);
                $('#registerTime').textbox("setValue", data.registerTime);
                $('#type').combobox("setValue", data.type);

            }
        });
    }


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
     ** 判断必填内容不能为空；如果司机ID为空，则为添加数据；如果司机ID有值，则为修改数据
     */
    function completedForm(dialog, grid, p) {

        var id = $('#id').val();
        var iconCls = $('#iconCls').textbox("getValue");

        var powerName = $('#powerName').textbox("getValue");
        var powerRemark = $('#powerRemark').textbox("getValue");
        var powerUrl = $('#powerUrl').textbox("getValue");

        var registerTime = $('#registerTime').textbox("getValue");

        var pid = $('#pid').combobox("getValue");
        var ppid = $('#ppid').combobox("getValue");
        var type = $('#type').combobox("getValue");

        var data = {
            "id": id,
            "iconCls": iconCls,
            "pid": pid,
            "powerName": powerName,
            "powerRemark": powerRemark,
            "powerUrl": powerUrl,
            "ppid": ppid,
            "registerTime": registerTime,
            "type": type,
            "token": token
        };

        ////console.info(data);
//return;
        var requestURL = path + "/resource/saveorupdateResource";

        $.ajax({
            type: "POST",
            crossDomain: true,
            url: requestURL,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {

                grid.treegrid('reload');
                window.parent.$.messager.show({
                    title: '提示',
                    msg: data.desc,
                    showType: 'slide'
                });
                dialog.dialog("destroy");
            }
        });


    }	//function completedForm()结束


</script>
