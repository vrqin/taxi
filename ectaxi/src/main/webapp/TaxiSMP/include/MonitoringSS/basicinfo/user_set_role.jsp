<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>设置权限</title>

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
        <td><input type="checkbox" name="taxismp" id="callingss" value="1">电召服务</td>

        <td><input type="checkbox" name="taxismp" id="enterprisebs" value="2">企业业务</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="taxismp" id="monitoringss" value="3">监控调度</td>

        <td><input type="checkbox" name="taxismp" id="seatscc" value="4">坐席调度</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="taxismp" id="servicees" value="5">服务考评</td>

        <td><input type="checkbox" name="taxismp" id="comprehensiveas" value="6">综合分析</td>
    </tr>
    <tr>
        <td><input type="checkbox" name="taxismp" id="dynamicis" value="7">动态稽查</td>

        <td><input type="checkbox" name="taxismp" id="operationsc" value="8">运营服务</td>


        <input type="hidden" id="accountID" name="accountID" value="">
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

        /*
        ** 判断当前状态是否为修改内容
        */
        if ('${param.accountID}' > 0) {
            loadvalue();
        }


    });

    /*
    ** 获取选中项的信息，并显示在输入框
    */
    function loadvalue() {

        $.ajax({
            url: path + '/userinfo/findUserById?id=' +${param.accountID},
            dataType: "json",
            type: "GET",
            success: function (data) {
//					////console.info(data);
                $('#accountID').val(data.accountID);

                for (var i = 0; i < data.privilegeSet.length; i++) {
                    $("input[value=" + data.privilegeSet[i].id + "]").prop("checked", true);
                }
                if (data.clientId != 0) {
                    $("#seatscc").attr("disabled", true);
                }

            }
        });
    }


    /*
    ** 判断必填内容不能为空；如果司机ID为空，则为添加数据；如果司机ID有值，则为修改数据
    */
    function completedForm(dialog, grid, p) {

        var callingss = $('#callingss:checked').val();
        if (callingss == undefined) {
            callingss = 0;
        }
        var enterprisebs = $('#enterprisebs:checked').val();
        if (enterprisebs == undefined) {
            enterprisebs = 0;
        }
        var monitoringss = $('#monitoringss:checked').val();
        if (monitoringss == undefined) {
            monitoringss = 0;
        }
        var seatscc = $('#seatscc:checked').val();
        if (seatscc == undefined) {
            seatscc = 0;
        }
        var servicees = $('#servicees:checked').val();
        if (servicees == undefined) {
            servicees = 0;
        }
        var comprehensiveas = $('#comprehensiveas:checked').val();
        if (comprehensiveas == undefined) {
            comprehensiveas = 0;
        }
        var dynamicis = $('#dynamicis:checked').val();
        if (dynamicis == undefined) {
            dynamicis = 0;
        }
        var operationsc = $('#operationsc:checked').val();
        if (operationsc == undefined) {
            operationsc = 0;
        }
        var clientid = $("#accountID").val();
        var data = {
            "clientid": clientid,
            "callingss": callingss,
            "enterprisebs": enterprisebs,
            "monitoringss": monitoringss,
            "seatscc": seatscc,
            "servicees": servicees,
            "comprehensiveas": comprehensiveas,
            "dynamicis": dynamicis,
            "operationsc": operationsc,
            "token": token
        };
////console.info(data);
//		return;
        var requestURL = path + "/userinfo/saveorupdateUserRole";

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