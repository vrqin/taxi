<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>企业信息分析</title>

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
        <div title="经济性质">
            <table id="economic"></table>
        </div>
        <div title="车辆总数">
            <table id="vehicle"></table>
        </div>
        <div title="人员规模">
            <table id="person"></table>
        </div>
        <div title="资金规模">
            <table id="funds"></table>
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
        var globab_clientId = sessionStorage.clientId;

        /*
        ** 默认加载
        */
        economicData('', '');
        vehicleData('', '');
        personData('', '');
        fundsData('', '');
        levelData('', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var begintime = $("#begintime").combobox("getValue");
            var endtime = $("#endtime").combobox("getValue");
            economicData(begintime, endtime);
            vehicleData(begintime, endtime);
            personData(begintime, endtime);
            fundsData(begintime, endtime);
            levelData(begintime, endtime);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            var date = new Date();
            $("#begintime").combobox("setValue", "2015");
            $("#endtime").combobox("setValue", date.getFullYear());
            economicData('', '');
            vehicleData('', '');
            personData('', '');
            fundsData('', '');
            levelData('', '');
        });

        /*
        ** 经济性质面板表格
        */
        function economicData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#economic").datagrid({
                url: path + "/enterpriseInformationAnalysisEconomi/findEnterpriseInformationAnalysisEconomiForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "stateowned", title: "国有全资", width: 100, align: "center", sortable: true},
                    {field: "collective", title: "集体全资", width: 100, align: "center", sortable: true},
                    {field: "sharecooperation", title: "股份合作", width: 100, align: "center", sortable: true},
                    {field: "pool", title: "联营", width: 100, align: "center", sortable: true},
                    {field: "coltd", title: "有限责任公司", width: 100, align: "center", sortable: true},
                    {field: "shareltd", title: "股份有限公司", width: 100, align: "center", sortable: true},
                    {field: "privation", title: "私有", width: 100, align: "center", sortable: true},
                    {field: "other", title: "其它", width: 100, align: "center", sortable: true},
                    {field: "cooperation", title: "合计", width: 100, align: "center", sortable: true},
                ]],
//	        	onLoadSuccess: function (data) {
//					////console.info(data);
//	        	},
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

        /*
    	** 经济性质面板表格
    	*/
        function vehicleData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#vehicle").datagrid({
                url: path + "/enterpriseInformationAnalysisVehicles/findEnterpriseInformationAnalysisVehiclesForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "car200", title: "0~200辆", width: 100, align: "center", sortable: true},
                    {field: "car500", title: "201~500辆", width: 100, align: "center", sortable: true},
                    {field: "car1000", title: "501~1000辆", width: 100, align: "center", sortable: true},
                    {field: "car2000", title: "1001~2000辆", width: 100, align: "center", sortable: true},
                    {field: "car5000", title: "2001~5000辆", width: 100, align: "center", sortable: true},
                    {field: "car5001", title: "5000辆以上", width: 100, align: "center", sortable: true},
                    {field: "total", title: "合计", width: 100, align: "center", sortable: true},
                ]],
//	        	onLoadSuccess: function (data) {
//					////console.info(data);
//	        	},
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

        /*
    	** 人员规模面板表格
    	*/
        function personData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#person").datagrid({
                url: path + "/enterpriseInformationAnalysisStaff/findEnterpriseInformationAnalysisStaffForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "peop200", title: "0~200人", width: 100, align: "center", sortable: true},
                    {field: "peop500", title: "201~500人", width: 100, align: "center", sortable: true},
                    {field: "peop1000", title: "501~1000人", width: 100, align: "center", sortable: true},
                    {field: "peop2000", title: "1001~2000人", width: 100, align: "center", sortable: true},
                    {field: "peop5000", title: "2001~5000人", width: 100, align: "center", sortable: true},
                    {field: "peop5001", title: "5000人以上", width: 100, align: "center", sortable: true},
                    {field: "peoptotal", title: "合计", width: 100, align: "center", sortable: true},
                ]],
//	        	onLoadSuccess: function (data) {
//					////console.info(data);
//	        	},
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

        /*
    	** 资金规模面板表格
    	*/
        function fundsData(begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime;
            $("#funds").datagrid({
                url: path + "/enterpriseInformationAnalysisFunds/findEnterpriseInformationAnalysisFundsForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "annual", title: "年份", width: 100, align: "center", sortable: true},
                    {field: "wan100", title: "0~100万", width: 100, align: "center", sortable: true},
                    {field: "wan500", title: "101~500万", width: 100, align: "center", sortable: true},
                    {field: "wan1000", title: "501~1000万", width: 100, align: "center", sortable: true},
                    {field: "wan2000", title: "1001~2000万", width: 100, align: "center", sortable: true},
                    {field: "wan5000", title: "2001~5000万", width: 100, align: "center", sortable: true},
                    {field: "wan10000", title: "5001~10000万", width: 100, align: "center", sortable: true},
                    {field: "wan15000", title: "10001~15000万", width: 100, align: "center", sortable: true},
                    {field: "wan20000", title: "15001~20000万", width: 100, align: "center", sortable: true},
                    {field: "wan20001", title: "20000万以上", width: 100, align: "center", sortable: true},
                    {field: "wantotal", title: "合计", width: 100, align: "center", sortable: true},
                ]],
//	        	onLoadSuccess: function (data) {
//					////console.info(data);
//	        	},
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
                url: path + "/enterpriseInformationAnalysisCredit/findEnterpriseInformationAnalysisCreditForPageList?" + dataUrl,
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
//	        	onLoadSuccess: function (data) {
//					////console.info(data);
//	        	},
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                rownumbers: true,
            });
        }

    });
</script>