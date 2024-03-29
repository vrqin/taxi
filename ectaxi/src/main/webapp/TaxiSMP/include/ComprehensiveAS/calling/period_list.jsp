<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>电召时段分析</title>

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
    <div title="按年">
        <table id="year"></table>
    </div>
    <div title="按月">
        <table id="month"></table>
    </div>
    <div title="按日">
        <table id="day"></table>
    </div>
    <div title="按时">
        <table id="hour"></table>
    </div>
</div>

<!-- 工具栏 -->
<div id="yeartoolbar">
    <div id="input" style="font-size:12px;">
        <label>年度</label>
        <select id="begintime1" class="yearbegin easyui-combobox"
                data-options="width:70,panelHeight:'auto',editable:false">
        </select>
        <label>至</label>
        <select id="endtime1" class="yearend easyui-combobox" data-options="width:70,panelHeight:'auto',editable:false">
        </select>
        <label>&nbsp;地区</label>
        <input id="key1" class="easyui-textbox"/>&nbsp;
        <button class="easyui-linkbutton" id="search1" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset1" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export1" style="padding:0 10px">导出</button>
    </div>
</div>

<!-- 工具栏 -->
<div id="monthtoolbar">
    <div id="input" style="font-size:12px;">
        <label>月份</label>
        <input id="begintime2" class="easyui-datetimespinner"
               data-options="width:100,formatter:formatter2,parser:parser2,selections:[[0,4],[5,7]]"/>
        <label>至</label>
        <input id="endtime2" class="easyui-datetimespinner"
               data-options="width:100,formatter:formatter2,parser:parser2,selections:[[0,4],[5,7]]"/>
        <label>&nbsp;地区</label>
        <input id="key2" class="easyui-textbox"/>&nbsp;
        <button class="easyui-linkbutton" id="search2" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset2" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export2" style="padding:0 10px">导出</button>
    </div>
</div>

<!-- 工具栏 -->
<div id="daytoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime3" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime3" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>&nbsp;地区</label>
        <input id="key3" class="easyui-textbox"/>&nbsp;
        <button class="easyui-linkbutton" id="search3" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset3" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export3" style="padding:0 10px">导出</button>
    </div>
</div>

