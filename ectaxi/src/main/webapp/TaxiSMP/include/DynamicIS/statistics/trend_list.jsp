<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>违章趋势统计</title>

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
</div>

<!-- 工具栏 -->
<div id="yeartoolbar">
    <div id="input" style="font-size:12px;">
        <label>年份</label>
        <select id="begintime1" class="yearbegin easyui-combobox"
                data-options="width:80,panelHeight:'auto',editable:false">
        </select>
        <label>至</label>
        <select id="endtime1" class="yearend easyui-combobox" data-options="width:80,panelHeight:'auto',editable:false">
        </select>&nbsp;
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
               data-options="width:100,formatter:formatter2,parser:parser2,selections:[[0,4],[5,7]]"/>&nbsp;
        <button class="easyui-linkbutton" id="search2" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset2" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export2" style="padding:0 10px">导出</button>
    </div>
</div>

</body>
</html>

<script>

    $(function () {

        /*
        ** 默认加载
        */
        yearData('', '');
        monthData('', '');

        /*
        ** 年度查询
        */
        $("#search1").on("click", function () {
            var begintime1 = $("#begintime1").combobox("getValue");
            var endtime1 = $("#endtime1").combobox("getValue");
            yearData(begintime1, endtime1);
        });

        /*
        ** 年度重置
        */
        $("#reset1").on("click", function () {
            var date = new Date();
            $("#begintime1").combobox("setValue", "2015");
            $("#endtime1").combobox("setValue", date.getFullYear());
            yearData('', '');
        });

        /*
        ** 月份查询
        */
        $("#search2").on("click", function () {
            var begintime2 = $("#begintime2").datetimespinner("getValue");
            var endtime2 = $("#endtime2").datetimespinner("getValue");
            monthData(begintime2, endtime2);
        });

        /*
        ** 月份重置
        */
        $("#reset2").on("click", function () {
            $("#begintime2").datetimespinner("setValue", "");
            $("#endtime2").datetimespinner("setValue", "");
            monthData('', '');
        });

        /*
    	** 按年面板表格
    	*/
        function yearData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#year").datagrid({
                url: path + "/illegalTrendStatisticsYear/findIllegalTrendStatisticsYearForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "scrapcar", title: "报废车辆", width: 100, align: "center", sortable: true},
                    {field: "notcheckcar", title: "未年检车辆", width: 100, align: "center", sortable: true},
                    {field: "withoutcar", title: "未年审车辆", width: 100, align: "center", sortable: true},
                    {field: "deckcar", title: "套牌车辆", width: 100, align: "center", sortable: true},
                    {field: "blackcar", title: "黑的", width: 100, align: "center", sortable: true},
                    {field: "other", title: "其它", width: 100, align: "center", sortable: true},
                    {field: "combined", title: "合计", width: 100, align: "center", sortable: true},
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                singleSelect: true,
                rownumbers: true,
                toolbar: "#yeartoolbar",
                //pagination : true,
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
                url: path + "/illegalTrendStatisticsMonth/findIllegalTrendStatisticsMonthForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "month", title: "月份", width: 100, align: "center", sortable: true},
                    {field: "scrapcar", title: "报废车辆", width: 100, align: "center", sortable: true},
                    {field: "notcheckcar", title: "未年检车辆", width: 100, align: "center", sortable: true},
                    {field: "withoutcar", title: "未年审车辆", width: 100, align: "center", sortable: true},
                    {field: "deckcar", title: "套牌车辆", width: 100, align: "center", sortable: true},
                    {field: "blackcar", title: "黑的", width: 100, align: "center", sortable: true},
                    {field: "other", title: "其它", width: 100, align: "center", sortable: true},
                    {field: "combined", title: "合计", width: 100, align: "center", sortable: true},
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

    });
</script>