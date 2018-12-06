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
    <title>紧急报警统计</title>

    <link href="../../../public/jquery-easyui-1.5/themes/metro/easyui.css" rel="stylesheet"/>
    <link href="../../../public/jquery-easyui-1.5/themes/icon.css" rel="stylesheet"/>

    <script src="../../../public/jquery-easyui-1.5/js/jquery.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/jquery.easyui.min.js"></script>
    <script src="../../../public/jquery-easyui-1.5/js/easyui-lang-zh_CN.js"></script>

    <!-- childstyle -->
    <link rel="stylesheet" type="text/css" href="../../../public/css/childstyle.css"/>

    <!-- 数据接口路径、共用JS -->
    <script src="../../../public/js/path.js"></script>
    <script src="../../../public/js/constant.js"></script>


</head>
<body id="body" class="easyui-layout" data-options="fit:true">

<!-- 数据表格 -->
<table id="redataGril"></table>

<!-- 工具栏 -->
<div id="toolbar">
    <div id="input">
        <label>关键字</label>
        <input id="name" class="easyui-textbox" style="width:160px;" prompt="车牌号码 | 驾驶员姓名 ">
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
        /*
         ** 默认加载
         */
        acquireData(-1, '');

        /*
         ** 查询
         */
        $("#search").on("click", function () {
            var name = $('#name').textbox('getValue');
            acquireData(-1, name);
        });

        /*
         ** 重置
         */
        $("#reset").on("click", function () {
            $("#name").textbox("setValue", "");
            acquireData(-1, '');
        });

        /*
         ** 获取数据
         */
        function acquireData(type, key) {
            var dataurl = path + "/emergencyAlarmDetails/findEmergencyAlarmDetailsForPageList?startime=&endtime="
                + "&order=desc&sort=id&key=" + key + "&type=" + type + "&token=" + token;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: dataurl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'account', title: '驾驶员', width: 100, align: 'center', sortable: true},
                        {field: 'kabnum', title: '车辆号码', width: 100, align: 'center'},
                        {field: 'unit', title: '所属单位', width: 100, align: 'center'},
                        {field: 'type', title: '操作类型', width: 100, align: 'center'},
                        {field: 'starttime', title: '开始时间', width: 100, align: 'center'},
                        {field: 'endtime', title: '结束时间', width: 100, align: 'center'},
                        {field: 'creattime', title: '时间', width: 100, align: 'center'},
                        {field: 'address', title: '地点', width: 100, align: 'center'}

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
