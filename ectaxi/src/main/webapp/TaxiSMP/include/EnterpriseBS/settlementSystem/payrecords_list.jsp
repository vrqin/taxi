<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>模拟司机申请提现</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/utiljavascript.js"></script>
    <script src="../../../public/js/constant.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>关键字</label>
        <input id="key" class="easyui-textbox" style="width:160px;" prompt="企业名称 | 司机姓名">
        <label>&nbsp;提现方式</label>
        <select id="way" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="0">支付宝</option>
            <option value="1">微信</option>
            <option value="2">信用卡</option>
            <option value="3">储蓄卡</option>
            <option value="4">其它</option>
        </select>
        <label>&nbsp;提现时间</label>
        <input id="begintime" class="easyui-datetimebox" data-options="width:160,editable:false">
        <label>至</label>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,editable:false">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" data-options="iconCls:'icon-search'">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>

    </div>
</div>

</body>
</html>

<script>
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    var grid;


    $(function () {

        /*
        ** 默认加载
        */
        acquireData("", -1, '', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            var way = $("#way").combobox("getValue");
            var begintime = $("#begintime").datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            acquireData(key, way, begintime, endtime);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#way").combobox("setValue", "-1");
            $("#begintime").datetimebox("setValue", "");
            $("#endtime").datetimebox("setValue", "");
            acquireData('', -1, '', '');
        });

        /*
        ** 获取数据
        */
        function acquireData(key, way, begintime, endtime) {
            var dataUrl = 'sort=id&order=desc&begintime=&endtime=&key=' + key + "&clientid=" + globab_clientId;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/payrecords/findPayrecordsForWalletList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'account', title: '司机帐号', width: 100, align: 'center', sortable: true},
                        {field: 'money', title: '余额', width: 100, align: 'center', sortable: true},
                        {
                            field: 'ordernum', title: '电召单数', width: 100, align: 'center', sortable: true,
                            formatter: function (value, row, index) {
                                var codes = row["account"];
                                return '<span class="openrelation" onclick="openrelationWallnet(id)" id=' + codes + '>' + value + '</span>';
                            }
                        },
                        {
                            field: 'operating', title: '操作', width: 100, align: 'center', sortable: true,
                            formatter: function (value, row, index) {
                                var codes = row["account"];
                                return '<span class="openrelation" onclick="openrelation(id)" id=' + codes + '>申请</span>';
                            }
                        }
                    ]
                ],
                onLoadSuccess: function (data) {
                    ////console.info(data);
                },
                idField: 'starttime',
                sortName: 'starttime',
                sortOrder: 'desc',
                singleSelect: true,
                pagination: true,
                pageSize: 20,
                pageList: [20, 40, 60, 80],
                rownumbers: true,
                toolbar: '#toolbar'
            });
        }

    });

    //查看电召单信息
    function openrelationWallnet(data) {
        console.info(data);
        var dialog = phm.modalDialog({
            title: '电召单流水',
            closable: true,
            width: 900,
            height: 600,
            url: "payrecords_count_list.jsp?account=" + data,
            buttons: [
                {
                    text: '取消',
                    iconCls: 'icon-cancel',
                    handler: function () {
                        dialog.dialog("close");
                    }
                }
            ]
        });
    }

    //查看电召单信息
    function openrelation(data) {
        console.info(data);
        $.ajax({
            url: path + "/payrecords/findPayrecordsByList?key=" + data,
            type: "GET",
            crossDomain: true,
            cache: false,
            dataType: "json", //后台返回值类型
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                console.info(data);
                var tempID = data[0].orderid;
                if (data.length > 1) {
                    for (i = 1; i < data.length; i++) {
                        tempID += "," + data[i].orderid;
                    }
                }
                payWithdraw(tempID);
                console.log(tempID);

            }
        });

    }

    function payWithdraw(ids) {


        var data = {
            "orderid": ids,
            "token": token
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
                console.info(data);
                grid.datagrid('reload');
            }
        });


    }	//function completedForm()结束
</script>