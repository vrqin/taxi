<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>处理提现</title>

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
        <input type="hidden" id="orderid" name="orderid">
        <td><span class="required">*</span>收款人姓名：<input id="name" name="name" class="easyui-textbox"
                                                        data-options="validType:'length[1,20]'" readonly/></td>
        <td><span class="required">*</span>收款账号：<input id="cashaccount" name="cashaccount" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'" readonly/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>金额：<input id="money" name="money" class="easyui-textbox"
                                                     data-options="validType:'length[1,20]'" readonly/>元
        </td>
        <td><span class="required">*</span>收款方式：<input id="paytype" name="paytype" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'" readonly/></td>
    </tr>
    <tr>
        <td><span class="required">*</span>处理人姓名：<input id="dealpeople" name="dealpeople" class="easyui-textbox"
                                                        data-options="validType:'length[1,20]'" readonly/></td>
        <td><span class="required">*</span>流水号：<input id="ccc" name="ccc" class="easyui-textbox"
                                                      data-options="validType:'length[1,20]'" readonly/></td>
        <%--<td></td>--%>
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
    var name = "${param.name}";
    var amount = "${param.amount}";
    var cashaccount = "${param.cashaccount}";
    var extracttime = "${param.extracttime}";
    var phone = "${param.phone}";
    var paytype = "${param.way}";

    $(function () {

        //console.info(globab_clientId);

        /*
         ** 判断当前状态是否为修改内容
         */
        $('#name').textbox("setValue", name);
        $('#cashaccount').textbox("setValue", cashaccount);
        $('#money').textbox("setValue", amount);
        $('#paytype').combobox("setValue", paytype);
        $('#account').textbox("setValue", name);
        $('#dealpeople').textbox("setValue", token);
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

        <%--$.ajax({--%>
        <%--url: path + '/payrecords/findPayrecordsByid?id='+${param.orderid},--%>
        <%--dataType: "json",--%>
        <%--type: "POST",--%>
        <%--success: function (data) {--%>
        <%--//console.info(data);--%>
        <%--$('#orderid').val(data.orderid);--%>
        <%--//						$('#money').textbox("setValue",data.money);--%>
        <%--//						$('#paytype').combobox("setValue",data.paytype);--%>
        <%--//						$('#account').textbox("setValue",data.account);--%>
        <%--//						loaddriver(data.account);--%>

        <%--}--%>
        <%--});--%>
    }

    function loaddriver(account) {

        $.ajax({
            url: path + '/driver/findByaccount?account=' + account,
            dataType: "json",
            type: "POST",
            success: function (data) {
                //console.info(data);

//						$('#phone').textbox("setValue",data.phone);
//						$('#cashaccount').textbox("setValue",data.phone);
//						$('#name').textbox("setValue",data.name);


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
        var orderid = $('#orderid').val();

        var cashaccount = $('#cashaccount').textbox("getValue");
        var dealpeople = token;

        var data = {
            "orderid": orderid,
            "dealpeople": dealpeople
        };

        console.info(data);

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

    function completedDeal() {
        window.open("https://auth.alipay.com/login/index.htm", "newwindow");
    }
</script>
