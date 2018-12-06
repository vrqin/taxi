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
    <title>疲劳驾驶统计</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>
    <style type="text/css">

    </style>


</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>关键字</label>
        <input id="name" class="easyui-textbox" style="width:160px;" prompt="车牌号码 | 驾驶员姓名 ">
        <span>开始时间</span>
        <select name="date" class="easyui-datetimebox " data-options="panelHeight:'auto',editable:false"
                style="width: 160px;">
        </select>
        <span>结束时间</span>
        <select name="date" class="easyui-datetimebox" data-options="panelHeight:'auto',editable:false"
                style="width: 160px;">
        </select>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <%--<button class="easyui-linkbutton" id="export">导出</button>--%>
    </div>
</div>

</body>
</html>


<script>
    var grid;
    var data = [
//            { "kabnum": " ","driver": " ","unit": "  ", "cumulative": " ", "drivtime": " "}
    ];
    $(function () {


        grid = $("#redataGril").datagrid({
            fit: true,
            data: data,
//                height: $("#dataview").height() -300+"px",
            fitColumns: true,
            striped: true,
            columns: [
                [
                    {field: 'kabnum', title: '车牌号码', width: fixWidth(0.1), align: 'center', sortable: true},
                    {field: 'driver', title: '驾驶员', width: fixWidth(0.1), align: 'center', sortable: true},
                    {field: 'unit', title: '所属单位', width: fixWidth(0.1), align: 'center'},
                    {field: 'cumulative', title: '次数', width: fixWidth(0.1), align: 'center'},
                    {field: 'drivtime', title: '驾驶时长', width: fixWidth(0.1), align: 'center'}

                ]
            ],
            onLoadSuccess: function (data) {

            },
            detailFormatter: function (rowIndex, rowData) {
            },
            onDblClickRow: function (rowIndex, rowData) {

            },
            onClickRow: function (rowIndex, rowData) {

            },
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

    });

    //datagril 列表宽度
    function fixWidth(percent) {
        return Math.floor(document.body.clientWidth * percent); //这里你可以自己做调整
    }
</script>

