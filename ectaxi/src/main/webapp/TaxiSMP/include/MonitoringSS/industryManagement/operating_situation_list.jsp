<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no"
          name="viewport" id="viewport"/>
    <title>运营的情况</title>

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
        <label>企业名称</label>
        <input id="name" class="easyui-textbox" style="width:160px;">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
        <%--<button class="easyui-linkbutton" id="export">导出</button>--%>
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
        var token = sessionStorage.account;
        var globab_clientId = sessionStorage.clientId;
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
            var dataurl = path + "/operatingSituation/findOperatingSituationForPageList?startime=&endtime="
                + "&order=desc&sort=totalnum&key=" + key + "&token=" + token + "&clientid=" + globab_clientId;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: dataurl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'company', title: '企业名称', width: 100, align: 'center'},
                        {field: 'totalnum', title: '车辆总数', width: 100, align: 'center', sortable: true},
                        {field: 'emptynum', title: '空车数量', width: 100, align: 'center', sortable: true},
                        {field: 'heavynum', title: '重车数量', width: 100, align: 'center'},
                        {field: 'totaloperat', title: '总运营次数', width: 100, align: 'center', sortable: true},
                        {field: 'passmiles', title: '总载客里程', width: 100, align: 'center', sortable: true},
                        {field: 'totalrevenue', title: '总收入', width: 100, align: 'center', sortable: true}
                    ]
                ],
                onLoadSuccess: function (data) {
                    ////console.info(data);
                },

                idField: 'id',
                sortName: 'id',
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