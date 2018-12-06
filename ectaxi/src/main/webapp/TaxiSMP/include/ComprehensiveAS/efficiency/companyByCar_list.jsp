<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>企业出车统计</title>

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

</head>

<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <span>日期</span>
        <input id="begintime3" class="easyui-datebox" data-options="width:100,panelHeight:'auto',editable:false"/>
        <span>至</span>
        <input id="endtime3" class="easyui-datebox" data-options="width:100,panelHeight:'auto',editable:false"/>
        <label>&nbsp;企业名称</label>
        <input id="key3" class="easyui-textbox" style="width:160px;">
    </div>
    <div id="button">
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
        ** 获取数据
        */
        function dayData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            $("#redataGril").datagrid({
                fit: true,
                url: path + "/enterpriseCarStatis/findEnterpriseCarStatisForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: "date", title: "日期", width: 100, align: "center", sortable: true},
                        {field: 'companyname', title: '企业名称', width: 100, align: 'center', sortable: true},
                        {field: 'carnum', title: '企业车辆数', width: 100, align: 'center'},
                        {field: 'operationcarnum', title: '运营车辆数', width: 100, align: 'center'},
                        {field: 'avedatebikeoperatnum', title: '日均工作车辆数', width: 100, align: 'center', sortable: true},
                        {field: 'carrate', title: '企业出车率（%）', width: 100, align: 'center', sortable: true},

                    ]
                ],
                idField: 'mobile',
                sortName: 'mobile',
                sortOrder: 'desc',
                singleSelect: true,
                rownumbers: true,
                toolbar: '#toolbar'
            });
        }

    });

</script>