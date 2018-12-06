<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no"
          name="viewport" id="viewport"/>
    <title>司机收入流水</title>

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
        <input id="key" class="easyui-textbox" style="width:360px;" prompt="车牌号码 | 司机姓名 | 司机手机号 | 乘客姓名 | 乘客手机号 | 订单号">
        <label>&nbsp;收入时间</label>
        <input id="begintime" class="easyui-datetimebox" data-options="editable:false"/>
        <label>至</label>
        <input id="endtime" class="easyui-datetimebox" data-options="editable:false"/>
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
        acquireData('', GetDateStr(0), GetDateStr(1));

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            var begintime = $("#begintime").datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            acquireData(key, begintime, endtime);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#begintime").datetimebox("setValue", GetDateStr(0));
            $("#endtime").datetimebox("setValue", GetDateStr(1));
            acquireData('', GetDateStr(0), GetDateStr(1));
        });

        /*
        ** 获取数据
        */
        function acquireData(key, begintime, endtime) {
            var dataUrl = 'sort=id&order=desc&begintime=' + begintime +
                '&endtime=' + endtime +
                '&key=' + key +
                '&clientid=' + globab_clientId +
                "&payment=-1";
            $("#redataGril").datagrid({
                fit: true,
                url: path + "/driverIncome/findDriverIncomeForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'driverphone', title: '司机手机号', width: 100, align: 'center', sortable: true},
                        {field: 'drivername', title: '司机姓名', width: 100, align: 'center', sortable: true},
                        {field: 'amount', title: '收入金额', width: 100, align: 'center'},
                        {field: 'bill', title: '打车费', width: 100, align: 'center'},
                        {field: 'drivertip', title: '司机小费', width: 100, align: 'center'},
                        {
                            field: 'payment', title: '支付方式', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                return getValueFromArray(value, paytypecom);
                            }
                        },
                        {field: 'incometime', title: '收入时间', width: 100, align: 'center', sortable: true},
                        {field: 'kabnum', title: '车牌号', width: 100, align: 'center', sortable: true},
                        {field: 'passname', title: '乘客姓名', width: 100, align: 'center', sortable: true},
                        {field: 'passphone', title: '乘客手机号', width: 100, align: 'center', sortable: true},
                        {field: 'ordernum', title: '订单ID', width: 100, align: 'center', sortable: true},
                    ]
                ],
//	            onLoadSuccess: function (data) {
//					////console.info(data);
//	            },
                idField: 'phone',
                sortName: 'phone',
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