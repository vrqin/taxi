<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>稽查任务台账</title>

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
        <label>关键字</label>
        <input id="key" class="easyui-textbox" data-options="width:160" prompt="稽查区域 | 任务负责人">
        <label>&nbsp;开始时间</label>
        <input id="begintime" class="easyui-datetimebox" data-options="width:160, editable:false">
        <label>至</label>
        <input id="endtime" class="easyui-datetimebox" data-options="width:160, editable:false">
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
        acquireData('', '', '');

        /*
        ** 查询
        */
        $("#search").click(function () {
            var key = $("#key").textbox("getValue");
            var begintime = $('#begintime').datetimebox("getValue");
            var endtime = $("#endtime").datetimebox("getValue");
            acquireData(begintime, endtime, key);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            $("#begintime").datetimebox('setValue', '');
            $("#endtime").datetimebox('setValue', '');
            acquireData('', '', '');
        });

        /*
        ** 获取数据
        */
        function acquireData(begintime, endtime, key) {
            var dataUrl = "sort=id&order=desc&begintime=" + begintime +
                "&endtime=" + endtime +
                "&key=" + key;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/auditTaskParameter/findAuditTaskParameterForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'auditarea', title: '稽查区域', width: 100, align: 'center', sortable: true},
                        {
                            field: 'starttime', title: '开始时间', width: 100, align: 'center', sortable: true,
                            formatter: function (value) {
                                return formattime(value);
                            }
                        },
                        {
                            field: 'endtime', title: '结束时间', width: 100, align: 'center',
                            formatter: function (value) {
                                return formattime(value);
                            }
                        },
                        {field: 'tasker', title: '任务负责人', width: 100, align: 'center'},
                        {field: 'auditnum', title: '稽查异常总数', width: 100, align: 'center', sortable: true},
                        {field: 'detail', title: '稽查明细', width: 100, align: 'center', sortable: true}
                    ]
                ],
                //          onLoadSuccess: function (data) {
                //				////console.info(data);
                //          },
                idField: 'starttime',
                sortName: 'starttime',
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