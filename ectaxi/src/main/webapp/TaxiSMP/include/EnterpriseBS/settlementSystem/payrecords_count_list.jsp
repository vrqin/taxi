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
    var account = "${param.account}";

    $(function () {

        /*
        ** 默认加载
        */
        acquireData(account, -1, '', '');
        $("#key").textbox("setValue", account);
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
            console.info(path + "/payrecords/findPayrecordsForPageList?" + dataUrl);
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/payrecords/findPayrecordsForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'orderid', title: 'orderid', width: 100, align: 'center', sortable: true},
                        {field: 'geton', title: 'geton', width: 100, align: 'center', sortable: true},
                        {field: 'getoff', title: 'getoff', width: 100, align: 'center', sortable: true},
                        {field: 'account', title: 'account', width: 100, align: 'center', sortable: true},
                        {field: 'mileage', title: 'mileage', width: 100, align: 'center', sortable: true},
                        {field: 'money', title: 'money', width: 100, align: 'center', sortable: true},
                        {field: 'vainmileage', title: 'vainmileage', width: 100, align: 'center', sortable: true},
                        {field: 'extramoney', title: 'extramoney', width: 100, align: 'center', sortable: true},
                        {field: 'waittime', title: 'waittime', width: 100, align: 'center', sortable: true},
                        {field: 'submittime', title: 'submittime', width: 100, align: 'center', sortable: true},
                        {
                            field: 'paytype', title: 'paytype', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                return getValueFromArray(value, waytype);
                            }
                        },
                        {field: 'paytime', title: 'paytime', width: 100, align: 'center', sortable: true},
                        {field: 'tradeno', title: 'tradeno', width: 100, align: 'center', sortable: true}
//	                    {field: 'operating', title: '操作', width: 100, align: 'center',sortable:true,
//							formatter: function (value, row, index) {
//								var codes = row["orderid"];
//								return'<span class="openrelation" onclick="openrelation(id)" id=' + codes + '>申请</span>';
//							}
//						}
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
    function openrelation(data) {
        //console.info(data);
        var dialog = phm.modalDialog({
            title: '申请提现',
            closable: true,
            url: "payrecords_add.jsp?orderid=" + data,
            buttons: [
                {
                    text: '申请',
                    iconCls: 'icon-save',
                    handler: function () {
                        dialog.find('iframe').get(0).contentWindow.completedForm(dialog, grid, parent.$);
                    }
                },
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
</script>