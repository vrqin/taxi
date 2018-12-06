<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>终端在线查询</title>

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
        <span>SIM:</span>
        <input id="name" class="easyui-textbox" style="width:160px;">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <%--<button class="easyui-linkbutton" id="export"> 导出</button>--%>
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
        /*
         ** 默认加载
         */
        acquireData('');

        /*
         ** 查询
         */
        $("#search").on("click", function () {
            var name = $('#name').textbox('getValue');
            acquireData(name);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#name").textbox("setValue", "");
            acquireData('');
        });

        /*
        ** 获取数据
        */
        function acquireData(key) {
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/driver/findDriverOnOfflineMsid?msid=" + key + "&isonline=1&clientid=" + globab_clientId + "&token=" + token,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'msid', title: '终端号', width: 100, align: 'center'},
                        {field: 'phone', title: 'SIM卡号', width: 100, align: 'center', sortable: true},
                        {field: 'type', title: '设备类型', width: 100, align: 'center', sortable: true},
                        {
                            field: 'gpstime', title: '时间', width: 100, align: 'center'
                        },
                        {field: 'geographical', title: '地理位置', width: 100, align: 'center', sortable: true},
                        {field: 'history', title: '历史轨迹', width: 100, align: 'center', sortable: true},
                        {field: 'track', title: '车辆追踪', width: 100, align: 'center', sortable: true}
                    ]
                ],
//              onLoadSuccess: function (data) {
//                  ////console.info(data);
//              },
                idField: 'kabnum',
                sortName: 'kabnum',
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