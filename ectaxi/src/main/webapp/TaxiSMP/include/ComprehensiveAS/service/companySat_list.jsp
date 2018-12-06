<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>企业满意度</title>

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
    <div title="经济性质">
        <table id="property"></table>
    </div>
    <div title="车辆总数">
        <table id="cartotal"></table>
    </div>
    <div title="人员规模">
        <table id="person"></table>
    </div>
    <div title="资金规模">
        <table id="funds"></table>
    </div>
</div>

<!-- 工具栏 -->
<div id="propertytoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime1" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime1" class="easyui-datebox" data-options="width:100,editable:false"/>&nbsp;
        <button class="easyui-linkbutton" id="search1" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset1" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export1" style="padding:0 10px">导出</button>
    </div>
</div>

<!-- 工具栏 -->
<div id="cartotaltoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime2" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime2" class="easyui-datebox" data-options="width:100,editable:false"/>&nbsp;
        <button class="easyui-linkbutton" id="search2" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset2" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export2" style="padding:0 10px">导出</button>
    </div>
</div>

<!-- 工具栏 -->
<div id="persontoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime3" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime3" class="easyui-datebox" data-options="width:100,editable:false"/>&nbsp;
        <button class="easyui-linkbutton" id="search3" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset3" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export3" style="padding:0 10px">导出</button>
    </div>
</div>

<!-- 工具栏 -->
<div id="fundstoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime4" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime4" class="easyui-datebox" data-options="width:100,editable:false"/>&nbsp;
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
        ** 默认加载
        */
        propertyData('', '', '');
        cartotalData('', '', '');
        personData('', '', '');
        fundsData('', '', '');

        /*
        ** 经济性质查询
        */
        $("#search1").on("click", function () {
            var begintime1 = $("#begintime1").datebox("getValue");
            var endtime1 = $("#endtime1").datebox("getValue");
            //var key1 = $("#key1").textbox("getValue");
            propertyData(begintime1, endtime1, '');
        });

        /*
        ** 经济性质重置
        */
        $("#reset1").on("click", function () {
            $("#begintime1").datebox("setValue", "");
            $("#endtime1").datebox("setValue", "");
            //$("#key1").textbox("setValue","");
            propertyData('', '', '');
        });

        /*
        ** 车辆总数查询
        */
        $("#search2").on("click", function () {
            var begintime2 = $("#begintime2").datebox("getValue");
            var endtime2 = $("#endtime2").datebox("getValue");
            //var key1 = $("#key1").textbox("getValue");
            cartotalData(begintime2, endtime2, '');
        });

        /*
        ** 车辆总数重置
        */
        $("#reset2").on("click", function () {
            $("#begintime2").datebox("setValue", "");
            $("#endtime2").datebox("setValue", "");
            //$("#key1").textbox("setValue","");
            cartotalData('', '', '');
        });

        /*
        ** 人员规模查询
        */
        $("#search3").on("click", function () {
            var begintime3 = $("#begintime3").datebox("getValue");
            var endtime3 = $("#endtime3").datebox("getValue");
            //var key1 = $("#key1").textbox("getValue");
            personData(begintime3, endtime3, '');
        });

        /*
        ** 人员规模重置
        */
        $("#reset3").on("click", function () {
            $("#begintime3").datebox("setValue", "");
            $("#endtime3").datebox("setValue", "");
            //$("#key1").textbox("setValue","");
            personData('', '', '');
        });

        /*
        ** 资金规模查询
        */
        $("#search4").on("click", function () {
            var begintime4 = $("#begintime4").datebox("getValue");
            var endtime4 = $("#endtime4").datebox("getValue");
            //var key1 = $("#key1").textbox("getValue");
            fundsData(begintime4, endtime4, '');
        });

        /*
        ** 资金规模重置
        */
        $("#reset4").on("click", function () {
            $("#begintime4").datebox("setValue", "");
            $("#endtime4").datebox("setValue", "");
            //$("#key1").textbox("setValue","");
            fundsData('', '', '');
        });

        /*
        ** 经济性质面板表格
        */
        function propertyData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#property").datagrid({
                url: path + "/enterpriseSatisfacteEconomic/findEnterpriseSatisfacteEconomicForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "satistime", title: "日期", width: 100, align: "center", sortable: true},
                    {
                        field: "economicnature", title: "经济性质", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0:
                                    return "国有全资";
                                    break;
                                case 1:
                                    return "集体全资";
                                    break;
                                case 2:
                                    return "股份合作";
                                    break;
                                case 3:
                                    return "联营";
                                    break;
                                case 4:
                                    return "有限责任公司";
                                    break;
                                case 5:
                                    return "股份有限公司";
                                    break;
                                case 6:
                                    return "私有";
                                    break;
                            }
                        }
                    },
                    {
                        field: "satisfaction", title: "满意度（%）", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            return value + "%";
                        }
                    },
                ]],
