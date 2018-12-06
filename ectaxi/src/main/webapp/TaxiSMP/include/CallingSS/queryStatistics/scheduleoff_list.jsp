<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>离线明细表</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

</head>
<body class="easyui-layout" data-options="fit:true" style="padding:10px; box-sizing: border-box;">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div style="margin: 10px;padding: 10px;border: 1px solid #c8c8c8;">
        <label>车牌号:</label>
        <input class="easyui-textbox" style="width:160px;">
    </div>
    <div style="margin:  0 0 10px 10px;">
        <button type="button" class="easyui-linkbutton" iconCls="icon-search" style="width:80px">查询</button>
        <button type="button" class="easyui-linkbutton">重置</button>
        <button type="button" class="easyui-linkbutton"> 导出</button>
    </div>
</div>

</body>
</html>

<script>
    $(function () {

        /*
        ** 变量声明
        */
        var grid;
        var clientid = sessionStorage.clientId;
        var token = sessionStorage.account;
        /*
        ** 获取数据
        */
        grid = $("#redataGril").datagrid({
            fit: true,
            url: path + "/driver/findDriverOnOfflineCar?kabnum=&isonline=1&clientid=" + clientid + "&token=" + token,
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'kabnum', title: '车牌号码', width: 100, align: 'center'},
                    {field: 'name', title: '驾驶员', width: 100, align: 'center', sortable: true},
                    {field: 'company', title: '所属公司', width: 100, align: 'center', sortable: true},
                    {field: 'starttime', title: '开始时间', width: 100, align: 'center'},
                    {field: 'endtime', title: '结束时间', width: 100, align: 'center', sortable: true},
                    {
                        field: 'gpstime', title: '离线时间', width: 100, align: 'center', sortable: true,
                        formatter: function (value) {
                            return formattime(value.time);
                        }
                    },
                    {field: 'getoffaddress', title: '离线地址', width: 100, align: 'center', sortable: true}
                ]
            ],
//          onLoadSuccess: function (data) {
//				////console.info(data);
//          },
//          detailFormatter: function(rowIndex, rowData){
//          },
//          onDblClickRow: function(rowIndex, rowData){
//
//          },
//          onClickRow: function(rowIndex, rowData){
//
//          },
            idField: 'kabnum',
            sortName: 'kabnum',
            sortOrder: 'desc',
            singleSelect: true,
            pagination: true,
            pageSize: 20,
            pageList: [20, 40, 60, 80],
            rownumbers: true,
            toolbar: '#toolbar'
        });

    });
</script>