<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>乘客支付明细</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
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
        <input id="key" class="easyui-textbox" data-options="width:180" prompt="乘客姓名 | 手机号码 | 订单号"/>
        <label>&nbsp;支付方式</label>
        <select id="way" class="easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="0">支付宝</option>
            <option value="1">微信</option>
            <option value="2">现金</option>
        </select>
        <label>&nbsp;支付时间</label>
        <input id="begintime" class="easyui-datetimebox" data-options="width:160, editable:false">
        <label>至</label>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160, editable:false">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="export">导出</button>
    </div>
</div>

</body>
</html>

<script>
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        /*
        ** 默认加载
        */
        $("#begintime").datetimebox("setValue", GetDateStr(0));
        $("#endtime").datetimebox("setValue", GetDateStr(1));
        acquireData('', -1, GetDateStr(0), GetDateStr(1));

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
            $("#begintime").datetimebox("setValue", GetDateStr(0));
            $("#endtime").datetimebox("setValue", GetDateStr(1));
            acquireData('', -1, GetDateStr(0), GetDateStr(1));
        });

        /*
        ** 获取数据
        */
        function acquireData(key, way, begintime, endtime) {
            var dataUrl = 'sort=id&order=desc&begintime=' + begintime +
                '&endtime=' + endtime +
                '&key=' + key +
                '&clientid=' + globab_clientId +
                '&payment=' + way;
            $("#redataGril").datagrid({
                fit: true,
                url: path + "/passPayDetails/findPassPayDetailsForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'passphone', title: '手机号码', width: 100, align: 'center', sortable: true},
                        {field: 'passname', title: '乘客姓名', width: 100, align: 'center', sortable: true},
                        {field: 'totalamount', title: '总金额', width: 100, align: 'center', sortable: true},
                        {field: 'payamount', title: '支付金额', width: 100, align: 'center', sortable: true},
                        {field: 'taxicoupons', title: '打车券', width: 100, align: 'center', sortable: true},
                        {field: 'tip', title: '小费', width: 100, align: 'center', sortable: true},
                        {
                            field: 'payment', title: '支付方式', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                return getValueFromArray(value, paytypecom);
                            }
                        },
                        {field: 'calltime', title: '打车时间', width: 100, align: 'center', sortable: true},
                        {field: 'drivername', title: '司机姓名', width: 100, align: 'center', sortable: true},
                        {field: 'kabnum', title: '车牌号码', width: 100, align: 'center', sortable: true},
                        {field: 'ordernum', title: '订单ID', width: 100, align: 'center', sortable: true},

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
</script>