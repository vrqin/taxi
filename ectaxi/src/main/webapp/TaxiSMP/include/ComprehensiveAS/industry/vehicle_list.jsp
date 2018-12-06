<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>车辆信息分析</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <style>
        .tabs {
            padding-left: 10px;
        }
    </style>

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 外框样式 -->
<div class="easyui-layout" data-options="fit:true" style="border:1px solid #c8c8c8">

    <!-- 工具栏 -->
    <div id="toolbar">
        <div id="input" style="font-size:12px;">
            <label>年度:</label>
            <select id="begintime" class="yearbegin easyui-combobox"
                    data-options="width:70,panelHeight:'auto',editable:false">
            </select>
            <label>至</label>
            <select id="endtime" class="yearend easyui-combobox"
                    data-options="width:70,panelHeight:'auto',editable:false">
            </select>
            <button class="easyui-linkbutton" id="search" iconCls="icon-search" style="padding:0 10px">查询</button>
            <button class="easyui-linkbutton" id="reset" style="padding:0 10px">重置</button>
            <button class="easyui-linkbutton" id="export" style="padding:0 10px">导出</button>
        </div>
    </div>

    <!-- 面板 -->
    <div id="tabs" class="easyui-tabs" data-options="border:false">
        <div title=" 地区 ">
            <table id="area"></table>
        </div>
        <div title="燃油类型">
            <table id="fuel"></table>
        </div>
        <div title=" 车型 ">
            <table id="models"></table>
        </div>
        <div title="使用年限">
            <table id="useyears"></table>
        </div>
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
        var globab_clientId = sessionStorage.clientId;


        /*
        ** 默认加载
        */
        areaData('', '');
        fuelData('', '');
        modelsData('', '');
        useyearsData('', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var begintime = $("#begintime").combobox("getValue");
            var endtime = $("#endtime").combobox("getValue");
            areaData(begintime, endtime);
            fuelData(begintime, endtime);
            modelsData(begintime, endtime);
            useyearsData(begintime, endtime);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            var date = new Date();
            $("#begintime").combobox("setValue", "2015");
            $("#endtime").combobox("setValue", date.getFullYear());
            areaData('', '');
            fuelData('', '');
            modelsData('', '');
            useyearsData('', '');
        });

        /*
        ** 地区面板表格
        */
        function areaData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#area").datagrid({
                url: path + "/carInformationAnalysisRegion/findCarInformationAnalysisRegionForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "cities", title: "地区", width: 100, align: "center", sortable: true},
                    {field: "total", title: "车辆数", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

        /*
    	** 燃油类型面板表格
    	*/
        function fuelData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#fuel").datagrid({
                url: path + "/carInformationAnalysisFueltype/findCarInformationAnalysisFueltypeForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "gasoline", title: "汽油", width: 100, align: "center", sortable: true},
                    {field: "diesel", title: "柴油", width: 100, align: "center", sortable: true},
                    {field: "gas", title: "天燃气", width: 100, align: "center", sortable: true},
                    {field: "electric", title: "电力", width: 100, align: "center", sortable: true},
                    {field: "hybrid", title: "混合动力", width: 100, align: "center", sortable: true},
                    {field: "unknown", title: "未知", width: 100, align: "center", sortable: true},
                    {field: "combined", title: "合计", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

        /*
    	** 车型面板表格
    	*/
        function modelsData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#models").datagrid({
                url: path + "/carInformationAnalysisModels/findCarInformationAnalysisModelsForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "minicar", title: "微型桥车", width: 100, align: "center", sortable: true},
                    {field: "regularcars", title: "普通级桥车", width: 100, align: "center", sortable: true},
                    {field: "intermediatesedan", title: "中级桥车", width: 100, align: "center", sortable: true},
                    {field: "seniorcar", title: "中高级桥车", width: 100, align: "center", sortable: true},
                    {field: "limousine", title: "高级桥车", width: 100, align: "center", sortable: true},
                    {field: "minivans", title: "微型客车", width: 100, align: "center", sortable: true},
                    {field: "lightbus", title: "轻型客车", width: 100, align: "center", sortable: true},
                    {field: "mediumsizedcoach", title: "中型客车", width: 100, align: "center", sortable: true},
                    {field: "buses", title: "大型客车", width: 100, align: "center", sortable: true},
                    {field: "other", title: "其它", width: 100, align: "center", sortable: true},
                    {field: "combined", title: "合计", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

        /*
    	** 使用年限面板表格
    	*/
        function useyearsData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#useyears").datagrid({
                url: path + "/carInformationAnalysisValidittime/findCarInformationAnalysisValidittimeForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "year1", title: "1年", width: 100, align: "center", sortable: true},
                    {field: "year2", title: "2年", width: 100, align: "center", sortable: true},
                    {field: "year3", title: "3年", width: 100, align: "center", sortable: true},
                    {field: "year4", title: "4年", width: 100, align: "center", sortable: true},
                    {field: "year5", title: "5年", width: 100, align: "center", sortable: true},
                    {field: "year6", title: "6年", width: 100, align: "center", sortable: true},
                    {field: "year7", title: "7年", width: 100, align: "center", sortable: true},
                    {field: "year8", title: "8年", width: 100, align: "center", sortable: true},
                    {field: "unknown", title: "未知", width: 100, align: "center", sortable: true},
                    {field: "total", title: "合计", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

    });
</script>