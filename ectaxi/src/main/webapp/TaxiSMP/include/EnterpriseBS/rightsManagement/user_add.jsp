<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加登录用户</title>

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
        <input type="hidden" id="accountID" name="accountID" value="">
        <td><span class="required">*</span>权限：
            <select id="roleid" class="easyui-combobox" data-options="editable:false" style="width:176px;">

            </select>
        </td>
        <td><span class="required">*</span>所属公司：
            <select id="company" class="easyui-combobox" data-options="editable:false" style="width:176px;">

            </select>
        </td>
    </tr>
    <tr>
        <td><span class="required">*</span>帐号：<input id="accountName" name="clientName" class="easyui-textbox"
                                                     data-options="validType:'length[1,15]'"/></td>
        <td><span class="required">*</span> 密码：<input id="passwd" class="easyui-textbox"
                                                      data-options="validType:'length[1,15]'"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>用户名称：<input id="userName" class="easyui-textbox"/></td>
        <td colspan="2"><span class="required">*</span>备注：<input id="remark" class="easyui-textbox"
                                                                 style="width:176px;"/></td>
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

//		alert(globab_clientId);
        //本地
        $("#roleid").combobox({
            url: path + '/role/findRoletree?clientid=' + globab_clientId,
            method: 'GET',
            valueField: 'id',
            textField: 'text',
            onLoadSuccess: function (data) {
                ////console.info(data);
            },
            onChange: function (newValue, oldValue) {
                //console.info(newValue);
                var roleid = $(this).combobox("getText");
                if (roleid.indexOf("人工") > -1) {
                    $(this).combobox("setValue", "");
                    alert("人工坐席权限只能‘电召服务系统下的坐席人员添加’");
                }

            }


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

        /*
        ** 判断当前状态是否为修改内容
        */
        if ('${param.accountID}' > 0) {
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
                url: path + "/userinfo/checkUserinfoName?account=" + account,
                dataType: 'json',
                type: 'GET',
                async: false,
                success: function (data) {
                    if (data.code !== 0) {
                        $.messager.alert('警告', "用户已存在！", 'error');
                        $('#accountName').textbox("setValue", "");
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
            url: path + '/userinfo/findUserById?id=' +${param.accountID},
            dataType: "json",
            type: "GET",
            success: function (data) {
                ////console.info(data);

                $('#accountID').val(data.accountID);
                $('#accountName').textbox("setValue", data.accountName);
                $('#passwd').textbox("setValue", data.passwd);
                $('#userName').textbox("setValue", data.userName);
                $('#company').combobox("setValue", data.clientId);
                $('#remark').textbox("setValue", data.remark);
                $('#roleid').combobox("setValue", data.roleid);
                oldname = data.accountName;
            }
        });
    }

    /**
     * 获取时间
     * 0为当前时间
     * 1为明天时间
     * -1为前天时间
     * @param AddDayCount
     * @returns {string}
     * @constructor
     */
    function GetDateStr(AddDayCount) {
        var dd = new Date();
        dd.setDate(dd.getDate() + AddDayCount);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = (dd.getMonth() + 1) < 10 ? "0" + (dd.getMonth() + 1) : (dd.getMonth() + 1);//获取当前月份的日期，不足10补0
        var d = dd.getDate() < 10 ? "0" + dd.getDate() : dd.getDate(); //获取当前几号，不足10补0
        return y + "-" + m + "-" + d + " 00:00:00";
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

        var accountID = $('#accountID').val();
        var accountName = $('#accountName').textbox("getValue");
        var passwd = $('#passwd').textbox("getValue");
        var userName = $('#userName').textbox("getValue");
        var remark = $('#remark').textbox("getValue");
        var company = $('#company').combobox("getValue");
        var roleid = $('#roleid').combobox("getValue");

        var data = {
            "accountID": accountID,
            "accountName": accountName,
            "passwd": passwd,
            "userName": userName,
            "remark": remark,
            "clientid": company,
            "roleid": roleid,
            "token": token
        };
////console.info(data);

        var requestURL = path + "/userinfo/saveorupdateUserInfo";

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