<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="wap-font-scale" content="no">
    <!--<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0,user-scalable=no" name="viewport" id="viewport" />-->
    <title>设置预警阀值</title>

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
        <label>版本名称</label>
        <input id="key" class="easyui-textbox" data-options="width:160">
    </div>
    <div id="button">
        <button class="easyui-linkbutton" id="search" iconCls="icon-search">查询</button>
        <button class="easyui-linkbutton" id="reset">重置</button>
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
        acquireData('');

        /*
        ** 查询
        */
        $("#search").on("click", function () {
            var key = $("#key").textbox("getValue");
            acquireData(key);
        });

        /*
        ** 重置
        */
        $("#reset").on("click", function () {
            $("#key").textbox("setValue", "");
            acquireData('');
        });

        /*
        ** 获取数据
        */
        function acquireData(key) {
            var dataUrl = "sort=id&order=desc&begintime=&endtime=&key=" + key;
            grid = $("#redataGril").datagrid({
                fit: true,
                url: path + "/setWarnThreshold/findSetWarnThresholdForPageList?" + dataUrl,
                fitColumns: true,
                striped: true,
                columns: [
                    [
                        {field: 'versionname', title: '版本名称', width: 100, align: 'center', sortable: true},
                        {field: 'versionyears', title: '版本年度', width: 100, align: 'center', sortable: true},
                        {field: 'evaluationtime', title: '考评时间', width: 100, align: 'center'},
                        {
                            field: 'type', title: '版本类型', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0:
                                        return "企业";
                                        break;
                                    case 1:
                                        return "驾驶员";
                                        break;
                                }
                            }
                        },
                        {
                            field: 'status', title: '阀值状态', width: 100, align: 'center',
                            formatter: function (value) {
                                switch (value) {
                                    case 0:
                                        return "已设置";
                                        break;
                                    case 1:
                                        return "未设置";
                                        break;
                                }
                            }
                        },
                        {field: 'operate', title: '操作', width: 100, align: 'center'}
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