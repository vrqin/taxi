<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>添加发票</title>

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
        <td><span class="required">*</span>发票代码：<input id="invoicecode" name="invoicecode" class="easyui-textbox"
                                                       data-options="validType:'length[1,20]'"/></td>
        <td><span class="required">*</span>领票人：<input id="ledholder" name="ledholder" class="easyui-textbox"
                                                      data-options="validType:'length[1,20]'"/></td>

    </tr>
    <tr>
        <td><span class="required">*</span>发票开始号码：<input id="invoicestart" name="invoicestart" class="easyui-textbox"
                                                         data-options="validType:'length[1,20]'"/></td>
        <td><span class="required">*</span>发票结束号码：<input id="invoiceend" name="invoiceend" class="easyui-textbox"
                                                         data-options="validType:'length[1,20]'"/></td>
    </tr>
    <tr>

        <td><span class="required">*</span>领票时间：<input id="tickettime" name="tickettime" class="easyui-datetimebox"
                                                       data-options="editable:false"/></td>
        <td>备注：<input id="remarke" name="remarke" class="easyui-textbox" data-options="validType:'length[1,20]'"/></td>
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


        /*
         ** 判断当前状态是否为修改内容
         */
        if ("${param.id}" > 0) {
            loadvalue();
        }


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
                url: path + "/invoice/checkInvoiceName?account=" + account,
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
            url: path + '/invoice/findInvoiceByid?id=' +${param.id},
            dataType: "json",
            type: "GET",
            success: function (data) {
                ////console.info(data);

                $('#id').val(data.id);
                $('#invoicecode').textbox("setValue", data.invoicecode);
                $('#invoiceend').textbox("setValue", data.invoiceend);
                $('#invoicestart').textbox("setValue", data.invoicestart);
                $('#ledholder').textbox("setValue", data.ledholder);
                $('#remarke').textbox("setValue", data.remarke);
                $('#tickettime').textbox("setValue", formattime(data.tickettime.time));

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
        var invoicecode = $('#invoicecode').textbox("getValue");
        var invoiceend = $('#invoiceend').textbox("getValue");
        var invoicestart = $('#invoicestart').textbox("getValue");
        var ledholder = $('#ledholder').textbox("getValue");
        var remarke = $('#remarke').textbox("getValue");
        var tickettime = $('#tickettime').datetimebox("getValue");
        tickettime = StringtoDate(tickettime);//转换时间格式
        var data = {
            "id": id,
            "invoicecode": invoicecode,
            "invoiceend": invoiceend,
            "invoicestart": invoicestart,
            "ledholder": ledholder,
            "remarke": remarke,
            "tickettime": tickettime,
            "token": token
        };

        ////console.info(data);
//				return;
        var requestURL = path + "/invoice/saveorupdateInvoice";

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
