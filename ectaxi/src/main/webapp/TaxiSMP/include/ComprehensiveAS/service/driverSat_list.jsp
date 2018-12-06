<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>驾驶员满意度</title>

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
    <div title="年龄">
        <table id="age"></table>
    </div>
    <div title="从业时间">
        <table id="work"></table>
    </div>
    <div title="文化程度">
        <table id="education"></table>
    </div>
    <div title="星级">
        <table id="level"></table>
    </div>
</div>

<!-- 工具栏 -->
<div id="agetoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime1" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime1" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>&nbsp;企业名称</label>
        <input id="key1" class="easyui-textbox"/>&nbsp;
        <button class="easyui-linkbutton" id="search1" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset1" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export1" style="padding:0 10px">导出</button>
    </div>
</div>

<!-- 工具栏 -->
<div id="worktoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime2" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime2" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>&nbsp;企业名称</label>
        <input id="key2" class="easyui-textbox"/>&nbsp;
        <button class="easyui-linkbutton" id="search2" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset2" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export2" style="padding:0 10px">导出</button>
    </div>
</div>

<!-- 工具栏 -->
<div id="educationtoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime3" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime3" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>&nbsp;企业名称</label>
        <input id="key3" class="easyui-textbox"/>&nbsp;
        <button class="easyui-linkbutton" id="search3" iconCls="icon-search" style="padding:0 10px">查询</button>
        <button class="easyui-linkbutton" id="reset3" style="padding:0 10px">重置</button>
        <button class="easyui-linkbutton" id="export3" style="padding:0 10px">导出</button>
    </div>
</div>

<!-- 工具栏 -->
<div id="leveltoolbar">
    <div id="input" style="font-size:12px;">
        <label>日期</label>
        <input id="begintime4" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>至</label>
        <input id="endtime4" class="easyui-datebox" data-options="width:100,editable:false"/>
        <label>&nbsp;企业名称</label>
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
        ** 默认加载
        */
        ageData('', '', '');
        workData('', '', '');
        educationData('', '', '');
        levelData('', '', '');

        /*
        ** 年龄段查询
        */
        $("#search1").on("click", function () {
            var begintime1 = $("#begintime1").datebox("getValue");
            var endtime1 = $("#endtime1").datebox("getValue");
            var key1 = $("#key1").textbox("getValue");
            ageData(begintime1, endtime1, key1);
        });

        /*
        ** 年龄段重置
        */
        $("#reset1").on("click", function () {
            $("#begintime1").datebox("setValue", "");
            $("#endtime1").datebox("setValue", "");
            $("#key1").textbox("setValue", "");
            ageData('', '', '');
        });

        /*
        ** 从业时间查询
        */
        $("#search2").on("click", function () {
            var begintime2 = $("#begintime2").datebox("getValue");
            var endtime2 = $("#endtime2").datebox("getValue");
            var key2 = $("#key2").textbox("getValue");
            workData(begintime2, endtime2, key2);
        });

        /*
        ** 从业时间重置
        */
        $("#reset2").on("click", function () {
            $("#begintime2").datebox("setValue", "");
            $("#endtime2").datebox("setValue", "");
            $("#key2").textbox("setValue", "");
            workData('', '', '');
        });

        /*
        ** 文化程度查询
        */
        $("#search3").on("click", function () {
            var begintime3 = $("#begintime3").datebox("getValue");
            var endtime3 = $("#endtime3").datebox("getValue");
            var key3 = $("#key3").textbox("getValue");
            educationData(begintime3, endtime3, key3);
        });

        /*
        ** 文化程度重置
        */
        $("#reset3").on("click", function () {
            $("#begintime3").datebox("setValue", "");
            $("#endtime3").datebox("setValue", "");
            $("#key3").textbox("setValue", "");
            educationData('', '', '');
        });

        /*
        ** 星级查询
        */
        $("#search4").on("click", function () {
            var begintime4 = $("#begintime4").datebox("getValue");
            var endtime4 = $("#endtime4").datebox("getValue");
            var key4 = $("#key4").textbox("getValue");
            levelData(begintime4, endtime4, key4);
        });

        /*
        ** 星级重置
        */
        $("#reset4").on("click", function () {
            $("#begintime4").datebox("setValue", "");
            $("#endtime4").datebox("setValue", "");
            $("#key4").textbox("setValue", "");
            levelData('', '', '');
        });

        /*
        ** 年龄段面板表格
        */
        function ageData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#age").datagrid({
                url: path + "/driverSatisfactionAge/findDriverSatisfactionAgeForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "satistime", title: "日期", width: 100, align: "center", sortable: true},
                    {field: "companyname", title: "企业名称", width: 100, align: "center", sortable: true},
                    {
                        field: "age", title: "年龄段", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0:
                                    return "18~24岁";
                                    break;
                                case 1:
                                    return "25~34岁";
                                    break;
                                case 2:
                                    return "35~44岁";
                                    break;
                                case 3:
                                    return "45~59岁";
                                    break;
                                case 4:
                                    return "60岁以上";
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
                toolbar: "#agetoolbar",
            });
        }

        /*
    	** 从业时间面板表格
    	*/
        function workData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#work").datagrid({
                url: path + "/driverSatisfactionWorktime/findDriverSatisfactionWorktimeForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "satistime", title: "日期", width: 100, align: "center", sortable: true},
                    {field: "companyname", title: "企业名称", width: 100, align: "center", sortable: true},
                    {
                        field: "worktime", title: "从业时间", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0:
                                    return "0~6月";
                                    break;
                                case 1:
                                    return "7~12月";
                                    break;
                                case 2:
                                    return "1~2年";
                                    break;
                                case 3:
                                    return "2~3年";
                                    break;
                                case 4:
                                    return "3~4年";
                                    break;
                                case 5:
                                    return "4~5年";
                                    break;
                                case 6:
                                    return "5年以上";
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
                toolbar: "#worktoolbar",
                //pagination : true,
            });
        }

        /*
    	** 文化程度面板表格
    	*/
        function educationData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#education").datagrid({
                url: path + "/driverSatisfactionEducation/findDriverSatisfactionEducationForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "satistime", title: "日期", width: 100, align: "center", sortable: true},
                    {field: "companyname", title: "企业名称", width: 100, align: "center", sortable: true},
                    {
                        field: "education", title: "文化程度", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0:
                                    return "博士";
                                    break;
                                case 1:
                                    return "研究生";
                                    break;
                                case 2:
                                    return "本科";
                                    break;
                                case 3:
                                    return "大专";
                                    break;
                                case 4:
                                    return "高中";
                                    break;
                                case 5:
                                    return "初中";
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
                toolbar: "#educationtoolbar",
                //pagination : true,
            });
        }

        /*
    	** 星级面板表格
    	*/
        function levelData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#level").datagrid({
                url: path + "/driverSatisfactionStar/findDriverSatisfactionStarForPageList?" + dataUrl,
                border: false,
                fitColumns: true,
                striped: true,
                columns: [[
                    {field: "satistime", title: "日期", width: 100, align: "center", sortable: true},
                    {field: "companyname", title: "企业名称", width: 100, align: "center", sortable: true},
                    {
                        field: "star", title: "星级", width: 100, align: "center", sortable: true,
                        formatter: function (value) {
                            switch (value) {
                                case 0:
                                    return "一星";
                                    break;
                                case 1:
                                    return "二星";
                                    break;
                                case 2:
                                    return "三星";
                                    break;
                                case 3:
                                    return "四星";
                                    break;
                                case 4:
                                    return "五星";
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
                toolbar: "#leveltoolbar",
                //pagination : true,
            });
        }

    });
</script>