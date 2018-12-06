<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>座席添加</title>

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
            font-size: 12px;
            text-align: center;
            border-spacing: 10px;
        }

        #sex {
            width: 166px;
        }
    </style>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<table class="table">
    <tbody>
    <tr>
        <td>姓名：<input id="name" class="easyui-textbox"/></td>
        <td>性别：
            <select id="sex" class="easyui-combobox" data-options="editable:false">
                <option value="0">男</option>
                <option value="1">女</option>
            </select>
        </td>
        <input type="hidden" id="opruser" name="opruser">
    </tr>
    <tr>
        <td>帐号：<input id="mobile" class="easyui-textbox" type="number" prompt="请收入手机号码"/></td>
        <td>密码：<input id="password" class="easyui-textbox" value="123456" prompt="只能为数字"/></td>
    </tr>
    <tr>
        <td>坐席号：<input id="seatsnum" class="easyui-textbox"/></td>
        <td>分机号：<input id="extensionnum" class="easyui-textbox"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>所属公司：
            <select id="company" class="easyui-combobox" data-options="editable:false" style="width:176px;">

            </select>
        </td>
        <td><span class="required">*</span>权限：
            <select id="roleid" class="easyui-combobox" data-options="editable:false" style="width:176px;">

            </select>
        </td>
    </tr>
    <tr>
        <td>是否指定派单：<select id="assign" class="easyui-combobox" data-options="editable:false"
                           style="width:176px;"></select></td>
        <td></td>
    </tr>
    </tbody>
</table>

</body>
</html>

<script>
    /*
     ** 全局变量声明
     */
    var oldname;
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        //console.info('${param.opruser}');
        /*
        ** 判断当前状态是否为修改内容
        */
        if ('${param.opruser}' > 0) {
            loadvalue();
            $('#mobile').textbox('textbox').attr('readonly', true)
        }

        /*
    	** 判断登录帐号是否已存在
    	*/
        $("#mobile").next("span").children("input").eq(0).blur(function () {
            var mobile = $('#mobile').val();
            checkMobile(mobile);

        });


        $("#company").combobox({
            url: path + '/client/findclienttree?clientid=' + globab_clientId,
            method: 'GET',
            valueField: 'id',
            textField: 'text',
            onLoadSuccess: function (data) {
                ////console.info(data);
                if (globab_clientId != 0) {
                    $(this).combobox("setValue", globab_clientId);

                }
            }
        });

        $("#roleid").combobox({
            url: path + '/role/findRoleSeatstree?clientid=' + globab_clientId,
            method: 'GET',
            valueField: 'id',
            textField: 'text',
            onLoadSuccess: function (data) {
//				console.info(data);
                if (data != "" && data != null) {
                    $(this).combobox("setValue", data[0].id);

                }
            }

        });

        $("#assign").combobox({
            data: isvalue,
            valueField: 'id',
            textField: 'text'
        });

        /*
        ** 获取选中项的信息，并显示在输入框
        */
        function loadvalue() {
            $.ajax({
                url: path + '/passenger/findPassByid?opruser=' +${param.opruser},
                dataType: "json",
                type: "GET",
                success: function (data) {
                    //console.info(data);
                    $('#opruser').val(data.opruser);
                    $('#name').textbox("setValue", data.name);
                    $('#sex').combobox("setValue", data.sex);
                    $('#mobile').textbox("setValue", data.account);
                    $('#password').textbox("setValue", data.password);
                    $('#seatsnum').textbox("setValue", data.seatsnum);
                    $('#extensionnum').textbox("setValue", data.extensionnum);
//					$('#unit').textbox("setValue",data.unit);
                    $('#roleid').combobox("setValue", data.roleid);
                    $('#company').combobox("setValue", data.clientid);
                    $('#assign').combobox("setValue", data.assign);
                    oldname = data.account;

                }
            });

        }

    });


    function checkMobile(mobile) {
        if (mobile == null || mobile == "") {
            $.messager.alert('警告', "不能为空！", 'error');
            return;
        }
        if (oldname != mobile) {
            $.ajax({
                url: path + "/passenger/checkPassName?opruser=" + mobile,
                dataType: 'json',
                type: 'GET',
                async: false,
                success: function (data) {
                    if (data.code !== 0) {
                        $.messager.alert('警告', "用户已存在！", 'error');
                    }
                }
            });
        }
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
    ** 判断必填内容不能为空；如果座席ID为空，则为添加数据；如果座席ID有值，则为修改数据
    */
    function completedForm(dialog, grid, p) {
        var opruser = $('#opruser').val();

        var name = $('#name').val();
        if (!errorAlert(name, "姓名不能为空！！！")) {
            return false
        }

        var sex = $("#sex").combobox("getValue");

        var mobile = $('#mobile').val();
        if (!errorAlert(mobile, "帐号不能为空！！！")) {
            return false
        }
        checkMobile(mobile);
        var password = $('#password').val();
        if (!errorAlert(password, "密码不能为空！！！")) {
            return false
        }

        var seatsnum = $('#seatsnum').textbox("getValue");
        var extensionnum = $('#extensionnum').textbox("getValue");
//		var unit= $('#unit').textbox("getValue");
        var company = $('#company').combobox("getValue");
        if (!errorAlert(company, "公司不能为空！！！")) {
            return false
        }
        var roleid = $('#roleid').combobox("getValue");

        var assign = $('#assign').combobox("getValue");

        var dataUrl = "opruser=" + opruser +
            "&name=" + name +
            "&sex=" + sex +
            "&mobile=" + mobile +
            "&seatsnum=" + seatsnum +
            "&extensionnum=" + extensionnum +
            "&roleid=" + roleid +
            "&company=" + company +
            "&assign=" + assign +
            "&clientid=" + globab_clientId +
            "&token=" + token +
            "&password=" + password;

        $.ajax({
            url: path + '/passenger/saveorupdatePassenger?' + dataUrl,
            dataType: "json",
            type: "POST",
            success: function (data) {
                grid.datagrid('reload');
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