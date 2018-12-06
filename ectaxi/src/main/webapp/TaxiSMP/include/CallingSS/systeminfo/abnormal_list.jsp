<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>异常日志</title>

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
        <span>操作时间</span>
        <input id="startime" class="easyui-datetimebox " data-options="width:160,panelHeight:'auto',editable:false"/>
        <span>至</span>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160,panelHeight:'auto',editable:false"/>
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" data-options="iconCls:'icon-search'">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
    </div>
</div>

</body>
</html>

<script>
    var token = sessionStorage.account;
    var globab_clientId = sessionStorage.clientId;
    $(function () {

        /*
        ** 变量声明
        */
        var grid;

        acquireData("", "");

        /*
         ** 查询
         */
        $("#search").on("click", function () {
            var startime = $("#startime").datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            acquireData(startime, endtime)
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#startime").textbox("setValue", "");
            $("#endtime").textbox("setValue", "");
            acquireData("", "")
        });

        /*
        ** 获取数据
        */
        function acquireData(startime, endtime) {
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/logabnormal/findLogAbnormalForPageList?startime=" + startime + "&endtime=" + endtime + "&order=desc&sort=id&key=&clientid=" + globab_clientId,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'operator', title: '操作者', width: 100, align: 'center', sortable: true},
                        {field: 'operattime', title: '操作时间', width: 100, align: 'center', sortable: true},
                        {field: 'returninfo', title: '返回信息', width: 100, align: 'center'}
                    ]
                ],
//          onLoadSuccess: function (data) {
//				////console.info(data);
//          },
                idField: 'phone',
                sortName: 'phone',
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