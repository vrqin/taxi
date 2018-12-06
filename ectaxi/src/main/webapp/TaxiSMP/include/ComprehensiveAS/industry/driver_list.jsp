<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>驾驶员信息分析</title>

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
        <div title="年龄段">
            <table id="age"></table>
        </div>
        <div title=" 驾龄 ">
            <table id="drivingage"></table>
        </div>
        <div title="信誉等级">
            <table id="level"></table>
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

        /*
        ** 默认加载
        */
        areaData('', '');
        ageData('', '');
        drivingageData('', '');
        levelData('', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var begintime = $("#begintime").combobox("getValue");
            var endtime = $("#endtime").combobox("getValue");
            areaData(begintime, endtime);
            ageData(begintime, endtime);
            drivingageData(begintime, endtime);
            levelData(begintime, endtime);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            var date = new Date();
            $("#begintime").combobox("setValue", "2015");
            $("#endtime").combobox("setValue", date.getFullYear());
            areaData('', '');
            ageData('', '');
            drivingageData('', '');
            levelData('', '');
        });

        /*
        ** 地区面板表格
        */
        function areaData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#area").datagrid({
                url: path + "/driverInformationAnalysisRegion/findDriverInformationAnalysisRegionForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "cities", title: "地区", width: 100, align: "center", sortable: true},
                    {field: "total", title: "驾驶员数", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

        /*
    	** 年龄段面板表格
    	*/
        function ageData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#age").datagrid({
                url: path + "/driverInformationAnalysisAge/findDriverInformationAnalysisAgeForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "age24", title: "18~24岁", width: 100, align: "center", sortable: true},
                    {field: "age29", title: "25~29岁", width: 100, align: "center", sortable: true},
                    {field: "age34", title: "30~34岁", width: 100, align: "center", sortable: true},
                    {field: "age39", title: "35~39岁", width: 100, align: "center", sortable: true},
                    {field: "age44", title: "40~44岁", width: 100, align: "center", sortable: true},
                    {field: "age49", title: "45~49岁", width: 100, align: "center", sortable: true},
                    {field: "age54", title: "50~54岁", width: 100, align: "center", sortable: true},
                    {field: "age59", title: "55~59岁", width: 100, align: "center", sortable: true},
                    {field: "age60", title: "60岁以上", width: 100, align: "center", sortable: true},
                    {field: "unknown", title: "未知", width: 100, align: "center", sortable: true},
                    {field: "total", title: "合计", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

        /*
    	** 驾龄面板表格
    	*/
        function drivingageData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#drivingage").datagrid({
                url: path + "/driverInformationAnalysisBeendrive/findDriverInformationAnalysisBeendriveForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "year6", title: "0~6年", width: 100, align: "center", sortable: true},
                    {field: "year17", title: "7~17年", width: 100, align: "center", sortable: true},
                    {field: "year28", title: "18~28年", width: 100, align: "center", sortable: true},
                    {field: "year39", title: "29~39年", width: 100, align: "center", sortable: true},
                    {field: "year40", title: "40年以上", width: 100, align: "center", sortable: true},
                    {field: "unknown", title: "未知", width: 100, align: "center", sortable: true},
                    {field: "total", title: "合计", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

        /*
    	** 信誉等级面板表格
    	*/
        function levelData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#level").datagrid({
                url: path + "/driverInformationAnalysisCreditrate/findDriverInformationAnalysisCreditrateForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "good", title: "优秀(AAA)", width: 100, align: "center", sortable: true},
                    {field: "qualified", title: "良(AA)", width: 100, align: "center", sortable: true},
                    {field: "basic", title: "中(A)", width: 100, align: "center", sortable: true},
                    {field: "unqualified", title: "差(B)", width: 100, align: "center", sortable: true},
                    {field: "inspection", title: "未考核", width: 100, align: "center", sortable: true},
                    {field: "cooperation", title: "合计", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

    });
</script>