<!-- 工具栏 -->
<div id="hourtoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime4" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime4" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>&nbsp;地区</label>
        <input id="key4" class="easyui-textbox"/>&nbsp;
        <button class="easyui-linkbutton" id="search4" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset4" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export4" style="padding:0 10px">导出</button>
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
        yearData('', '', '');
        monthData('', '', '');
        dayData('', '', '');
        hourData('', '', '');

        /*
        ** 年度查询
        */
        $("#search1").on("click", function () {
            var begintime1 = $("#begintime1").combobox("getValue");
            var endtime1 = $("#endtime1").combobox("getValue");
            var key1 = $("#key1").textbox("getValue");
            yearData(begintime1, endtime1, key1);
        });

        /*
        ** 年度重置
        */
        $("#reset1").on("click", function () {
            var date = new Date();
            $("#begintime1").combobox("setValue", "2015");
            $("#endtime1").combobox("setValue", date.getFullYear());
            $("#key1").textbox("setValue", "");
            yearData('', '', '');
        });

        /*
        ** 月份查询
        */
        $("#search2").on("click", function () {
            var begintime2 = $("#begintime2").datetimespinner("getValue");
            var endtime2 = $("#endtime2").datetimespinner("getValue");
            var key2 = $("#key2").textbox("getValue");
            monthData(begintime2, endtime2, key2);
        });

        /*
        ** 月份重置
        */
        $("#reset2").on("click", function () {
            $("#begintime2").datetimespinner("setValue", "");
            $("#endtime2").datetimespinner("setValue", "");
            $("#key2").textbox("setValue", "");
            monthData('', '', '');
        });

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
        ** 日期查询（时间段）
        */
        $("#search4").on("click", function () {
            var begintime4 = $("#begintime4").datebox("getValue");
            var endtime4 = $("#endtime4").datebox("getValue");
            var key4 = $("#key4").textbox("getValue");
            hourData(begintime4, endtime4, key4);
        });

        /*
        ** 日期重置（时间段）
        */
        $("#reset4").on("click", function () {
            $("#begintime4").datebox("setValue", "");
            $("#endtime4").datebox("setValue", "");
            $("#key4").textbox("setValue", "");
            hourData('', '', '');
        });

        /*
        ** 按年面板表格
        */
        function yearData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#year").datagrid({
                url: path + "/callingDuringAnalysisYear/findCallingDuringAnalysisYearForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年度", width: 100, align: "center", sortable: true},
                    {field: "area", title: "地区", width: 100, align: "center", sortable: true},
                    {field: "total", title: "总业务数", width: 100, align: "center", sortable: true},
                    {field: "succnum", title: "成功数", width: 100, align: "center", sortable: true},
                    {field: "succratio", title: "成功比例（%）", width: 100, align: "center", sortable: true},
                    {field: "passcancel", title: "乘客取消数", width: 100, align: "center", sortable: true},
                    {field: "passcancelratio", title: "乘客取消比例（%）", width: 100, align: "center", sortable: true},
                    {field: "drivercancel", title: "司机取消数", width: 100, align: "center", sortable: true},
                    {field: "drivercancelratio", title: "司机取消比例（%）", width: 100, align: "center", sortable: true},
                    {field: "noanswer", title: "无人接单数", width: 100, align: "center", sortable: true},
                    {field: "noanswerratio", title: "无人接单比例（%）", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                singleSelect: true,
                rownumbers: true,
                toolbar: "#yeartoolbar",
            });
        }

        /*
    	** 按月面板表格
    	*/
        function monthData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#month").datagrid({
                url: path + "/callingDuringAnalysisMonth/findCallingDuringAnalysisMonthForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "month", title: "月份", width: 100, align: "center", sortable: true},
                    {field: "area", title: "地区", width: 100, align: "center", sortable: true},
                    {field: "total", title: "总业务数", width: 100, align: "center", sortable: true},
                    {field: "succnum", title: "成功数", width: 100, align: "center", sortable: true},
                    {field: "succratio", title: "成功比例（%）", width: 100, align: "center", sortable: true},
                    {field: "passcancel", title: "乘客取消数", width: 100, align: "center", sortable: true},
                    {field: "passcancelratio", title: "乘客取消比例（%）", width: 100, align: "center", sortable: true},
                    {field: "drivercancel", title: "司机取消数", width: 100, align: "center", sortable: true},
                    {field: "drivercancelratio", title: "司机取消比例（%）", width: 100, align: "center", sortable: true},
                    {field: "noanswer", title: "无人接单数", width: 100, align: "center", sortable: true},
                    {field: "noanswerratio", title: "无人接单比例（%）", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                singleSelect: true,
                rownumbers: true,
                toolbar: "#monthtoolbar",
                //pagination : true,
            });
        }

        /*
    	** 按日面板表格
    	*/
        function dayData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#day").datagrid({
                url: path + "/callingDuringAnalysisDay/findCallingDuringAnalysisDayForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "date", title: "日期", width: 100, align: "center", sortable: true},
                    {field: "area", title: "地区", width: 100, align: "center", sortable: true},
                    {field: "total", title: "总业务数", width: 100, align: "center", sortable: true},
                    {field: "succnum", title: "成功数", width: 100, align: "center", sortable: true},
                    {field: "succratio", title: "成功比例（%）", width: 100, align: "center", sortable: true},
                    {field: "passcancel", title: "乘客取消数", width: 100, align: "center", sortable: true},
                    {field: "passcancelratio", title: "乘客取消比例（%）", width: 100, align: "center", sortable: true},
                    {field: "drivercancel", title: "司机取消数", width: 100, align: "center", sortable: true},
                    {field: "drivercancelratio", title: "司机取消比例（%）", width: 100, align: "center", sortable: true},
                    {field: "noanswer", title: "无人接单数", width: 100, align: "center", sortable: true},
                    {field: "noanswerratio", title: "无人接单比例（%）", width: 100, align: "center", sortable: true},
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

        /*
    	** 按时间段面板表格
    	*/
        function hourData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#hour").datagrid({
                url: path + "/callingDuringAnalysisTime/findCallingDuringAnalysisTimeForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "date", title: "日期", width: 100, align: "center", sortable: true},
                    {field: "hours", title: "时间段", width: 100, align: "center", sortable: true},
                    {field: "area", title: "地区", width: 100, align: "center", sortable: true},
                    {field: "total", title: "总业务数", width: 100, align: "center", sortable: true},
                    {field: "succnum", title: "成功数", width: 100, align: "center", sortable: true},
                    {field: "succratio", title: "成功比例（%）", width: 100, align: "center", sortable: true},
                    {field: "passcancel", title: "乘客取消数", width: 100, align: "center", sortable: true},
                    {field: "passcancelratio", title: "乘客取消比例（%）", width: 100, align: "center", sortable: true},
                    {field: "drivercancel", title: "司机取消数", width: 100, align: "center", sortable: true},
                    {field: "drivercancelratio", title: "司机取消比例（%）", width: 100, align: "center", sortable: true},
                    {field: "noanswer", title: "无人接单数", width: 100, align: "center", sortable: true},
                    {field: "noanswerratio", title: "无人接单比例（%）", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                singleSelect: true,
                rownumbers: true,
                toolbar: "#hourtoolbar",
                //pagination : true,
            });
        }

    });
</script>