//	        	onLoadSuccess: function (data) {
//					////console.info(data);
//	          	},
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                singleSelect: true,
                rownumbers: true,
                toolbar: "#propertytoolbar",
            });
        }

        /*
    	** 车辆总数面板表格
    	*/
        function cartotalData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#cartotal").datagrid({
                url: path + "/enterpriseSatisfacteCartotal/findEnterpriseSatisfacteCartotalForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "satistime", title: "日期", width: 100, align: "center", sortable: true},
                    {
                        field: "carnum", title: "车辆总数", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0:
                                    return "0~200辆";
                                    break;
                                case 1:
                                    return "201~500辆";
                                    break;
                                case 2:
                                    return "501~1000辆";
                                    break;
                                case 3:
                                    return "1001~2000辆";
                                    break;
                                case 4:
                                    return "2001~5000辆";
                                    break;
                                case 5:
                                    return "5000辆以上";
                                    break;
                            }
                        }
                    },
                    {
                        field: "satisfaction", title: "满意度（%）", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            return value + "%";
                        }
                    },
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                singleSelect: true,
                rownumbers: true,
                toolbar: "#cartotaltoolbar",
                //pagination : true,
            });
        }

        /*
    	** 人员规模面板表格
    	*/
        function personData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#person").datagrid({
                url: path + "/enterpriseSatisfacteStaff/findEnterpriseSatisfacteStaffForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "satistime", title: "日期", width: 100, align: "center", sortable: true},
                    {
                        field: "staffsize", title: "人员规模", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0:
                                    return "0~200人";
                                    break;
                                case 1:
                                    return "201~500人";
                                    break;
                                case 2:
                                    return "501~1000人";
                                    break;
                                case 3:
                                    return "1001~2000人";
                                    break;
                                case 4:
                                    return "2001~5000人";
                                    break;
                                case 5:
                                    return "5000人以上";
                                    break;
                            }
                        }
                    },
                    {
                        field: "satisfaction", title: "满意度（%）", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            return value + "%";
                        }
                    },
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                singleSelect: true,
                rownumbers: true,
                toolbar: "#persontoolbar",
                //pagination : true,
            });
        }

        /*
    	** 资金规模面板表格
    	*/
        function fundsData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#funds").datagrid({
                url: path + "/enterpriseSatisfacteFunds/findEnterpriseSatisfacteFundsForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "satistime", title: "日期", width: 100, align: "center", sortable: true},
                    {
                        field: "funds", title: "资金规模", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0:
                                    return "0~100万";
                                    break;
                                case 1:
                                    return "101~500万";
                                    break;
                                case 2:
                                    return "501~1000万";
                                    break;
                                case 3:
                                    return "1001~2000万";
                                    break;
                                case 4:
                                    return "2001~5000万";
                                    break;
                                case 5:
                                    return "5001~10000万";
                                    break;
                                case 6:
                                    return "10001~15000万";
                                    break;
                                case 7:
                                    return "15001~20000万";
                                    break;
                                case 8:
                                    return "20000万以上";
                                    break;
                            }
                        }
                    },
                    {
                        field: "satisfaction", title: "满意度（%）", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            return value + "%";
                        }
                    },
                ]],
                idField: 'years',
                sortName: 'years',
                sortOrder: 'desc',
                singleSelect: true,
                rownumbers: true,
                toolbar: "#fundstoolbar",
                //pagination : true,
            });
        }

    });
</script>