<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加Payrecords</title>

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
        <td><span class="required">*</span>电召单号：<input id="orderid" name="orderid" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>
        <td><span class="required">*</span>司机帐号：<input id="account" name="account" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>提现金额：<input id="money" name="money" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>
        <td><span class="required">*</span>提现方式：<input id="paytype" name="paytype" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>司机号码：<input id="phone" name="paytime" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>
        <td><span class="required">*</span>提现帐号：<input id="cashaccount" name="tradeno" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>
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

        //console.info(globab_clientId);

        /*
         ** 判断当前状态是否为修改内容
         */
        if ("${param.orderid}" > 0) {
            loadvalue();
        }


    });

    $("#paytype").combobox({
        data: waytype,
        valueField: 'id',
        textField: 'text'
    });


    /*
     ** 获取选中项的信息，并显示在输入框
     */
    function loadvalue() {

        $.ajax({
            url: path + '/payrecords/findPayrecordsByid?id=' +${param.orderid},
            dataType: "json",
            type: "POST",
            success: function (data) {
                //console.info(data);

                $('#orderid').textbox("setValue", data.orderid);
//						$('#account').textbox("setValue",data.account);
//						loaddriver(data.account);
//						$('#money').textbox("setValue",data.money);
//						$('#paytype').combobox("setValue",data.paytype);
//						$('#paytime').textbox("setValue",data.paytime);


            }
        });
    }

    function loaddriver(account) {

        $.ajax({
            url: path + '/driver/findByaccount?account=' + account,
            dataType: "json",
            type: "POST",
            success: function (data) {
                //console.info(data);

                $('#phone').textbox("setValue", data.phone);
                $('#cashaccount').textbox("setValue", data.phone);


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
        var orderid = $('#orderid').textbox("getValue");
        var account = $('#account').textbox("getValue");
        var money = $('#money').textbox("getValue");
        var paytype = $('#paytype').combobox("getValue");
        var phone = $('#phone').textbox("getValue");
        var cashaccount = $('#cashaccount').textbox("getValue");

        var data = {
            "orderid": orderid
//					"name":account,
//					"amount":money,
//					"way":paytype,
//					"phone":phone,
//					"cashaccount":cashaccount
        };


        var requestURL = path + "/withdraw/saveorupdateWithdraw";

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
