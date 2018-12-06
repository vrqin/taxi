<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加Role</title>

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
    <tr>
    <tr>
        <input type="hidden" id="id" name="id" value="">
        <td><span class="required">*</span>角色名称：<input id="name" name="name" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>备注：<input id="roleRemark" name="roleRemark" class="easyui-textbox"
                                                     data-options="validType:'length[1,20]'"/></td>
    </tr>
    <tr id="registerTimetr">
        <td><span class="required">*</span>注册时间：<input id="registerTime" name="registerTime"
                                                       class="easyui-datetimebox"/></td>

        <%--<td><span class="required">*</span>roleName：<input id="roleName" name="roleName" class="easyui-textbox"  data-options="validType:'length[1,20]'" /></td>--%>
        <%--<td><span class="required">*</span>company：<input id="company" name="company" class="easyui-textbox"  data-options="validType:'length[1,20]'" /></td>--%>
        <%--<td><span class="required">*</span>membership：<input id="membership" name="membership" class="easyui-textbox"  data-options="validType:'length[1,20]'" /></td>--%>
        <%--<td><span class="required">*</span>remark：<input id="remark" name="remark" class="easyui-textbox"  data-options="validType:'length[1,20]'" /></td>--%>
        <%--<td><span class="required">*</span>validity：<input id="validity" name="validity" class="easyui-textbox"  data-options="validType:'length[1,20]'" /></td>--%>


    </tr>


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


        /*
         ** 判断当前状态是否为修改内容
         */
        if ("${param.id}" > 0) {
            loadvalue();
        } else {
            $("#registerTimetr").hide();
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
                url: path + "/role/checkRoleName?account=" + account,
                dataType: 'json',
                type: 'GET',
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
            url: path + '/role/findRoleByid?id=' +${param.id},
            dataType: "json",
            type: "GET",
            success: function (data) {
                ////console.info(data);

                $('#id').val(data.roleId);
                $('#name').textbox("setValue", data.name);
                $('#registerTime').datetimebox("setValue", formattime(data.registerTime.time));
                $('#roleName').textbox("setValue", data.roleName);
                $('#roleRemark').textbox("setValue", data.roleRemark);
                $('#company').textbox("setValue", data.company);
                $('#membership').textbox("setValue", data.membership);
                $('#remark').textbox("setValue", data.remark);
                $('#validity').textbox("setValue", data.validity);

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
        var name = $('#name').textbox("getValue");
        var roleRemark = $('#roleRemark').textbox("getValue");
        var registerTime = $('#registerTime').datetimebox("getValue");
        if (registerTime != "") {
            registerTime = StringtoDate(registerTime);
        }

        var data = {
            "roleId": id,
            "name": name,
            "registerTime": registerTime,
            "roleRemark": roleRemark,
            "clientid": globab_clientId

        };

        ////console.info(data);

        var requestURL = path + "/role/saveorupdateRole";

        $.ajax({
            type: "POST",
            crossDomain: true,
            url: requestURL,
            data: JSON.stringify(data), //必须转成JSON进行传递，否则会报code 117错误
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
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
