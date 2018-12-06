<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>驾驶员预警监控</title>

    <!-- jquery easyui 插件 -->
    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>

</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>关键字</label>
        <input id="key" class="easyui-textbox" data-options="width:200" prompt="企业名称 | 驾驶员名称 | 考评版本">
        <label>&nbsp;考评等级</label>
        <select id="level" class="easyui-combobox" data-options="width:60,panelHeight:'auto',editable:false">
            <option value="-1">全部</option>
            <option value="0">A</option>
            <option value="1">B</option>
            <option value="2">C</option>
        </select>
        <label>&nbsp;考评时间</label>
        <input id="begintime" class="easyui-datetimebox" data-options="width:160,editable:false"/>
        <label>至</label>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,editable:false"/>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <button class="easyui-linkbutton" id="export">导出</button>
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
        acquireData('', '', '', '');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            var level = $("#level").combobox("getValue");
            var begintime = $("#begintime").datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            acquireData(key, level, begintime, endtime);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#level").combobox("setValue", "-1");
            $("#begintime").datetimebox("setValue", "");
            $("#endtime").datetimebox("setValue", "");
            acquireData('', '', '', '');
        });

        /*
        ** 获取数据
        */
        function acquireData(key, level, begintime, endtime) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key +
                "&evaluationLevel=" + level;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/driverWarningMonitore/findDriverWarningMonitoreForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {
                            field: 'evaluationLevel', title: '考评等级', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0:
                                        return "A";
                                        break;
                                    case 1:
                                        return "B";
                                        break;
                                    case 2:
                                        return "C";
                                        break;
                                }
                            }
                        },
                        {field: 'achievementdet', title: '得分详细', width: 100, align: 'center', sortable: true},
                        {field: 'account', title: '驾驶员姓名', width: 100, align: 'center', sortable: true},
                        {field: 'seniority', title: '从业资格证号', width: 100, align: 'center'},
                        {field: 'kabnum', title: '车牌号', width: 100, align: 'center'},
                        {field: 'phone', title: '取系电话', width: 100, align: 'center'},
                        {field: 'enterprisename', title: '企业名称', width: 100, align: 'center', sortable: true},
                        {field: 'achievement', title: '总得分', width: 100, align: 'center'},
                        {field: 'evaluationyears', title: '考评年度', width: 100, align: 'center'},
                        {field: 'evaluationversion', title: '考评版本', width: 100, align: 'center'},
                        {field: 'evaluationtime', title: '考评时间', width: 100, align: 'center', sortable: true}
                    ]
                ],
                //          onLoadSuccess: function (data) {
                //				////console.info(data);
                //          },
                idField: 'enterpriseName',
                sortName: 'enterpriseName',
                sortOrder: 'desc',
                singleSelect: true,
                pagination: true,
                pageSize: 20,
                pageList: [20, 40, 60, 80],
                rownumbers: true,
                toolbar: '#toolbar'
            });
        }
    });
</script>