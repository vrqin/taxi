<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>驾驶员企业</title>

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
        <td><span class="required">*</span>客户名称：<input id="clientName" name="clientName" class="easyui-textbox"
                                                       data-options="validType:'length[1,15]'"/></td>
        <td><span class="required">*</span> 联系人：<input id="contactperson" class="easyui-textbox"
                                                       data-options="validType:'length[1,15]'"/></td>
        <input type="hidden" id="clientId" name="clientId">
    </tr>
    <tr id="pidcityFlag">
        <td>上一级：
            <select id="pid" class="easyui-combotree" data-options="editable:false" style="width:140px;">
            </select>
        </td>
        <td>地市分公司：
            <select id="cityFlag" class="easyui-combobox" data-options="editable:false" style="width:140px;">
                <option value="0">否</option>
                <option value="1" selected>是</option>
            </select>
        </td>

    </tr>
    <tr>
        <td><span class="required">*</span>联系电话：<input id="phone" class="easyui-textbox"
                                                       data-options="validType:'length[1,18]'"/></td>
        <td><span class="required">*</span>公司：<input id="company" class="easyui-textbox"/></td>

    </tr>
    <tr>

        <td colspan="2"><span class="required">*</span>地址：<input id="address" class="easyui-textbox"
                                                                 style="width: 460px"/></td>
    </tr>

    <tr>

        <td>邮箱：<input id="email" class="easyui-textbox"/></td>
        <td>备注：<input id="remark" class="easyui-textbox"/></td>
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
    $(function () {

        $("#pid").combotree({
            url: path + '/client/findClienttree?clientid=' + globab_clientId,
            valueField: 'id',
            textField: 'text',
            onLoadSuccess: function (data) {
//                    ////console.info(data);
            }
        });


        /*
        ** 判断当前状态是否为修改内容
        */
        if ('${param.clientId}' > 0) {
            loadvalue();
        }

        /*
        ** 判断当前时间值是否为空，如果为空则设置值为明年今天时间
        */

//
//        /*
//    	** 判断登录帐号是否已存在
//    	*/
//        $("#account").next("span").children("input").eq(0).blur(function(){
//
//            var account = $('#account').val();
//			checkDriverAccount(account);
//			$("#iframe2")[0].contentWindow.document.getElementById('account').value= account;
//        });
//		/*
//		 ** 离开执行判断电话号码是否已存在
//		 */
//		$("#phone").next("span").children("input").eq(0).blur(function(){
//			var phone = $('#phone').val();
//			checkDriverPhone(phone);
//		});
    });

    /*
     ** 判断登录帐号是否已存在
     */
    function checkDriverAccount(account) {
        if (account == null || account == "") {
            $.messager.alert('警告', "不能为空！", 'error');
            return;
        }
        if (oldname != account) {
            $.ajax({
                url: path + "/driver/checkDriverName?account=" + account,
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
     ** 判断电话号码是否已存在
     */
    function checkDriverPhone(phone) {
        if (phone == null || phone == "") {
            $.messager.alert('警告', "不能为空！", 'error');
            return;
        }
        if (oldphone != phone) {
            $.ajax({
                url: path + "/driver/checkDriverPhone?phone=" + phone,
                dataType: 'json',
                type: 'GET',
                async: false,
                success: function (data) {

                    if (data.code !== 0) {
                        $.messager.alert('警告', "电话号码存在！", 'error');
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
            url: path + '/client/findClientByid?id=' +${param.clientId},
            dataType: "json",
            type: "POST",
            success: function (data) {
                ////console.info(data);
                $('#clientId').val(data.clientId);
                $('#clientName').textbox("setValue", data.clientName);
                $('#pid').combotree("setValue", data.pid);
                $('#cityFlag').textbox("setValue", data.cityFlag);
                $('#contactperson').textbox("setValue", data.contactperson);
                $('#phone').textbox("setValue", data.phone);
                $('#address').textbox("setValue", data.address);
                $('#company').textbox("setValue", data.company);
                $('#email').textbox("setValue", data.email);
                $('#remark').textbox("setValue", data.remark);
                if (data.clientId == globab_clientId) {
                    $("#pidcityFlag").hide();
                }
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

        var clientId = $('#clientId').val();
        var clientName = $('#clientName').textbox("getValue");
        if (!errorAlert(clientName, "客户名称不能为空！！！")) {
            return false
        }
        checkDriverAccount(clientName);

        var pid = $('#pid').combotree("getValue");
        if (!errorAlert(pid, "上级不能为空！！！")) {
            return false
        }

        var contactperson = $('#contactperson').textbox("getValue");
        if (!errorAlert(contactperson, "联系人不能为空！！！")) {
            return false
        }

        var phone = $('#phone').textbox("getValue");
        if (!errorAlert(phone, "电话不能为空！！！")) {
            return false
        }
        checkDriverPhone(phone);

        var company = $('#company').textbox("getValue");
        if (!errorAlert(company, "公司不能为空！！！")) {
            return false
        }

        var cityFlag = $('#cityFlag').combobox("getValue");


        var address = $('#address').textbox("getValue");
        var email = $('#email').textbox("getValue");
        var remark = $('#remark').textbox("getValue");

        var data = {
            "clientId": clientId,
            "clientName": clientName,
            "pid": pid,
            "cityFlag": cityFlag,
            "contactperson": contactperson,
            "phone": phone,
            "company": company,
            "address": address,
            "email": email,
            "remark": remark,
            "token": token
        };
        ////console.info(data);
//return;
        var requestURL = path + "/client/saveorupdateClient";
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