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
    <title>司机收入明细</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>


</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>关键字</label>
        <input id="key" class="easyui-textbox" style="width:200px;" prompt="车牌号码 | 司机姓名 | 司机手机号">
        <span>&nbsp;收入时间</span>
        <input id="begintime" class="easyui-datebox" data-options="editable:false"/>
        <span>至</span>
        <input id="endtime" class="easyui-datebox" data-options="editable:false"/>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" data-options="iconCls:'icon-search'">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="export"> 导出</button>
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
        $("#begintime").datebox("setValue", GetDateStr2(0));
        $("#endtime").datebox("setValue", GetDateStr2(0));
        acquireData('', GetDateStr2(0), GetDateStr2(1));

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            var begintime = $("#begintime").datebox("getValue");
            var endtime = $("#endtime").datebox("getValue");
            acquireData(key, begintime, endtime);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#begintime").datebox("setValue", GetDateStr2(0));
            $("#endtime").datebox("setValue", GetDateStr2(0));
            acquireData('', GetDateStr2(0), GetDateStr2(1));
        });

        function acquireData(key, begintime, endtime) {
            var dataUrl = 'sort=id&order=desc&begintime=' + begintime +
                '&endtime=' + endtime +
                '&key=' + key +
                '&clientid=' + globab_clientId;
            $("#redataGril").datagrid({
                fit: true,
                url: path + "/driverIncomeDetail/findDriverIncomeDetailForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'date', title: '收入时间', width: 100, align: 'center', sortable: true},
                        {field: 'name', title: '司机姓名', width: 100, align: 'center', sortable: true},
                        {field: 'amount', title: '收入金额', width: 100, align: 'center', sortable: true},
                        {field: 'phone', title: '司机手机号', width: 100, align: 'center'},
                        {field: 'kabnum', title: '车牌号', width: 100, align: 'center'},
                        {field: 'successnum', title: '完成接单次数', width: 100, align: 'center'}
                    ]
                ],
                //          onLoadSuccess: function (data) {
                //
                //          },
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