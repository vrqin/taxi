<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>运营次数-按高峰</title>

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

    <style>
        .tabs {
            padding-left: 0px;
        }

        .tabs-header {
            border: none;
        }

        .datagrid .datagrid-pager {
            border-bottom: 1px solid #dddddd;
        }
    </style>

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 面板 -->
<div id="tabs" class="easyui-tabs" data-options="fit:true,tabWidth:80,border:true">
    <div title="按日">
        <table id="day"></table>
    </div>
</div>

<!-- 工具栏 -->
<div id="daytoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime3" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime3" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>&nbsp;关键字</label>
        <input id="key3" class="easyui-textbox" prompt="区域 | 企业名称"/>&nbsp;
        <button class="easyui-linkbutton" id="search3" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset3" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export3" style="padding:0 10px">导出</button>
    </div>
</div>

</body>
</html>

<script>

    $(function () {

        /*
        ** 默认加载
        */
        dayData('', '', '');

        /*
        ** 日期查询
        */
        $("#search3").on("click", function () {
            var begintime3 = $("#begintime3").datebox("getValue");
            var endtime3 = $("#endtime3").datebox("getValue");
            var key3 = $("#key3").textbox("getValue");
            dayData(begintime3, endtime3, key3);
        });

        /*
        ** 日期重置
        */
        $("#reset3").on("click", function () {
            $("#begintime3").datebox("setValue", "");
            $("#endtime3").datebox("setValue", "");
            $("#key3").textbox("setValue", "");
            dayData('', '', '');
        });

        /*
    	** 按时面板表格
    	*/
        function dayData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#day").datagrid({
                url: path + "/operationsPeak/findOperationsPeakForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "date", title: "日期", width: 100, align: "center", sortable: true},
                    {field: "area", title: "区域", width: 100, align: "center", sortable: true},
                    {field: "companyname", title: "企业名称", width: 100, align: "center", sortable: true},
                    {field: "peakperiod", title: "高峰段", width: 100, align: "center", sortable: true},
                    {field: "operationcarnum", title: "营运车辆数", width: 100, align: "center", sortable: true},
                    {field: "totaloperation", title: "总营运次数", width: 100, align: "center", sortable: true},
                    {field: "avedatebikeoperatnum", title: "日均单车营运次数）", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                singleSelect: true,
                rownumbers: true,
                toolbar: "#daytoolbar",
                //pagination : true,
            });
        }

    });
</script>